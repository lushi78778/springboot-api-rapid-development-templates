package top.lushi787778.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import top.lushi787778.api.model.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @ClassName JsonUtil
 * @Description Servlet返回JSON（供拦截器用）
 * @Author hui
 * @Date 2022/1/20 20:04
 */
public class JsonUtil {

    /**
     * Servlet返回JSON（供拦截器用）
     *
     * @param response HttpServletResponse对象
     * @param result   统一返回值枚举
     */
    @SneakyThrows
    public static void response(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("utf8");
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = response.getWriter();
        writer.write(mapper.writeValueAsString(result));
        writer.flush();
        writer.close();
    }

}