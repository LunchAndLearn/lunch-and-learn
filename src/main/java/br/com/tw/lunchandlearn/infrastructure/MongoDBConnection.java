package br.com.tw.lunchandlearn.infrastructure;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;

public class MongoDBConnection {

    public static MongoClient connect(@Value("db.user") String user, @Value("db.password") String password) {
        String uri = "mongodb://"+ user + ":"+ password + "@ds239968.mlab.com:39968/lunchandlearnapp";

        MongoClientURI mongoClientURI = new MongoClientURI(uri);

        MongoClient mongoClient = new MongoClient(mongoClientURI);

        return mongoClient;
    }

}
