package com.first.start.project.system.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.first.start.project.system.entity.SysUser;
import com.first.start.project.system.mapper.SysUserMapper;
import com.first.start.project.system.service.SysLoginService;

@Service
public class SysLoginServiceImpl implements SysLoginService {
	@Autowired
	private SysUserMapper sysusermapper;

	/**
	 * 通过用户名查询密码是否一致
	 */
	@Override
	public SysUser selectUserByUserName(String username) {
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
		queryWrapper.select().eq("username", username);
		List<SysUser> user=sysusermapper.selectList(queryWrapper);
	
		return user.get(0);
	}

	@Override
	public int updPwd(String username) {
		UpdateWrapper<SysUser> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("username", username);
		SysUser user = new SysUser();
		user.setPassword(username);
		int rows = sysusermapper.update(user, updateWrapper);
		return rows;

	}

}
