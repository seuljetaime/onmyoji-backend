package com.ez.onmyoji.service;

import com.ez.onmyoji.bean.ShiShen;
import com.ez.onmyoji.repository.ShiShenRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * 式神service
 */
@Service
public class ShiShenService {

  @Resource
  private ShiShenRepository repository;

  /**
   * 式神初始化
   *
   * @return
   */
  public Flux<ShiShen> init() {
    Flux<ShiShen> shiShenFlux = Flux.range(200, 227)
      .flatMap(i -> getShishenInfo(i))
      .flatMap(r -> saveShiShen(r));
    return shiShenFlux;
  }

  /**
   * 从URL获取式神信息，并转换为bean
   *
   * @param shishenId
   * @return
   */
  private Mono<ShiShen> getShishenInfo(Integer shishenId) {
    Mono<ShiShen> resHtml = WebClient.create()
      .get()
      .uri("https://yys.163.com/shishen/{id}.html", shishenId) //200-347
      .exchange()
      .flatMap(clientResponse -> {
        if (clientResponse.statusCode().isError()) {
          return Mono.empty();
        } else {
          return clientResponse.bodyToMono(String.class).
            flatMap(r -> Mono.just(convertToBean(r)));
        }
      });
    return resHtml;
  }

  private ShiShen convertToBean(String htmlStr) {
    Document doc = Jsoup.parse(htmlStr);
    String shishenId = doc.getElementById("shishenId").val();
    String shishenName = doc.getElementById("shishenName").val();
    String shishenLevel = doc.getElementById("shishenLevel").val();
    String imgSrc = doc.select(".before_title img").attr("src");

    ShiShen entity = new ShiShen();
    entity.setShishenId(Integer.valueOf(shishenId));
    entity.setShishenName(shishenName);
    entity.setShishenLevel(shishenLevel);
    entity.setImgSrc(imgSrc);

    return entity;
  }

  /**
   * 新增或更新式神
   *
   * @param entity
   * @return
   */
  private Mono<ShiShen> saveShiShen(ShiShen entity) {
    Mono<ShiShen> saveMono = repository.save(entity);
    return saveMono;
  }

}
