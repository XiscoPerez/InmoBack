package mx.com.realstate.administration.exception;

public final class ExceptionData {

    /** The mensaje. */
    public final String message;

    /** The ruta. */
    public final String route;

    /** The response code. */
    public final int responseCode;

    /** The parametros. */
    public final String parameters;

    /**
     * Instantiates a new exception data.
     *
     * @param ruta
     *            the ruta
     * @param sceException
     *            the sce exception
     */
    public ExceptionData(final String ruta, final BusinessException businessException) {
        super();
        message = businessException.getMessage();
        route = ruta;
        responseCode = businessException.getResponseCode().value();
        parameters = businessException.getParameters();
    }

    /**
     * Gets the mensaje.
     *
     * @return the mensaje
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets the ruta.
     *
     * @return the ruta
     */
    public String getRoute() {
        return route;
    }

    /**
     * Gets the response code.
     *
     * @return the response code
     */
    public int getResponseCode() {
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

    @Override
    public String toString() {
        return "ExceptionData [message=" + message + ", route=" + route + ", responseCode=" + responseCode + ", parameters=" + parameters + "]";
    }

}