package com.rk.automobile.service;

import com.rk.automobile.model.ConvenirModel;
import com.rk.automobile.repository.ConvenirRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Vector;

@Service
@AllArgsConstructor
public class ConvenirService{
    private final ConvenirRepository convenirRepository;


    public List<ConvenirModel> findAll() {
        return convenirRepository.findAll();
    }

    public Optional<ConvenirModel> findById(String id) {
        return convenirRepository.findById(id);
    }


    public List<ConvenirModel> findByCode(String codeModele, String codeTypePiece) {
        List<ConvenirModel> convenirModelRetour = new Vector<>();
        List<ConvenirModel> convenirModelStock = convenirRepository.findByCodeModele(codeModele);
        for (ConvenirModel c: convenirModelStock) {
            if (c.getCodeTypePiece().equals(codeTypePiece)) {
                convenirModelRetour.add(c);
            }
        }
        return convenirModelRetour;
    }

    public List<ConvenirModel> findByCodeModele(String codeModele) {
        return convenirRepository.findByCodeModele(codeModele);
    }

    public List<ConvenirModel> findByCodeTypePiece(String codeTypePiece) {
        return convenirRepository.findByCodeTypePiece(codeTypePiece);
    }

    public ConvenirModel save(ConvenirModel convenirModel){
        return convenirRepository.save(convenirModel);
    };

    public ConvenirModel update(ConvenirModel convenirModel){
        return convenirRepository.save(convenirModel);
    };

    public void delete(String id){
        convenirRepository.deleteById(id);
    };
}

