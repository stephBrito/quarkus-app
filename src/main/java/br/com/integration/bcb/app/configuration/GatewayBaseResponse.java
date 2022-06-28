package br.com.integration.bcb.app.configuration;

public class GatewayBaseResponse {
    private Object data;
    private boolean successSaveDb;

    public GatewayBaseResponse(){}

    public GatewayBaseResponse(Object data, boolean successSaveDb) {
        this.data = data;
        this.successSaveDb = successSaveDb;
    }

    public GatewayBaseResponse(Object data){
        this.data = data;
    }

    public GatewayBaseResponse(boolean successSaveDb){
        this.successSaveDb = successSaveDb;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccessSaveDb() {
        return successSaveDb;
    }

    public void setSuccessSaveDb(boolean successSaveDb) {
        this.successSaveDb = successSaveDb;
    }
}
