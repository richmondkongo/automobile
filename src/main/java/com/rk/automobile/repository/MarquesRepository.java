package com.rk.automobile.repository;

import com.rk.automobile.model.MarquesModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MarquesRepository extends MongoRepository<MarquesModel, String> {
    List<MarquesModel> findByCodeMarque(String codeMarque);
    List<MarquesModel> findByNomMarque(String nomMarque);
}
