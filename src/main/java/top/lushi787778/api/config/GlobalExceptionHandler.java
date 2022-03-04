package top.lushi787778.api.config;

import cn.hutool.jwt.JWTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.lushi787778.api.model.Result;
import top.lushi787778.api.utils.JsonUtil;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常捕获
 * @Author lushi
 * @Date 2022/2/5 12:16
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理token的业务异常
     *
     * @param response HttpServletResponse
     * @param e        JWTException
     */
    @ExceptionHandler(value = JWTException.class)
    public void JWTExceptionHandler(HttpServletResponse response, JWTException e) {
        Result result = new Result();
        logger.error(result.getRequest_id() + "发生业务异常！原因是：{}", e.toString());
        result.setCode(Result.Bad_Request);
        result.setObject("token格式不正确或token为空");
        JsonUtil.response(response, result);
    }


    /**
     * 重复索引冲突
     * SQLIntegrityConstraintViolationException
     *
     * @param response HttpServletResponse
     * @param e        SQLIntegrityConstraintViolationException
     */
    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public void exceptionHandler(HttpServletResponse response, SQLIntegrityConstraintViolationException e) {
        Result result = new Result();
        logger.error(result.getRequest_id() + "发生业务异常！原因是：{}", e.toString());
        result.setCode(Result.Bad_Request);
        result.setObject("用户已注册，不要重复注册");
        JsonUtil.response(response, result);
    }


    /**
     * 缺少必要参数
     * MissingServletRequestParameterException
     *
     * @param response HttpServletResponse
     * @param e        MissingServletRequestParameterException
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public void exceptionHandler(HttpServletResponse response, MissingServletRequestParameterException e) {
        Result result = new Result();
        logger.error(result.getRequest_id() + "发生业务异常！原因是：{}", e.toString());
        result.setCode(Result.Parameter_Required);
        result.setObject("您的请求缺少必要参数");
        JsonUtil.response(response, result);
    }

    /**
     * 缺少必要hander参数
     * MissingRequestHeaderException
     *
     * @param response HttpServletResponse
     * @param e        MissingRequestHeaderException
     */
    @ExceptionHandler(value = MissingRequestHeaderException.class)
    public void exceptionHandler(HttpServletResponse response, MissingRequestHeaderException e) {
        Result result = new Result();
        logger.error(result.getRequest_id() + "发生业务异常！原因是：{}", e.toString());
        result.setCode(Result.Parameter_Required);
        result.setObject("您的请求缺少必要hander参数");
        JsonUtil.response(response, result);
    }
}
