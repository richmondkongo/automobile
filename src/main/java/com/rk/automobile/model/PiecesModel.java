package com.rk.automobile.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("pieces")
public class PiecesModel {
    @Id
    private String id;
    private String codePiece;
    private String etat;
    private String date;
    private String codeTypePiece;

    public PiecesModel(String id, String codePiece, String etat, String date, String codeTypePiece) {
        this.id = id;
        this.codePiece = codePiece;
        this.etat = etat;
        this.date = date;
        this.codeTypePiece = codeTypePiece;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodePiece() {
        return codePiece;
    }

    public void setCodePiece(String codePiece) {
        this.codePiece = codePiece;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCodeTypePiece() {
        return codeTypePiece;
    }

    public void setCodeTypePiece(String codeTypePiece) {
        this.codeTypePiece = codeTypePiece;
    }
}
