package com.ez.onmyoji.controller;

import com.ez.onmyoji.service.ShiShenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Api(description = "管理接口")
@RestController
@RequestMapping(value = "/man")
public class ManagementController {

  @Resource
  private ShiShenService shiShenService;

  /**
   * 生成式神库
   *
   * @return
   */
  @ApiOperation(value = "式神初始化")
  @PostMapping("/init/shishen")
  public Mono<String> initShiShen() {
    return Mono.just("Hello World");
  }
}
