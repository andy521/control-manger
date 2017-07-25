package com.drore.cloud.control.manger.common.base.domain.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 卓锐科技有限公司
 * Created by wmm on 2017/4/19.
 * email：6492178@gmail.com
 * description:
 *
 * @author wmm
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -8780917125380864387L;
    public boolean isSuccess;
    public int code;
    public String message;
    public T data;

    public Result() {
        this.setSuccess(true);
        this.setCode(1012);
    }

    public static Result error() {
        return error(500, "服务器异常请联系管理员");
    }

    public static Result error(String message) {
        return error(500, message);
    }

    public static Result error(int code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setSuccess(false);
        return result;
    }

    public static Result success() {
        return new Result();
    }

    public static Result success(String message) {
        Result result = new Result();
        result.setMessage(message);
        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setData(data);
        return result;
    }
}
