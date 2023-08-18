/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author aluno
 */
class Processo {

    protected String nome;
    protected int tempoExecucao;
    protected int tempoRestante;

    public Processo(String nome, int tempoRestante, int tempoExecucao) {
        this.nome = nome;
        this.tempoExecucao = tempoExecucao;
        this.tempoRestante = tempoRestante;
    }

    public String getNome() {
        return nome;
    }

    public int getTempoRestante() {
        return tempoRestante;
    }

    public int getTempoExecucao() {
        return tempoExecucao;
    }

    public void executar() {
        int x = tempoRestante;
        tempoRestante = x - tempoExecucao;
        int y = tempoRestante;
    }

    public boolean isFinalizado() {
        return tempoRestante == 0;
    }
}

