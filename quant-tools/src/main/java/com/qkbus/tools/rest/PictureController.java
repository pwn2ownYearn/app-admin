
package com.qkbus.tools.rest;

import com.qkbus.dozer.service.IGenerator;
import com.qkbus.logging.aop.log.Log;
import com.qkbus.tools.domain.Picture;
import com.qkbus.tools.service.PictureService;
import com.qkbus.tools.service.dto.PictureDto;
import com.qkbus.tools.service.dto.PictureQueryCriteria;
import com.qkbus.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 少林一枝花
 * @date 2021/09/20 14:13:32
 */
@RestController
@RequestMapping("/api/pictures")
@Api(tags = "工具：免费图床管理")
public class PictureController {
    private final IGenerator generator;
    private final PictureService pictureService;

    public PictureController(IGenerator generator, PictureService pictureService) {
        this.generator = generator;
        this.pictureService = pictureService;
    }

    @Log("查询图片")
    @PreAuthorize("@el.check('pictures:list')")
    @GetMapping
    @ApiOperation("查询图片")
    public ResponseEntity<Object> getRoles(PictureQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity<>(pictureService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('pictures:list')")
    public void download(HttpServletResponse response, PictureQueryCriteria criteria) throws IOException {
        pictureService.download(generator.convert(pictureService.queryAll(criteria), PictureDto.class), response);
    }

    @Log("上传图片")
    @PreAuthorize("@el.check('admin','pictures:add')")
    @PostMapping
    @ApiOperation("上传图片")
    public ResponseEntity<Object> upload(@RequestParam MultipartFile file) {
        String userName = SecurityUtils.getUsername();
        Picture picture = pictureService.upload(file, userName);
        return new ResponseEntity<>(picture, HttpStatus.OK);
    }

    @Log("同步图床数据")
    @ApiOperation("同步图床数据")
    @PostMapping(value = "/synchronize")
    public ResponseEntity<Object> synchronize() {
        pictureService.synchronize();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Log("多选删除图片")
    @ApiOperation("多选删除图片")
    @PreAuthorize("@el.check('pictures:del')")
    @DeleteMapping
    public ResponseEntity<Object> deleteAll(@RequestBody Long[] ids) {
        pictureService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
