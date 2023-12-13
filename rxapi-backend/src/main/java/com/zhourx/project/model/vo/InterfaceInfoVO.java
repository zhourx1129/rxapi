package com.zhourx.project.model.vo;



import com.zhourx.rxcommon.model.entity.InterfaceInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 接口信息封装视图
 *
 * @author zhourx
 * @date 2023/11/25
 * @TableName product
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(
        value = "InterfaceInfoVo",
        description = "接口信息Vo"
)
public class InterfaceInfoVO extends InterfaceInfo {

    /**
     * 调用次数
     */
    @ApiModelProperty("调用总数")
    private Integer totalNum;

    private static final long serialVersionUID = 1L;
}