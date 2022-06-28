package br.com.integration.bcb.core.repositories;

import br.com.integration.bcb.core.contracts.response.QuoteDollarResponse;

public interface QuoteRepository {
    boolean addDollarQuoteOfDay(QuoteDollarResponse quoteDollar, String setDateQuoteUrlRequest);
}
