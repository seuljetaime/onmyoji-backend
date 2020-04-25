package com.ez.onmyoji.controller;

import com.ez.onmyoji.bean.ShiShen;
import com.ez.onmyoji.service.ShiShenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import javax.annotation.Resource;

@Api(description = "式神接口")
@RestController
@RequestMapping(value = "/shishen")
public class ShiShenController {

  @Resource
  private ShiShenService shiShenService;

  @ApiOperation(value = "获取式神")
  @GetMapping
  public Flux<ShiShen> getAll() {
    return shiShenService.getAll();
  }
}
