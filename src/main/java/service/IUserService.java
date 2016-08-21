package service;


import pojo.Userinfo;


public interface IUserService {
	public Userinfo getUserById(String userId);
	public Userinfo getUserByUsername(String userName);
}
