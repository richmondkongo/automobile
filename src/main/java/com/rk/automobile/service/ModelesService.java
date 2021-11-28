package com.rk.automobile.service;

import com.rk.automobile.model.ModelesModel;
import com.rk.automobile.repository.ModelesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModelesService{
    private final ModelesRepository modelesRepository;

    public List<ModelesModel> findAll() {
        return modelesRepository.findAll();
    }

    public Optional<ModelesModel> findById(String id) {
        return modelesRepository.findById(id);
    }

    public List<ModelesModel> findByCode(String codeModele) {
        return modelesRepository.findByCodeModele(codeModele);
    }

    public List<ModelesModel> findByNom(String nomModele) {
        return modelesRepository.findByNomModele(nomModele);
    }

    public List<ModelesModel> findByAnnee(int anneeModele) {
        return modelesRepository.findByAnneeModele(anneeModele);
    }

    public List<ModelesModel> findByCodeMarque(String codeMarque) {
        return modelesRepository.findByCodeMarque(codeMarque);
    }

    public ModelesModel save(ModelesModel modelesModel){
        return modelesRepository.save(modelesModel);
    };

    public ModelesModel update(ModelesModel modelesModel){
        return modelesRepository.save(modelesModel);
    };

    public void delete(String id){
        modelesRepository.deleteById(id);
    };
}

