package com.xyspring.extension;

import java.util.Objects;

/**
 * Extension Coordinate(扩展坐标) is used to uniquely position an Extension
 * @author xiaoyuan
 */
public class ExtensionCoordinate {
    private String bizCode;
    private Class<?> extensionPointClass;

    public ExtensionCoordinate(Class<?> extensionPointClass, String bizCode) {
        this.bizCode = bizCode;
        this.extensionPointClass = extensionPointClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtensionCoordinate that = (ExtensionCoordinate) o;
        return bizCode.equals(that.bizCode) && extensionPointClass.equals(that.extensionPointClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bizCode, extensionPointClass.getName());
    }

    @Override
    public String toString() {
        return "ExtensionCoordinate{" +
                "bizCode='" + bizCode + '\'' +
                ", extensionPointClass=" + extensionPointClass +
                '}';
    }
}
