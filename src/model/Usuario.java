package model;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Evento;
import java.util.stream.Collectors;
import java.io.Serializable;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private List<Evento> eventosInscritos;

    public Usuario(String nome, String endereco, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public List<Evento> getEventosInscritos() {
        return eventosInscritos;
    }

    public void cadastrarParticipacaoEvento(Evento evento) {
        eventosInscritos.add(evento);
    }

    public void cancelarParticipacaoEvento(Evento evento) {
        eventosInscritos.remove(evento);
    }

    @Override
    public String toString() {
        String eventosStr = eventosInscritos.stream()
            .map(Evento::toString)
            .collect(Collectors.joining(", "));

        return "Usuario{" +
            "nome='" + nome + '\'' +
            ", endereco='" + endereco + '\'' +
            ", telefone='" + telefone + '\'' +
            ", email='" + email + '\'' +
            ", Eventos Inscritos={" + eventosStr + "}" +
            '}';
    }
}

