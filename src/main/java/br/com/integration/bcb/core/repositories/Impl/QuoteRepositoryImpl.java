package br.com.integration.bcb.core.repositories.Impl;

import br.com.integration.bcb.core.contracts.model.Quotes;
import br.com.integration.bcb.core.contracts.response.QuoteDollarResponse;
import br.com.integration.bcb.core.entities.QuoteDollar;
import br.com.integration.bcb.core.repositories.QuoteRepository;
import br.com.integration.bcb.core.services.QuoteService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
public class QuoteRepositoryImpl implements QuoteRepository {

    @Inject QuoteService quoteService;

    @Override
    @Transactional
    public boolean addDollarQuoteOfDay(QuoteDollarResponse quoteDollar, String setDateQuoteUrlRequest) {
        QuoteDollar newQuote = new QuoteDollar();

        if(quoteDollar.getValues().size() > 0){
            for (Quotes quotes: quoteDollar.getValues()) {
                newQuote.setDatetimeQuote(quotes.getDatetimeQuote());
                newQuote.setSaleQuote(quotes.getSaleQuote());
                newQuote.setPurchaseQuote(quotes.getPurchaseQuote());
            }
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            LocalDateTime dateTimeRequest = LocalDate.parse(setDateQuoteUrlRequest,dateTimeFormatter).atStartOfDay();
            newQuote.setRequestTimestamp(Timestamp.valueOf(LocalDateTime.now()));
            newQuote.setQuoteDollarDate(dateTimeRequest);
        }
        else{
            return false;
        }
        try{
            quoteService.addQuote(newQuote);
            return true;
        }
        catch (Exception exception){
            throw new RuntimeException("Houve um problema para armazenar a cotação atual: " + exception.getMessage());
        }
    }
}
