package br.com.tw.lunchandlearn.infrastructure;

import br.com.tw.lunchandlearn.domain.LunchAndLearn;
import com.fasterxml.jackson.dataformat.yaml.snakeyaml.Yaml;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;
import static java.util.Arrays.asList;

@Component
public class SpreadSheetClient {

    private static final String APPLICATION_NAME = "Lunch and Learn";

    private static final File DATA_STORE_DIR = Paths.get(".credentials/sheets.googleapis.com-java-quickstart").toFile();

    private static FileDataStoreFactory DATA_STORE_FACTORY;

    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    private static HttpTransport HTTP_TRANSPORT;

    private static final List<String> SCOPES = asList(SheetsScopes.SPREADSHEETS_READONLY);

    public List<LunchAndLearn> getAllLunchAndLearns() throws Exception {
        Sheets service = getSheetsService();

        String spreadsheetId = "1gR25ndB8M3_37TGdzqTDt3hImRVDcFh8bZ5k31lfIwA";
        String range = "'BH 2018'!A58:G1000";
        Sheets.Spreadsheets.Values.Get request = service.spreadsheets()
                .values()
                .get(spreadsheetId, range);

        request.setMajorDimension("ROWS");
        request.setDateTimeRenderOption("FORMATTED_STRING");

        ValueRange response = request
                .execute();

        List<List<Object>> values = response.getValues();

        if (values == null || values.size() == 0) {
            return asList(new LunchAndLearn());
        } else {
            return printData(values);
        }
    }

    private Credential authorize() throws Exception {

        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }

        GoogleConfiguration googleConfiguration = new Yaml()
                .loadAs(SpreadSheetClient.class.getResourceAsStream("/client_secret.yml"),
                        GoogleConfiguration.class);

        Gson gson = new Gson();
        String jsonConfigurations = gson.toJson(googleConfiguration);
        System.out.println(gson);

        InputStream inputStream = new ByteArrayInputStream(jsonConfigurations.getBytes());
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, inputStreamReader);

        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                        .setDataStoreFactory(DATA_STORE_FACTORY)
                        .setAccessType("offline")
                        .build();

        Credential credential = new AuthorizationCodeInstalledApp(flow,
                new LocalServerReceiver()).authorize("user");

        return credential;
    }

    private Sheets getSheetsService() throws Exception {
        Credential credential = authorize();

        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    private List<LunchAndLearn> printData(List<List<Object>> values) {
        System.out.println("\n");

        List<LunchAndLearn> lunchAndLearns = new ArrayList<>();

        for (List row : values) {
            if (row.size() > 5 && row.get(5).equals("L&L")) {
                LunchAndLearn lunchAndLearn = new LunchAndLearn(valueOf(row.get(0)), valueOf(row.get(2)),
                        valueOf(row.get(3)));
                lunchAndLearns.add(lunchAndLearn);
            }
        }

        System.out.printf("%s\n", lunchAndLearns);
        return lunchAndLearns;
    }


}
