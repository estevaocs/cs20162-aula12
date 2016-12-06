package model;

import java.util.HashMap;


/**
 * Created by Estevao on 01/09/2016.
 */
public class Expression {
    private String expressao;
    private float esperado;
    private HashMap<String, Float> variaveis;
    private float obtido;

    public Expression(String expressao, float esperado) {
        this.expressao = expressao;
        this.esperado = esperado;
    }

    public Expression(String expressao, float esperado, HashMap<String, Float> variaveis) {
        this.expressao = expressao;
        this.esperado = esperado;
        this.variaveis = variaveis;
    }

    public String getExpression() {
        return expressao;
    }


    public float getEsperado() {
        return esperado;
    }

    public HashMap<String, Float> getVariates() {
        return variaveis;
    }

    public float getObtido() {
        return obtido;
    }

    public void setObtido(Float obtido) {
        this.obtido = obtido;
    }

    public boolean testAcurracy() {
        return esperado == obtido;
    }
}
