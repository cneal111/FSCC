package com.ibm.fscc.kafka.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.ibm.fscc.kafka.model.User;
import org.springframework.stereotype.Repository;
@Repository
public interface KafkaRepository extends MongoRepository<User, String> {
}
