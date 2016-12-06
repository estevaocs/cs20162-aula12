/**
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 * 
 * Pacote Contendo as Classes de interção com o usuário.
 */
package com.github.estevaocs.view;

import com.github.estevaocs.model.Expression;
import com.github.estevaocs.control.ExpressionEvaluator;
import com.github.estevaocs.model.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe que serve para Apoiar a Classe qp.
 * @author Estevao Cristino
 * @since 04/12/2016.
 * @version 1.0
 */
public class QpHelper {

    /**
     * Separador padrão de string
     */
    private final String COMAN = ";";
    
    /**
     * Relatório
     * 
     * @see com.github.estevaocs.model.Test
     */
    private Test teste;

    /**
     * Método que lê as linhas do arquivo .txt de testes.
     *
     * @return lines - ArrayList -> retorna um array contendo todas as linhas do
     * arquivo txt.
     * @throws IOException - caso não exista o arquivo txt;
     * 
     * @see java.util.ArrayList
     * @see import java.io.IOException
     */
    private ArrayList<String> getLines() throws IOException {

        ArrayList<String> lines = new ArrayList<>();

        FileReader arq = new FileReader(qp.localFile);
        BufferedReader bufferedReader = new BufferedReader(arq);

        String line = bufferedReader.readLine();
        lines.add(line);

        while (line != null) {
            line = bufferedReader.readLine();
            lines.add(line);

        }
        lines.remove(lines.size() - 1);

        return lines;

    }

    /**
     * Método que Transforma os teste do arquivo .txt em objetos Expression;
     *
     * @throws IOException - caso os testes não estiverem o formato correto.
     * @throws NumberFormatException - caso os caso de test apresente algum erro
     * no formato padrão.
     * 
     * @see import java.io.IOException
     */
    public void toExpression() throws IOException, NumberFormatException {
        ArrayList<String> lines = getLines();
        ArrayList<Expression> test = new ArrayList<>();

        for (String line : lines) {
            String[] content = line.split(COMAN);
            String expressao = content[0].replaceAll(" ", "");
            float esperado = Float.parseFloat(content[2]);
            if (!content[1].isEmpty()) {
                String[] variables = content[1].split(",");
                HashMap<String, Float> variaveis = new HashMap<>();
                for (String var : variables) {
                    String[] v = var.split("=");
                    String nome = v[0];
                    Float valor;
                    valor = Float.parseFloat(v[1]);
                    variaveis.put(nome, valor);
                }
                test.add(new Expression(expressao, esperado, variaveis));
            } else {
                test.add(new Expression(expressao, esperado));
            }

        }
        teste = new Test(test);
    }

    /**
     * Método que popula a ArrayList de testes;
     *
     * @throws IOException - caso nao exista o arquivo .txt ou o dos testes
     * estajam incorreto.
     * 
     * @throws NumberFormatException - caso nao alguma instanciação de um número
     * não seja possivel
     * 
     * @see import java.io.IOException
     */
    public void popularTeste() throws IOException, NumberFormatException {
        toExpression();
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        teste = expressionEvaluator.testerExecuter(teste);
    }

    /**
     * Metodo que retorna o arryList teste;
     *
     * @return teste - ArrayList -> retorna o ArrayList Contendo os resultados e
     * os testes que foram executados
     * 
     * @see com.github.estevaocs.model.Test
     */
    public Test getTeste() {
        return teste;
    }
}
