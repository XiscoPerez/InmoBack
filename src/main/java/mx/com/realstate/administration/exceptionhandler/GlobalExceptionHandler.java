package mx.com.realstate.administration.exceptionhandler;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import mx.com.realstate.administration.exception.BusinessException;
import mx.com.realstate.administration.exception.ExceptionData;

/**
 * The Class GlobalExceptionHandler.
 *
 * @author FPLOPEZ Francisco Perez Lopez
 */
@ControllerAdvice
public final class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(GlobalExceptionHandler.class.getName());

    /**
     * Handle sce exception.
     *
     * @param webRequest
     *            the web request
     * @param ex
     *            the ex
     * @return the response entity
     */
    @ExceptionHandler(BusinessException.class)
    ResponseEntity<Object> handleSceException(final WebRequest webRequest, final Exception ex) {
        String ruta = ((ServletWebRequest) webRequest).getRequest().getRequestURI();
        ExceptionData exceptionData = new ExceptionData(ruta, (BusinessException) ex);
        LOG.log(Level.INFO, "{0}", exceptionData);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(ex, exceptionData, headers, ((BusinessException) ex).getResponseCode(), webRequest);
    }
}