/**
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 * 
 * Pacote Contendo a classe de controle
 */
package com.github.estevaocs.control;

import com.github.kyriosdata.parser.*;
import com.github.estevaocs.model.Expression;
import com.github.estevaocs.model.Test;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Estevao on 04/12/2016.
 */
public class ExpressionEvaluator {

    /**
     * Método que executa uma expressão matematica e retorna o resultado.
     * @param expression - String -> expressão matemática
     * @return - float - resultado da expressão
     */
    private float expressionExector(String expression) {
        List<Token> tokens = new Lexer(expression).tokenize();
        Parser parser = new Parser(tokens);
        float resultado = parser.expressao().valor();
        return resultado;
    }

    /**
     * Método que executa uma expressão matematica e retorna o resultado.
     * @param expression - String -> expressão Matemática
     * @param variables - HashMap -> variaveis e seus respectivos Valores.
     * @return - float - resultado da expressão
     * 
     * @see java.util.HashMap
     */
    private float expressionExector(String expression, HashMap<String, Float> variables) {
        List<Token> tokens = new Lexer(expression).tokenize();
        Parser parser = new Parser(tokens);
        float resultado = parser.expressao().valor(variables);
        return resultado;
    }

    /**
     * Executa os casos de testes do arquivo .txt e guarda seus resultados
     * @param teste - Test - casos de testes
     * @return - Test - Resultados
     * 
     * @see com.github.estevaocs.model.Test
     */
    public Test testerExecuter(Test teste) {
        int contSuccess = 0;
        long time = 0;
        long memoriaInicial = Runtime.getRuntime().totalMemory() 
                - Runtime.getRuntime().freeMemory();
        for(Expression exp : teste.getTestes()) {
            float obtido;
            try {
                long startTime = System.nanoTime();
                obtido = expressionExector(exp.getExpression(), exp.getVariates());
                time += System.nanoTime() - startTime;
            } catch (NullPointerException npe) {
                long startTime = System.nanoTime();
                obtido = expressionExector(exp.getExpression());
                time += System.nanoTime() - startTime;
            }
            exp.setObtido(obtido);
            if(exp.testAcurracy()) {
                contSuccess++;
            }
        }
        long memoriaFinal = Runtime.getRuntime().totalMemory() 
                - Runtime.getRuntime().freeMemory();
        teste.setTempo(time);
        teste.setMemoriaInicio(memoriaInicial);
        teste.setMemoriaFinal(memoriaFinal);
        teste.setSucessos(contSuccess);
        return teste;
    }


}
