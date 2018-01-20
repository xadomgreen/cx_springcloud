package cn.com.cx.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy // 开启路由转发和过滤功能
@EnableEurekaClient // 注册到注册中心
@SpringBootApplication // 标记springboot程序
public class GateWayApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(GateWayApplication.class, args);
	}
}
