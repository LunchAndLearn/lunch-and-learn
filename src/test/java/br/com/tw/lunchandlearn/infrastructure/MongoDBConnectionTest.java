package br.com.tw.lunchandlearn.infrastructure;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MongoDBConnectionTest {

    private static final String USER_PASSWORD = "thoughtworks";
    private static final String USER_COLLECTION_NAME = "user";
    private static final String LUNCH_AND_LEARN_APP = "lunchandlearnapp";
    private MongoClient mongoClient;

    @Test
    public void connectToMongoDB() throws Exception {
        String databaseName = LUNCH_AND_LEARN_APP;
        mongoClient = MongoDBConnection.connect(USER_PASSWORD, USER_PASSWORD);

        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> user = database.getCollection(USER_COLLECTION_NAME);

        assertEquals(databaseName, database.getName());
        assertEquals(1, user.count());
    }

    @After
    public void tearDown() throws Exception {
        mongoClient.close();
    }

}