package top.lushi787778.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @ClassName SwaggerConfig
 * @Description Swagger配置
 * @Author lushi
 * @Date 2022/1/18 11:43
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket adminApi() {
        // OAS_30：区别于 V2，（OpenAPI Specification 的简称 OAS）
        return new Docket(
                // 使用 OpenAPI 3.0
                DocumentationType.OAS_30)
                .enable(true)
                // API 信息
                .apiInfo(getAdminApiInfo())
                .select()
                // 对某个包的接口进行监听
                .apis(RequestHandlerSelectors.basePackage("top.lushi787778.api.controller"))
                // 监听所有接口
                // .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 定义接口文档信息
     *
     * @return ApiInfo
     */
    private ApiInfo getAdminApiInfo() {
        return new ApiInfoBuilder()
                // 文档标题
                .title("新大厅接口文档")
                // 文档描述
                .description("文档描述巴拉巴拉")
                // 联系人信息
                .contact(new Contact("lushi",
                        "https://gitee.com/lushi78778",
                        "lushi78778@outlook.com"))
                // 文档版本
                .version("v1.0")
                .build();
    }

}
