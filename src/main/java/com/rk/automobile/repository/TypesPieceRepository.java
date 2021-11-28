package com.rk.automobile.repository;

import com.rk.automobile.model.TypesPieceModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TypesPieceRepository extends MongoRepository<TypesPieceModel, String> {
    List<TypesPieceModel> findByCodeTypePiece(String codeTypePiece);
    List<TypesPieceModel> findByRefConstructeur(String refConstructeur);
    List<TypesPieceModel> findByPrix(int prix);
    List<TypesPieceModel> findByCodeCategorie(String codeCategorie);
}
