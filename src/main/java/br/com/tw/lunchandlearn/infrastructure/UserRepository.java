package br.com.tw.lunchandlearn.infrastructure;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByName(String name);

    User findByUsername(String username);
}
