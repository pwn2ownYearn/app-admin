package com.qkbus.modules.monitor.rest;

import com.qkbus.modules.monitor.service.VisitsService;
import com.qkbus.utils.RequestHolder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 少林一枝花
 * @date 2021-12-13
 */
@RestController
@RequestMapping("/api/visits")
@Api(tags = "系统:访问记录管理")
public class VisitsController {

    private final VisitsService visitsService;

    public VisitsController(VisitsService visitsService) {
        this.visitsService = visitsService;
    }

    @PostMapping
    @ApiOperation("创建访问记录")
    public ResponseEntity<Object> create() {
        visitsService.count(RequestHolder.getHttpServletRequest());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    @ApiOperation("查询")
    public ResponseEntity<Object> get() {
        return new ResponseEntity<>(visitsService.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/chartData")
    @ApiOperation("查询图表数据")
    public ResponseEntity<Object> getChartData() {
        return new ResponseEntity<>(visitsService.getChartData(), HttpStatus.OK);
    }
}
