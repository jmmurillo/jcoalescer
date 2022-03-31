package org.murillo.coalescer;

import org.murillo.coalescer.fallible.FallibleSupplier;

import java.util.Optional;
import java.util.function.Supplier;

public class BooleanCoalescer {

    //region Fallback
    public static boolean b$(Boolean value) {
        if (value == null) return false;
        return value;
    }

    public static boolean b$(Boolean value, boolean fallback) {
        if (value == null) return fallback;
        return value;
    }

    public static <E extends Exception> boolean b$E(Boolean value, FallibleSupplier<Boolean, E> supplier) throws E {
        return value != null ? value : b$(supplier.get());
    }
    //endregion Fallback

    //region Fallback optional
    public static boolean b$O(Optional<Boolean> value) {
        return value != null && value.isPresent() ? value.get() : false;
    }

    public static boolean b$O(Optional<Boolean> value, boolean fallback) {
        return value != null && value.isPresent() ? value.get() : fallback;
    }

    public static boolean b$O(Optional<Boolean> value, Optional<Boolean> fallback) {
        return value != null && value.isPresent() ? value.get() : b$O(fallback);
    }

    public static boolean b$O(Optional<Boolean> value, Supplier<Optional<Boolean>> supplier) {
        return value != null && value.isPresent() ? value.get() : b$O(supplier.get());
    }

    public static <E extends Exception> boolean b$OE(Optional<Boolean> value, FallibleSupplier<Optional<Boolean>, E> supplier) throws E {
        return value != null && value.isPresent() ? value.get() : b$O(supplier.get());
    }
    //endregion Fallback optional
}
