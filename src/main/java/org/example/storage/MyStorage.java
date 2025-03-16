package org.example.storage;

import java.util.UUID;

public interface MyStorage {

    Object get(UUID id);

    UUID post(Object obj);

    boolean put(UUID id, Object obj);

    Object delete(UUID id);
}
