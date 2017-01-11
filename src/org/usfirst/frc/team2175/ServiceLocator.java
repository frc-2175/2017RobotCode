package org.usfirst.frc.team2175;

import java.util.HashMap;

public class ServiceLocator {

    private static final HashMap<Class<?>, Object> MAP = new HashMap<>();

    public static void clear() {
        MAP.clear();
    }

    public static void register(Object instance) {
        MAP.put(instance.getClass(), instance);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(Class<T> clazz) throws IllegalStateException {
        Object instance = MAP.get(clazz);
        if (instance == null) {
            throw new IllegalStateException("No instance of the class "
                    + clazz.getName() + " was registered");
        }

        return (T) instance;
    }

}
