package com.l.utils;

import com.l.json.CODE;
import com.l.json.MESSAGE;
import com.l.json.MyJSON;

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
    public static <T> MyJSON<T> get(Integer code, String message, T data) {
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
    public static MyJSON<Void> get(Integer code, String message) {
        return get(code, message, null);
    }

    /**
     * true
     * code:200 message: 成功 data: data
     * false
     * code:400 message: 失败 data: data
     *
     * @param data
     * @param ok
     * @param <T>
     * @return
     */
    public static <T> MyJSON<T> get(T data, boolean ok) {
        if (ok) return get(CODE.OK, MESSAGE.OK, data);
        return get(CODE.ERROR, MESSAGE.ERROR, data);
    }
}
