package com.hyx.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T>  {

    private Integer code; // 响应码，0-成功，1-失败
    private String message; // 提示信息，非必须
    private T data; // 泛型数据，根据实际业务场景定义


    public static <T> Result<T> success(T data) {
        return new Result<>(0, "操作成功", data);
    }

    public static Result success() {
        return new Result<>(0, "操作成功", null);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<>(1, message, null);
    }
}


