package br.com.unesp.condominio.model;

import jakarta.persistence.Entity;
import java.util.Date;

@Entity
public class AreaAlugavel extends Comum {

    private int limitePessoas;
    private boolean disponivel;
    private Date disponivelDe;
    private Date disponivelAte;

    public AreaAlugavel() {
    }

    // Getters e Setters
    public int getLimitePessoas() {
        return limitePessoas;
    }

    public void setLimitePessoas(int limitePessoas) {
        this.limitePessoas = limitePessoas;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Date getDisponivelDe() {
        return disponivelDe;
    }

    public void setDisponivelDe(Date disponivelDe) {
        this.disponivelDe = disponivelDe;
    }

    public Date getDisponivelAte() {
        return disponivelAte;
    }

    public void setDisponivelAte(Date disponivelAte) {
        this.disponivelAte = disponivelAte;
    }
}
