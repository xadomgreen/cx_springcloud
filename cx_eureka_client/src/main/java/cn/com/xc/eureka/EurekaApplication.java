package cn.com.xc.eureka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XiaDongdong 服务客户端
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		return "hi " + name + ",i am from port:" + port;
	}
}
