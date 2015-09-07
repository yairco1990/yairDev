package interfaces.services;


import interfaces.errors.ServerResponse;

/**
 * the class returned by all the services containing a result, a response type, and exceptions
 *
 * @param <T> the result type
 */
public class ServiceResult<T> {
    //service result
    private T result;
    //service response type (success or error (by type))
    private ServerResponse.ResponseType responseType;

    /**
     * default constructor
     */
    public ServiceResult(){}

    /**
     * constructor used mostly when there is no result
     * @param responseType default response type
     */
    public ServiceResult(ServerResponse.ResponseType responseType) {
        this.responseType = responseType;
    }

    /**
     * constructor
     * @param result default result
     * @param responseType default response
     */
    public ServiceResult(T result, ServerResponse.ResponseType responseType) {
        this.result = result;
        this.responseType = responseType;
    }

    /**
     * set response type as success
     */
    public void setAsSuccess() {
        setResponseType(ServerResponse.ResponseType.SUCCESS);
    }

    /**
     * set result with success and the response type
     * @param result
     */
    public void setResultWithSuccess(T result) {
        setResult(result);
        setResponseType(ServerResponse.ResponseType.SUCCESS);
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public ServerResponse.ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ServerResponse.ResponseType responseType) {
        this.responseType = responseType;
    }
}