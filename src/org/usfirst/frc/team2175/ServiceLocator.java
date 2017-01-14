package org.usfirst.frc.team2175;

import java.util.HashMap;

public class ServiceLocator {
    private static final HashMap<Class<?>, Object> MAP = new HashMap<>();

    public static void clear() {
        MAP.clear();
    }

    public static void register(final Object instance) {
        final Object previousObject = MAP.put(instance.getClass(), instance);
        if (previousObject != null) {
            throw new IllegalStateException(
                    "MAP already contains value for key=" + instance);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(final Class<T> clazz) throws IllegalStateException {
        final Object instance = MAP.get(clazz);
        if (instance == null) {
            throw new IllegalStateException("No instance of the class "
                    + clazz.getName() + " was registered");
        }

        return (T) instance;
    }
}
