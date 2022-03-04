package top.lushi787778.api.model;

import lombok.Data;

import static cn.hutool.core.util.IdUtil.randomUUID;

/**
 * @ClassName Result
 * @Description 返回结果集
 * @Author lushi
 * @Date 2021/12/8 12:11
 */
@Data
public class Result {

    /**
     * 100	Continue	继续。客户端应继续其请求
     * 200	OK	请求成功。一般用于GET与POST请求
     * 202	Accepted	已接受。已经接受请求，但未处理完成
     * 203	Parameter required	错误的使用方法
     * 400	Bad Request	客户端请求的语法错误，服务器无法理解
     * 401	Unauthorized	请求要求用户的身份认证
     * 403	Forbidden	服务器理解请求客户端的请求，但是拒绝执行此请求
     * NOT_FOUND= 404;
     * 500	Internal Server Error	服务器内部错误，无法完成请求
     */
    public final static int Continue = 100;

    public final static int OK = 200;

    public final static int Accepted = 202;

    public final static int Parameter_Required = 203;

    public final static int Bad_Request = 400;

    public final static int Unauthorized = 401;

    public final static int Forbidden = 403;

    public final static int NOT_FOUND = 404;

    public final static int Internal_Server_Error = 500;

    /**
     * 消息码
     */
    private int code;
    /**
     * 消息凭证
     */
    private String token;
    /**
     * 请求唯一编号
     */
    private String request_id;

    {
        request_id = randomUUID();
    }

    /**
     * 消息结果集
     */
    private Object object;
}
