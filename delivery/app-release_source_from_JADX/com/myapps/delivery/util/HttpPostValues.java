package com.myapps.delivery.util;

public class HttpPostValues {
    private String parametro;
    private String valor;

    public HttpPostValues(String parametro, String valor) {
        this.parametro = parametro;
        this.valor = valor;
    }

    public String getParametro() {
        return this.parametro;
    }

    public String getValor() {
        return this.valor;
    }
}
