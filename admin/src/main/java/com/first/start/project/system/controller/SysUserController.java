package com.first.start.project.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.first.start.project.system.entity.SysUser;
import com.first.start.project.system.model.AjaxResult;
import com.first.start.project.system.service.SysUserService;

@RestController
public class SysUserController {
	@Autowired
	private SysUserService sysuser;

	/**
	 * 获取用户列表
	 */

	@GetMapping("/getUserInfo")
	public AjaxResult getuserInfo(@RequestParam  Long currentPage,@RequestParam  Long pageSize) {
		List<SysUser> userList = sysuser.selectAll(currentPage,pageSize);
		List<Map<String, Object>> alluser = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < userList.size(); i++) {
			SysUser userInfo= userList.get(i);
			Map<String, Object> user = new HashMap<String, Object>();
			user.put("userId", userInfo.getUserId());
			user.put("deptId", userInfo.getDeptId());
			user.put("userName", userInfo.getUserName());
			user.put("nickName", userInfo.getNickName());
			user.put("email", userInfo.getEmail());
			user.put("phoneNumber", userInfo.getPhonenumber());
			user.put("sex", userInfo.getSex());
			user.put("avatar", userInfo.getAvatar());
			user.put("password", userInfo.getPassword());
			user.put("salt", userInfo.getSalt());
			user.put("status", userInfo.getStatus());
			user.put("delFlag", userInfo.getDelFlag());
			user.put("loginip", userInfo.getLoginIp());
			user.put("loginDate", userInfo.getLoginDate());
			user.put("roles", userInfo.getRoles());
			user.put("roleids", userInfo.getRoleIds());
			user.put("postids", userInfo.getPostIds());
			alluser.add(user);
		}
		AjaxResult ajax = AjaxResult.success();
		ajax.put("userInfo", alluser);
		ajax.put("total", userList.size());
		
		return ajax;

	}

}
