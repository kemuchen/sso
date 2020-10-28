package cn.sinobest.framework.service.inter.user;

import cn.sinobest.framework.beans.entity.ApiResponseResultEntity;
import cn.sinobest.framework.beans.error.AppException;
import cn.sinobest.framework.dao.auto.entity.SysLoginHistoryEntity;

/**
 * @ClassName SysUserLoginServiceInterface
 * @Desc
 * @Author 柯雷
 * @Date 2020-04-28 10:10
 * @Version 1.0
 */
public interface SysLoginHistoryServiceInterface {

    /**
     * @Description: 保存登录历史
     * @Params: [sysLoginHistoryEntity]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-04-28 10:11
     */
    ApiResponseResultEntity saveLoginHistory(SysLoginHistoryEntity sysLoginHistoryEntity) throws AppException;
}
