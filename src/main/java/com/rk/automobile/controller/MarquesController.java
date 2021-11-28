package com.rk.automobile.controller;

import com.rk.automobile.Validation;
import com.rk.automobile.model.MarquesModel;
import com.rk.automobile.service.MarquesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class MarquesController {
    private final MarquesService marquesService;

    @GetMapping("/marques")
    public ResponseEntity<List<MarquesModel>> findAll() {
        return ResponseEntity.ok(marquesService.findAll());
    }

    @PostMapping("/marques")
    public ResponseEntity<Object> save(@RequestBody MarquesModel marquesModel) {
        if (Validation.isEmpty(marquesModel.getCodeMarque())) {
            return ResponseEntity.ok("Le champs code de la marque ne peut être vide.");
        } else if (Validation.isEmpty(marquesModel.getNomMarque())) {
            return ResponseEntity.ok("Le champs nom de la marque ne peut être vide.");
        } else {
            if (marquesService.findByCode(marquesModel.getCodeMarque()).isEmpty() && marquesService.findByNom(marquesModel.getNomMarque()).isEmpty()) {
                marquesService.save(marquesModel);
                return ResponseEntity.ok("Insertion effectuée avec succès.");
            } else if (marquesService.findByNom(marquesModel.getNomMarque()).isEmpty()) {
                return ResponseEntity.ok("La marque possédant ce code existe déjà dans la base de donnée.");
            } else {
                return ResponseEntity.ok("La marque possédant ce nom existe déjà dans la base de donnée.");
            }
        }
    }

    @PutMapping("/marques")
    public ResponseEntity<Object> update(@RequestBody MarquesModel marquesModel) {
        if (Validation.isEmpty(marquesModel.getCodeMarque())) {
            return ResponseEntity.ok("Le champs code de la marque ne peut être vide.");
        } else if (Validation.isEmpty(marquesModel.getNomMarque())) {
            return ResponseEntity.ok("Le champs nom de la marque ne peut être vide.");
        } else {
            List<MarquesModel> marqueUpd = marquesService.findByCode(marquesModel.getCodeMarque());
            if (marqueUpd.isEmpty()) {
                return ResponseEntity.ok("La marque possédant ce code(" + marquesModel.getCodeMarque() + ") est inexistante en bd.");
            } else {
                for (int i=0; i < marqueUpd.size(); i++){
                    marqueUpd.get(i).setNomMarque(marquesModel.getNomMarque());
                    marquesService.update(marqueUpd.get(i));
                }
                return ResponseEntity.ok("Modification effectuée avec succès.");
            }
        }
    }

    @DeleteMapping("/marques")
    public ResponseEntity<Object> delete(@RequestParam String id) {
        List<MarquesModel> marqueDel = marquesService.findByCode(id);
        if (marqueDel.isEmpty()) {
            return ResponseEntity.ok("La marque possédant ce code(" + id + ") est inexistante en bd.");
        } else {
            for (int i=0; i < marqueDel.size(); i++)
                marquesService.delete(marqueDel.get(i).getId());
            return ResponseEntity.ok("Suppression effectuée avec succès");
        }
    }
}
