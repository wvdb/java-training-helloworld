package be.ictdynamic.helloworld.exception;

/**
 * Created by admin on 22/09/2017.
 */
public class MyDomainException extends MyCompanyException {
    public MyDomainException(String message, String domain) {
        super(message);
    }
}
