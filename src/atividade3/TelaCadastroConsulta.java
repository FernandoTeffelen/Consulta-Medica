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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TelaCadastroConsulta extends JFrame {
    private JTextField txtNome;
    private JTextField txtCPF;
    private JTextField txtTelefone;
    private JTextField txtIdade;
    private JTextField txtDataConsulta;
    private ConsultaManager consultaManager;
    private TelaInicial telaInicial;

    public TelaCadastroConsulta(ConsultaManager consultaManager, TelaInicial telaInicial) {
        this.consultaManager = consultaManager;
        this.telaInicial = telaInicial;

        setTitle("Cadastro de Consulta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Componentes
        JLabel lblNome = new JLabel("Nome:");
        JLabel lblCPF = new JLabel("CPF:");
        JLabel lblTelefone = new JLabel("Telefone:");
        JLabel lblIdade = new JLabel("Idade:");
        JLabel lblDataConsulta = new JLabel("Data da Consulta (dd/mm/aaaa):");

        txtNome = new JTextField(20);
        txtCPF = new JTextField(20);
        txtTelefone = new JTextField(20);
        txtIdade = new JTextField(5);
        txtDataConsulta = new JTextField(10);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarConsulta();
            }
        });

        // Layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        panel.add(lblNome, gbc);
        gbc.gridy++;
        panel.add(lblCPF, gbc);
        gbc.gridy++;
        panel.add(lblTelefone, gbc);
        gbc.gridy++;
        panel.add(lblIdade, gbc);
        gbc.gridy++;
        panel.add(lblDataConsulta, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(txtNome, gbc);
        gbc.gridy++;
        panel.add(txtCPF, gbc);
        gbc.gridy++;
        panel.add(txtTelefone, gbc);
        gbc.gridy++;
        panel.add(txtIdade, gbc);
        gbc.gridy++;
        panel.add(txtDataConsulta, gbc);

        gbc.gridy++;
        panel.add(btnCadastrar, gbc);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
    }

    private void cadastrarConsulta() {
        try {
            String nome = txtNome.getText();
            String cpf = txtCPF.getText();
            String telefone = txtTelefone.getText();
            int idade = Integer.parseInt(txtIdade.getText());
            Date dataConsulta = new SimpleDateFormat("dd/MM/yyyy").parse(txtDataConsulta.getText());

            Consulta consulta = new Consulta(nome, cpf, telefone, idade, dataConsulta);
            consultaManager.adicionarConsulta(consulta);
            telaInicial.atualizarTabela();
            JOptionPane.showMessageDialog(this, "Consulta cadastrada com sucesso");
            dispose(); // Fechar a janela de cadastro
        } catch (ParseException | NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar consulta: " + ex.getMessage());
        }
    }
}

