package org.example;

public class Cotacao {
    public float USD;
    public float ARS;
    public float BRL;
    public float COP;

    public Cotacao(float USD, float ARS, float BRL, float COP) {
        this.USD = USD;
        this.ARS = ARS;
        this.BRL = BRL;
        this.COP = COP;
    }




    @Override
    public String toString() {
        return "Cotacao{" +
                "usd=" + USD +
                ", ars=" + ARS +
                ", brl=" + BRL +
                ", cop=" + COP +
                '}';
    }
}
