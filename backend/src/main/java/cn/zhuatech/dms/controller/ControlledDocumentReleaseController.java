/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.dms.controller;

import cn.zhuatech.dms.common.ApiResponse;
import cn.zhuatech.dms.service.ControlledDocumentReleaseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/enterprise/dms")
public class ControlledDocumentReleaseController {
    private final ControlledDocumentReleaseService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public ControlledDocumentReleaseController(ControlledDocumentReleaseService service) { this.service = service; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/controlled-document-release")
    public ApiResponse<ControlledDocumentReleaseService.Assessment> assess(
        @Valid @RequestBody ControlledDocumentReleaseService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
