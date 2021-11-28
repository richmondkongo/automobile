package com.rk.automobile.repository;

import com.rk.automobile.model.PiecesModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PiecesRepository extends MongoRepository<PiecesModel, String> {
    List<PiecesModel> findByCodeTypePiece(String codeTypePiece);
    List<PiecesModel> findByEtat(String eta);
    List<PiecesModel> findByDate(String date);
    List<PiecesModel> findByCodePiece(String codePiece);
}
