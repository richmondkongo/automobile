package com.rk.automobile.service;

import com.rk.automobile.model.TypesPieceModel;
import com.rk.automobile.repository.TypesPieceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TypesPieceService{
    private final TypesPieceRepository typesPieceRepository;;

    public List<TypesPieceModel> findAll() {
        return typesPieceRepository.findAll();
    }

    public Optional<TypesPieceModel> findById(String id) {
        return typesPieceRepository.findById(id);
    }

    public List<TypesPieceModel> findByCode(String codeTypePiece) {
        return typesPieceRepository.findByCodeTypePiece(codeTypePiece);
    }

    public List<TypesPieceModel> findByRefConstructeur(String refConstructeur) {
        return typesPieceRepository.findByRefConstructeur(refConstructeur);
    }

    public List<TypesPieceModel> findByPrix(int prix) {
        return typesPieceRepository.findByPrix(prix);
    }

    public List<TypesPieceModel> findByCodeCategorie(String codeCategorie) {
        return typesPieceRepository.findByCodeCategorie(codeCategorie);
    }

    public TypesPieceModel save(TypesPieceModel typesPieceModel){
        return typesPieceRepository.save(typesPieceModel);
    };

    public TypesPieceModel update(TypesPieceModel typesPieceModel){
        return typesPieceRepository.save(typesPieceModel);
    };

    public void delete(String id){
        typesPieceRepository.deleteById(id);
    };
}

