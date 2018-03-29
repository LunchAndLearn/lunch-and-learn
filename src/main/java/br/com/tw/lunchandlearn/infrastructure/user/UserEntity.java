package br.com.tw.lunchandlearn.infrastructure.user;

import br.com.tw.lunchandlearn.infrastructure.office.OfficeEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "user")
public class UserEntity {

    @Id
    public String id;

    public String name;

    public String lastName;

    public String user;

    public String password;

    public OfficeEntity office;

}
