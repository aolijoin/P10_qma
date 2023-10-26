package cn.jiyun.result;

import lombok.Data;

import java.io.Serializable;

@Data

public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public static <T> Result<T> success() {
        Result result = new Result();
        result.setCode(200);
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result result = new Result();
        result.setCode(200);
        result.setData(object);
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result result = new Result();
        result.setCode(300);
        result.setMsg(msg);
        return result;
    }
}

