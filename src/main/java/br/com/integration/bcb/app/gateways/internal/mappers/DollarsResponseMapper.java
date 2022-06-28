package br.com.integration.bcb.app.gateways.internal.mappers;

import br.com.integration.bcb.app.gateways.internal.DollarsResourceResponse;
import br.com.integration.bcb.core.entities.QuoteDollar;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DollarsResponseMapper {
    public static Set<DollarsResourceResponse> mapToOutput(List<QuoteDollar> quotes){
        Set<DollarsResourceResponse> dollarsQuotes = new HashSet<>();

        if(quotes.size() > 0){
            for (Iterator<QuoteDollar> quoteIterator = quotes.iterator(); quoteIterator.hasNext(); ){
                QuoteDollar quote = quoteIterator.next();
                dollarsQuotes.add(new DollarsResourceResponse(
                        quote.getRequestId(),
                        quote.getRequestTimestamp(),
                        quote.getQuoteDollarDate(),
                        quote.getPurchaseQuote(),
                        quote.getSaleQuote(),
                        quote.getDatetimeQuote()));
            }
            return dollarsQuotes;
        }
        return dollarsQuotes;
    }
}
