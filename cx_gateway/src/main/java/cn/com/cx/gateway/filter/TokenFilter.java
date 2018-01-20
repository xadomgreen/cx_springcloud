package cn.com.cx.gateway.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class TokenFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(TokenFilter.class);

	@Override
	public Object run() {
		// 获取请求上下文对象
		RequestContext ctx = RequestContext.getCurrentContext();
		// 获取http请求
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("%s >>> %s", request.getMethod(),request.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");
		if(accessToken == null) {
			log.warn("token is empty.");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			
			try {
				ctx.getResponse().getWriter().write("token is empty");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		log.info("ok");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// 是否过滤
		return true;
	}

	@Override
	public int filterOrder() {
		// 过滤的顺序
		return 0;
	}

	/**
	 * pre：路由之前 routing：路由之时 post： 路由之后
	 */
	@Override
	public String filterType() {
		// 路由之前
		return "pre";
	}

}
