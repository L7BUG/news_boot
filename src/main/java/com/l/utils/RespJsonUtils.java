package com.l.utils;

import com.l.json.MyJSON;
import com.sun.istack.internal.NotNull;

public class RespJsonUtils {
    /**
     * 返回一个请求响应数据
     *
     * @param code    状态码
     * @param message 消息提示
     * @param data    数据
     * @param <T>     数据类型
     * @return
     */
    public static <T> MyJSON<T> get(@NotNull Integer code, @NotNull String message, T data) {
        MyJSON<T> json = new MyJSON<>();
        if (data != null) {
            json.setData(data);
        }
        json.setCode(code);
        json.setMessage(message);
        return json;
    }

    /**
     * 返回一个 data类型为 Void 的 请求响应数据
     *
     * @param code    状态码
     * @param message 消息提示
     * @return
     */
    public static MyJSON<Void> get(@NotNull Integer code, @NotNull String message) {
        return get(code, message, null);
    }
}
