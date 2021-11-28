package com.rk.automobile.controller;

import com.rk.automobile.Validation;
import com.rk.automobile.model.PiecesModel;
import com.rk.automobile.service.CategoriesService;
import com.rk.automobile.service.PiecesService;
import com.rk.automobile.service.TypesPieceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PiecesController {
    private final PiecesService piecesService;
    private final TypesPieceService typesPieceService;

    @GetMapping("/pieces")
    public ResponseEntity<List<PiecesModel>> findAll() {
        return ResponseEntity.ok(piecesService.findAll());
    }

    @PostMapping("/pieces")
    public ResponseEntity<Object> save(@RequestBody PiecesModel piecesModel) {
        if (Validation.isEmpty(piecesModel.getCodeTypePiece())) {
            return ResponseEntity.ok("Le champs type piece de pièce ne peut être vide.");
        } else if (Validation.isEmpty(piecesModel.getEtat())) {
            return ResponseEntity.ok("Le champs etat de pièce ne peut être vide.");
        } else if (Validation.isEmpty(piecesModel.getDate())) {
            return ResponseEntity.ok("Le champs date de pièce ne peut être vide.");
        } else if (Validation.isEmpty(piecesModel.getCodePiece())){
            return ResponseEntity.ok("Le champs codePiece de pièce ne peut être vide.");
        } else {
            if (piecesService.findByCodePiece(piecesModel.getCodePiece()).isEmpty() && typesPieceService.findByCode(piecesModel.getCodeTypePiece()).size() !=0) {
                piecesService.save(piecesModel);
                return ResponseEntity.ok("Insertion effectuée avec succès.");
            } else if (typesPieceService.findByCode(piecesModel.getCodeTypePiece()).size() == 0) {
                return ResponseEntity.ok("Le type de pièce spécifié pour cette pièce est inexistante dans la base de donnée.");
            } else {
                return ResponseEntity.ok("La pièce possédant ce code existe déjà dans la base de donnée.");
            }
        }
    }

    @PutMapping("/pieces")
    public ResponseEntity<Object> update(@RequestBody PiecesModel piecesModel) {
        if (Validation.isEmpty(piecesModel.getCodeTypePiece())) {
            return ResponseEntity.ok("Le champs type piece de pièce ne peut être vide.");
        } else if (Validation.isEmpty(piecesModel.getEtat())) {
            return ResponseEntity.ok("Le champs etat de pièce ne peut être vide.");
        } else if (Validation.isEmpty(piecesModel.getDate())) {
            return ResponseEntity.ok("Le champs date de pièce ne peut être vide.");
        } else if (Validation.isEmpty(piecesModel.getCodePiece())){
            return ResponseEntity.ok("Le champs codePiece de pièce ne peut être vide.");
        } else {
            List<PiecesModel> pieceUpd = piecesService.findByCodePiece(piecesModel.getCodePiece());
            if (pieceUpd.isEmpty()) {
                return ResponseEntity.ok("La pièce possédant ce code(" + piecesModel.getCodePiece() + ") est inexistante en bd.");
            } else if (typesPieceService.findByCode(piecesModel.getCodeTypePiece()).size() == 0) {
                return ResponseEntity.ok("Le type de pièce spécifié pour cette pièce est inexistante dans la base de donnée.");
            } else {
                for (int i=0; i < pieceUpd.size(); i++){
                    pieceUpd.get(i).setCodeTypePiece(piecesModel.getCodeTypePiece());
                    pieceUpd.get(i).setEtat(piecesModel.getEtat());
                    pieceUpd.get(i).setDate(piecesModel.getDate());
                    piecesService.update(pieceUpd.get(i));
                }
                return ResponseEntity.ok("Modification effectuée avec succès.");
            }
        }
    }

    @DeleteMapping("/pieces")
    public ResponseEntity<Object> delete(@RequestParam String id) {
        List<PiecesModel> pieceDel = piecesService.findByCodePiece(id);
        if (pieceDel.isEmpty()) {
            return ResponseEntity.ok("La pièce possédant ce code(" + id + ") est inexistante en bd.");
        } else {
            for (int i=0; i < pieceDel.size(); i++)
                piecesService.delete(pieceDel.get(i).getId());
            return ResponseEntity.ok("Suppression effectuée avec succès");
        }
    }
}
