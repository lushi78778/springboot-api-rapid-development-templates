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
package top.lushi787778.api.utils;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.JWTValidator;
import cn.hutool.jwt.signers.JWTSignerUtil;

import java.nio.charset.StandardCharsets;
import java.time.Instant;

/**
 * @ClassName JWTCommonUtil
 * @Description JWTCommonUtil
 * @Author lushi
 * @Date 2022/1/11 23:00
 */
public class JWTCommonUtil {

    //做梦也想不到的密钥哈哈哈哈哈
    private static final String key = DigestUtil.md5Hex("123456789");

    /**
     * 生成token
     *
     * @param userInfo 用户信息
     * @return token
     */
    public static String genToken(Object userInfo) {
        return JWT.create()
                .setPayload("userInfo", userInfo)
                .setIssuedAt(DateTime.of(Instant.now().toEpochMilli()))
                //10mins
                .setExpiresAt(DateTime.of(Instant.now().toEpochMilli() + 1000 * 60 * 10))
                //hs384
                .sign(JWTSignerUtil.hs384(key.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * 验签
     *
     * @param token jwt token
     * @return bool
     */
    public static boolean checkToken(String token) {
        try {
            JWTValidator.of(token)
                    //时间
                    .validateDate(DateUtil.date())
                    //签名
                    .validateAlgorithm(JWTSignerUtil.hs384(key.getBytes(StandardCharsets.UTF_8)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * JWT解析
     *
     * @param token jwt token
     * @return User 负载
     */
    public static Object getInfo(String token) {
        return  JWTUtil.parseToken(token).getPayload("userInfo");
    }

    /**
     * 更新再签发
     *
     * @param token jwt
     * @return jwt
     */
    public static String updateToken(String token) {
        return genToken(getInfo(token));
    }

//    public static void main(String[] args) {
//        Console.log(genToken("wgehytjehweryrthr"));
//    }
}

