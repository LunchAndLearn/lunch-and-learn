package br.com.tw.lunchandlearn.infrastructure;

import org.junit.Test;

public class SpreadSheetClientTest {

    @Test
    public void readSpreadSheet() throws Exception {
        SpreadSheetClient spreadSheetClient = new SpreadSheetClient();
        spreadSheetClient.getAllLunchAndLearns();
    }

}