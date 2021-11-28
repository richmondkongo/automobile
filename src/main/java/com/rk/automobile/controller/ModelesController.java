package com.rk.automobile.controller;

import com.rk.automobile.Validation;
import com.rk.automobile.model.ModelesModel;
import com.rk.automobile.service.MarquesService;
import com.rk.automobile.service.ModelesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ModelesController {
    private final ModelesService modelesService;
    private final MarquesService marquesService;

    @GetMapping("/modeles")
    public ResponseEntity<List<ModelesModel>> findAll() {
        return ResponseEntity.ok(modelesService.findAll());
    }

    @PostMapping("/modeles")
    public ResponseEntity<Object> save(@RequestBody ModelesModel modelesModel) {
        if (Validation.isEmpty(modelesModel.getCodeModele())) {
            return ResponseEntity.ok("Le champs code du modèle ne peut être vide.");
        } else if (Validation.isEmpty(modelesModel.getNomModele())) {
            return ResponseEntity.ok("Le champs nom du modèle ne peut être vide.");
        } else if (Validation.isNotYear(Integer.toString(modelesModel.getAnneeModele()))) {
            return ResponseEntity.ok("Le champs année du modèle doit contenir quatre chiffre.");
        } else if (Validation.isEmpty(modelesModel.getCodeMarque())){
            return ResponseEntity.ok("Le champs codeMarque du modèle doit contenir le code d'une marque.");
        } else {
            if (modelesService.findByCode(modelesModel.getCodeModele()).isEmpty() && marquesService.findByCode(modelesModel.getCodeMarque()).size() !=0) {
                modelesService.save(modelesModel);
                return ResponseEntity.ok("Insertion effectuée avec succès.");
            } else if (marquesService.findByCode(modelesModel.getCodeMarque()).size() == 0) {
                return ResponseEntity.ok("La marque spécifiée pour ce modèle est inexistante dans la base de donnée.");
            } else {
                return ResponseEntity.ok("Le modèle possédant ce code existe déjà dans la base de donnée.");
            }

            /*else if (modelesService.findByCode(modelesModel.getCodeModele()).size() != 0) {
                return ResponseEntity.ok("Le modèle possédant ce code existe déjà dans la base de donnée.");
            } else {
                return ResponseEntity.ok("Le modèle possédant ce nom et cette année existe déjà dans la base de donnée.");
            }*/
        }
    }

    @PutMapping("/modeles")
    public ResponseEntity<Object> update(@RequestBody ModelesModel modelesModel) {
        if (Validation.isEmpty(modelesModel.getCodeModele())) {
            return ResponseEntity.ok("Le champs code du modèle ne peut être vide.");
        } else if (Validation.isEmpty(modelesModel.getNomModele())) {
            return ResponseEntity.ok("Le champs nom du modèle ne peut être vide.");
        } else if (Validation.isNotYear(Integer.toString(modelesModel.getAnneeModele()))) {
            return ResponseEntity.ok("Le champs année du modèle doit contenir quatre chiffre.");
        } else if (Validation.isEmpty(modelesModel.getCodeMarque())){
            return ResponseEntity.ok("Le champs codeMarque du modèle doit contenir le code d'une marque.");
        } else {
            List<ModelesModel> modeleUpd = modelesService.findByCode(modelesModel.getCodeModele());
            if (modeleUpd.isEmpty()) {
                return ResponseEntity.ok("Le modèle possédant ce code(" + modelesModel.getCodeModele() + ") est inexistante en bd.");
            } else if (marquesService.findByCode(modelesModel.getCodeMarque()).size() == 0) {
                return ResponseEntity.ok("La marque spécifiée pour ce modèle est inexistante dans la base de donnée.");
            } else {
                for (int i=0; i < modeleUpd.size(); i++){
                    modeleUpd.get(i).setNomModele(modelesModel.getNomModele());
                    modeleUpd.get(i).setAnneeModele(modelesModel.getAnneeModele());
                    modeleUpd.get(i).setCodeMarque(modelesModel.getCodeMarque());
                    modelesService.update(modeleUpd.get(i));
                }
                return ResponseEntity.ok("Modification effectuée avec succès.");
            }
        }
    }

    @DeleteMapping("/modeles")
    public ResponseEntity<Object> delete(@RequestParam String id) {
        List<ModelesModel> modeleDel = modelesService.findByCode(id);
        if (modeleDel.isEmpty()) {
            return ResponseEntity.ok("Le modèle possédant ce code(" + id + ") est inexistante en bd.");
        } else {
            for (int i=0; i < modeleDel.size(); i++)
                modelesService.delete(modeleDel.get(i).getId());
            return ResponseEntity.ok("Suppression effectuée avec succès");
        }
    }
}
