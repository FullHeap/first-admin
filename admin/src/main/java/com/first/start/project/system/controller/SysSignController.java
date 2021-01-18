package com.first.start.project.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.start.project.system.model.AjaxResult;

/**
 * 登录验证
 * 
 */
@RestController
public class SysSignController {

	@GetMapping("/sign")
	public AjaxResult signError() {
		AjaxResult ajax = AjaxResult.success();
		ajax.put("code", "401");
		ajax.put("msg", "签名未验证通过");
		return ajax;
	}
}
