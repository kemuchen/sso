package cn.sinobest.framework.service.inter.role;

import cn.sinobest.framework.beans.entity.ApiResponseResultEntity;
import cn.sinobest.framework.beans.error.AppException;
import cn.sinobest.framework.dao.auto.entity.SysRole2rightEntity;

/**
 * @ClassName SysRole2RightServiceInterface
 * @Desc
 * @Author 柯雷
 * @Date 2020-09-15 18:07
 * @Version 1.0
 */
public interface SysRole2RightServiceInterface {

    /**
     * @Description: 获取角色权限信息
     * @Params: [role_id]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-09-16 8:11
     */
    ApiResponseResultEntity getRoleRights(Integer role_id) throws AppException;
    
    /** 
     * @Description: 保存角色权限信息
     * @Params: [sysRole2rightEntity]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-09-16 8:23
     */ 
    ApiResponseResultEntity saveRole2Right(SysRole2rightEntity sysRole2rightEntity) throws AppException;
}
