package br.com.tw.lunchandlearn.infrastructure.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {

    UserEntity findByFirstName(String name);

    UserEntity findByUserName(String userName);

}
