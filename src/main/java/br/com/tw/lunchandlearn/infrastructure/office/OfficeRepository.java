package br.com.tw.lunchandlearn.infrastructure.office;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OfficeRepository extends MongoRepository<OfficeEntity, String> {

}
