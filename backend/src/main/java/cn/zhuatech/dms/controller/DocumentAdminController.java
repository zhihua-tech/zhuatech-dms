/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.dms.controller; import cn.zhuatech.dms.common.ApiResponse; import cn.zhuatech.dms.dto.DmsDto.*; import cn.zhuatech.dms.service.DmsService; import org.springframework.security.access.prepost.PreAuthorize; import org.springframework.web.bind.annotation.*; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/admin") @PreAuthorize("hasAnyRole('DOCUMENT_MANAGER','QUALITY','ADMIN')") public class DocumentAdminController {private final DmsService dms;/**
                                                                                                                                                                                    * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                    */
public DocumentAdminController(DmsService dms){this.dms=dms;}/**
                                                                                                                                                                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                 */
@GetMapping("/dashboard") public ApiResponse<Dashboard> dashboard(){return ApiResponse.ok(dms.adminDashboard());}/**
                                                                                                                                                                                                                                                                                                                                                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                                                                  */
@GetMapping("/work-orders") public ApiResponse<List<DocumentView>> orders(){return ApiResponse.ok(dms.documents());}}
