package org.example.extension.validate;

/**
 * @author DM-AI
 */
public interface CustomizeValidation<T> {
    /**
     * 自定义校验规则
     * @param value 要校验的对象
     * @return 校验通过/不通过
     */
    default boolean validate(T value){
        return true;
    }
}
