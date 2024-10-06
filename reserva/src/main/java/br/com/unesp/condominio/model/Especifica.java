package br.com.unesp.condominio.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ESPECIFICA")
public class Especifica extends Area {

    private String descricao;

    public Especifica() {
    }

    // Getters e Setters
}
