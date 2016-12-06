package com.github.estevaocs.view;

import model.Expression;
import com.github.estevaocs.control.ExpressionEvaluator;
import model.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Estevao on 04/12/2016.
 *
 * Classe que serve para Apoiar a Classe qp.
 */
public class QpHelper {

    private static final String COMAN = ";";
    private static Test teste;

    /**
     * Método que lê as linhas do arquivo .txt de testes.
     *
     * @return lines - ArrayList -> retorna um array contendo todas as linhas do
     * arquivo txt.
     * @throws IOException - caso não exista o arquivo txt;
     */
    private static ArrayList<String> getLines() throws IOException {

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
     * @throws IOException - caso nao exista o arquivo txt ou se os testes não
     * estiverem o formato correto.
     */
    public static void toExpression() throws IOException, NumberFormatException {
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
     */
    public static void popularTeste() throws IOException, NumberFormatException {
        toExpression();
        teste = ExpressionEvaluator.testerExecuter(teste);
    }

    /**
     * Metodo que retorna o arryList teste;
     *
     * @return teste - ArrayList -> retorna o ArrayList Contendo os resultados e
     * os testes que foram executados
     */
    public static Test getTeste() {
        return teste;
    }
}
