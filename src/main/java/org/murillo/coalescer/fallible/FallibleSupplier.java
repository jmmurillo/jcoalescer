package org.murillo.coalescer.fallible;

@FunctionalInterface
public interface FallibleSupplier<O, E extends Exception> {
    O get() throws E;
}