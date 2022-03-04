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
package top.lushi787778.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import top.lushi787778.api.model.Result;


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
