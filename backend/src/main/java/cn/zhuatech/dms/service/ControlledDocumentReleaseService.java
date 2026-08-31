/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.dms.service;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ControlledDocumentReleaseService {
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        if (request.legalHoldActive()) blockers.add("文档处于法律保全状态，禁止发布或覆盖");
        if (!request.retentionAssigned()) blockers.add("未分配保留分类与处置规则");
        if (!request.checksumVerified()) blockers.add("文件校验和验证失败");
        if (!request.malwareScanPassed()) blockers.add("恶意代码扫描未通过");
        if (!request.finalApprovalComplete()) blockers.add("最终审批未完成");
        if (!request.immutableAuditComplete()) blockers.add("不可篡改审计记录未生成");
        List<String> actions = blockers.isEmpty()
            ? List.of("发布受控版本，冻结校验和并通知订阅人员")
            : List.of("保持当前生效版本，关闭阻断项后重新送审");
        return new Assessment(blockers.isEmpty() ? Decision.RELEASE : Decision.BLOCKED,
            blockers.isEmpty(), request.documentId() + "@" + request.version(), blockers, actions);
    }

    public record Request(@NotBlank String documentId, @NotBlank String version,
                          @NotBlank String retentionClass, boolean retentionAssigned,
                          boolean checksumVerified, boolean malwareScanPassed,
                          boolean legalHoldActive, boolean finalApprovalComplete,
                          boolean immutableAuditComplete) {}
    public record Assessment(Decision decision, boolean releasable, String releaseKey,
                             List<String> blockers, List<String> actions) {}
    public enum Decision { RELEASE, BLOCKED }
}
