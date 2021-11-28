package com.rk.automobile.service;

import com.rk.automobile.model.CategoriesModel;
import com.rk.automobile.repository.CategoriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoriesService{
    private final CategoriesRepository categoriesRepository;

    public List<CategoriesModel> findAll() {
        return categoriesRepository.findAll();
    }

    public Optional<CategoriesModel> findById(String id) {
        return categoriesRepository.findById(id);
    }

    public List<CategoriesModel> findByCode(String codeCategorie) {
        return categoriesRepository.findByCodeCategorie(codeCategorie);
    }

    public List<CategoriesModel> findByIntitule(String IntituleCategorie) {
        return categoriesRepository.findByIntituleCategorie(IntituleCategorie);
    }

    public CategoriesModel save(CategoriesModel categoriesModel){
        return categoriesRepository.save(categoriesModel);
    };

    public CategoriesModel update(CategoriesModel categoriesModel){
        return categoriesRepository.save(categoriesModel);
    };

    public void delete(String id){
        categoriesRepository.deleteById(id);
    };
}

