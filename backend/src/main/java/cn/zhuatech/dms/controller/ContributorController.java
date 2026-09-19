/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.dms.controller; import cn.zhuatech.dms.common.ApiResponse; import cn.zhuatech.dms.dto.DmsDto.*; import cn.zhuatech.dms.service.DmsService; import jakarta.validation.Valid; import org.springframework.security.access.prepost.PreAuthorize; import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/shopfloor") @PreAuthorize("hasAnyRole('CONTRIBUTOR','ADMIN')") public class ContributorController {private final DmsService dms;/**
                                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                       */
public ContributorController(DmsService dms){this.dms=dms;}/**
                                                                                                                                                                                                                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                  */
@GetMapping("/dashboard") public ApiResponse<Dashboard> dashboard(){return ApiResponse.ok(dms.shopfloorDashboard());}/**
                                                                                                                                                                                                                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                       */
@PostMapping("/work-orders/{id}/reports") public ApiResponse<ReportResult> report(@PathVariable Long id,@Valid @RequestBody ReportRequest request){return ApiResponse.ok("反馈提交成功",dms.report(id,request));}}
