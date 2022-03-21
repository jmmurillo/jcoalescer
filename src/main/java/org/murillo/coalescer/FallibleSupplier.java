package org.murillo.coalescer;

@FunctionalInterface
public interface FallibleSupplier<O, E extends Exception> {
    O get() throws E;
}