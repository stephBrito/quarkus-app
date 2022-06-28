package br.com.integration.bcb.core.services;

import br.com.integration.bcb.core.entities.QuoteDollar;

import java.util.List;

public interface QuoteService {

    List<QuoteDollar> getQuotes();

    void addQuote(QuoteDollar quote);
}
