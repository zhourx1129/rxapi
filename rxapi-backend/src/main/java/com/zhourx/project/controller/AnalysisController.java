package com.zhourx.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.zhourx.project.annotation.AuthCheck;
import com.zhourx.project.common.BaseResponse;
import com.zhourx.project.common.ErrorCode;
import com.zhourx.project.common.ResultUtils;
import com.zhourx.project.exception.BusinessException;
import com.zhourx.project.mapper.UserInterfaceInfoMapper;
import com.zhourx.project.model.vo.InterfaceInfoVO;
import com.zhourx.project.service.InterfaceInfoService;
import com.zhourx.rxcommon.model.entity.InterfaceInfo;
import com.zhourx.rxcommon.model.entity.UserInterfaceInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: zhourx
 * @Description: 分析控制器
 * @Date: 2023/12/7
 */
@RestController
@RequestMapping("/analysis")
@Slf4j
@Api(value = "分析")
public class AnalysisController {

    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Resource
    private InterfaceInfoService interfaceInfoService;

    /**
     * 列表顶部调用接口信息
     *
     * @return {@link BaseResponse}<{@link List}<{@link InterfaceInfoVO}>>
     */
    @GetMapping("/top/interface/invoke")
    @AuthCheck(mustRole = "admin")
    @ApiOperation("列表顶部调用接口信息")
    public BaseResponse<List<InterfaceInfoVO>> listTopInvokeInterfaceInfo() {
        List<UserInterfaceInfo> userInterfaceInfoList = userInterfaceInfoMapper.listTopInvokeInterfaceInfo(3);
        Map<Long, List<UserInterfaceInfo>> interfaceInfoIdObjMap = userInterfaceInfoList.stream()
                .collect(Collectors.groupingBy(UserInterfaceInfo::getInterfaceInfoId));
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", interfaceInfoIdObjMap.keySet());
        List<InterfaceInfo> list = interfaceInfoService.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        List<InterfaceInfoVO> interfaceInfoVOList = list.stream().map(interfaceInfo -> {
            InterfaceInfoVO interfaceInfoVO = new InterfaceInfoVO();
            BeanUtils.copyProperties(interfaceInfo, interfaceInfoVO);
            int totalNum = interfaceInfoIdObjMap.get(interfaceInfo.getId()).get(0).getTotalNum();
            interfaceInfoVO.setTotalNum(totalNum);
            return interfaceInfoVO;
        }).collect(Collectors.toList());
        return ResultUtils.success(interfaceInfoVOList);
    }
}
