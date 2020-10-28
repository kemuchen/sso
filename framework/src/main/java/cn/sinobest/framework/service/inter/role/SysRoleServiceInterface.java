package cn.sinobest.framework.service.inter.role;

import cn.sinobest.framework.beans.entity.ApiResponseResultEntity;
import cn.sinobest.framework.beans.error.AppException;
import cn.sinobest.framework.dao.auto.entity.SysRoleEntity;

/**
 * @ClassName SysRoleServiceInterface
 * @Desc
 * @Author 柯雷
 * @Date 2020-04-27 17:53
 * @Version 1.0
 */
public interface SysRoleServiceInterface {

    /**
     * @Description: 获取所有角色信息-不分页
     * @Params: []
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-09-15 18:12
     */
    ApiResponseResultEntity getAllRoles() throws AppException;

    /**
     * @Description: 获取所有角色信息
     * @Params: [sysRoleEntity]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-04-27 17:58
     */
    ApiResponseResultEntity getAllRoles(SysRoleEntity sysRoleEntity) throws AppException;

    /**
     * @Description: 保存角色信息-分页
     * @Params: [sysRoleEntity]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-04-27 17:59
     */
    ApiResponseResultEntity saveRole(SysRoleEntity sysRoleEntity) throws AppException;

    /**
     * @Description: 根据id查询角色信息
     * @Params: [id]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-04-27 18:00
     */
    ApiResponseResultEntity getRoleById(Integer id) throws AppException;

    /**
     * @Description: 删除角色信息
     * @Params: [id]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-09-15 18:16
     */
    ApiResponseResultEntity deleteRole(Integer id) throws AppException;
}
