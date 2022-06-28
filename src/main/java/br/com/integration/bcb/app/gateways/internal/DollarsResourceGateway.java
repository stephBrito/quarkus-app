package br.com.integration.bcb.app.gateways.internal;


import br.com.integration.bcb.app.configuration.GatewayBaseResponse;
import br.com.integration.bcb.app.gateways.internal.mappers.DollarsResponseMapper;
import br.com.integration.bcb.core.services.QuoteService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

@Path("/v1/dollar")
public class DollarsResourceGateway {
    private static final Logger LOG = Logger.getLogger(DollarsResourceGateway.class);

    @Inject QuoteService quoteService;

    @Path("/getallsavedquotes")
    @Transactional
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSaveAlldQuotes(){
        LOG.info("Iniciando consulta para retornar lista cotações realizadas");
        try {

            Set<DollarsResourceResponse> dollarsResourceResponse =
                    DollarsResponseMapper.mapToOutput(quoteService.getQuotes());

            if(dollarsResourceResponse.size() > 0)
                return Response.ok(new GatewayBaseResponse(dollarsResourceResponse)).build();
            else
                return Response.noContent().build();
        } catch(Exception exception){
            throw new RuntimeException(exception.getMessage());
        }
    }
}
