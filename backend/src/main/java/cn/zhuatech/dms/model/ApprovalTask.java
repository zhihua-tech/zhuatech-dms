/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.dms.model;
import jakarta.persistence.*; import java.time.LocalDateTime;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Entity @Table(name="dms_approval_task") public class ApprovalTask extends BaseEntity {
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public enum Result { PENDING, PASSED, FAILED }
    @Column(nullable=false,unique=true,length=32) private String approvalTaskNo; @ManyToOne(optional=false,fetch=FetchType.LAZY) private Document document;
    @Column(nullable=false,length=30) private String approvalTaskType; @Column(nullable=false) private int sampleQty; @Column(nullable=false) private int defectQty; @Enumerated(EnumType.STRING) @Column(nullable=false,length=20) private Result result;
    @Column(length=50) private String inspector; @Column(nullable=false) private LocalDateTime createdAt;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    protected ApprovalTask(){} /**
                                * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                */
public ApprovalTask(String approvalTaskNo,Document document,String approvalTaskType,int sampleQty,int defectQty,Result result,String inspector){this.approvalTaskNo=approvalTaskNo;this.document=document;this.approvalTaskType=approvalTaskType;this.sampleQty=sampleQty;this.defectQty=defectQty;this.result=result;this.inspector=inspector;this.createdAt=LocalDateTime.now();}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String getApprovalTaskNo(){return approvalTaskNo;} /**
                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                               */
public Document getDocument(){return document;} /**
                                                                                                               * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                               */
public String getApprovalTaskType(){return approvalTaskType;} /**
                                                                                                                                                                             * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                             */
public int getSampleQty(){return sampleQty;} /**
                                                                                                                                                                                                                          * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                          */
public int getDefectQty(){return defectQty;} /**
                                                                                                                                                                                                                                                                       * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                       */
public Result getResult(){return result;} /**
                                                                                                                                                                                                                                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                 */
public String getInspector(){return inspector;}
}
