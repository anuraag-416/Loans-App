package com.auth.exception;

public class EmptyInputException extends RuntimeException
{
    private String errorcode;
    private String errormessage;
    public EmptyInputException(String errorcode,String errormessage)
    {
        super();
        this.errorcode=errorcode;
        this.errormessage=errormessage;
    }
}
