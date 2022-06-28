package br.com.integration.bcb.core.services.impl;

import br.com.integration.bcb.core.entities.QuoteDollar;
import br.com.integration.bcb.core.services.QuoteService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class QuoteServiceImpl implements QuoteService {

    @Inject EntityManager entityManager;

    public List<QuoteDollar> getQuotes() {
        return entityManager.createNativeQuery("select requestId, requestTimestamp, quoteDollarDate, purchaseQuote, " +
                "saleQuote, datetimeQuote from dollarquotes", QuoteDollar.class).getResultList();
    }

    public void addQuote(QuoteDollar quote) {
        entityManager.persist(quote);
    }
}
