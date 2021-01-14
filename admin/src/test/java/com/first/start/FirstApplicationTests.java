package com.first.start;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.first.start.project.system.entity.SysUser;
import com.first.start.project.system.mapper.SysUserMapper;

@SpringBootTest
class FirstApplicationTests {

	  @Autowired
	    SysUserMapper userMapper;

	    @Test
	    public void selectAll() {
	        System.out.println(("----- selectAll method test ------"));
			//QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>();
			//Ipage 中参数一是当前页，参数二是每页个数
			 IPage<SysUser> Page = new Page<>(1, 5);
			 IPage<SysUser> sysuser = userMapper.selectPage(Page, null);
			  List<SysUser> list = sysuser.getRecords();
			           for(SysUser user : list){
			              System.out.println("数据查询"+user);
			        }
	    }

}
