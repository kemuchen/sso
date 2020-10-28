package cn.sinobest.framework.service.inter.role;

import cn.sinobest.framework.beans.entity.ApiResponseResultEntity;
import cn.sinobest.framework.beans.error.AppException;
import cn.sinobest.framework.dao.auto.entity.SysUser2roleEntity;

/**
 * @ClassName SysUser2RoleServiceInterface
 * @Desc
 * @Author 柯雷
 * @Date 2020-09-15 17:25
 * @Version 1.0
 */
public interface SysUser2RoleServiceInterface {

    /**
     * @Description: 获取用户角色信息
     * @Params: [user_id]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-09-16 8:10
     */
    ApiResponseResultEntity getUserRoles(Integer user_id) throws AppException;

    /**
     * @Description: 保存用户角色信息
     * @Params: [sysUser2roleEntity]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-09-16 8:16
     */
    ApiResponseResultEntity saveSysUser2Role(SysUser2roleEntity sysUser2roleEntity) throws AppException;
}
