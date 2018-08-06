package mx.com.realstate.administration.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends Exception {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The response code. */
    private final HttpStatus responseCode;

    /** The parametros. */
    private final String parameters;

    /**
     * Instantiates a new sce exception.
     *
     * @param mensaje
     *            the mensaje
     * @param responseCode
     *            the response code
     * @param parametros
     *            the parametros
     */
    public BusinessException(final String message, final HttpStatus responseCode, final String parameters) {
        super(message);
        this.responseCode = responseCode;
        this.parameters = parameters;
    }

    /**
     * Gets the response code.
     *
     * @return the response code
     */
    public HttpStatus getResponseCode() {
        return responseCode;
    }

    /**
     * Gets the parametros.
     *
     * @return the parametros
     */
    public String getParameters() {
        return parameters;
    }

}
