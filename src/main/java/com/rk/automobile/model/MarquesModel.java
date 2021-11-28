package com.rk.automobile.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("marques")
public class MarquesModel {
    @Id
    private String id;
    private String codeMarque;
    private String nomMarque;

    public MarquesModel(String codeMarque, String nomMarque) {
        this.codeMarque = codeMarque;
        this.nomMarque = nomMarque;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodeMarque() {
        return codeMarque;
    }

    public void setCodeMarque(String codeMarque) {
        this.codeMarque = codeMarque;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }
}
