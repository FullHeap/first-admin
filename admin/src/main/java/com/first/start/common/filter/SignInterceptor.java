package com.first.start.common.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.first.start.common.util.crypt.DESUtil;
import com.first.start.common.util.crypt.RSAUtil;
import com.first.start.common.util.text.StringUtils;
import com.first.start.project.system.model.AjaxResult;

/**
 * @ClassName: SignInterceptor
 * @Description: 签名验证请求拦截器
 * @author 忙碌的菠萝
 * @date 2020年11月30日 下午1:45:02
 *
 */
@Component
public class SignInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		String sign = request.getHeader("sign");
		String timestamp = request.getHeader("timestamp");
		String appid = request.getHeader("appid");
		String appsecret = request.getHeader("appsecret");
		
		if(StringUtils.isNotEmpty(sign)) {
			boolean result = RSAUtil.verify(appid+appsecret+timestamp, sign, RSAUtil.DEFAULT_PK);
			
			if (!result) {
				System.out.println(result);
				System.out.println("签名验证失败");
				PrintWriter printWriter = response.getWriter();
				AjaxResult ajax = AjaxResult.error();
				ajax.put("code","401");
				ajax.put("msg", "签名验证失败");
				printWriter.print(ajax);
				return false;
			}
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO 自动生成的方法存根
		System.out.println("postHandle");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO 自动生成的方法存根
		System.out.println("afterCompletion");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	
	public static StringBuilder getReqStr(HttpServletRequest request) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder("");
		try {
			br = request.getReader();
			String str;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb;
	}
	
}
