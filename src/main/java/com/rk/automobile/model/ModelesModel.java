package com.rk.automobile.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("modeles")
public class ModelesModel {
    @Id
    private String id;
    private String codeModele;
    private String nomModele;
    private int anneeModele;
    private String codeMarque;

    public ModelesModel(String codeModele, String nomModele, int anneeModele, String codeMarque) {
        this.codeModele = codeModele;
        this.nomModele = nomModele;
        this.anneeModele = anneeModele;
        this.codeMarque = codeMarque;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodeModele() {
        return codeModele;
    }

    public void setCodeModele(String codeModele) {
        this.codeModele = codeModele;
    }

    public void setNomModele(String nomModele) { this.nomModele = nomModele; }

    public String getNomModele() {
        return nomModele;
    }

    public void setAnneeModele(String nomModele) {
        this.nomModele = nomModele;
    }

    public void setAnneeModele(int anneeModele) {
        this.anneeModele = anneeModele;
    }

    public int getAnneeModele() { return anneeModele; }

    public String getCodeMarque() { return codeMarque; }

    public void setCodeMarque(String codeMarque) {this.codeMarque = codeMarque; }
}
