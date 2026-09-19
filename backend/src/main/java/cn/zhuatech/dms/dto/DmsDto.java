/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.dms.dto;
import jakarta.validation.constraints.*; import java.time.*; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public final class DmsDto { /**
                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                             */
private DmsDto(){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Metric(String label,String value,String hint,String tone){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record DocumentView(Long id,String orderNo,String productCode,String productName,String library,String workshop,int plannedQty,int completedQty,int defectQty,LocalDate dueDate,String status,String batchNo,int progress){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record StorageNodeView(String code,String name,String library,String status,int oee,LocalDateTime lastHeartbeat){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record ApprovalTaskView(String approvalTaskNo,String orderNo,String productName,String approvalTaskType,int sampleQty,int defectQty,String result,String inspector){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record Dashboard(List<Metric> metrics,List<DocumentView> documents,List<StorageNodeView> storageNode,List<ApprovalTaskView> approvalTasks){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record ReportRequest(@NotBlank String operationName,@Positive int goodQty,@PositiveOrZero int defectQty,@Size(max=200) String remark){}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record ReportResult(String orderNo,int completedQty,int defectQty,int progress,String status){}
}
