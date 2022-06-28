package br.com.integration.bcb.core.contracts.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Quotes {
    @JsonProperty("cotacaoCompra")
    private float purchaseQuote;
    @JsonProperty("cotacaoVenda")
    private float saleQuote;
    @JsonProperty("dataHoraCotacao")
    private String datetimeQuote;

    public Quotes(){}

    public Quotes(float purchaseQuote, float saleQuote, String datetimeQuote) {
        this.purchaseQuote = purchaseQuote;
        this.saleQuote = saleQuote;
        this.datetimeQuote = datetimeQuote;
    }

    public float getPurchaseQuote() {
        return purchaseQuote;
    }

    public void setPurchaseQuote(float purchaseQuote) {
        this.purchaseQuote = purchaseQuote;
    }

    public float getSaleQuote() {
        return saleQuote;
    }

    public void setSaleQuote(float saleQuote) {
        this.saleQuote = saleQuote;
    }

    public String getDatetimeQuote() {
        return datetimeQuote;
    }

    public void setDatetimeQuote(String datetimeQuote) {
        this.datetimeQuote = datetimeQuote;
    }
}
