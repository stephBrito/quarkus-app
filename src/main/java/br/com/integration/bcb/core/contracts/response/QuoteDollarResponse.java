package br.com.integration.bcb.core.contracts.response;

import br.com.integration.bcb.core.contracts.model.Quotes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteDollarResponse {

    @JsonProperty("@odata.context")
    private String dataContext;

    @JsonProperty("value")
    private List<Quotes> quotes;

    public QuoteDollarResponse(){}

    public QuoteDollarResponse(String dataContext, List<Quotes> quotes) {
        this.dataContext = dataContext;
        this.quotes = quotes;
    }

    public String getDataContext() {
        return dataContext;
    }

    public void setDataContext(String dataContext) {
        this.dataContext = dataContext;
    }

    public List<Quotes> getValues() {
        return quotes;
    }

    public void setValues(List<Quotes> quotes) {
        this.quotes = quotes;
    }
}



