package controller;

import model.Usuario;
import model.Evento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class UserController {
    private LocalDateTime agora = LocalDateTime.now();
    private List<Usuario> usuarios;
    private String nomeUsuario;
    private List<Evento> eventos;
    private final String FILENAME = "users.data";
    private EventoController eventoController;
    private Usuario usuario;

    public UserController() {
        eventos = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void cadastrarUsuario(String nomeUsuario, String endereco, String telefone, String email) {
        Usuario novousuario = new Usuario(nomeUsuario, endereco, telefone, email);
        usuarios.add(novousuario);
        salvarDadosUser();
        this.nomeUsuario = nomeUsuario;
    }

    public void participarEvento(String nomeEvento) {
        Usuario usuario = usuarios.stream()
            .filter(u -> u.getNome().equals(nomeUsuario))
            .findFirst()
            .orElse(null);

        Evento evento = eventos.stream()
            .filter(e -> e.getNome().equals(nomeEvento))
            .findFirst()
            .orElse(null);

        if (usuario != null && evento != null) {
            usuario.getEventosInscritos().add(evento);
            evento.getInscritos().add(usuario);
            eventoController.cadastrarParticipacao(usuario, evento);
        }
    }

    public void cancelarParticipacao(String nomeEvento) {
        Usuario usuario = usuarios.stream()
            .filter(u -> u.getNome().equals(nomeUsuario))
            .findFirst()
            .orElse(null);

        Evento evento = eventos.stream()
            .filter(e -> e.getNome().equals(nomeEvento))
            .findFirst()
            .orElse(null);

        if (usuario != null && evento != null) {
            usuario.getEventosInscritos().remove(evento);
            evento.getInscritos().remove(usuario);
            eventoController.cancelarParticipacao(usuario, evento);
        }
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public List<Evento> getEventosInscritos() {
        Usuario usuario = usuarios.stream()
            .filter(u -> u.getNome().equals(nomeUsuario))
            .findFirst()
            .orElse(null);

        if (usuario != null) {
            return usuario.getEventosInscritos();
        } else {
            return Collections.emptyList();
        }
    }

    public void salvarDadosUser() {
        try {
            FileOutputStream file = new FileOutputStream(FILENAME);
            ObjectOutputStream stream = new ObjectOutputStream(file);
            stream.writeObject(usuario);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}