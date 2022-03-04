package top.lushi787778.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import top.lushi787778.api.model.Result;

import java.sql.SQLException;

/**
 * @ClassName UserController
 * @Description 微信授权登录与易班授权登录
 * @Author lushi
 * @Date 2022/1/20 20:20
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    Result result = new Result();

    /**
     * 获取学生基本信息
     *
     * @param token token
     * @return Result
     */
    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public Result getStudentInfo(@RequestHeader String token){
        result.setCode(Result.OK);
        result.setToken(token);
        result.setObject("demo api");
        logger.info(String.valueOf(result));
        return result;
    }
}
