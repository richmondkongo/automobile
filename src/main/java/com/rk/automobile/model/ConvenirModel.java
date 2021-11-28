package com.rk.automobile.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("convenir")
public class ConvenirModel {
    @Id
    private String id;
    //private String codeConvenir;
    private String codeTypePiece;
    private String codeModele;

    public ConvenirModel(String codeTypePiece, String codeModele) {
        this.codeTypePiece = codeTypePiece;
        this.codeModele = codeModele;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /*
    public String getCodeConvenir() {
        return codeConvenir;
    }

    public void setCodeConvenir(String codeConvenir) {
        this.codeConvenir = codeConvenir;
    }
    */

    public String getCodeTypePiece() {
        return codeTypePiece;
    }

    public void setCodeTypePiece(String codeTypePiece) {
        this.codeTypePiece = codeTypePiece;
    }

    public String getCodeModele() {
        return codeModele;
    }

    public void setCodeModele(String codeModele) {
        this.codeModele = codeModele;
    }
}
