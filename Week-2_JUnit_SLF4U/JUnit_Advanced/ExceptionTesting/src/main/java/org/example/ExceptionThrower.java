package org.example;

public class ExceptionThrower {
    public void throwException(boolean exception)
    {
        if(exception)
            throw new RuntimeException("Exception Thrown");
    }
}
