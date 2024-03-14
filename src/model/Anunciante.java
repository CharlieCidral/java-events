package model;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.Serializable;

import model.Evento;

public class Anunciante implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private List<Evento> eventosCriados;

    public Anunciante(String nome, String endereco, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.eventosCriados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void cadastrarNovoEvento(Evento evento) {
        System.out.println("Evento CA cadastrado com sucesso!");
        eventosCriados.add(evento);
    }

    public void excluirEvento(String nomeEvento) {
        eventosCriados.removeIf(e -> e.getNome().equals(nomeEvento));
    }

    public List<Evento> getEventosCriados() {
        return eventosCriados;
    }

    @Override
    public String toString() {
        String eventosStr = eventosCriados.stream()
            .map(Evento::toString)
            .collect(Collectors.joining(", "));

        return "Anunciante{" +
            "nome='" + nome + '\'' +
            ", endereco='" + endereco + '\'' +
            ", telefone='" + telefone + '\'' +
            ", email='" + email + '\'' +
            ", Eventos Criados={" + eventosStr + "}" +
            '}';
    }
}
