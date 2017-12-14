package com.wwcc.service;

import java.util.List;

import com.wwcc.po.ActiveUser;
import com.wwcc.po.SysPermission;
import com.wwcc.po.SysUser;
import org.springframework.stereotype.Service;

/**
 * 
 * <p>Title: SysService</p>
 * <p>Description: 认证授权服务接口</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-3-23上午11:29:48
 * @version 1.0
 */

public interface SysService {
	
	//根据用户的身份和密码 进行认证，如果认证通过，返回用户身份信息
	public ActiveUser authenticat(String userCode,String password) throws Exception;
	
	//根据用户账号查询用户信息
	public SysUser findSysUserByUserCode(String userCode)throws Exception;
	
	//根据用户id查询权限范围的菜单
	public List<SysPermission> findMenuListByUserId(String userid) throws Exception;
	
	//根据用户id查询权限范围的url
	public List<SysPermission> findPermissionListByUserId(String userid) throws Exception;
}
