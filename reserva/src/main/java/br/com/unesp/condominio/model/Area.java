package br.com.unesp.condominio.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "area_type", discriminatorType = DiscriminatorType.STRING)
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String descricao;
    private int tamanhoMetroQuadrado;
    private boolean utilizavel;

    public Area() {
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTamanhoMetroQuadrado() {
        return tamanhoMetroQuadrado;
    }

    public void setTamanhoMetroQuadrado(int tamanhoMetroQuadrado) {
        this.tamanhoMetroQuadrado = tamanhoMetroQuadrado;
    }

    public boolean isUtilizavel() {
        return utilizavel;
    }

    public void setUtilizavel(boolean utilizavel) {
        this.utilizavel = utilizavel;
    }
}
