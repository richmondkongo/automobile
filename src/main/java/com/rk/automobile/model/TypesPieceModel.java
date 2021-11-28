package com.rk.automobile.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("typesPiece")
public class TypesPieceModel {
    @Id
    private String id;
    private String codeTypePiece;
    private String refConstructeur;
    private int prix;
    private String codeCategorie;

    public TypesPieceModel(String codeTypePiece, String refConstructeur, int prix, String codeCategorie) {
        this.codeTypePiece = codeTypePiece;
        this.refConstructeur = refConstructeur;
        this.prix = prix;
        this.codeCategorie = codeCategorie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodeTypePiece() {
        return codeTypePiece;
    }

    public void setCodeTypePiece(String codeTypePiece) {
        this.codeTypePiece = codeTypePiece;
    }

    public void setRefConstructeur(String refConstructeur) {
        this.refConstructeur = refConstructeur;
    }

    public String getRefConstructeur() {
        return refConstructeur;
    }

    public void setPrix(String refConstructeur) {
        this.refConstructeur = refConstructeur;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getPrix() { return prix; }

    public String getCodeCategorie() {
        return codeCategorie;
    }

    public void setCodeCategorie(String codeCategorie) {
        this.codeCategorie = codeCategorie;
    }
}
