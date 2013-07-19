package com.wj2411.lottery.common.utils;

import java.io.IOException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {

	private static final Logger log = LoggerFactory.getLogger(HttpUtil.class);
	
	public static String get(String url) {
		HttpClient httpClient = new HttpClient();
		// 设置 Http 连接超时为5秒
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);

		/* 2 生成 GetMethod 对象并设置参数 */
		GetMethod getMethod = new GetMethod(url);
		// 设置 get 请求超时为 5 秒
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
		// 设置请求重试处理，用的是默认的重试处理：请求三次
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());

		// 读取 HTTP 响应内容
		byte[] responseBody = null;// 读取为字节数组
					
		/* 执行 HTTP GET 请求 */
		try {
			int statusCode = httpClient.executeMethod(getMethod);
			/* 判断访问的状态码 */
			if (statusCode != HttpStatus.SC_OK) {
				log.error("Method failed: "+ getMethod.getStatusLine());
			}

			/* 处理 HTTP 响应内容 */
			// HTTP响应头部信息，这里简单打印
			Header[] headers = getMethod.getResponseHeaders();
			for (Header h : headers){
				log.debug(h.getName() + " " + h.getValue());
			}
				
			// 读取 HTTP 响应内容
			responseBody = getMethod.getResponseBody();// 读取为字节数组
			log.debug("responseBody : "+new String(responseBody));
			// 读取为 InputStream，在网页内容数据量大时候推荐使用
			// InputStream response = getMethod.getResponseBodyAsStream();//
		} catch (HttpException e) {
			// 发生致命的异常，可能是协议不对或者返回的内容有问题
			log.error("Please check your provided http address!",e);
		} catch (IOException e) {
			log.error("Please check your io!",e);
		} finally {
			log.debug("Release connection!");
			/* 6 .释放连接 */
			getMethod.releaseConnection();
		}
		return new String(responseBody);
	}
}
