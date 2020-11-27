package com.l.json;

import lombok.Data;

@Data
public class MyJSON<T> {
    private Integer code;
    private T Data;
    private String message;
}
