package cn.sinobest.framework.service.inter.right;

import cn.sinobest.framework.beans.entity.ApiResponseResultEntity;
import cn.sinobest.framework.beans.error.AppException;
import cn.sinobest.framework.dao.auto.entity.SysRightEntity;

/**
 * @ClassName SysRightServiceInterface
 * @Desc
 * @Author 柯雷
 * @Date 2020-04-27 18:07
 * @Version 1.0
 */
public interface SysRightServiceInterface {

    /**
     * @Description: 分页查询权限信息
     * @Params: [sysRightEntity]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-04-27 18:08
     */
    ApiResponseResultEntity getAllRights(SysRightEntity sysRightEntity) throws AppException;

    /**
     * @Description: 保存菜单信息
     * @Params: [sysRightEntity]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-04-27 18:11
     */
    ApiResponseResultEntity saveRight(SysRightEntity sysRightEntity) throws AppException;

    /**
     * @Description: 根据id查询菜单信息
     * @Params: [id]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-04-27 18:12
     */
    ApiResponseResultEntity getRightById(Integer id) throws AppException;

    /**
     * @Description: 查询菜单信息
     * @Params: [sysRightEntity]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-04-28 11:38
     */
    ApiResponseResultEntity getRights(SysRightEntity sysRightEntity) throws AppException;

    /**
     * @Description: 根据id查询用户菜单信息
     * @Params: [user_id]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-04-28 11:49
     */
    ApiResponseResultEntity getRightsByUserId(Integer user_id) throws AppException;
}
