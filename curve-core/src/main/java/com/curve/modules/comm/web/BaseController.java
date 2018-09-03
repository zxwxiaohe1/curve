/**
 * Copyright &copy; 2015-2020 <a href="http://www.sinux.com.cn/">JFusion</a> All rights reserved.
 */
package com.curve.modules.comm.web;

import com.curve.core.dto.Result;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 控制器支持类
 * @author sinux
 * @version 2013-3-23
 */
public abstract class BaseController {

	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	public <T> Result<T> success() {
		Result.Builder<T> builder = new Result.Builder<T>();
		builder.setCode(200);
		builder.setMessage("操作成功！");
		return builder.builder();
	}

	public <T> Result<T> success(String message) {
		Result.Builder<T> builder = new Result.Builder<T>();
		builder.setCode(200);
		if (StringUtils.isNoneBlank(message)) {
			builder.setMessage(message);
		} else {
			builder.setMessage("操作成功！");
		}
		return builder.builder();
	}

	public <T> Result<T> success(T data) {
		Result.Builder<T> builder = new Result.Builder<T>();
		builder.setCode(200);
		builder.setMessage("操作成功！");
		builder.setData(data);
		return builder.builder();
	}

	public <T> Result<T> success(String message, T data) {
		Result.Builder<T> builder = new Result.Builder<T>();
		builder.setCode(200);
		builder.setData(data);
		if (StringUtils.isNoneBlank(message)) {
			builder.setMessage(message);
		} else {
			builder.setMessage("操作成功！");
		}
		return builder.builder();
	}

	public <T> Result<T> error() {
		return error("");
	}

	public <T> Result<T> error(String message) {
		Result.Builder<T> builder = new Result.Builder<T>();
		// 预定义5000为无业务需求用户提示统一返回code
		builder.setCode(5000);
		if (StringUtils.isNoneBlank(message)) {
			builder.setMessage(message);
		} else {
			builder.setMessage("操作失败！");
		}
		return builder.builder();
	}


	public <T> Result<T> error(int code, String message) {
		Result.Builder<T> builder = new Result.Builder<T>();
		builder.setCode(code);
		if (StringUtils.isNoneBlank(message)) {
			builder.setMessage(message);
		} else {
			builder.setMessage("操作失败！");
		}
		return builder.builder();
	}

	public <T> Result<T> build(int code, String message, T data) {
		Result.Builder<T> builder = new Result.Builder<T>();
		builder.setCode(200);
		builder.setMessage(message);
		builder.setData(data);
		return builder.builder();
	}
}
