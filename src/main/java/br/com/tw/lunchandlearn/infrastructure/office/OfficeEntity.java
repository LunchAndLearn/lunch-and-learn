package br.com.tw.lunchandlearn.infrastructure.office;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "office")
public class OfficeEntity {

    @Id
    public String id;

    public String name;

}
