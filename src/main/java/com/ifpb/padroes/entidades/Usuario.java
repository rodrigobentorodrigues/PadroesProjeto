
package com.ifpb.padroes.entidades;

import com.ifpb.padroes.enums.Papel;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private int matricula;
    private Papel papel;
    
    public Usuario(){};

    public Usuario(String nome, String email, String senha, int matricula, Papel papel) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.matricula = matricula;
        this.papel = papel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", email=" + email + ", senha=" + senha + ", matricula=" + matricula + ", papel=" + papel + '}';
    }
    
    
}
