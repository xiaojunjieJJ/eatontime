package com.xiao.eatontime.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String SWAGGER_SCAN_ADMIN_PACKAGE = "com.xiao.eatontime";
    public static final String ADMIN_VERSION = "1.0.0";

    @Bean
    public Docket createAdminRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("按时吃饭")
                .apiInfo(apiAdminInfo())
                .select()
                //api接口包扫描路径
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_ADMIN_PACKAGE))
                .build();
    }


    private ApiInfo apiAdminInfo() {
        return new ApiInfoBuilder()
                //设置文档的标题
                .title("按时吃饭")
                .contact(new Contact("肖俊杰", "", "hninee@163.com"))
                //设置文档的描述->1.Overview
                .description("按时吃饭")
                //设置文档的版本信息-> 1.1 Version information
                .version(ADMIN_VERSION)
                .build();
    }
}
