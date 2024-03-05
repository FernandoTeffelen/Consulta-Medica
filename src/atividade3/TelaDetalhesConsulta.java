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

public class TelaDetalhesConsulta extends JFrame {
    private Consulta consulta;
    private ConsultaManager consultaManager;
    private TelaInicial telaInicial;

    public TelaDetalhesConsulta(Consulta consulta, ConsultaManager consultaManager, TelaInicial telaInicial) {
        this.consulta = consulta;
        this.consultaManager = consultaManager;
        this.telaInicial = telaInicial;

        setTitle("Detalhes da Consulta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Componentes
        JLabel lblConsultaRealizada = new JLabel("Consulta Realizada:");
        JCheckBox checkBoxConsultaRealizada = new JCheckBox();
        checkBoxConsultaRealizada.setSelected(consulta.isConsultaRealizada());
        checkBoxConsultaRealizada.setEnabled(false);

        JLabel lblReceitaObservacoes = new JLabel("Receita e Observações:");
        JTextArea txtReceitaObservacoes = new JTextArea(5, 20);
        txtReceitaObservacoes.setText(consulta.getReceitaObservacoes());

        JButton btnFinalizar = new JButton("Finalizar");
        btnFinalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finalizarConsulta(txtReceitaObservacoes.getText());
            }
        });

        // Layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel.add(lblConsultaRealizada, gbc);
        gbc.gridy++;
        panel.add(lblReceitaObservacoes, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(checkBoxConsultaRealizada, gbc);
        gbc.gridy++;
        panel.add(new JScrollPane(txtReceitaObservacoes), gbc);

        gbc.gridy++;
        panel.add(btnFinalizar, gbc);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
    }

    private void finalizarConsulta(String receitaObservacoes) {
        if (!receitaObservacoes.isEmpty()) {
            consulta.setConsultaRealizada(true);
            consulta.setReceitaObservacoes(receitaObservacoes);
            consultaManager.atualizarConsulta(consulta);
            telaInicial.atualizarTabela();
            JOptionPane.showMessageDialog(this, "Consulta finalizada com sucesso");
            dispose(); // Fechar a janela de detalhes
        } else {
            JOptionPane.showMessageDialog(this, "Digite a receita e observações antes de finalizar a consulta");
        }
    }
}

