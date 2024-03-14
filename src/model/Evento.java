package model;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.Serializable;

public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String endereco;
    private String categoria;
    private LocalDateTime horario;
    private String descricao;
    private String telefone;
    private String email;
    private String nomeAnunciante;
    private List<Usuario> participantes;

    public Evento(String nome, String endereco, String categoria, LocalDateTime horario, String descricao, String telefone, String email, String nomeAnunciante) {
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
        this.horario = horario;
        this.descricao = descricao;
        this.telefone = telefone;
        this.email = email;
        this.nomeAnunciante = nomeAnunciante;
        this.participantes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCategoria() {
        return categoria;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getNomeAnunciante() {
        return nomeAnunciante;
    }

    public void salvarParticipante(Usuario usuario, Evento evento) {
        participantes.add(usuario);
    }

    public void cancelarParticipacao(Usuario usuario, Evento evento) {
        participantes.remove(usuario);
    }

    public List<Usuario> getInscritos() {
        return participantes;
    }

     @Override
    public String toString() {
        String participantesStr = participantes.stream()
            .map(Usuario::toString)
            .collect(Collectors.joining(", "));

        return "Evento{" +
            "nome='" + nome + '\'' +
            ", endereco='" + endereco + '\'' +
            ", categoria='" + categoria + '\'' +
            ", horario=" + horario +
            ", descricao='" + descricao + '\'' +
            ", telefone='" + telefone + '\'' +
            ", email='" + email + '\'' +
            ", nome Anunciante='" + nomeAnunciante + '\'' +
            ", Participantes={" + participantesStr + "}" +
            '}';
    }
}

