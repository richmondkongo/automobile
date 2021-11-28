package com.rk.automobile.controller;

import com.rk.automobile.Validation;
import com.rk.automobile.model.TypesPieceModel;
import com.rk.automobile.service.CategoriesService;
import com.rk.automobile.service.TypesPieceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TypesPieceController {
    private final TypesPieceService typesPieceService;
    private final CategoriesService categoriesService;

    @GetMapping("/types-piece")
    public ResponseEntity<List<TypesPieceModel>> findAll() {
        return ResponseEntity.ok(typesPieceService.findAll());
    }

    @PostMapping("/types-piece")
    public ResponseEntity<Object> save(@RequestBody TypesPieceModel typesPieceModel) {
        if (Validation.isEmpty(typesPieceModel.getCodeTypePiece())) {
            return ResponseEntity.ok("Le champs code du type de pièce ne peut être vide.");
        } else if (Validation.isEmpty(typesPieceModel.getRefConstructeur())) {
            return ResponseEntity.ok("Le champs nom du type de pièce ne peut être vide.");
        } else if (Validation.isNotYear(Integer.toString(typesPieceModel.getPrix()))) {
            return ResponseEntity.ok("Le champs année du type de pièce doit contenir quatre chiffre.");
        } else if (Validation.isEmpty(typesPieceModel.getCodeCategorie())){
            return ResponseEntity.ok("Le champs codeCategorie du type de pièce doit contenir le code d'une marque.");
        } else {
            if (typesPieceService.findByCode(typesPieceModel.getCodeTypePiece()).isEmpty() && categoriesService.findByCode(typesPieceModel.getCodeCategorie()).size() !=0) {
                typesPieceService.save(typesPieceModel);
                return ResponseEntity.ok("Insertion effectuée avec succès.");
            } else if (categoriesService.findByCode(typesPieceModel.getCodeCategorie()).size() == 0) {
                return ResponseEntity.ok("La catégorie spécifiée pour ce type de pièce est inexistante dans la base de donnée.");
            } else {
                return ResponseEntity.ok("Le type de pièce possédant ce code existe déjà dans la base de donnée.");
            }

            /*else if (typesPieceService.findByCode(typesPieceModel.getCodeTypePiece()).size() != 0) {
                return ResponseEntity.ok("Le type de pièce possédant ce code existe déjà dans la base de donnée.");
            } else {
                return ResponseEntity.ok("Le type de pièce possédant ce nom et cette année existe déjà dans la base de donnée.");
            }*/
        }
    }

    @PutMapping("/types-piece")
    public ResponseEntity<Object> update(@RequestBody TypesPieceModel typesPieceModel) {
        if (Validation.isEmpty(typesPieceModel.getCodeTypePiece())) {
            return ResponseEntity.ok("Le champs code du type de pièce ne peut être vide.");
        } else if (Validation.isEmpty(typesPieceModel.getRefConstructeur())) {
            return ResponseEntity.ok("Le champs refConstructeur du type de pièce ne peut être vide.");
        } else if (Validation.isNotPrice(Integer.toString(typesPieceModel.getPrix()))) {
            return ResponseEntity.ok("Le champs prix du type de pièce doit être un chiffre et non-vide.");
        } else if (Validation.isEmpty(typesPieceModel.getCodeCategorie())){
            return ResponseEntity.ok("Le champs codeCategorie du type de pièce doit contenir le code d'une catégorie.");
        } else {
            List<TypesPieceModel> typePieceUpd = typesPieceService.findByCode(typesPieceModel.getCodeTypePiece());
            if (typePieceUpd.isEmpty()) {
                return ResponseEntity.ok("Le type de pièce possédant ce code(" + typesPieceModel.getCodeTypePiece() + ") est inexistante en bd.");
            } else if (categoriesService.findByCode(typesPieceModel.getCodeCategorie()).size() == 0) {
                return ResponseEntity.ok("La catégorie spécifiée pour ce type de pièce est inexistante dans la base de donnée.");
            } else {
                for (int i=0; i < typePieceUpd.size(); i++){
                    typePieceUpd.get(i).setRefConstructeur(typesPieceModel.getRefConstructeur());
                    typePieceUpd.get(i).setPrix(typesPieceModel.getPrix());
                    typePieceUpd.get(i).setCodeCategorie(typesPieceModel.getCodeCategorie());
                    typesPieceService.update(typePieceUpd.get(i));
                }
                return ResponseEntity.ok("Modification effectuée avec succès.");
            }
        }
    }

    @DeleteMapping("/types-piece")
    public ResponseEntity<Object> delete(@RequestParam String id) {
        List<TypesPieceModel> typePieceDel = typesPieceService.findByCode(id);
        if (typePieceDel.isEmpty()) {
            return ResponseEntity.ok("Le type de pièce possédant ce code(" + id + ") est inexistante en bd.");
        } else {
            for (int i=0; i < typePieceDel.size(); i++)
                typesPieceService.delete(typePieceDel.get(i).getId());
            return ResponseEntity.ok("Suppression effectuée avec succès");
        }
    }
}
