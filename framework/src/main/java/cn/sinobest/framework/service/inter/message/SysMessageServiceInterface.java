package cn.sinobest.framework.service.inter.message;

import cn.sinobest.framework.beans.entity.ApiResponseResultEntity;
import cn.sinobest.framework.beans.error.AppException;
import cn.sinobest.framework.dao.auto.entity.SysMessageEntity;

/**
 * @ClassName SysMessageServiceInterface
 * @Desc
 * @Author 柯雷
 * @Date 2020-05-09 10:10
 * @Version 1.0
 */
public interface SysMessageServiceInterface {

    /**
     * @Description: 查询消息列表
     * @Params: [sysMessageEntity]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-05-09 10:10
     */
    ApiResponseResultEntity getMessages(SysMessageEntity sysMessageEntity) throws AppException;

    /**
     * @Description: 保存系统消息
     * @Params: [sysMessageEntity]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-05-09 10:11
     */
    ApiResponseResultEntity saveMessage(SysMessageEntity sysMessageEntity) throws AppException;

    /**
     * @Description: 查询消息数量
     * @Params: [sysMessageEntity]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-05-09 10:54
     */
    ApiResponseResultEntity getMessageCount(SysMessageEntity sysMessageEntity) throws AppException;
}
