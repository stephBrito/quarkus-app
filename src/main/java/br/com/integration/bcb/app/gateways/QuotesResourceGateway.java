package br.com.integration.bcb.app.gateways;

import br.com.integration.bcb.app.configuration.GatewayBaseResponse;
import br.com.integration.bcb.core.contracts.response.QuoteDollarResponse;
import br.com.integration.bcb.core.repositories.QuoteRepository;
import br.com.integration.bcb.core.services.QuotesProxyService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/dollar")
public class QuotesResourceGateway {
    private static final Logger LOG = Logger.getLogger(QuotesResourceGateway.class);
    @Inject QuoteRepository quoteRepository;

    @RestClient
    @Inject QuotesProxyService quotesProxyService;

    @GET
    @Path("/quotesbyperiod/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuotes(@QueryParam String datetimeQuote)
                                             throws Exception{
       try{
           LOG.info("Iniciando consulta na api do parceiro para obter uma cotações por data");
            Response quoteResponse = Response.ok(quotesProxyService.getQuotes("'"
                    + datetimeQuote + "'")).build();
            QuoteDollarResponse quoteDollarResult = (QuoteDollarResponse) quoteResponse.getEntity();

            if(quoteResponse.getStatus() == 200){
                Boolean isSaveSuccess = saveQuote(quoteDollarResult, datetimeQuote);
                return Response.ok(new GatewayBaseResponse(quoteDollarResult.getValues(), isSaveSuccess)).build();
            }
            else{
                return Response.noContent().build();
            }
        }
        catch (RuntimeException exceptions){
           throw new Exception(exceptions.getLocalizedMessage());
        }
    }

     Boolean saveQuote(QuoteDollarResponse dollarQuote, String datetimeQuote){
        if(dollarQuote.getValues().size() > 0){
            return quoteRepository.addDollarQuoteOfDay(dollarQuote, datetimeQuote);
        }
        else{
            return false;
        }
    }
}
