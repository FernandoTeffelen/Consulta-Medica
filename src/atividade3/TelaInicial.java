/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade3;

/**
 *
 * @author Fernando T
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaInicial extends JFrame {
    private JTable tabelaConsultas;
    private ConsultaManager consultaManager;

    public TelaInicial(ConsultaManager consultaManager) {
        this.consultaManager = consultaManager;

        setTitle("Consultas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criando tabela de consultas
        tabelaConsultas = new JTable();
        atualizarTabela();

        // Botões
        JButton btnNovaConsulta = new JButton("Nova Consulta");
        btnNovaConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abrir tela de cadastro de consulta
                TelaCadastroConsulta telaCadastro = new TelaCadastroConsulta(consultaManager, TelaInicial.this);
                telaCadastro.setVisible(true);
            }
        });

        JButton btnExcluirConsulta = new JButton("Excluir Consulta");
        btnExcluirConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Remover consulta selecionada
                int indiceSelecionado = tabelaConsultas.getSelectedRow();
                if (indiceSelecionado != -1) {
                    consultaManager.removerConsulta(indiceSelecionado);
                    atualizarTabela();
                } else {
                    JOptionPane.showMessageDialog(TelaInicial.this, "Selecione uma consulta para excluir");
                }
            }
        });

        JButton btnFinalizarConsulta = new JButton("Finalizar Consulta");
        btnFinalizarConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abrir tela de detalhes e finalização da consulta
                int indiceSelecionado = tabelaConsultas.getSelectedRow();
                if (indiceSelecionado != -1) {
                    Consulta consulta = consultaManager.getConsultas().get(indiceSelecionado);
                    TelaDetalhesConsulta telaDetalhes = new TelaDetalhesConsulta(consulta, consultaManager, TelaInicial.this);
                    telaDetalhes.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(TelaInicial.this, "Selecione uma consulta para finalizar");
                }
            }
        });

        // Layout
        JPanel panelBotoes = new JPanel();
        panelBotoes.add(btnNovaConsulta);
        panelBotoes.add(btnExcluirConsulta);
        panelBotoes.add(btnFinalizarConsulta);

        setLayout(new BorderLayout());
        add(panelBotoes, BorderLayout.NORTH);
        add(new JScrollPane(tabelaConsultas), BorderLayout.CENTER);
    }

    public void atualizarTabela() {
        List<Consulta> consultas = consultaManager.getConsultas();
        ConsultaTableModel model = new ConsultaTableModel(consultas);
        tabelaConsultas.setModel(model);
    }
}

