package service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import IDao.SysUserMapper;
import pojo.SysUser;
import service.SysUserService;
@Service("sysUserService")
public class UserServiceImpl implements SysUserService {
	@Autowired
	SysUserMapper sysUserDao;

	@Override
	public int deleteByPrimaryKey(Integer userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(SysUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(SysUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysUser selectByPrimaryKey(Integer userId) {
		// TODO Auto-generated method stub
		return this.sysUserDao.selectByPrimaryKey(userId);
	}

	@Override
	public int updateByPrimaryKeySelective(SysUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(SysUser record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysUser selectByPrimaryUserName(String userName) {
		// TODO Auto-generated method stub
		return this.sysUserDao.selectByPrimaryUserName(userName);
	}

}
