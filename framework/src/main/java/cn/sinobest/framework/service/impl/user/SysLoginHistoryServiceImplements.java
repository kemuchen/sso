package cn.sinobest.framework.service.impl.user;

import cn.sinobest.framework.beans.entity.ApiResponseResultEntity;
import cn.sinobest.framework.beans.error.AppException;
import cn.sinobest.framework.beans.error.SysErrorCode;
import cn.sinobest.framework.dao.auto.entity.SysLoginHistoryEntity;
import cn.sinobest.framework.dao.auto.mapper.SysLoginHistoryMapper;
import cn.sinobest.framework.service.inter.user.SysLoginHistoryServiceInterface;
import cn.sinobest.framework.util.sys.SysUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysUserLoginServiceImplements
 * @Desc
 * @Author 柯雷
 * @Date 2020-04-28 10:10
 * @Version 1.0
 */
@Service
public class SysLoginHistoryServiceImplements implements SysLoginHistoryServiceInterface {

    /**
     * 日志输出对象
     */
    Logger logger = LoggerFactory.getLogger(SysLoginHistoryServiceImplements.class);

    /**
     * 登录历史CURD基础DAO操作
     */
    @Autowired
    SysLoginHistoryMapper sysLoginHistoryMapper;

    /**
     * @Description: 保存登录历史信息
     * @Params: [sysLoginHistoryEntity]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-04-28 10:14
     */
    @Override
    public ApiResponseResultEntity saveLoginHistory(SysLoginHistoryEntity sysLoginHistoryEntity) throws AppException {
        try {
            if (SysUtil.isEmpty(sysLoginHistoryEntity.getId())) {
                // 新增
                sysLoginHistoryMapper.insertSysLoginHistory(sysLoginHistoryEntity);
            } else {
                // 修改
                sysLoginHistoryMapper.updateSysLoginHistory(sysLoginHistoryEntity);
            }
            return new ApiResponseResultEntity(SysErrorCode.SUCCESS);
        } catch (Exception e) {
            logger.error("【SysLoginHistoryServiceImplements.saveLoginHistory】保存登录历史信息出错：" + e);
            throw new AppException(SysErrorCode.SYSTEM_ERROR);
        }
    }
}
