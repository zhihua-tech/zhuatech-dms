/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.dms.controller;
import cn.zhuatech.dms.common.ApiResponse; import cn.zhuatech.dms.service.RetentionDecisionService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/admin") public class RetentionDecisionController {private final RetentionDecisionService service; /**
                                                                                                                                         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                         */
public RetentionDecisionController(RetentionDecisionService service){this.service=service;} /**
                                                                                                                                                                                                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                     */
@PostMapping("/retention-decision") public ApiResponse<RetentionDecisionService.Result> evaluate(@Valid @RequestBody RetentionDecisionService.Request request){return ApiResponse.ok(service.evaluate(request));}}

