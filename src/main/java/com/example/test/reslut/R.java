package com.example.test.reslut;

import lombok.Data;

@Data
public class R<T>{
    private T data;
    private String msg;
    private int status = 0;
}
