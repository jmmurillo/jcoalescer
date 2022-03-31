package org.murillo.coalescer.fallible;

@FunctionalInterface
public interface FallibleConsumer<I, E extends Exception> {
    void accept(I input) throws E;
}