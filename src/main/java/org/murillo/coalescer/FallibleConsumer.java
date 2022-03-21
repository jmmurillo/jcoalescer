package org.murillo.coalescer;

@FunctionalInterface
public interface FallibleConsumer<I, E extends Exception> {
    void accept(I input) throws E;
}