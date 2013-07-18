package com.wj2411.lottery.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 全局过滤器
 * @author 须俊杰
 * @version 1.0 2012-7-8
 */
public class ControllerFilter implements Filter {

	private final static Log log = LogFactory.getLog(ControllerFilter.class);
	@SuppressWarnings("unused")
	private ServletContext context;
	
	/**
	 * 过滤器初始化
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	/**
	 * 执行过滤操作
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;

		try {
			log.debug("全局过滤器开始");
			chain.doFilter(request, response);
		} catch (Exception e) {
			log.error("全局过滤器异常",e);
		} finally {
			// 关闭数据库连接
//			DBManager.closeConnection();
			log.debug("全局过滤器结束");
		}
	}

	/**
	 * 过滤器释放资源
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
