package com.sports.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 统一响应结果
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("统一响应对象")
public class ResultCode<T> {
    @ApiModelProperty("状态码")
    private int code;

    @ApiModelProperty("信息")
    private String message;

    @ApiModelProperty("数据")
    private T data;
}
