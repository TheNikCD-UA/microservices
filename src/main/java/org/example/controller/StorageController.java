package org.example.controller;

import org.example.api.StorageApi;
import org.example.storage.MyStorageImpl;
import org.example.storage.MyStorage;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class StorageController implements StorageApi {

    private final MyStorage myStorage;

    public StorageController() {
        this.myStorage = new MyStorageImpl();
    }

    @Override
    public Object get(UUID id) {
        return myStorage.get(id);
    }

    @Override
    public UUID post(Object obj) {
        return myStorage.post(obj);
    }

    @Override
    public boolean put(UUID id, Object obj) {
        return myStorage.put(id, obj);
    }

    @Override
    public Object delete(UUID id) {
        return myStorage.delete(id);
    }
}
