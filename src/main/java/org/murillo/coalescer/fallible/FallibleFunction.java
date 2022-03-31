package org.murillo.coalescer.fallible;

@FunctionalInterface
public interface FallibleFunction<I, O, E extends Exception> {
    O apply(I input) throws E;
}