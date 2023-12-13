package com.zhourx.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhourx.rxcommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
 * <p>
 * 用户调用接口关系 Mapper 接口
 * </p>
 *
 * @author zhourx
 * @since 2023-12-06
 */
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}
