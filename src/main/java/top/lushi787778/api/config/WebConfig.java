package top.lushi787778.api.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebConfig
 * @Description 解决跨域问题
 * @Author lushi
 * @Date 2022/2/10 18:54
 */
@SpringBootConfiguration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        /*
         * 所有请求允许跨域
         */
        corsRegistry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("https://lushi78778.top")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedHeaders("*")
                .maxAge(3600);
    }

}