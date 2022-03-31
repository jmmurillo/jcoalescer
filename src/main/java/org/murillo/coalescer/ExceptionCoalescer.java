package org.murillo.coalescer;

import org.murillo.coalescer.fallible.FallibleFunction;
import org.murillo.coalescer.fallible.FallibleSupplier;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

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

    //region fallible function

    public static <I, O> Function<I, O> _e$(FallibleFunction<I, O, ?> function) {
        return input -> {
            try {
                return function.apply(input);
            } catch (Exception e) {
                return null;
            }
        };
    }

    public static <I, O, E extends Exception> Function<I, O> _e$(FallibleFunction<I, O, ? extends E> function, Consumer<E> catcher) {
        return input -> {
            try {
                return function.apply(input);
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
        };
    }

    public static <I, O> FallibleFunction<I, O, ?> _e$E(FallibleFunction<I, O, ?> function, Class<? extends Exception>... ignoreList) {
        return input -> {
            try {
                return function.apply(input);
            } catch (Exception e) {
                if (ignoreList != null && Arrays.stream(ignoreList).filter(Objects::nonNull).anyMatch(c -> c.isInstance(e))) {
                    return null;
                }
                throw e;
            }
        };
    }

    public static <I, O, E extends Exception> FallibleFunction<I, O, E> _e$R(FallibleFunction<I, O, ?> function, Class<? extends E>... rethrowList) {
        return input -> {
            try {
                return function.apply(input);
            } catch (Exception e) {
                if (rethrowList != null && Arrays.stream(rethrowList).filter(Objects::nonNull).anyMatch(c -> c.isInstance(e))) {
                    throw (E) e;
                }
                return null;
            }
        };
    }

    //endregion fallible function

}
