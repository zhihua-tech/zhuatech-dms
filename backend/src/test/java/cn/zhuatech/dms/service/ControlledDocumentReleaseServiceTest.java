/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.dms.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class ControlledDocumentReleaseServiceTest {
    private final ControlledDocumentReleaseService service = new ControlledDocumentReleaseService();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void releasesAControlledVersion() {
        var result = service.assess(new ControlledDocumentReleaseService.Request(
            "SOP-001", "3.0", "QUALITY-10Y", true, true, true, false, true, true));
        assertThat(result.decision()).isEqualTo(ControlledDocumentReleaseService.Decision.RELEASE);
        assertThat(result.releaseKey()).isEqualTo("SOP-001@3.0");
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void blocksLegalHoldAndMissingControls() {
        var result = service.assess(new ControlledDocumentReleaseService.Request(
            "SOP-002", "2.0", "LEGAL", false, false, false, true, false, false));
        assertThat(result.decision()).isEqualTo(ControlledDocumentReleaseService.Decision.BLOCKED);
        assertThat(result.blockers()).hasSize(6);
        assertThat(result.releasable()).isFalse();
    }
}
