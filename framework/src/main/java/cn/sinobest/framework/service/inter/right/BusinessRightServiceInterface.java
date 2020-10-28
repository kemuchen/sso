package cn.sinobest.framework.service.inter.right;

import cn.sinobest.framework.beans.entity.ApiResponseResultEntity;
import cn.sinobest.framework.beans.error.AppException;
import cn.sinobest.framework.dao.auto.entity.SysRightEntity;

/**
 * @ClassName BusinessRightServiceInterface
 * @Desc
 * @Author 柯雷
 * @Date 2020-04-28 11:27
 * @Version 1.0
 */
public interface BusinessRightServiceInterface {

    /**
     * @Description: 根据用户id查询用户菜单信息
     * @Params: [userId]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-04-28 11:31
     */
    ApiResponseResultEntity getRightsByUserId(Integer userId) throws AppException;

    /**
     * @Description: 查询格式化菜单信息
     * @Params: []
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-04-28 11:47
     */
    ApiResponseResultEntity getRightsByFormat() throws AppException;

    /**
     * @Description: 查询菜单
     * @Params: [sysRightEntity]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-04-28 11:35
     */
    ApiResponseResultEntity getRights(SysRightEntity sysRightEntity) throws AppException;
}
