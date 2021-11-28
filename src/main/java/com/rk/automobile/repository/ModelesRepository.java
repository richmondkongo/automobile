package com.rk.automobile.repository;

import com.rk.automobile.model.ModelesModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ModelesRepository extends MongoRepository<ModelesModel, String> {
    List<ModelesModel> findByCodeModele(String codeModele);
    List<ModelesModel> findByNomModele(String nomModele);
    List<ModelesModel> findByAnneeModele(int anneeModele);
    List<ModelesModel> findByCodeMarque(String codeMarque);
}
