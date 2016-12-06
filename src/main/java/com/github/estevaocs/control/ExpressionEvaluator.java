package com.github.estevaocs.control;

import com.github.kyriosdata.parser.*;
import model.Expression;
import model.Test;
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
    private static float expressionExector(String expression) {
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
     */
    private static float expressionExector(String expression, HashMap<String, Float> variables) {
        List<Token> tokens = new Lexer(expression).tokenize();
        Parser parser = new Parser(tokens);
        float resultado = parser.expressao().valor(variables);
        return resultado;
    }

    /**
     * Executa os casos de testes do arquivo .txt e guarda seus resultados
     * @param teste - Test - casos de testes
     * @return - Test - Resultados
     */
    public static Test testerExecuter(Test teste) {
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
        teste.setTempoTotal(time);
        teste.setMemoriaInicio(memoriaInicial);
        teste.setMemoriaFinal(memoriaFinal);
        teste.setSucessos(contSuccess);
        return teste;
    }


}
