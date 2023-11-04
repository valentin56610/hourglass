/*
 * Copyright (C) 2021 Nick Iacullo
 *
 * This file is part of Hourglass.
 *
 * Hourglass is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Hourglass is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Hourglass.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.lavabucket.hourglass.wrappers;

import java.util.function.Supplier;

/** A class wrapper used to reduce the number of references to external classes in this codebase. */
public class Wrapper<T> implements Supplier<T> {

    /** The wrapped object. */
    protected final T wrapped;

    /**
     * Instantiates a new object wrapper.
     * @param object  the object to wrap
     */
    public Wrapper(T object) {
        this.wrapped = object;
    }

    /** {@return the wrapped object} */
    public T get() {
        return wrapped;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((wrapped == null) ? 0 : wrapped.hashCode());
        return result;
    }

    /**
     * Returns true if {@code obj} is an instance of the same class as this object and has a wrapped
     * object that is equal to the object that this object wraps.
     * <p>{@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        ServerLevelWrapper other = (ServerLevelWrapper) obj;
        if (wrapped == null) {
            return other.wrapped == null;
        } else {
            return wrapped.equals(other.wrapped);
        }
    }

}
