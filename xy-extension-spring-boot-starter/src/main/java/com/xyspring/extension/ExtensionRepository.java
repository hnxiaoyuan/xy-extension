package com.xyspring.extension;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The extension point repository, saved the mapping
 * @author xiaoyuan
 */
public class ExtensionRepository {
    private final Map<ExtensionCoordinate, Object> extensionRepo = new ConcurrentHashMap<>();

    public void put(ExtensionCoordinate coordinate, Object extensionPoint){
        final Object preValue = this.extensionRepo.put(coordinate, extensionPoint);
        if (preValue != null) {
            throw new RuntimeException("Duplicate registration is not allowed for :" + coordinate);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getExtension(ExtensionCoordinate coordinate){
        return (T)extensionRepo.get(coordinate);
    }
}
