package com.rk.automobile.repository;

import com.rk.automobile.model.ConvenirModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ConvenirRepository extends MongoRepository<ConvenirModel, String> {
    List<ConvenirModel> findByCodeTypePiece(String codeTypePiece);
    List<ConvenirModel> findByCodeModele(String codeModel);
}
