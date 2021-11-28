package com.rk.automobile.repository;

import com.rk.automobile.model.CategoriesModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoriesRepository extends MongoRepository<CategoriesModel, String> {
    List<CategoriesModel> findByCodeCategorie(String codeCategorie);
    List<CategoriesModel> findByIntituleCategorie(String intutileCategorie);
}
