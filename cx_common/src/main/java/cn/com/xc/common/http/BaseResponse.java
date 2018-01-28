package cn.com.xc.common.http;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 请求响应基类
 * 
 * @author xmlab
 *
 * @param <T>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse implements Serializable {

	private static final long serialVersionUID = 5904767038637432979L;

	private String errcode = ErrorCode.OK; // errcode = 0表示正常
	private String errmsg; // 描述
	// private String errtype; // 错误类型

	public BaseResponse() {
		this.setErrcode(ErrorCode.OK);
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	/*
	 * public String getErrtype() { return errtype; }
	 * 
	 * public void setErrtype(String errtype) { this.errtype = errtype; }
	 */

}
