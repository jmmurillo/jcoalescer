package org.murillo.coalescer;

public class ArrayCoalescer {

    public static <T> T $i(T[] array, int i) {
        if (array == null
                || array.length <= i) return null;
        return array[i];
    }

    public static <T> T[] $i(T[][] array, int i) {
        if (array == null
                || array.length <= i) return null;
        return array[i];
    }

    public static <T> T $i(T[][] array, int i, int j) {
        if (array == null
                || array.length <= i
                || array[i] == null
                || array.length <= j) return null;
        return array[i][j];
    }

    public static <T> T[][] $i(T[][][] array, int i) {
        if (array == null
                || array.length <= i) return null;
        return array[i];
    }

    public static <T> T[] $i(T[][][] array, int i, int j) {
        if (array == null
                || array.length <= i
                || array[i] == null
                || array.length <= j) return null;
        return array[i][j];
    }

    public static <T> T $i(T[][][] array, int i, int j, int k) {
        if (array == null
                || array.length <= i
                || array[i] == null
                || array.length <= j
                || array[i][j] == null
                || array.length <= k) return null;
        return array[i][j][k];
    }

    public static <T> T $iE(T[] array, int i) {
        if (array == null) return null;
        return array[i];
    }

    public static <T> T[] $iE(T[][] array, int i) {
        if (array == null) return null;
        return array[i];
    }

    public static <T> T $iE(T[][] array, int i, int j) {
        if (array == null
                || array[i] == null) return null;
        return array[i][j];
    }

    public static <T> T[][] $iE(T[][][] array, int i) {
        if (array == null) return null;
        return array[i];
    }

    public static <T> T[] $iE(T[][][] array, int i, int j) {
        if (array == null
                || array[i] == null) return null;
        return array[i][j];
    }

    public static <T> T $iE(T[][][] array, int i, int j, int k) {
        if (array == null
                || array[i] == null
                || array[i][j] == null) return null;
        return array[i][j][k];
    }

}
