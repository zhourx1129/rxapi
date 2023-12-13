package com.zhourx.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhourx.rxcommon.model.entity.UserInterfaceInfo;

/**
 * <p>
 * 用户调用接口关系 服务类
 * </p>
 *
 * @author zhourx
 * @since 2023-12-06
 */
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
