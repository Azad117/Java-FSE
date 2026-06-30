package org.example;

public class DataService {
    private ExternalAPI api;

    public DataService(ExternalAPI api)
    {
        this.api = api;
    }

    public String fetchData()
    {
        return api.getData();
    }
}
