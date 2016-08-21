package service.impl;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import IDao.UserinfoMapper;
import pojo.Userinfo;
import service.IUserService;
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	UserinfoMapper userDao;
	@Override
	public Userinfo getUserById(String userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}
	@Override
	public Userinfo getUserByUsername(String userName) {
		// TODO Auto-generated method stub
		return this.userDao.selectByUserName(userName);
	}

}
