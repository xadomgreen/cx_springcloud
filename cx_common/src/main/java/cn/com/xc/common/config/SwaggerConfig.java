package cn.com.xc.common.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @ClassName: SwaggerConfig
 * @Description: Swagger 是一款RESTFUL接口的文档在线自动生成+功能测试功能软件
 * @author xiadongdong
 * @date 2018年1月2日 上午10:15:58
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends AbstractSwaggerConfig {
	@Override
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("XadomGreen&&CuiZhengGuang电商项目接口API").description("©2018 Copyright. Powered By XC.")
				.termsOfServiceUrl("http://www.xc.com.cn/").version("1.0").build();
	}

	@Override
	public String apiPath() {
		return "/xc/.*";
	}

}
