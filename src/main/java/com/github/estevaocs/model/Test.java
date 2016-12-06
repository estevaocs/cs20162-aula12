/**
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 * 
 * Pacote Contendo todos o Moldes
 * 
 */
package com.github.estevaocs.model;

import java.util.ArrayList;

/**
 * Classe molde do Objeto do tipo Test que guarda todo o Relatório gerado.
 * @author Estevao Cristino
 * @since 04/12/2016.
 * @version 1.0
 */
public class Test {
    
    /**
     * Tempo total gasto Durante os teste pelo Parse .
     */
    private long tempoTotal;
    
    /**
     * Tempo médio gasto durante os teste pelo Parse.
     */
    private long tempoMedio;
    
    /**
     * Memoria gasta antes de rodar o Parse.
     */
    private long memoriaInicio;
    
    /**
     * Memoria gasta depois de rodar o Parse.
     */
    private long memoriaFinal;
    
    /**
     * Numero total de testes.
     */
    private final int totalDeTest;
    
    /**
     * Numero de teste com sucesso (obitido o esperado).
     */
    private int sucessos;
    
    /**
     * Numero de teste que falharam (Não obitido o esperado).
     */
    private int falhas;
    
    /**
     * Lista Contendo todos os casos de teste.
     */
    private final ArrayList<Expression> testes;

    /**
     * Metodo construtor
     * @param testes - ArrayList<Expression> -> Array contendo todos os casos de 
     *      testes.
     * @see com.github.estevaocs.model.Expression
     * @see java.util.ArrayList
     */
    public Test(ArrayList<Expression> testes) {
        this.testes = testes;
        this.totalDeTest = testes.size();
    }

    /**
     * Método que recupera o tempo total dos testes.
     * @return long - tempoTotal
     */
    public long getTempoTotal() {
        return tempoTotal;
    }

    /**
     * Metodo que instancia o tempo Total e o tempo médio dos testes.
     * @param tempoTotal - long
     */
    public void setTempo(long tempoTotal) {
        this.tempoTotal = tempoTotal;
        this.tempoMedio = tempoTotal / totalDeTest;
    }

    /**
     * Método que recupera o tempo médio dos testes.
     * @return long - tempoMedio
     */
    public long getTempoMedio() {
        return tempoMedio;
    }

    /**
     * Método que recupera o número total de testes executados
     * @return int - totalDeTest
     */
    public int getTotalDeTest() {
        return totalDeTest;
    }

    /**
     * Método que recupera o número de teste com sucesso.
     * @return int - sucessos
     */
    public int getSucessos() {
        return sucessos;
    }
    
    /**
     * Método que instancia o numero de teste com sucesso e o numero de teste 
     *      com fracasssos.
     * @param sucessos - int
     */
    public void setSucessos(int sucessos) {
        this.sucessos = sucessos;
        this.falhas = getTotalDeTest()- sucessos;
    }

    /**
     * Método que recupera o numero total de teste fracassados.
     * @return int - falhas
     */
    public int getFalhas() {
        return falhas;
    }

    /**
     * Método que recupea o array contendo todos os casos de Testes.
     * @return ArrayList<Expression> - testes
     * @see com.github.estevaocs.model.Expression
     * @see java.util.ArrayList
     */
    public ArrayList<Expression> getTestes() {
        return testes;
    }

    /**
     * Método que recupera o a quantidade de memoria gasta antes do inicio dos testes.
     * @return long - memoriaInicio
     */
    public long getMemoriaInicio() {
        return memoriaInicio;
    }

    /**
     * Método que instancia a quantidade de memoria gasta antes do inicio dos testes.
     * @param memoriaInicio - long
     */
    public void setMemoriaInicio(long memoriaInicio) {
        this.memoriaInicio = memoriaInicio;
    }

    /**
     * Método que recupera a quantidade de memoria gasta após o fim dos testes.
     * @return long - memoriaFinal
     */
    public long getMemoriaFinal() {
        return memoriaFinal;
    }

    /**
     * Método que instancia a quantidade de memoria gasta após o fim dos testes.
     * @param memoriaFinal - long
     */
    public void setMemoriaFinal(long memoriaFinal) {
        this.memoriaFinal = memoriaFinal;
    }
}
