package cn.sinobest.framework.service.impl.role;

import cn.sinobest.framework.constant.SystemConstants;
import cn.sinobest.framework.beans.entity.ApiResponseResultEntity;
import cn.sinobest.framework.beans.error.AppException;
import cn.sinobest.framework.beans.error.SysErrorCode;
import cn.sinobest.framework.dao.auto.entity.SysRightEntity;
import cn.sinobest.framework.dao.auto.entity.SysRole2rightEntity;
import cn.sinobest.framework.dao.auto.mapper.SysRightMapper;
import cn.sinobest.framework.dao.auto.mapper.SysRole2rightMapper;
import cn.sinobest.framework.service.inter.role.SysRole2RightServiceInterface;
import cn.sinobest.framework.util.sys.SysUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SysRole2RightServiceImplements
 * @Desc
 * @Author 柯雷
 * @Date 2020-09-15 18:08
 * @Version 1.0
 */
@Service
public class SysRole2RightServiceImplements implements SysRole2RightServiceInterface {

    /** 日志输出对象 */
    Logger logger = LoggerFactory.getLogger(SysRole2RightServiceImplements.class);

    /** 角色权限CURD */
    @Autowired
    SysRole2rightMapper sysRole2rightMapper;

    /** 权限CURD */
    @Autowired
    SysRightMapper sysRightMapper;

    /**
     * @Description: 获取角色权限列表
     * @Params: [role_id]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-09-16 8:37
     */
    @Override
    public ApiResponseResultEntity getRoleRights(Integer role_id) throws AppException {
        try {
            Map<String, Object> result = new HashMap<>();
            SysRightEntity sysRightEntity = new SysRightEntity();
            sysRightEntity.setValid(SystemConstants.YES);
            List<SysRightEntity> roles = sysRightMapper.getSysRights(sysRightEntity);
            result.put("all", roles);
            SysRole2rightEntity sysRole2rightEntity = new SysRole2rightEntity();
            sysRole2rightEntity.setRoleid(role_id);
            sysRole2rightEntity.setValid(SystemConstants.YES);
            List<SysRole2rightEntity> list = sysRole2rightMapper.getSysRole2rights(sysRole2rightEntity);
            result.put("me", list);
            return new ApiResponseResultEntity(SysErrorCode.SUCCESS.getError_code(), result);
        } catch (Exception e) {
            logger.error("【SysRole2RightServiceImplements.getRoleRights】获取角色权限列表出错：" + e);
            throw new AppException(SysErrorCode.SYSTEM_ERROR);
        }
    }

    /**
     * @Description: 保存角色权限信息
     * @Params: [sysRole2rightEntity]
     * @return: cn.sinobest.framework.beans.entity.ApiResponseResultEntity
     * @Author: 柯雷
     * @Date: 2020-09-16 8:40
     */
    @Override
    public ApiResponseResultEntity saveRole2Right(SysRole2rightEntity sysRole2rightEntity) throws AppException {
        try {
            if (SysUtil.isEmpty(sysRole2rightEntity.getId())) {
                sysRole2rightMapper.insertSysRole2right(sysRole2rightEntity);
            } else {
                sysRole2rightMapper.updateSysRole2right(sysRole2rightEntity);
            }
            return new ApiResponseResultEntity(SysErrorCode.SUCCESS);
        } catch (Exception e) {
            logger.error("【SysRole2RightServiceImplements.saveRole2Right】保存角色权限信息出错：" + e);
            throw new AppException(SysErrorCode.SYSTEM_ERROR);
        }
    }
}
