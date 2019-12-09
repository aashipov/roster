package org.dummy.roster.backend.utils;

/***
 * Утилиты исключений.
 */
public final class ThrowableUtils {

    private ThrowableUtils() {
        //
    }

    /**
     * Returns the innermost cause of {@code throwable}. The first throwable in a chain provides
     * context from when the error or exception was initially detected. Example usage:
     * <pre>
     * assertEquals("Unable to assign a customer id", Throwables.getRootCause(e).getMessage());
     * </pre>
     * @param throwable {@link Throwable}
     * @return {@link Throwable}
     * @throws IllegalArgumentException if there is a loop in the causal chain
     *                                 Borrowed from Guava 27
     */
    public static Throwable getRootCause(Throwable throwable) {
        // Keep a second pointer that slowly walks the causal chain. If the fast pointer ever catches
        // the slower pointer, then there's a loop.
        Throwable slowPointer = throwable;
        boolean advanceSlowPointer = false;
        Throwable cause;
        while (true) {
            cause = throwable.getCause();
            if (null == cause || null == (cause.getMessage()) || cause.getMessage().isEmpty()){
                break;
            }
            throwable = cause;
            if (throwable == slowPointer) {
                throw new IllegalArgumentException("Loop in causal chain detected.", throwable);
            }
            if (advanceSlowPointer) {
                slowPointer = slowPointer.getCause();
            }
            // only advance every other iteration
            advanceSlowPointer = !advanceSlowPointer;
        }
        return throwable;
    }
}
