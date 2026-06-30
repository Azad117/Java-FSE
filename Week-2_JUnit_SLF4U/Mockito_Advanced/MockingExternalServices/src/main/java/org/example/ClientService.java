package org.example;

public class ClientService {
    private RestClient restapi;

    public ClientService(RestClient restapi) {
        this.restapi = restapi;
    }

    public String processData()
    {
        return restapi.getResponse();
    }
}
