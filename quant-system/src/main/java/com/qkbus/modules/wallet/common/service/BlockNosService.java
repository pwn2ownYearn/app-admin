
package com.qkbus.modules.wallet.common.service;

import com.qkbus.common.service.BaseService;
import com.qkbus.modules.wallet.common.domain.BlockNos;
import com.qkbus.modules.wallet.common.service.dto.BlockNosDto;
import com.qkbus.modules.wallet.common.service.dto.BlockNosQueryCriteria;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 少林一枝花
 * @date 2021-05-12
 */
public interface BlockNosService extends BaseService<BlockNos> {

    /**
     * 查询数据分页
     *
     * @param criteria 条件
     * @param pageable 分页参数
     * @return Map
     * <String,Object>
     */
    Map<String, Object> queryAll(BlockNosQueryCriteria criteria, Pageable pageable);

    /**
     * 查询所有数据不分页
     *
     * @param criteria 条件参数
     * @return List
     * <BlockNosDto>
     */
    List<BlockNos> queryAll(BlockNosQueryCriteria criteria);

    /**
     * 导出数据
     *
     * @param all      待导出的数据
     * @param response /
     * @throws IOException /
     */
    void download(List<BlockNosDto> all, HttpServletResponse response) throws IOException;

    /**
     * 创建
     *
     * @param resources /
     * @return BlockNosDto
     */
    void create(BlockNos resources);

    /**
     * 编辑
     *
     * @param resources /
     */
    void update(BlockNos resources);

    /**
     * 多选删除
     *
     * @param ids /
     */
    void deleteAll(Set<Long> ids);

}
