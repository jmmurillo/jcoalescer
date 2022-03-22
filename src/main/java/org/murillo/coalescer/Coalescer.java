package org.murillo.coalescer;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Coalescer {

//region Fallback

    public static <T> T $(T value, T fallback) {
        return value != null ? value : fallback;
    }

    public static <T> T $(T value, Supplier<T> supplier) {
        return value != null ? value : supplier.get();
    }

    public static <T, E extends Exception> T $E(T value, FallibleSupplier<T, E> supplier) throws E {
        return value != null ? value : supplier.get();
    }

    //endregion Fallback

//region Fallback optional

    public static <T> T $O(Optional<T> value) {
        return value != null && value.isPresent() ? value.get() : null;
    }

    public static <T> T $O(Optional<T> value, T fallback) {
        return value != null && value.isPresent() ? value.get() : fallback;
    }

    public static <T> T $O(Optional<T> value, Optional<T> fallback) {
        return value != null && value.isPresent() ? value.get() : $O(fallback);
    }

    public static <T> T $O(Optional<T> value, Supplier<Optional<T>> supplier) {
        return value != null && value.isPresent() ? value.get() : $O(supplier.get());
    }

    public static <T, E extends Exception> T $OE(Optional<T> value, FallibleSupplier<Optional<T>, E> supplier) throws E {
        return value != null && value.isPresent() ? value.get() : $O(supplier.get());
    }

    //endregion Fallback optional

//region Void method chain

    public static <A> void $$V(
            A value,
            Consumer<A> consumer) {
        if (value == null) return;
        consumer.accept(value);
    }

    public static <A, B> void $$V(
            A value,
            Function<A, B> functionB,
            Consumer<B> consumer
    ) {
        if (value == null) return;
        B valueB = functionB.apply(value);
        if (valueB == null) return;
        consumer.accept(valueB);
    }

    public static <A, B, C> void $$V(
            A value,
            Function<A, B> functionB,
            Function<B, C> functionC,
            Consumer<C> consumer
    ) {
        if (value == null) return;
        B valueB = functionB.apply(value);
        if (valueB == null) return;
        C valueC = functionC.apply(valueB);
        if (valueC == null) return;
        consumer.accept(valueC);
    }

    public static <A, B, C, D> void $$V(
            A value,
            Function<A, B> functionB,
            Function<B, C> functionC,
            Function<C, D> functionD,
            Consumer<D> consumer
    ) {
        if (value == null) return;
        B valueB = functionB.apply(value);
        if (valueB == null) return;
        C valueC = functionC.apply(valueB);
        if (valueC == null) return;
        D valueD = functionD.apply(valueC);
        if (valueD == null) return;
        consumer.accept(valueD);
    }

    public static <A, B, C, D, E> void $$V(
            A value,
            Function<A, B> functionB,
            Function<B, C> functionC,
            Function<C, D> functionD,
            Function<D, E> functionE,
            Consumer<E> consumer
    ) {
        if (value == null) return;
        B valueB = functionB.apply(value);
        if (valueB == null) return;
        C valueC = functionC.apply(valueB);
        if (valueC == null) return;
        D valueD = functionD.apply(valueC);
        if (valueD == null) return;
        E valueE = functionE.apply(valueD);
        if (valueE == null) return;
        consumer.accept(valueE);
    }

    //endregion Void method chain

    //region Returning method chain
    public static <A, B> B $$(
            A value,
            Function<A, B> function) {
        if (value == null) return null;
        return function.apply(value);
    }

    public static <A, B, C> C $$(
            A value,
            Function<A, B> functionB,
            Function<B, C> functionC
    ) {
        if (value == null) return null;
        B valueB = functionB.apply(value);
        if (valueB == null) return null;
        C valueC = functionC.apply(valueB);
        return valueC;
    }

    public static <A, B, C, D> D $$(
            A value,
            Function<A, B> functionB,
            Function<B, C> functionC,
            Function<C, D> functionD
    ) {
        if (value == null) return null;
        B valueB = functionB.apply(value);
        if (valueB == null) return null;
        C valueC = functionC.apply(valueB);
        if (valueC == null) return null;
        D valueD = functionD.apply(valueC);
        return valueD;
    }

    public static <A, B, C, D, E> E $$(
            A value,
            Function<A, B> functionB,
            Function<B, C> functionC,
            Function<C, D> functionD,
            Function<D, E> functionE
    ) {
        if (value == null) return null;
        B valueB = functionB.apply(value);
        if (valueB == null) return null;
        C valueC = functionC.apply(valueB);
        if (valueC == null) return null;
        D valueD = functionD.apply(valueC);
        if (valueD == null) return null;
        E valueE = functionE.apply(valueD);
        return valueE;
    }

    public static <A, B, C, D, E, F> F $$(
            A value,
            Function<A, B> functionB,
            Function<B, C> functionC,
            Function<C, D> functionD,
            Function<D, E> functionE,
            Function<E, F> functionF
    ) {
        if (value == null) return null;
        B valueB = functionB.apply(value);
        if (valueB == null) return null;
        C valueC = functionC.apply(valueB);
        if (valueC == null) return null;
        D valueD = functionD.apply(valueC);
        if (valueD == null) return null;
        E valueE = functionE.apply(valueD);
        if (valueE == null) return null;
        F valueF = functionF.apply(valueE);
        return valueF;
    }

    //endregion Returning method chain

//region Void fallible method chain

    public static <A, X extends Exception> void $$VE(
            A value,
            FallibleConsumer<A, X> consumer) throws X {
        if (value == null) return;
        consumer.accept(value);
    }

    public static <A, B> void $$VE(
            A value,
            FallibleFunction<A, B, ?> functionB,
            FallibleConsumer<B, ?> consumer
    ) throws Exception {
        if (value == null) return;
        B valueB = functionB.apply(value);
        if (valueB == null) return;
        consumer.accept(valueB);
    }

    public static <A, B, C> void $$VE(
            A value,
            FallibleFunction<A, B, ?> functionB,
            FallibleFunction<B, C, ?> functionC,
            FallibleConsumer<C, ?> consumer
    ) throws Exception {
        if (value == null) return;
        B valueB = functionB.apply(value);
        if (valueB == null) return;
        C valueC = functionC.apply(valueB);
        if (valueC == null) return;
        consumer.accept(valueC);
    }

    public static <A, B, C, D> void $$VE(
            A value,
            FallibleFunction<A, B, ?> functionB,
            FallibleFunction<B, C, ?> functionC,
            FallibleFunction<C, D, ?> functionD,
            FallibleConsumer<D, ?> consumer
    ) throws Exception {
        if (value == null) return;
        B valueB = functionB.apply(value);
        if (valueB == null) return;
        C valueC = functionC.apply(valueB);
        if (valueC == null) return;
        D valueD = functionD.apply(valueC);
        if (valueD == null) return;
        consumer.accept(valueD);
    }

    public static <A, B, C, D, E> void $$VE(
            A value,
            FallibleFunction<A, B, ?> functionB,
            FallibleFunction<B, C, ?> functionC,
            FallibleFunction<C, D, ?> functionD,
            FallibleFunction<D, E, ?> functionE,
            FallibleConsumer<E, ?> consumer
    ) throws Exception {
        if (value == null) return;
        B valueB = functionB.apply(value);
        if (valueB == null) return;
        C valueC = functionC.apply(valueB);
        if (valueC == null) return;
        D valueD = functionD.apply(valueC);
        if (valueD == null) return;
        E valueE = functionE.apply(valueD);
        if (valueE == null) return;
        consumer.accept(valueE);
    }

    //endregion Void fallible method chain

//region Returning fallible method chain

    public static <A, B, X extends Exception> B $$E(
            A value,
            FallibleFunction<A, B, X> function) throws X {
        if (value == null) return null;
        return function.apply(value);
    }

    public static <A, B, C> C $$E(
            A value,
            FallibleFunction<A, B, ?> functionB,
            FallibleFunction<B, C, ?> functionC
    ) throws Exception {
        if (value == null) return null;
        B valueB = functionB.apply(value);
        if (valueB == null) return null;
        C valueC = functionC.apply(valueB);
        return valueC;
    }

    public static <A, B, C, D> D $$E(
            A value,
            FallibleFunction<A, B, ?> functionB,
            FallibleFunction<B, C, ?> functionC,
            FallibleFunction<C, D, ?> functionD
    ) throws Exception {
        if (value == null) return null;
        B valueB = functionB.apply(value);
        if (valueB == null) return null;
        C valueC = functionC.apply(valueB);
        if (valueC == null) return null;
        D valueD = functionD.apply(valueC);
        return valueD;
    }

    public static <A, B, C, D, E> E $$E(
            A value,
            FallibleFunction<A, B, ?> functionB,
            FallibleFunction<B, C, ?> functionC,
            FallibleFunction<C, D, ?> functionD,
            FallibleFunction<D, E, ?> functionE
    ) throws Exception {
        if (value == null) return null;
        B valueB = functionB.apply(value);
        if (valueB == null) return null;
        C valueC = functionC.apply(valueB);
        if (valueC == null) return null;
        D valueD = functionD.apply(valueC);
        if (valueD == null) return null;
        E valueE = functionE.apply(valueD);
        return valueE;
    }

    public static <A, B, C, D, E, F> F $$E(
            A value,
            FallibleFunction<A, B, ?> functionB,
            FallibleFunction<B, C, ?> functionC,
            FallibleFunction<C, D, ?> functionD,
            FallibleFunction<D, E, ?> functionE,
            FallibleFunction<E, F, ?> functionF
    ) throws Exception {
        if (value == null) return null;
        B valueB = functionB.apply(value);
        if (valueB == null) return null;
        C valueC = functionC.apply(valueB);
        if (valueC == null) return null;
        D valueD = functionD.apply(valueC);
        if (valueD == null) return null;
        E valueE = functionE.apply(valueD);
        if (valueE == null) return null;
        F valueF = functionF.apply(valueE);
        return valueF;
    }

//endregion Returning fallible method chain

}
