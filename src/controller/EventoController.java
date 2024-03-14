package controller;

import model.Usuario;
import model.Evento;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class EventoController {
    private Evento evento;
    private Usuario usuario;
    private List<Evento> eventos;
    private final String FILENAME = "events.data";

    public EventoController() {
        this.usuario = usuario;
        eventos = new ArrayList<>();
    }

    public List<Evento> getEventos() {
        return this.eventos;
    }

    public void cadastrarEvento(String nome, String endereco, String categoria, LocalDateTime horario, String descricao, String telefone, String email, String nomeAnunciante) {
        Evento evento = new Evento(nome, endereco, categoria, horario, descricao, telefone, email, nomeAnunciante);
        eventos.add(evento);
        salvarEventos();
        System.out.println("Evento C cadastrado com sucesso!");
    }

    public void cadastrarParticipacao(Usuario usuario, Evento evento) {
        evento.salvarParticipante(usuario, evento);
    }

    public void cancelarParticipacao(Usuario usuario, Evento evento) {
        evento.cancelarParticipacao(usuario, evento);
    }

    public Map<String, List<Usuario>> exibirInscritosEventos(String nomeAnunciante) {
        Map<String, List<Usuario>> inscritosPorEvento = new HashMap<>();

        for (Evento evento : eventos) {
            if (evento.getNomeAnunciante().equals(nomeAnunciante)) {
                inscritosPorEvento.put(evento.getNome(), evento.getInscritos());
            }
        }

        return inscritosPorEvento;
    }

    public void salvarEventos() {
        try {
            FileOutputStream fileOut = new FileOutputStream(FILENAME);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(evento);
            objectOut.close();
            fileOut.close();
            System.out.println("Evento SC cadastrado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
