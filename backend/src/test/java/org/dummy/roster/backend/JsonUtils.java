package org.dummy.roster.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Функции преобразования в/из JSON.
 */
public final class JsonUtils {

    /**
     * Конструтор.
     */
    private JsonUtils() {
        //Utils
    }

    /**
     * Объект - в JSON.
     * @param o {@link Object}
     * @return JSON
     */
    public static String serializePretty(Object o) {
        ObjectMapper mapper = makeAMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    private static ObjectMapper makeAMapper() {
        return new ObjectMapper();
    }
}
