package cn.com.xc.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Administrator Feign服务接口
 */
@FeignClient(value = "Xc-Eureka-Client",fallback=SchedualServiceHiHystric.class) // 服务名Xc-Eureka-Client
public interface SchedualServiceHi {

	@RequestMapping(value = "hi", method = RequestMethod.GET)
	public String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
