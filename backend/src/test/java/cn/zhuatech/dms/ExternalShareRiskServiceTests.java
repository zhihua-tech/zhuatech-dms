/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.dms;

import cn.zhuatech.dms.service.ExternalShareRiskService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class ExternalShareRiskServiceTests {
    private final ExternalShareRiskService service = new ExternalShareRiskService();

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test
    void blocksRestrictedPersonalDataShare() {
        var result = service.evaluate(new ExternalShareRiskService.Request(
            "DOC-2026-1001", "RESTRICTED", 2, 24, true, true, false, true));

        assertEquals(70, result.riskScore());
        assertEquals("BLOCK", result.decision());
        assertFalse(result.shareLinkAllowed());
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test
    void allowsProtectedPublicDocumentShare() {
        var result = service.evaluate(new ExternalShareRiskService.Request(
            "DOC-2026-1002", "PUBLIC", 3, 48, true, true, false, false));

        assertEquals("ALLOW", result.decision());
        assertTrue(result.shareLinkAllowed());
    }
}
