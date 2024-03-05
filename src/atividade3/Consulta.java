/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade3;

/**
 *
 * @author Fernando T
 */
import java.util.Date;

public class Consulta {
    private String nomePaciente;
    private String cpf;
    private String telefone;
    private int idade;
    private Date dataConsulta;
    private boolean consultaRealizada;
    private String receitaObservacoes;

    // Construtor
    public Consulta(String nomePaciente, String cpf, String telefone, int idade, Date dataConsulta) {
        this.nomePaciente = nomePaciente;
        this.cpf = cpf;
        this.telefone = telefone;
        this.idade = idade;
        this.dataConsulta = dataConsulta;
        this.consultaRealizada = false; // Por padrão, a consulta não foi realizada
    }

    // Getters e Setters
    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public boolean isConsultaRealizada() {
        return consultaRealizada;
    }

    public void setConsultaRealizada(boolean consultaRealizada) {
        this.consultaRealizada = consultaRealizada;
    }

    public String getReceitaObservacoes() {
        return receitaObservacoes;
    }

    public void setReceitaObservacoes(String receitaObservacoes) {
        this.receitaObservacoes = receitaObservacoes;
    }
}


