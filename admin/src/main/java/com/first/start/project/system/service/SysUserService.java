package com.first.start.project.system.service;

import java.util.List;

import com.first.start.project.system.entity.SysUser;

public interface SysUserService {
	/**
	 * 查询用户列表信息
	 *
	 */

	public List<SysUser> selectAll(long currentpage, long pagenum);

	/**
	 * 通过用户Id获取用户信息
	 * 
	 */
	public List<SysUser> selectUser(Long userId);

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
	public	void updateUser(Long userId,String status);

}
