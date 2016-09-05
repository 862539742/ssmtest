package IDao;

import pojo.SysPermission;

public interface SysPermissionMapper {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKeyWithBLOBs(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
}