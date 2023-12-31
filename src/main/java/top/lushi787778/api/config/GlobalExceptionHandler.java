/**
 * MIT License
 *
 * Copyright (c) 2022 lushi78778
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
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
