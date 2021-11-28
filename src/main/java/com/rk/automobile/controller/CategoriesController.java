package com.rk.automobile.controller;

import com.rk.automobile.Validation;
import com.rk.automobile.model.CategoriesModel;
import com.rk.automobile.service.CategoriesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoriesController {
    private final CategoriesService categoriesService;

    @GetMapping("/categories")
    public ResponseEntity<List<CategoriesModel>> findAll() {
        return ResponseEntity.ok(categoriesService.findAll());
    }

    @PostMapping("/categories")
    public ResponseEntity<Object> save(@RequestBody CategoriesModel categoriesModel) {
        if (Validation.isEmpty(categoriesModel.getCodeCategorie())) {
            return ResponseEntity.ok("Le champs code de la categorie ne peut être vide.");
        } else if (Validation.isEmpty(categoriesModel.getIntituleCategorie())) {
            return ResponseEntity.ok("Le champs nom de la categorie ne peut être vide.");
        } else {
            if (categoriesService.findByCode(categoriesModel.getCodeCategorie()).isEmpty() && categoriesService.findByIntitule(categoriesModel.getIntituleCategorie()).isEmpty()) {
                categoriesService.save(categoriesModel);
                return ResponseEntity.ok("Insertion effectuée avec succès.");
            } else if (categoriesService.findByIntitule(categoriesModel.getIntituleCategorie()).isEmpty()) {
                return ResponseEntity.ok("La categorie possédant ce code existe déjà dans la base de donnée.");
            } else {
                return ResponseEntity.ok("La categorie possédant ce nom existe déjà dans la base de donnée.");
            }
        }
    }

    @PutMapping("/categories")
    public ResponseEntity<Object> update(@RequestBody CategoriesModel categoriesModel) {
        if (Validation.isEmpty(categoriesModel.getCodeCategorie())) {
            return ResponseEntity.ok("Le champs code de la categorie ne peut être vide.");
        } else if (Validation.isEmpty(categoriesModel.getIntituleCategorie())) {
            return ResponseEntity.ok("Le champs nom de la categorie ne peut être vide.");
        } else {
            List<CategoriesModel> categorieUpd = categoriesService.findByCode(categoriesModel.getCodeCategorie());
            if (categorieUpd.isEmpty()) {
                return ResponseEntity.ok("La categorie possédant ce code(" + categoriesModel.getCodeCategorie() + ") est inexistante en bd.");
            } else {
                for (int i=0; i < categorieUpd.size(); i++){
                    categorieUpd.get(i).setIntituleCategorie(categoriesModel.getIntituleCategorie());
                    categoriesService.update(categorieUpd.get(i));
                }
                return ResponseEntity.ok("Modification effectuée avec succès.");
            }
        }
    }

    @DeleteMapping("/categories")
    public ResponseEntity<Object> delete(@RequestParam String id) {
        List<CategoriesModel> categorieDel = categoriesService.findByCode(id);
        if (categorieDel.isEmpty()) {
            return ResponseEntity.ok("La categorie possédant ce code(" + id + ") est inexistante en bd.");
        } else {
            for (int i=0; i < categorieDel.size(); i++)
                categoriesService.delete(categorieDel.get(i).getId());
            return ResponseEntity.ok("Suppression effectuée avec succès");
        }
    }
}
