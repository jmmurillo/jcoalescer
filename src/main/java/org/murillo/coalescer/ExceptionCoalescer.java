package org.murillo.coalescer;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;

public class ExceptionCoalescer {

    //region fallible supplier
    public static <T> T e$(FallibleSupplier<T, ?> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return null;
        }
    }

    public static <T, E extends Exception> T e$(FallibleSupplier<T, ? extends E> supplier, Consumer<E> catcher) {
        try {
            return supplier.get();
        } catch (Exception e) {
            E cast;
            try {
                cast = (E) e;
            } catch (ClassCastException cce) {
                return null;
            }

            try {
                catcher.accept(cast);
            } catch (Exception ignored) {
            }

            return null;
        }
    }

    public static <T> T e$E(FallibleSupplier<T, ?> supplier, Class<? extends Exception>... ignoreList) throws Exception {
        try {
            return supplier.get();
        } catch (Exception e) {
            if (ignoreList != null && Arrays.stream(ignoreList).filter(Objects::nonNull).anyMatch(c -> c.isInstance(e))) {
                return null;
            }
            throw e;
        }
    }

    public static <T, E extends Exception> T e$R(FallibleSupplier<T, ?> supplier, Class<? extends E>... rethrowList) throws E {
        try {
            return supplier.get();
        } catch (Exception e) {
            if (rethrowList != null && Arrays.stream(rethrowList).filter(Objects::nonNull).anyMatch(c -> c.isInstance(e))) {
                throw (E) e;
            }
            return null;
        }
    }

    //endregion fallible supplier

}
