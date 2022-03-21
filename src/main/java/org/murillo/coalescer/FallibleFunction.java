package org.murillo.coalescer;

@FunctionalInterface
public interface FallibleFunction<I, O, E extends Exception> {
    O apply(I input) throws E;
}