/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.dms.controller;

import cn.zhuatech.dms.common.ApiResponse;
import cn.zhuatech.dms.service.ExternalShareRiskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/dms/insights")
public class ExternalShareRiskController {
    private final ExternalShareRiskService service;

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public ExternalShareRiskController(ExternalShareRiskService service) {
        this.service = service;
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/external-share-risk")
    public ApiResponse<ExternalShareRiskService.Result> evaluate(
        @Valid @RequestBody ExternalShareRiskService.Request request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
