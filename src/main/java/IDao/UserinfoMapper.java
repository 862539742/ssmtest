package IDao;

import pojo.Userinfo;


public interface UserinfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(String id);
    
    Userinfo selectByUserName(String userName);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);
}