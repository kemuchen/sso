package cn.sinobest.framework.service.inter.role;

import cn.sinobest.framework.beans.entity.ApiResponseResultEntity;
import cn.sinobest.framework.beans.error.AppException;
import cn.sinobest.framework.dao.auto.entity.SysRoleEntity;
import cn.sinobest.framework.dao.customize.vo.RoleRightVo;
import cn.sinobest.framework.dao.customize.vo.UserRoleVo;

/**
 * @ClassName BusinessRoleServiceInterface
 * @Desc
 * @Author 柯雷
 * @Date 2020-09-15 17:24
 * @Version 1.0
 */
public interface BusinessRoleServiceInterface {

    /**
     * @Description: 获取所有设备
     * @Params: []
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-09-15 17:38
     */
    ApiResponseResultEntity getAllRoles() throws AppException;

    /**
     * @Description: 获取用户角色组
     * @Params: [user_id]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-09-15 17:40
     */
    ApiResponseResultEntity getUserRoles(Integer user_id) throws AppException;

    /**
     * @Description: 获取角色权限
     * @Params: [role_id]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-09-15 17:40
     */
    ApiResponseResultEntity getRoleRights(Integer role_id) throws AppException;

    /**
     * @Description: 保存用户角色信息
     * @Params: [userRoleVo]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-09-15 17:45
     */
    ApiResponseResultEntity saveUserRoles(UserRoleVo userRoleVo) throws AppException;

    /**
     * @Description: 保存角色权限信息
     * @Params: [roleRightVo]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-09-15 17:46
     */
    ApiResponseResultEntity saveRoleRights(RoleRightVo roleRightVo) throws AppException;

    /**
     * @Description:
     * @Params: []
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-09-15 17:57
     */
    ApiResponseResultEntity saveRole(SysRoleEntity sysRoleEntity) throws AppException;

    /**
     * @Description: 删除角色信息
     * @Params: [sysRoleEntity]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-09-15 18:00
     */
    ApiResponseResultEntity deleteRole(SysRoleEntity sysRoleEntity) throws AppException;

    /**
     * @Description: 分页查询角色
     * @Params: [sysRoleEntity]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-09-15 18:02
     */
    ApiResponseResultEntity queryRoles(SysRoleEntity sysRoleEntity) throws AppException;
}
