package org.qnit.common.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhuxianyu
 * @version 2020/9/15
 */
@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class Swagger2Config {

    // 定义分隔符,配置Swagger多包
    private static final String splitor = ";";

    /**
     * 创建API
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(basePackage("org.qnit"
//                                +
//                        splitor+"org.qnit.cloud.station"+
//                        splitor+"org.qnit.cloud.dict"+
//                        splitor+"org.qnit.cloud.api"+
//                        splitor+"org.qnit.cloud.stat"
                        ))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 添加摘要信息
     * 这里是接口的描述配置，不重要
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("系统API文档")
                .description("系统API文档")
                .version("1.0")
                .build();
    }


    /**
     * 重写basePackage方法，使能够实现多包访问，复制贴上去
     * @author  teavamc
     * @date 2019/1/26
     * @param [basePackage]
     * @return com.google.common.base.Predicate<springfox.documentation.RequestHandler>
     */
    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> (boolean) declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage)     {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(splitor)) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }
}
