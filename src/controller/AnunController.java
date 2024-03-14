package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

import model.Anunciante;
import model.Evento;
import view.AnunView;
import controller.EventoController;

public class AnunController {
    private Anunciante anunciante;
    private final String FILENAME = "anun.data";
    private List<Anunciante> anunciantes;
    private List<Evento> eventos;
    private String nomeAnunciante;
    private EventoController eventoController;

    public AnunController() {
        eventos = new ArrayList<>();
        anunciantes = new ArrayList<>();
        this.eventoController = new EventoController();
    }

    public void cadastrarAnunciante(String nomeAnunciante, String endereco, String telefone, String email) {
        Anunciante anunciante = new Anunciante(nomeAnunciante, endereco, telefone, email);
        anunciantes.add(anunciante);
        salvarDadosAnun();
        this.nomeAnunciante = nomeAnunciante;
    }

    public void cadastrarEvento(String nomeEvento, String endereco, String categoria, LocalDateTime horario, String descricao, String telefone, String email) {
        Evento evento = new Evento(nomeEvento, endereco, categoria, horario, descricao, telefone, email, nomeAnunciante);
        for (Anunciante anunciante : anunciantes) {
            if (anunciante.getNome().equals(nomeAnunciante)) {
                anunciante.cadastrarNovoEvento(evento);
                break;
            }
        }
        eventoController.cadastrarEvento(nomeEvento, endereco, categoria, horario, descricao, telefone, email, nomeAnunciante);
        System.out.println("Evento A cadastrado com sucesso!");
    }

    public void excluirEvento(String nomeEvento) {
        anunciante.excluirEvento(nomeEvento);
    }

    public List<Evento> consultarEventosCriados() {
        for (Anunciante anunciante : anunciantes) {
            if (anunciante.getNome().equals(nomeAnunciante)) {
                return anunciante.getEventosCriados();
            }
        }
        return new ArrayList<>(); // retorna uma lista vazia se nenhum Anunciante correspondente for encontrado
    }

    public void exibirInscritosEventos() {
        eventoController.exibirInscritosEventos(nomeAnunciante);
    }

    public void salvarDadosAnun() {
        try {
            FileOutputStream fileOut = new FileOutputStream(FILENAME);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(anunciante);
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}