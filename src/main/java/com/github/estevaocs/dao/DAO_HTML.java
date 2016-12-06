package com.github.estevaocs.dao;


import com.github.estevaocs.model.Expression;
import com.github.estevaocs.model.Test;

import javax.swing.text.html.HTMLEditorKit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Estevao on 04/12/2016.
 */
public class DAO_HTML extends HTMLEditorKit{

    private String html;
    private final FileWriter fileWriter;
    private final PrintWriter printWriter;

    /**
     * Método que Cria o DAO_HTML, e inicia o FileWriter e o PrintWriter gerando o arquivo .html
     * @param localFile - String -> Local onde irá criar o arquivo .html
     * @throws IOException - caso nao consiga gerar o arquivo .html
     */
    public DAO_HTML(String localFile) throws IOException {
        fileWriter = new FileWriter(localFile.replaceAll(".txt",".html"));
        printWriter = new PrintWriter(fileWriter);

    }

    /**
     * Método que instancia o arquivo HTML com o codigo do relatorio;
     * @param test - Testes - resultados dos testes executados
     * @throws IOException - Caso nao encontre o arquivo .html
     */
    public void createHTML(Test test) throws IOException {
        printWriter.write(generetorCodeHTML(test));
        fileWriter.close();
        printWriter.close();
    }

    /**
     * Método que irá gerar o codigo HTML
     * @param test - Test - resultados dos testes gerados
     * @return - String - Codigo HTML
     */
    private String generetorCodeHTML(Test test) {
        String codHtml = "<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>Relatório de Testes</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>Resultado geral</h1>\n" +
                "<table>\n" +
                "<tr>\n" +
                "<td><b>Tempo total</b></td>\n" +
                "<td>" + test.getTempoTotal() + "ms</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><b>Tempo médio</b></td>\n" +
                "<td>" + test.getTempoMedio() + "ms</td>\n" +
                "</tr>\n"+
                "<tr>\n"+
                "<td><b>Memória Inicial</b></td>\n" +
                "<td>" + test.getMemoriaInicio() + "bits</td>\n" +
                "</tr>\n" +
                "<tr>\n"+
                "<td><b>Memória Final</b></td>\n" +
                "<td>" + test.getMemoriaFinal() + "bits</td>\n" +
                "</tr>\n" +
                "<td><b>Total de testes</b></td>\n" +
                "<td>" + test.getTotalDeTest() +"</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><b>Corretos</b></td>\n" +
                "<td>" + test.getSucessos() + "</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td><b>Falhas</b></td>\n" +
                "<td>" + test.getFalhas() + "</td>\n" +
                "</tr>\n" +
                "</table>\n" +
                "\n" +
                "<h1>Relatório detalhado dos testes</h1>\n" +
                "<table>\n" +
                "<tr>\n" +
                "<th>Expressão</th>\n" +
                "<th>Esperado</th>\n" +
                "<th>Obtido</th>\n" +
                "</tr>\n";

        String contentExpression = "";
        for (Expression expre : test.getTestes()) {
            contentExpression = contentExpression
                    + "<tr>\n"
                    + "<td>" + expre.getExpression() + "</td>\n"
                    + "<td>" + expre.getEsperado() + "</td>\n"
                    + "<td>" + expre.getObtido() + "</td>\n";
        }
        return codHtml + contentExpression + "</tr>\n</table>\n</body>\n</html>";
    }


}
