package br.com.integration.bcb.app.gateways.internal;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DollarsResourceResponse{
    @JsonProperty("Id")
    private Long requestId;
    @JsonProperty("TimestampRequest")
    private Timestamp requestTimestamp;
    @JsonProperty("DateDollarQuote")
    private LocalDateTime dateDollarQuote;
    private float purchaseQuote;
    private float saleQuote;
    private String datetimeQuote;

    public DollarsResourceResponse(){}

    public DollarsResourceResponse(Long requestId, Timestamp requestTimestamp,
                                   LocalDateTime dateDollarQuote, float purchaseQuote, float saleQuote,
                                   String datetimeQuote) {
        this.requestId = requestId;
        this.requestTimestamp = requestTimestamp;
        this.dateDollarQuote = dateDollarQuote;
        this.purchaseQuote = purchaseQuote;
        this.saleQuote = saleQuote;
        this.datetimeQuote = datetimeQuote;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Timestamp getRequestTimestamp() {
        return requestTimestamp;
    }

    public void setRequestTimestamp(Timestamp requestTimestamp) {
        this.requestTimestamp = requestTimestamp;
    }

    public LocalDateTime getDateDollarQuote() {
        return dateDollarQuote;
    }

    public void setDateDollarQuote(LocalDateTime dateDollarQuote) {
        this.dateDollarQuote = dateDollarQuote;
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
