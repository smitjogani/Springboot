package com.quection.QuestionService.Repository;

import com.quection.QuestionService.Entity.Quection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuectionRepository extends MongoRepository<Quection, String> {

}