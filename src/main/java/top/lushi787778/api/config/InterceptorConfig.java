package top.lushi787778.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.lushi787778.api.interceptor.Interceptor;

/**
 * @ClassName InterceptorConfig
 * @Description 拦截器配置类
 * @Author lushi
 * @Date 2022/1/20 19:15
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Interceptor())
                .addPathPatterns("/api/**")
                .addPathPatterns("/v3/**")
//                .addPathPatterns("/swagger-ui/**");
                .excludePathPatterns("/swagger-ui/**");
    }
}
