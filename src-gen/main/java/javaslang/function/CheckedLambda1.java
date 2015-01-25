/**    / \____  _    ______   _____ / \____   ____  _____
 *    /  \__  \/ \  / \__  \ /  __//  \__  \ /    \/ __  \   Javaslang
 *  _/  // _\  \  \/  / _\  \\_  \/  // _\  \  /\  \__/  /   Copyright 2014-2015 Daniel Dietrich
 * /___/ \_____/\____/\_____/____/\___\_____/_/  \_/____/    Licensed under the Apache License, Version 2.0
 */
package javaslang.function;

/*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*\
     G E N E R A T O R   C R A F T E D
\*-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-*/

import javaslang.Tuple1;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface CheckedLambda1<T1, R> extends Lambda<R> {

    static <T> CheckedLambda1<T, T> identity() {
        return t -> t;
    }

    R apply(T1 t1) throws Throwable;

    @Override
    default int arity() {
        return 1;
    }

    @Override
    default CheckedLambda1<T1, R> curried() {
        return t1 -> apply(t1);
    }

    @Override
    default CheckedLambda1<Tuple1<T1>, R> tupled() {
        return t -> apply(t._1);
    }

    @Override
    default CheckedLambda1<T1, R> reversed() {
        return (t1) -> apply(t1);
    }

    @Override
    default <V> CheckedLambda1<T1, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (t1) -> after.apply(apply(t1));
    }

    default <V> CheckedLambda1<V, R> compose(Function<? super V, ? extends T1> before) {
        Objects.requireNonNull(before);
        return v -> apply(before.apply(v));
    }
}