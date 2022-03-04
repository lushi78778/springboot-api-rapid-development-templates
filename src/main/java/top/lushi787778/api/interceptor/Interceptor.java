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
package top.lushi787778.api.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.lushi787778.api.model.Result;
import top.lushi787778.api.utils.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static top.lushi787778.api.utils.JWTCommonUtil.checkToken;

/**
 * @ClassName Interceptor
 * @Description 拦截器
 * @Author lushi
 * @Date 2022/1/20 19:06
 */
@Component
public class Interceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Result result = new Result();
        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            return true; // 通过所有OPTION请求
        } else {
            //jwt拦截器
            String token = request.getHeader("token"); // 获取请求头中的token
            if (checkToken(token)) {
                return true;
            } else {
                result.setCode(Result.Unauthorized);
                result.setObject("请hander附带正确token");
                logger.info(result.getRequest_id() + "用户未授权访问");
                JsonUtil.response(response, result);
                return false;
            }
        }
    }

//    public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
//        String verify_request = "5d3bbc8f19d1741f8ae19753a9a92f18eda0b7673e3f1d7f41494670a0b5aeffc613efa4a9b03065286fea6f70c691a934413c501c1c63602032a88cf459c52bb543a8ac831c4b2b5e59da0716eaf205dec370a91b0cab2ed5604d3b90c92944120f7e67fca3e874c074b2221ac47e89914dc1bafc758a8eecd589e9be5243dc2b3998a3f5693d09f26cf79dc11cbb32e5ccdc62cbde3459809ee598c7794f3abb1ab010a8064777ad3e5a233ab7a2ae0f3436e599602bbe73a03b14f0d50c7a34280d3635862a744b060a5293b4e0234f347015378bfe9636596ba9d97678fe46bdb451cc6e4df1598d7ddbd7128fea";
//        JSONObject jsonObject = JSONUtil.parseObj(UnicodeUtil.toString(dec(verify_request, "cc6b0bbc9511a978fce79d609c15c2ce", "b5c3764820a30348")));
//        Console.log(JSONUtil.parseObj(jsonObject.getObj("visit_oauth")).getObj("access_token"));
//    }
}
