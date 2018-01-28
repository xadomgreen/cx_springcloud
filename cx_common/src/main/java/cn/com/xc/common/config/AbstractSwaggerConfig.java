package cn.com.xc.common.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 需要使用Swagger的地方继承此类，在类上面配置@Configuration 并实现apiInfo()方法
 * 
 * @author mawei
 */
@EnableSwagger2
public abstract class AbstractSwaggerConfig extends WebMvcConfigurerAdapter {
	final Logger logger = LoggerFactory.getLogger(AbstractSwaggerConfig.class);

	/**
	 * 这个地方要重新注入一下资源文件，不然不会注入资源的，也没有注入requestHandlerMappping,相当于xml配置的
	 * <!--swagger资源配置-->
	 * <mvc:resources location="classpath:/META-INF/resources/" mapping=
	 * "swagger-ui.html"/>
	 * <mvc:resources location="classpath:/META-INF/resources/webjars/" mapping=
	 * "/webjars/**"/> 不知道为什么，这也是spring boot的一个缺点（菜鸟觉得的）
	 * 
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars*").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Bean
	public Docket api() {
		logger.info("启动Swagger2 ===>");
		ParameterBuilder tokenPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		// 使用一个有效期为10年的jwt access token以方便测试
		tokenPar.name("Authorization").description("JWT令牌").modelRef(new ModelRef("string")).parameterType("header")
				.required(false)
				.defaultValue(
						"Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsib2F1dGgyLXJlc291cmNlIiwienV1bCJdLCJ1c2VyX25hbWUiOiJhZG1pbiIsInNjb3BlIjpbIndlYiIsImFwcCJdLCJuYW1lIjoi566h55CG5ZGYYSIsImlkIjoiYzZkYWE1MTg4NTE3NDJmMGIyN2QxMjMyMDE1ODc5YmIiLCJleHAiOjE1NDk2NTMzNTIsImF1dGhvcml0aWVzIjpbIkFDVFVBVE9SIiwiUk9MRV9VU0VSIl0sImp0aSI6IjkxYjc5MWRiLTZkNzYtNDI0MS1iYzQxLWY1MWFmNmVjOTNmMiIsImNsaWVudF9pZCI6ImNsaWVudDEifQ.BLbD6g7EJGX5lVQBgPvz4rSXiXi6wR99SHJBo67dXp08zu1aKmnNkfWREsKezzaWEFHPDo8K8eZbhYdNLfgVbi3z2nPY9jTFjZ37YkdZoy03vUSSlaU1zKOnlgKHFv5ZEzNktv23zi_NefaXYikWkcsliMJ1tuWktuNXwqxyN0doxOc6sYmU2x4sJ3_WQ6P1keY9pqh7z5ZaGWMJNH4RdB2Xv3Y6NMb4Cqn4ENjW_mOqaBOE3IjqbKaUQ72e5n5uLRz-j1mObwrWxtatAmMzvrxNwcyNVenmnSZcQD-HX1jkuBrANPxlUhgaEe6wcza7Va5g3ipSYo8si2-d1xrTZA")
				.build();

		pars.add(tokenPar.build());

		return new Docket(DocumentationType.SWAGGER_2).groupName("XC-Tech").select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex(apiPath())) // 要过滤的api uri
				.build().globalOperationParameters(pars).apiInfo(apiInfo());
	}

	public abstract ApiInfo apiInfo();

	/**
	 * 需要显示的api uri (正则表达式匹配)
	 * 
	 * @return
	 */
	public abstract String apiPath();

}