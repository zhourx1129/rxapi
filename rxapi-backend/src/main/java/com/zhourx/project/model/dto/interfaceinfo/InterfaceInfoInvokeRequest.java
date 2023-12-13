package com.zhourx.project.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 更新请求
 *
 * @author zhourx
 * @date 2023/11/25
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {


    /**
     * 主键
     */
    private Long id;


    /**
     * 用户请求参数
     */
    private String userRequestParams;


    private static final long serialVersionUID = 1L;
}