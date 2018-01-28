package cn.com.xc.common.http;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 请求服务器返回的结果对象
 * 
 * @author mawei
 *
 * @param <T>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestData<T> implements Serializable{

	private static final long serialVersionUID = -353661331696549464L;

	private T data;
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
