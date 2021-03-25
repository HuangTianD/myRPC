package com.lwx.rpc.enitity;

import com.lwx.rpc.enumeration.ResponseCode;
import lombok.Data;

import java.io.Serializable;

@Data
//rpc服务端向客户端回应的格式，分为成功和失败两种状态
public class RpcResponse<T> implements Serializable {
    private String requestId;
    private Integer statusCode;
    private String message;
    private T data;

    public static<T> RpcResponse<T> success(T data,String requestId){
        RpcResponse<T> response = new RpcResponse<>();
        response.setRequestId(requestId);
        response.setStatusCode(ResponseCode.SUCCESS.getCode());
        response.setData(data);
        return response;
    }

    public static<T> RpcResponse<T> fail(ResponseCode code,String requestId){
        RpcResponse<T> response = new RpcResponse<>();
        response.setRequestId(requestId);
        response.setStatusCode(code.getCode());
        response.setMessage(code.getMessage());
        return response;
    }
}
