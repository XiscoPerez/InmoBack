package mx.com.realstate.administration.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.validation.FieldError;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class RealStateUtils {
    /** The Constant LOGGER. */
    private static final Logger LOGGER = Logger.getLogger(RealStateUtils.class.getName());

    private RealStateUtils() {

    }

    public static String getMessages(final List<FieldError> errors) {
        List<String> messages = new ArrayList<>(errors.size());
        messages.addAll(errors.stream().map(error -> String.format("{%s %s}", error.getField(), error.getDefaultMessage())).collect(Collectors.toList()));
        return messages.toString();
    }

    public static String requestJson(final Object object) {
        ObjectMapper mapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        mapper.registerModule(javaTimeModule);
        ObjectWriter ow = mapper.writer();
        String result = "{}";
        try {
            result = ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.log(Level.FINEST, "{0}", e);
        }
        return result;
    }
}
