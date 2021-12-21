
package com.qkbus.modules.system.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 少林一枝花
 * @date 2020-05-16
 */
@Data
@TableName("sys_roles_menus")
public class RolesMenus implements Serializable {

    /**
     * 菜单ID
     */
    private Long menuId;


    /**
     * 角色ID
     */
    private Long roleId;

    public void copy(RolesMenus source) {
        BeanUtil.copyProperties(source, this, CopyOptions.create().setIgnoreNullValue(true));
    }
}
