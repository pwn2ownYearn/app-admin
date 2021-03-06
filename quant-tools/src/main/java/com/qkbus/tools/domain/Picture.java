
package com.qkbus.tools.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author 少林一枝花
 * @date 2020-05-13
 */

@Data
@TableName("tools_picture")
public class Picture implements Serializable {

    /**
     * ID
     */
    @TableId
    private Long id;


    /**
     * 上传日期
     */
    @TableField(fill = FieldFill.INSERT)
    private Timestamp gmtCreate;


    /**
     * 删除的URL
     */
    private String deleteUrl;


    /**
     * 图片名称
     */
    private String filename;


    /**
     * 图片高度
     */
    private String height;


    /**
     * 图片大小
     */
    private String size;


    /**
     * 图片地址
     */
    private String url;


    /**
     * 用户名称
     */
    private String username;


    /**
     * 图片宽度
     */
    private String width;


    /**
     * 文件的MD5值
     */
    private String md5code;

    public void copy(Picture source) {
        BeanUtil.copyProperties(source, this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
