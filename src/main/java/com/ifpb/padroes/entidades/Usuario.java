package com.ifpb.padroes.entidades;

import com.ifpb.padroes.enums.Papel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "minha_seq",
        sequenceName = "seq_usu",
        initialValue = 3, allocationSize = 1)
@NamedQueries(
@NamedQuery(name = "Usuario.login", 
        query = "SELECT u FROM Usuario u WHERE u.nome = :login AND u.senha = :senha"
                + " OR u.email = :email AND u.senha = :senha")
)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "minha_seq")
    private int id;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 60)
    private String email;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false)
    private int matricula;
    @Enumerated(EnumType.STRING)
    private Papel papel;
    
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "responsavel")
    private List<Evento> eventos;

    public Usuario() {
        this.eventos = new ArrayList<>();
    }

    public Usuario(String nome, String email, String senha, int matricula, Papel papel) {
        this();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.matricula = matricula;
        this.papel = papel;
    }

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

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    public boolean add(Evento evento){
        return eventos.add(evento);
    }
    
    public boolean remove(Evento evento){
        return eventos.remove(evento);
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", email=" + email + ", senha=" + senha + ", matricula=" + matricula + ", papel=" + papel + '}';
    }

}
