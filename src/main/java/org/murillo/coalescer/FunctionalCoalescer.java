package org.murillo.coalescer;

import org.murillo.coalescer.fallible.FallibleFunction;
import org.murillo.coalescer.fallible.FallibleSupplier;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.murillo.coalescer.Coalescer.$O;

public class FunctionalCoalescer {

//region Fallback

    public static <T> Function<T, T> _$(T fallback) {
        return input -> input != null ? input : fallback;
    }

    public static <T> Function<T, T> _$(Supplier<T> supplier) {
        return input -> {
            return input != null ? input : supplier.get();
        };
    }

    public static <T, E extends Exception> FallibleFunction<T, T, E> _$E(FallibleSupplier<T, E> supplier) {
        return input -> input != null ? input : supplier.get();
    }

    //endregion Fallback

//region Fallback optional

    public static <T> Function<Optional<T>, T> _$O() {
        return input -> input != null && input.isPresent() ? input.get() : null;
    }

    public static <T> Function<Optional<T>, T> _$O(T fallback) {
        return input -> input != null && input.isPresent() ? input.get() : fallback;
    }

    public static <T> Function<Optional<T>, T> _$O(Optional<T> fallback) {
        return input -> input != null && input.isPresent() ? input.get() : $O(fallback);
    }

    public static <T> Function<Optional<T>, T> _$O(Supplier<Optional<T>> supplier) {
        return input -> input != null && input.isPresent() ? input.get() : $O(supplier.get());
    }

    public static <T, E extends Exception> FallibleFunction<Optional<T>, T, E> _$OE(FallibleSupplier<Optional<T>, E> supplier) {
        return input -> input != null && input.isPresent() ? input.get() : $O(supplier.get());
    }

    //endregion Fallback optional

    //region Returning method chain
    public static <A, O> Function<A, O> _$$(
            Function<A, O> function) {
        return input -> {
            if (input == null) return null;
            return function.apply(input);
        };
    }

    public static <A, B, O> Function<A, O> _$$(
            Function<A, B> functionB,
            Function<B, O> functionC
    ) {
        return input -> {
            if (input == null) return null;
            B inputB = functionB.apply(input);
            if (inputB == null) return null;
            O inputC = functionC.apply(inputB);
            return inputC;
        };
    }

    public static <A, B, C, O> Function<A, O> _$$(
            Function<A, B> functionB,
            Function<B, C> functionC,
            Function<C, O> functionD
    ) {
        return input -> {
            if (input == null) return null;
            B inputB = functionB.apply(input);
            if (inputB == null) return null;
            C inputC = functionC.apply(inputB);
            if (inputC == null) return null;
            O inputD = functionD.apply(inputC);
            return inputD;
        };
    }

    public static <A, B, C, D, O> Function<A, O> _$$(
            Function<A, B> functionB,
            Function<B, C> functionC,
            Function<C, D> functionD,
            Function<D, O> functionE
    ) {
        return input -> {
            if (input == null) return null;
            B inputB = functionB.apply(input);
            if (inputB == null) return null;
            C inputC = functionC.apply(inputB);
            if (inputC == null) return null;
            D inputD = functionD.apply(inputC);
            if (inputD == null) return null;
            O inputE = functionE.apply(inputD);
            return inputE;
        };
    }

    public static <A, B, C, D, E, O> Function<A, O> _$$(
            Function<A, B> functionB,
            Function<B, C> functionC,
            Function<C, D> functionD,
            Function<D, E> functionE,
            Function<E, O> functionF
    ) {
        return input -> {
            if (input == null) return null;
            B inputB = functionB.apply(input);
            if (inputB == null) return null;
            C inputC = functionC.apply(inputB);
            if (inputC == null) return null;
            D inputD = functionD.apply(inputC);
            if (inputD == null) return null;
            E inputE = functionE.apply(inputD);
            if (inputE == null) return null;
            O inputF = functionF.apply(inputE);
            return inputF;
        };
    }

    //endregion Returning method chain

//region Returning fallible method chain

    public static <A, O, X extends Exception> FallibleFunction<A, O, X> _$$E(
            FallibleFunction<A, O, X> function) {
        return input -> {
            if (input == null) return null;
            return function.apply(input);
        };
    }

    public static <A, B, O> FallibleFunction<A, O, ?> _$$E(
            FallibleFunction<A, B, ?> functionB,
            FallibleFunction<B, O, ?> functionC
    ) {
        return input -> {
            if (input == null) return null;
            B inputB = functionB.apply(input);
            if (inputB == null) return null;
            O inputC = functionC.apply(inputB);
            return inputC;
        };
    }

    public static <A, B, C, O> FallibleFunction<A, O, ?> _$$E(
            FallibleFunction<A, B, ?> functionB,
            FallibleFunction<B, C, ?> functionC,
            FallibleFunction<C, O, ?> functionD
    ) {
        return input -> {

            if (input == null) return null;
            B inputB = functionB.apply(input);
            if (inputB == null) return null;
            C inputC = functionC.apply(inputB);
            if (inputC == null) return null;
            O inputD = functionD.apply(inputC);
            return inputD;
        };
    }

    public static <A, B, C, D, O> FallibleFunction<A, O, ?> _$$E(
            FallibleFunction<A, B, ?> functionB,
            FallibleFunction<B, C, ?> functionC,
            FallibleFunction<C, D, ?> functionD,
            FallibleFunction<D, O, ?> functionE
    ) {
        return input -> {
            if (input == null) return null;
            B inputB = functionB.apply(input);
            if (inputB == null) return null;
            C inputC = functionC.apply(inputB);
            if (inputC == null) return null;
            D inputD = functionD.apply(inputC);
            if (inputD == null) return null;
            O inputE = functionE.apply(inputD);
            return inputE;
        };
    }

    public static <A, B, C, D, E, O> FallibleFunction<A, O, ?> _$$E(
            FallibleFunction<A, B, ?> functionB,
            FallibleFunction<B, C, ?> functionC,
            FallibleFunction<C, D, ?> functionD,
            FallibleFunction<D, E, ?> functionE,
            FallibleFunction<E, O, ?> functionF
    ) {
        return input -> {
            if (input == null) return null;
            B inputB = functionB.apply(input);
            if (inputB == null) return null;
            C inputC = functionC.apply(inputB);
            if (inputC == null) return null;
            D inputD = functionD.apply(inputC);
            if (inputD == null) return null;
            E inputE = functionE.apply(inputD);
            if (inputE == null) return null;
            O inputF = functionF.apply(inputE);
            return inputF;
        };
    }

//endregion Returning fallible method chain

}
