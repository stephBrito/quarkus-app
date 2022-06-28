package br.com.integration.bcb.core.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "dollarquotes")
public class QuoteDollar implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;
    @Column
    private Timestamp requestTimestamp;
    @Column
    private LocalDateTime quoteDollarDate;
    @Column
    private float purchaseQuote;
    @Column
    private float saleQuote;
    @Column
    private String datetimeQuote;

    public QuoteDollar(){}

    public QuoteDollar(Long requestId, Timestamp requestTimestamp, LocalDateTime quoteDollarDate,
                       float purchaseQuote, float saleQuote, String datetimeQuote) {
        this.requestId = requestId;
        this.requestTimestamp = requestTimestamp;
        this.quoteDollarDate = quoteDollarDate;
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

    public LocalDateTime getQuoteDollarDate() {
        return quoteDollarDate;
    }

    public void setQuoteDollarDate(LocalDateTime quoteDollarDate) {
        this.quoteDollarDate = quoteDollarDate;
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
