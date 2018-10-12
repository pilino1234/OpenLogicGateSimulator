package org.cafebabe.model.util;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;


/**
 * A generic event.
 * @param <T> The type of data transmitted by the event.
 */
public class Event<T> {
    private final Set<Consumer<T>> listeners = new HashSet<>();

    /* Public */
    public void addListener(Consumer<T> listener) {
        this.listeners.add(listener);
    }

    public void removeListener(Consumer<T> listener) {
        this.listeners.remove(listener);
    }

    public void removeListeners() {
        this.listeners.clear();
    }

    public void notifyListeners(T arg) {
        this.listeners.forEach(x -> x.accept(arg));
    }
}