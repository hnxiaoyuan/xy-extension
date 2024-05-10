package com.xyspring.extension;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author xiaoyuan
 */
public class ExtensionExecutor {
    private final ExtensionRepository extensionRepository;

    public ExtensionExecutor(ExtensionRepository extensionRepository) {
        this.extensionRepository = extensionRepository;
    }

    /**
     * Execute extension with Response
     *
     * @param targetClz
     * @param bizCode
     * @param exeFunction
     * @param <T> Parameter Type
     * @return
     */
    public <T> void executeVoid(Class<T> targetClz, String bizCode, Consumer<T> exeFunction) {
        T component = locateComponent(targetClz, bizCode);
        exeFunction.accept(component);
    }

    /**
     * Execute extension with Response
     *
     * @param targetClz
     * @param bizCode
     * @param exeFunction
     * @param <R> Response Type
     * @param <T> Parameter Type
     * @return
     */
    public <R, T> R execute(Class<T> targetClz, String bizCode, Function<T, R> exeFunction) {
        T component = locateComponent(targetClz, bizCode);
        return exeFunction.apply(component);
    }

    protected <Ext> Ext locateComponent(Class<Ext> targetClz, String bizCode) {
        ExtensionCoordinate extensionCoordinate = new ExtensionCoordinate(targetClz, bizCode);
        final Ext extension = extensionRepository.getExtension(extensionCoordinate);
        if (extension == null) {
            throw new RuntimeException(String.format("Can not find extension with ExtensionPoint: %s bizCode: %s", targetClz, bizCode));
        }
        return extension;
    }
}
