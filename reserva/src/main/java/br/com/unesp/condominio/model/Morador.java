package br.com.unesp.condominio.model;

import jakarta.persistence.*;

@Entity
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMorador;

    @Enumerated(EnumType.STRING)
    private TipoMorador moradorTipo;

    public Morador() {
    }

    // Getters e Setters
    public int getIdMorador() {
        return idMorador;
    }

    public void setIdMorador(int idMorador) {
        this.idMorador = idMorador;
    }

    public TipoMorador getMoradorTipo() {
        return moradorTipo;
    }

    public void setMoradorTipo(TipoMorador moradorTipo) {
        this.moradorTipo = moradorTipo;
    }
}
