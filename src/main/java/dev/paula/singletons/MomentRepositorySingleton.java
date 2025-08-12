package dev.paula.singletons;

import dev.paula.repository.MomentRepository;

public class MomentRepositorySingleton {

    private static MomentRepository INSTANCE;

    private MomentRepositorySingleton() {}

    public static MomentRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MomentRepository();
        }
        return INSTANCE;
    }

}
