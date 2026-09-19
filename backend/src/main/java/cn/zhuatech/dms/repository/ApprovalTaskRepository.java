/* Copyright 2026 Shanghai Rujing Zhihua Information Technology Co., Ltd. · https://www.zhuatech.cn/ */
package cn.zhuatech.dms.repository; import cn.zhuatech.dms.model.ApprovalTask; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
public interface ApprovalTaskRepository extends JpaRepository<ApprovalTask,Long>{/**
                                                                                  * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                  */
List<ApprovalTask> findTop10ByOrderByIdDesc();/**
                                                                                                                                * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                */
long countByResult(ApprovalTask.Result result);}
