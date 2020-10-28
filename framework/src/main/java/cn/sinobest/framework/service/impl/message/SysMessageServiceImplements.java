package cn.sinobest.framework.service.impl.message;

import cn.sinobest.framework.beans.entity.ApiResponseResultEntity;
import cn.sinobest.framework.beans.error.AppException;
import cn.sinobest.framework.beans.error.SysErrorCode;
import cn.sinobest.framework.dao.auto.entity.SysMessageEntity;
import cn.sinobest.framework.dao.auto.mapper.SysMessageMapper;
import cn.sinobest.framework.service.inter.message.SysMessageServiceInterface;
import cn.sinobest.framework.util.sys.SysUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysMessageServiceImplements
 * @Desc
 * @Author 柯雷
 * @Date 2020-05-09 10:11
 * @Version 1.0
 */
@Service
public class SysMessageServiceImplements implements SysMessageServiceInterface {

    /**
     * 日志打印对象
     */
    Logger logger = LoggerFactory.getLogger(SysMessageServiceImplements.class);

    /**
     * 系统消息CURD操作service
     */
    @Autowired
    SysMessageMapper sysMessageMapper;

    /**
     * @Description: 获取消息列表
     * @Params: [sysMessageEntity]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-05-09 10:12
     */
    @Override
    public ApiResponseResultEntity getMessages(SysMessageEntity sysMessageEntity) throws AppException {
        try {
            ApiResponseResultEntity apiResponseResultEntity = new ApiResponseResultEntity(SysErrorCode.SUCCESS);
            apiResponseResultEntity.setData(sysMessageMapper.getSysMessages(sysMessageEntity));
            return apiResponseResultEntity;
        } catch (Exception e) {
            logger.error("【SysMessageServiceImplements.getMessages】获取消息列表出错：" + e);
            throw new AppException(SysErrorCode.SYSTEM_ERROR);
        }
    }

    /**
     * @Description: 保存系统消息
     * @Params: [sysMessageEntity]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-05-09 10:13
     */
    @Override
    public ApiResponseResultEntity saveMessage(SysMessageEntity sysMessageEntity) throws AppException {
        try {
            if (SysUtil.isEmpty(sysMessageEntity.getId())) {
                // 新增
                sysMessageMapper.insertSysMessage(sysMessageEntity);
            } else {
                sysMessageMapper.updateSysMessage(sysMessageEntity);
            }
            return new ApiResponseResultEntity(SysErrorCode.SUCCESS);
        } catch (Exception e) {
            logger.error("【SysMessageServiceImplements.saveMessage】保存系统消息出错： " + e);
            throw new AppException(SysErrorCode.SYSTEM_ERROR);
        }
    }

    /**
     * @Description: 查询消息数量
     * @Params: [sysMessageEntity]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-05-09 10:54
     */
    @Override
    public ApiResponseResultEntity getMessageCount(SysMessageEntity sysMessageEntity) throws AppException {
        try {
            ApiResponseResultEntity apiResponseResultEntity = new ApiResponseResultEntity(SysErrorCode.SUCCESS);
            apiResponseResultEntity.setData(sysMessageMapper.getSysMessagesCount(sysMessageEntity));
            return apiResponseResultEntity;
        } catch (Exception e) {
            logger.error("【SysMessageServiceImplements.getMessages】获取消息列表出错：" + e);
            throw new AppException(SysErrorCode.SYSTEM_ERROR);
        }
    }
}
