package com.uibuilder.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


public class Response<T> {
	
	private int statusCode;

	private String message;

	@JsonInclude(Include.NON_NULL)
	private T data;

	private LocalDateTime timeStamp;
	
	public static final Response<?> SUCCESS = new Response<>(200, "Success");
	public static final Response<?> CREATED = new Response<>(201, "Created");
	public static final Response<?> FAILURE = new Response<>(205, "Failed");
	public static final Response<?> NOT_FOUND = new Response<>(404, "Resource not found");
	public static final Response<?> BAD_REQUEST = new Response<>(400, "Bad Request");
	public static final Response<?> SERVER_ERROR = new Response<>(500, "Server Error");


	public Response(int statusCode, String message, T data) {
		this();
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}

	public Response(int statusCode, String message) {
		this();
		this.statusCode = statusCode;
		this.message = message;
	}

	public Response(T data) {
		this();
		this.data = data;
	}

	public Response() {
		super();
		this.timeStamp = LocalDateTime.now();
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

}
