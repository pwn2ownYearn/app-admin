
package com.qkbus.modules.wallet.tron.service;

import com.qkbus.common.service.BaseService;
import com.qkbus.modules.wallet.tron.domain.TrxAddress;
import com.qkbus.modules.wallet.tron.service.dto.TrxAddressDto;
import com.qkbus.modules.wallet.tron.service.dto.TrxAddressQueryCriteria;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 少林一枝花
 * @date 2021-05-15
 */
public interface TrxAddressService extends BaseService<TrxAddress> {

    /**
     * 查询数据分页
     *
     * @param criteria 条件
     * @param pageable 分页参数
     * @return Map
     * <String,Object>
     */
    Map<String, Object> queryAll(TrxAddressQueryCriteria criteria, Pageable pageable);

    /**
     * 查询所有数据不分页
     *
     * @param criteria 条件参数
     * @return List
     * <TrxAddressDto>
     */
    List<TrxAddress> queryAll(TrxAddressQueryCriteria criteria);

    /**
     * 导出数据
     *
     * @param all      待导出的数据
     * @param response /
     * @throws IOException /
     */
    void download(List<TrxAddressDto> all, HttpServletResponse response) throws IOException;


}
