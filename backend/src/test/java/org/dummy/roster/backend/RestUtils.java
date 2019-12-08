package org.dummy.roster.backend;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.dummy.roster.backend.JsonUtils.serializePretty;

/**
 * Функции REST.
 */
public final class RestUtils {

    /**
     * Конструктор.
     */
    private RestUtils() {
        //Utils
    }

    public static RequestBuilder buildPost(String path, MediaType produces, MediaType consumes, Object entity) {
        return MockMvcRequestBuilders.post(path).contentType(produces).accept(consumes).content(serializePretty(entity));
    }
}
