package com.rk.automobile.service;

import com.rk.automobile.model.PiecesModel;
import com.rk.automobile.repository.PiecesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PiecesService{
    private final PiecesRepository piecesRepository;;

    public List<PiecesModel> findAll() {
        return piecesRepository.findAll();
    }

    public Optional<PiecesModel> findById(String id) {
        return piecesRepository.findById(id);
    }

    public List<PiecesModel> findByCodeTypePiece(String codeTypePiece) {
        return piecesRepository.findByCodeTypePiece(codeTypePiece);
    }

    public List<PiecesModel> findByEtat(String etat) {
        return piecesRepository.findByEtat(etat);
    }

    public List<PiecesModel> findByDate(String date) {
        return piecesRepository.findByDate(date);
    }

    public List<PiecesModel> findByCodePiece(String codePiece) {
        return piecesRepository.findByCodePiece(codePiece);
    }

    public PiecesModel save(PiecesModel piecesModel){
        return piecesRepository.save(piecesModel);
    };

    public PiecesModel update(PiecesModel piecesModel){
        return piecesRepository.save(piecesModel);
    };

    public void delete(String id){
        piecesRepository.deleteById(id);
    };
}

