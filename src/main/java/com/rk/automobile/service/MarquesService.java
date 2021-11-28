package com.rk.automobile.service;

import com.rk.automobile.model.MarquesModel;
import com.rk.automobile.repository.MarquesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MarquesService{
    private final MarquesRepository marquesRepository;

    public List<MarquesModel> findAll() {
        return marquesRepository.findAll();
    }

    public Optional<MarquesModel> findById(String id) {
        return marquesRepository.findById(id);
    }

    public List<MarquesModel> findByCode(String codeMarque) {
        return marquesRepository.findByCodeMarque(codeMarque);
    }

    public List<MarquesModel> findByNom(String nomMarque) {
        return marquesRepository.findByNomMarque(nomMarque);
    }

    public MarquesModel save(MarquesModel marquesModel){
        return marquesRepository.save(marquesModel);
    };

    public MarquesModel update(MarquesModel marquesModel){
        return marquesRepository.save(marquesModel);
    };

    public void delete(String id){
        marquesRepository.deleteById(id);
    };
}

