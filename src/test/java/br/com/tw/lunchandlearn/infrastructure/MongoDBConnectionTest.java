package br.com.tw.lunchandlearn.infrastructure;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MongoDBConnectionTest {

    public static final String THOUGHTWORKS = "thoughtworks";
    private MongoClient mongoClient;

    @Test
    public void connectToMongoDB() throws Exception {
        String databaseName = "lunchandlearnapp";
        mongoClient = MongoDBConnection.connect(THOUGHTWORKS, THOUGHTWORKS);

        MongoDatabase database = mongoClient.getDatabase(databaseName);
        MongoCollection<Document> user = database.getCollection("user");

        assertEquals(databaseName, database.getName());
        assertEquals(1, user.count());
    }

    @After
    public void tearDown() throws Exception {
        mongoClient.close();
    }

}