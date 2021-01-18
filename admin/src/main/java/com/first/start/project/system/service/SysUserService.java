package com.first.start.project.system.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.first.start.project.system.entity.SysUser;

public interface SysUserService {
	/**
	 * 查询用户列表信息
	 *
	 */

	public IPage<SysUser> selectAll(Page<SysUser> pageparam,SysUser sysuser);

	/**
	 * 新增用户
	 * 
	 * @param userName 用户名
	 * @return 用户对象信息
	 */
	public SysUser insertUser(SysUser user);

	/**
	 * 删除用户
	 * 
	 * @param userName 用户名
	 * @return 用户对象信息
	 */
	public void deleteUser(Long userId);

	/**
	 * 修改用户
	 * 
	 * @param userName 用户名
	 * @return 用户对象信息
	 */
	public void updateUser(SysUser sysuser);

	/**
	 * 通过用户id修改用户状态
	 */
	public	void updateUserStatus(Long userId,String status);

}
