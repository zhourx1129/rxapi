package com.zhourx.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhourx.rxcommon.model.entity.InterfaceInfo;

/**
 * <p>
 * 接口信息 服务类
 * </p>
 *
 * @author zhourx
 * @since 2023-12-06
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
