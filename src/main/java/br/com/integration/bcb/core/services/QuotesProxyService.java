package br.com.integration.bcb.core.services;

import br.com.integration.bcb.core.contracts.response.QuoteDollarResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey = "restclient-quotes")
@Produces(MediaType.APPLICATION_JSON)
public interface QuotesProxyService {

    @Path("/CotacaoDolarDia(dataCotacao=@dataCotacao)")
    @GET
    QuoteDollarResponse getQuotes(@QueryParam("@dataCotacao") String dataCotacao);
}
