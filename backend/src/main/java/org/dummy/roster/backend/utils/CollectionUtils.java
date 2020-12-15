package org.dummy.roster.backend.utils;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Дописки к {@link java.util.Collections}.
 */
public final class CollectionUtils {

    /**
     * Конструктор.
     */
    private CollectionUtils() {
        //
    }

    public static <E> Collection<E> makeCollection(Iterable<E> iter) {
        Collection<E> list = new ArrayList<>(0);
        for (E item : iter) {
            list.add(item);
        }
        return list;
    }
}
