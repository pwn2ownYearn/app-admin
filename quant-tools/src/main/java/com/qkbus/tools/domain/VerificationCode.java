
package com.qkbus.tools.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author 少林一枝花
 * @date 2021-12-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("tools_verification_code")
public class VerificationCode implements Serializable {

    @TableId
    private Long id;

    private String code;

    /**
     * 使用场景，自己定义
     */
    private String scenes;

    /**
     * true 为有效，false 为无效，验证时状态+时间+具体的邮箱或者手机号
     */
    private Boolean status = true;

    /**
     * 类型 ：phone 和 email
     */
    private String type;

    /**
     * 具体的phone与email
     */
    private String value;

    /**
     * 创建日期
     */
    @TableField(fill = FieldFill.INSERT)
    private Timestamp gmtCreate;

    public VerificationCode(String code, String scenes, @NotBlank String type, @NotBlank String value) {
        this.code = code;
        this.scenes = scenes;
        this.type = type;
        this.value = value;
    }
}
