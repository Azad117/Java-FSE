package org.example;

public class MyService {
    private ExternalAPI api;

    public MyService(ExternalAPI api)
    {
        this.api = api;
    }

    public void setArgument(String name, int age)
    {
        api.argumentMethod(name,age);
    }
}
