package org.example.api;

import org.springframework.web.bind.annotation.*;
import java.util.UUID;

public interface StorageApi {

    @RequestMapping(value = "/storage/{id}", method = RequestMethod.GET)
    Object get(@PathVariable UUID id);

    @RequestMapping(value = "/storage", method = RequestMethod.POST)
    UUID post(@RequestBody Object obj);

    @RequestMapping(value = "/storage", method = RequestMethod.PUT)
    boolean put(@RequestParam UUID id, @RequestBody Object obj);

    @RequestMapping(value = "/storage/{id}", method = RequestMethod.DELETE)
    Object delete(@PathVariable UUID id);
}
