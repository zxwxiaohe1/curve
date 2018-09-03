/**
 * Copyright &copy; 2015-2020 <a href="http://www.sinux.com.cn/">JFusion</a> All rights reserved.
 */
package com.curve.core.dto;

/** 封装json对象，所有返回结果都使用
 *
 * @author heyong
 * @version 2018-08-10
 */
public class Result<T> {

    private final int code;
    private final String message;
    private final T data;
    
    public Result(int code, String message, T data) {
    	this.code = code;
    	this.message = message;
    	this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
    
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		Result other = (Result) obj;
		if (code != other.code) {
			return false;
		}
		if (data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!data.equals(other.data)) {
			return false;
		}

		if (message == null) {
			if (other.message != null) {
				return false;
			}
		} else if (!message.equals(other.message)) {
			return false;
		}
		return true;
	}

	public static class Builder<T> {
    	private int code;
    	private String message;
    	private T data;
    	
		public Builder() {
			
		}
		
    	public Builder<T> setCode(int code) {
			this.code = code;
			return this;
		}


		public Builder<T> setMessage(String message) {
			this.message = message;
			return this;
		}


		public Builder<T> setData(T data) {
			this.data = data;
			return this;
		}


		public Result<T> builder() {
    		return new Result<T>(this.code, this.message, this.data);
    	}
    	
    }
}
