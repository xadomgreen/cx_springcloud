package cn.com.cx.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer // 开启配置服务器的功能
@EnableEurekaClient // 注册到注册中心
public class ConfigServerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
