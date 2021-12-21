
package com.qkbus.tools.service;

import com.qkbus.common.service.BaseService;
import com.qkbus.tools.domain.Picture;
import com.qkbus.tools.service.dto.PictureDto;
import com.qkbus.tools.service.dto.PictureQueryCriteria;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author 少林一枝花
 * @date 2020-05-13
 */
public interface PictureService extends BaseService<Picture> {

    /**
     * 查询数据分页
     *
     * @param criteria 条件
     * @param pageable 分页参数
     * @return Map<String, Object>
     */
    Map<String, Object> queryAll(PictureQueryCriteria criteria, Pageable pageable);

    /**
     * 查询所有数据不分页
     *
     * @param criteria 条件参数
     * @return List<PictureDto>
     */
    List<Picture> queryAll(PictureQueryCriteria criteria);

    /**
     * 导出数据
     *
     * @param all      待导出的数据
     * @param response /
     * @throws IOException /
     */
    void download(List<PictureDto> all, HttpServletResponse response) throws IOException;


    /**
     * 上传文件
     *
     * @param file     /
     * @param username /
     * @return /
     */
    Picture upload(MultipartFile file, String username);

    /**
     * 根据ID查询
     *
     * @param id /
     * @return /
     */
    Picture findById(Long id);

    /**
     * 多选删除
     *
     * @param ids /
     */
    void deleteAll(Long[] ids);


    /**
     * 同步数据
     */
    void synchronize();
}
