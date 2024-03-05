/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade3;

/**
 *
 * @author Fernando T
 */
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criar uma lista de consultas
        List<Consulta> consultas = new ArrayList<>();

        // Criar uma instância de ConsultaManager passando a lista de consultas como argumento
        ConsultaManager consultaManager = new ConsultaManager(consultas);

        // Criar a tela inicial e exibi-la
        TelaInicial telaInicial = new TelaInicial(consultaManager);
        telaInicial.setVisible(true);
    }
}

