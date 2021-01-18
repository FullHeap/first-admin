package com.first.start.project.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.first.start.project.system.entity.SysUser;
import com.first.start.project.system.model.AjaxResult;
import com.first.start.project.system.model.QueryBody;
import com.first.start.project.system.service.SysUserService;

@RestController
public class SysUserController {
	@Autowired
	private SysUserService sysuserservice;

	/**
	 * 获取用户列表
	 */
	@RequestMapping("/getUserInfo")
	public AjaxResult getuserInfo(@RequestBody QueryBody queryBody) {
	   System.out.println("参数"+queryBody.getCurrentPage()+"---"+queryBody.getPageSize()+"-----"+queryBody.getUserId());
		Page<SysUser> pageParam = new Page<>(queryBody.getCurrentPage(), queryBody.getPageSize());
	    SysUser userVo= new SysUser();
	    userVo.setPhonenumber(queryBody.getPhoneNumber());
	    userVo.setUserId(queryBody.getUserId());
	    userVo.setUserName(queryBody.getUserName());
		System.out.println("参数"+queryBody.getCurrentPage()+"---"+queryBody.getPageSize()+"-----"+queryBody.getUserName());
		IPage<SysUser> pageModel = sysuserservice.selectAll(pageParam, userVo);
	    List<SysUser> userList =pageModel.getRecords();
		List<Map<String, Object>> alluser = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < userList.size(); i++) {
			SysUser userInfo = userList.get(i);
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
		ajax.put("total", pageModel.getTotal());

		return ajax;

	}

	/**
	 * 修改用户信息
	 */
	@RequestMapping(path = "/updateUserInfo", method = RequestMethod.POST)
	public AjaxResult updateUserInfo(@RequestBody SysUser sysuser) {
		System.out.println("11111" + sysuser);
		sysuserservice.updateUser(sysuser);

		AjaxResult ajax = AjaxResult.success();
		ajax.put("msg", "修改成功");
		return ajax;
	}

	/**
	 * 通过用户id修改用户信息
	 */
	@RequestMapping(path = "/changeUserStatus", method = RequestMethod.POST)
	public AjaxResult changeUserStatus(@RequestBody SysUser sysuser) {
		System.out.println("11111" + sysuser);
		sysuserservice.updateUserStatus(sysuser.getUserId(), sysuser.getStatus());
		AjaxResult ajax = AjaxResult.success();
		ajax.put("msg", "修改成功");
		return ajax;
	}

	

}
