package cn.com.xc.customer;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope(proxyMode=ScopedProxyMode.DEFAULT)
@ComponentScan(basePackages={"cn.com.xc"})
@EnableJpaRepositories(basePackages={"cn.com.xc.customer.dao"})
@EntityScan("cn.com.xc.customer.model")
//@EnableAutoConfiguration
public class CustomerApplication extends WebMvcConfigurerAdapter{

	// 使用Jackson
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
	}
	public static void main(String[] args) {

		SpringApplication.run(CustomerApplication.class, args);
	}

// 获取配置中心的数据
//	@Value(value = "${foo}")
//	String foo;
//
//	@RequestMapping("/get")
//	public String getByKey() {
//		return foo;
//	}
}
