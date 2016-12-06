/**
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 * 
 * Pacote Contendo todos o Moldes
 */
package com.github.estevaocs.model;

import java.util.HashMap;


/**
 * Classe molde do Objeto do tipo Expression que guarda os valores referente à 
 * expressão teste.
 * @author Estevao Cristino
 * @since 04/12/2016.
 * @version 1.0
 */
public class Expression {
    
    /**
     * Expressão Matematica
     */
    private final String expressao;
    
    /**
     * Valor esperado
     */
    private final float esperado;
    
    /**
     * Valor obtido
     */
    private float obtido;
    
    /**
     * Valor das variaveis.
     * 
     * @see java.util.HashMap
     */
    private HashMap<String, Float> variaveis;
    
    /**
     * Método construtor do Objeto Expression quando não se á variaveis para serem instanciadas.
     * @param expressao - String
     * @param esperado - float
     */
    public Expression(String expressao, float esperado) {
        this.expressao = expressao;
        this.esperado = esperado;
    }
    /**
     * Método construtor do Objeto Expression quando se tem variaveis para serem instanciadas.
     * @param expressao - String
     * @param esperado - float
     * @param variaveis - HashMap<String, Float>
     * 
     * @see java.util.HashMap
     */
    public Expression(String expressao, float esperado, HashMap<String, Float> variaveis) {
        this.expressao = expressao;
        this.esperado = esperado;
        this.variaveis = variaveis;
    }

    /**
     * Método que recupera a expressão.
     * @return String - expressao
     */
    public String getExpression() {
        return expressao;
    }

    /**
     * Método que recupera o valor esperado pelo teste
     * @return float - esperado
     */
    public float getEsperado() {
        return esperado;
    }

    /**
     * Método que retorna os valores das variaveis.
     * @return HashMap - variaveis
     * 
     * @see java.util.HashMap
     */
    public HashMap<String, Float> getVariates() {
        return variaveis;
    }

    /**
     * Método que recupera o valor obtido pelo teste.
     * @return float - obtido
     */
    public float getObtido() {
        return obtido;
    }

    /**
     * Método que instancia o valor obtido
     * @param obtido - float
     */
    public void setObtido(Float obtido) {
        this.obtido = obtido;
    }

    /**
     * Metodo que verifica se os teste estão corretos
     * @return boolean - true caso tenha sucesso e False caso tenha falhado. 
     */
    public boolean testAcurracy() {
        return esperado == obtido;
    }
}
