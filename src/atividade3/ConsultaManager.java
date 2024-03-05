/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade3;

/**
 *
 * @author Fernando T
 */
import java.util.List;

public class ConsultaManager {
    private List<Consulta> consultas;

    public ConsultaManager(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public void adicionarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }

    public void removerConsulta(int indice) {
        this.consultas.remove(indice);
    }

    public void atualizarConsulta(Consulta consultaAtualizada) {
        for (int i = 0; i < consultas.size(); i++) {
            Consulta consulta = consultas.get(i);
            if (consulta.equals(consultaAtualizada)) {
                consultas.set(i, consultaAtualizada);
                break;
            }
        }
    }

    public List<Consulta> getConsultas() {
        return this.consultas;
    }
}


