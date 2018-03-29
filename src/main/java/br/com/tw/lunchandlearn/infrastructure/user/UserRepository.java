package br.com.tw.lunchandlearn.infrastructure.user;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {

    UserEntity findByName(String name);

}
