package com.rk.automobile.controller;

import com.rk.automobile.Validation;
import com.rk.automobile.model.ConvenirModel;
import com.rk.automobile.service.ConvenirService;
import com.rk.automobile.service.ModelesService;
import com.rk.automobile.service.TypesPieceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ConvenirController {
    private final ConvenirService convenirService;
    private final TypesPieceService typesPieceService;
    private final ModelesService modelesService;

    @GetMapping("/convenir")
    public ResponseEntity<List<ConvenirModel>> findAll() {
        return ResponseEntity.ok(convenirService.findAll());
    }

    @PostMapping("/convenir")
    public ResponseEntity<Object> save(@RequestBody ConvenirModel convenirModel) {
        if (Validation.isEmpty(convenirModel.getCodeModele())) {
            return ResponseEntity.ok("Le champs codeModele de convenir ne peut être vide.");
        } else if (Validation.isEmpty(convenirModel.getCodeTypePiece())) {
            return ResponseEntity.ok("Le champs codeTypePiece de la convenir ne peut être vide.");
        } else {
            if (typesPieceService.findByCode(convenirModel.getCodeTypePiece()).size() != 0 && modelesService.findByCode(convenirModel.getCodeModele()).size() !=0) {
                if (convenirService.findByCode(convenirModel.getCodeModele(), convenirModel.getCodeTypePiece()).isEmpty()) {
                    //convenirModel.setCodeConvenir(String.valueOf(System.currentTimeMillis()));
                    convenirService.save(convenirModel);
                    return ResponseEntity.ok("Insertion effectuée avec succès.");
                } else {
                    return ResponseEntity.ok("Cette insertion existe déjà en base.");
                }
            } else if (typesPieceService.findByCode(convenirModel.getCodeTypePiece()).isEmpty()) {
                return ResponseEntity.ok("Le code de type pièce est inexistant dans la base de donnée.");
            } else {
                return ResponseEntity.ok("Le code de modèle est inexistant dans la base de donnée.");
            }
        }
    }
    @PutMapping("/convenir")
    public ResponseEntity<Object> update(@RequestBody ConvenirModel convenirModel) {
        if (Validation.isEmpty(convenirModel.getId())) {
            return ResponseEntity.ok("Le champs id de convenir ne peut être vide.");
        } else if (Validation.isEmpty(convenirModel.getCodeModele())) {
            return ResponseEntity.ok("Le champs codeModele de convenir ne peut être vide.");
        } else if (Validation.isEmpty(convenirModel.getCodeTypePiece())) {
            return ResponseEntity.ok("Le champs codeTypePiece de la convenir ne peut être vide.");
        } else {
            if (typesPieceService.findByCode(convenirModel.getCodeTypePiece()).size() != 0 && modelesService.findByCode(convenirModel.getCodeModele()).size() !=0) {
                Optional<ConvenirModel> convenirUpd = convenirService.findById(convenirModel.getId());
                try{
                    convenirUpd.get().setCodeTypePiece(convenirModel.getCodeTypePiece());
                    convenirUpd.get().setCodeModele(convenirModel.getCodeModele());
                    convenirService.update(convenirUpd.get());
                    return ResponseEntity.ok("Modification effectuée avec succès.");
                } catch (Exception e) {
                    return ResponseEntity.ok("L'enregistrement avec cette identifiant est inexistant en base.");
                }
            } else if (typesPieceService.findByCode(convenirModel.getCodeTypePiece()).isEmpty()) {
                return ResponseEntity.ok("Le code de type pièce est inexistant dans la base de donnée.");
            } else {
                return ResponseEntity.ok("Le code de modèle est inexistant dans la base de donnée.");
            }
        }
    }

    @DeleteMapping("/convenir")
    public ResponseEntity<Object> delete(@RequestBody ConvenirModel convenirModel) {
    if (Validation.isEmpty(convenirModel.getCodeModele())) {
            return ResponseEntity.ok("Le champs codeModele de convenir ne peut être vide.");
        } else if (Validation.isEmpty(convenirModel.getCodeTypePiece())) {
            return ResponseEntity.ok("Le champs codeTypePiece de la convenir ne peut être vide.");
        } else {
            if (typesPieceService.findByCode(convenirModel.getCodeTypePiece()).size() != 0 && modelesService.findByCode(convenirModel.getCodeModele()).size() !=0) {
                List<ConvenirModel> convenirUpd = convenirService.findByCode(convenirModel.getCodeModele(), convenirModel.getCodeTypePiece());
                if (convenirUpd.size() != 0) {
                    for (int i=0; i < convenirUpd.size(); i++)
                        convenirService.delete(convenirUpd.get(i).getId());
                    return ResponseEntity.ok("Suppression effectuée avec succès.");
                } else {
                    return ResponseEntity.ok("Cette relation de convenir est inexistante en base.");
                }
            } else if (typesPieceService.findByCode(convenirModel.getCodeTypePiece()).isEmpty()) {
                return ResponseEntity.ok("Le code de type pièce est inexistant dans la base de donnée.");
            } else {
                return ResponseEntity.ok("Le code de modèle est inexistant dans la base de donnée.");
            }
        }
    }
}
