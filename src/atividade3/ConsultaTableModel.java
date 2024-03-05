/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade3;

/**
 *
 * @author Fernando T
 */
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ConsultaTableModel extends AbstractTableModel {
    private List<Consulta> consultas;
    private String[] colunas = {"Nome Paciente", "CPF", "Telefone", "Idade", "Data da Consulta", "Consulta Realizada"};

    public ConsultaTableModel(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public int getRowCount() {
        return consultas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Consulta consulta = consultas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return consulta.getNomePaciente();
            case 1:
                return consulta.getCpf();
            case 2:
                return consulta.getTelefone();
            case 3:
                return consulta.getIdade();
            case 4:
                return consulta.getDataConsulta();
            case 5:
                return consulta.isConsultaRealizada();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}

