package org.example.storage;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MyStorageImpl implements MyStorage {

    private final Map<UUID, Object> storage = new HashMap<>();

    @Override
    public Object get(UUID id) {
        return storage.get(id);
    }

    @Override
    public UUID post(Object obj) {
        UUID newId = UUID.randomUUID();
        storage.put(newId, obj);
        return newId;
    }

    @Override
    public boolean put(UUID id, Object obj) {
        if (storage.containsKey(id)) {
            storage.put(id, obj);
            return true;
        }
        return false;
    }

    @Override
    public Object delete(UUID id) {
        return storage.remove(id);
    }
}
