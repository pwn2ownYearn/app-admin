
package com.qkbus.modules.withdraw.service.dto;

import com.qkbus.annotation.Query;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 少林一枝花
 * @date 2021-05-12
 */
@Data
public class WithdrawConfigQueryCriteria {
    /**
     * 精确
     */
    @Query
    @ApiModelProperty(value = "币种")
    private String currency;
    /**
     * 精确
     */
    @Query
    @ApiModelProperty(value = "币种名称")
    private String currencyName;
    /**
     * 精确
     */
    @Query
    @ApiModelProperty(value = "状态")
    private Integer status;
}
