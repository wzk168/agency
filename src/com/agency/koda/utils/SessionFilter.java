package com.agency.koda.utils;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import com.agency.koda.model.UserInfo;

/**
 * 登录过滤
 * 
 * @author Waco
 *
 */
public class SessionFilter extends OncePerRequestFilter {
	// 不过滤的uri
	private static final String[] INHERENT_ESCAPE_URIS = { "/agency/",
			"/agency/user/login.html", "/agency/user/goOut.html" };

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// 请求的uri

		String uri = request.getRequestURI();

		if (isURILogin(uri, request)) {// 检查是否需要过滤
			// 执行过滤
			// 从session中获取登录者实体
			UserInfo userOfSession = (UserInfo) request.getSession()
					.getAttribute("userInfo");
			if (null == userOfSession) {
				boolean isAjaxRequest = isAjaxRequest(request);
				if (isAjaxRequest) {
					response.setCharacterEncoding("UTF-8");
					response.sendError(HttpStatus.UNAUTHORIZED.value(),
							"您已经太长时间没有操作,请刷新页面");
					return;
				}
				request.getRequestDispatcher("/user/sessionAlert.html")
						.forward(request, response); // 转发到登录页面
				return;
			} else {
				// 如果session中存在登录者实体，则继续
				filterChain.doFilter(request, response);
			}
		} else {
			// 如果不执行过滤，则继续
			filterChain.doFilter(request, response);
		}
	}

	/**
	 * 当前URI资源是否需要登录才能访问 返回true，无需登录即可访问 返回false，需登录才能访问
	 * 
	 * @param requestURI
	 * @param request
	 * @return
	 */
	private boolean isURILogin(String requestURI, HttpServletRequest request) {
		for (String uri : INHERENT_ESCAPE_URIS) {
			if (requestURI.equals(uri)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断是否为Ajax请求 <功能详细描述>
	 * 
	 * @param request
	 * @return 是true, 否false
	 * @see [类、类#方法、类#成员]
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
		String header = request.getHeader("X-Requested-With");
		if (header != null && "XMLHttpRequest".equals(header))
			return true;
		else
			return false;
	}
}
