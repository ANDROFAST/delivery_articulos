package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;

public final class C0825J implements C0515k {
    private static final Map f1151a = new HashMap();
    private static final Map f1152b = new HashMap();
    private static final Map f1153c = new HashMap();

    public C0825J() {
        f1151a.put(cB.AGREE_AND_PAY, "同意并付款");
        f1151a.put(cB.AND_OTHER_FUNDING_SOURCES, "和其他");
        f1151a.put(cB.AUTHENTICATING, "正在验证");
        f1151a.put(cB.BACK_BUTTON, "返回");
        f1151a.put(cB.BACKUP_FUNDING_SOURCE, "备用");
        f1151a.put(cB.CANCEL, "取消");
        f1151a.put(cB.CARDTYPE_AMERICANEXPRESS, "American Express");
        f1151a.put(cB.CARDTYPE_CARTAAURA, "Carta Aura");
        f1151a.put(cB.CARDTYPE_CARTEAURORE, "Carte Aurore");
        f1151a.put(cB.CARDTYPE_CARTAPREPAGATAPAYPAL, "Carta Prepagata PayPal");
        f1151a.put(cB.CARDTYPE_CARTEBLEUE, "Carte Bancaire");
        f1151a.put(cB.CARDTYPE_COFINOGA, "Cofinoga");
        f1151a.put(cB.CARDTYPE_DELTA, "Delta");
        f1151a.put(cB.CARDTYPE_DISCOVER, "Discover");
        f1151a.put(cB.CARDTYPE_ELECTRON, "Electron");
        f1151a.put(cB.CARDTYPE_JCB, "JCB");
        f1151a.put(cB.CARDTYPE_MAESTRO, "Maestro");
        f1151a.put(cB.CARDTYPE_MASTERCARD, "MasterCard");
        f1151a.put(cB.CARDTYPE_POSTEPAY, "Postepay");
        f1151a.put(cB.CARDTYPE_4ETOILES, "4 étoiles");
        f1151a.put(cB.CARDTYPE_TARJETAAURORA, "Tarjeta Aurora");
        f1151a.put(cB.CARDTYPE_VISA, "Visa");
        f1151a.put(cB.CHANGE_PAYMENT_METHOD, "更改付款方式");
        f1151a.put(cB.CHECKING_ACCOUNT_FOR_INSTITUTION, "支票");
        f1151a.put(cB.CHECKING_DEVICE, "正在检查此设备…");
        f1151a.put(cB.CLEAR_CREDIT_CARD_INFO, "清除卡信息");
        f1151a.put(cB.CONFIRM, "确认");
        f1151a.put(cB.CONFIRM_CLEAR_CREDIT_CARD_INFO, "您确定要清除您的卡信息吗？");
        f1151a.put(cB.CONFIRM_CHARGE_CREDIT_CARD, "用卡付款");
        f1151a.put(cB.CONFIRM_LOG_OUT, "您确定要退出PayPal吗？");
        f1151a.put(cB.CONFIRM_SEND_PAYMENT, "付款");
        f1151a.put(cB.CONSENT_AGREEMENT_AGREE, "同意");
        f1151a.put(cB.CONSENT_AGREEMENT_ATTRIBUTE_ACCOUNT_CREATION_DATE, "账户创建日期");
        f1151a.put(cB.CONSENT_AGREEMENT_ATTRIBUTE_ACCOUNT_STATUS, "账户状态");
        f1151a.put(cB.CONSENT_AGREEMENT_ATTRIBUTE_ACCOUNT_TYPE, "账户类型");
        f1151a.put(cB.CONSENT_AGREEMENT_ATTRIBUTE_ADDRESS, "地址");
        f1151a.put(cB.CONSENT_AGREEMENT_ATTRIBUTE_AGE_RANGE, "年龄范围");
        f1151a.put(cB.CONSENT_AGREEMENT_ATTRIBUTE_DATE_OF_BIRTH, "出生日期");
        f1151a.put(cB.CONSENT_AGREEMENT_ATTRIBUTE_EMAIL_ADDRESS, "邮箱地址");
        f1151a.put(cB.CONSENT_AGREEMENT_ATTRIBUTE_FULL_NAME, "全名");
        f1151a.put(cB.CONSENT_AGREEMENT_ATTRIBUTE_GENDER, "性别");
        f1151a.put(cB.CONSENT_AGREEMENT_ATTRIBUTE_LANGUAGE, "语言");
        f1151a.put(cB.CONSENT_AGREEMENT_ATTRIBUTE_LOCALE, "地区");
        f1151a.put(cB.CONSENT_AGREEMENT_ATTRIBUTE_PHONE, "电话");
        f1151a.put(cB.CONSENT_AGREEMENT_ATTRIBUTE_TIME_ZONE, "时区");
        f1151a.put(cB.CONSENT_AGREEMENT_ATTRIBUTES, "共享以下：%s。");
        f1151a.put(cB.CONSENT_AGREEMENT_EXPRESS_CHECKOUT, "使用无缝结账。");
        f1151a.put(cB.CONSENT_AGREEMENT_INTRO, "%s要求您：");
        f1151a.put(cB.CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS, "共享与您的PayPal账户关联的<a href='%1$s'>付款方式</a>。");
        f1151a.put(cB.CONSENT_AGREEMENT_FUNDING_OPTIONS, "支持显示您的资金选项，让您可以自由选择。");
        f1151a.put(cB.CONSENT_AGREEMENT_FUTURE_PAYMENTS, "对以后用PayPal付款的%2$s购物<a href='%1$s'>授权付款</a>。您授权PayPal支付%3$s请求的所有金额。");
        f1151a.put(cB.CONSENT_AGREEMENT_LOYALTY_CARD, "允许他们在您的PayPal钱包中添加并管理他们的积分卡。");
        f1151a.put(cB.CONSENT_AGREEMENT_MERCHANT_PRIVACY_POLICY, "同意%1$s《<a href='%2$s'>隐私权保护规则</a>》和《<a href='%3$s'>用户协议</a>》。");
        f1151a.put(cB.CONSENT_AGREEMENT_REQUEST_MONEY, "在您撤回同意前允许他们代表您<a href='%1$s'>收款</a>。");
        f1151a.put(cB.CONSENT_AGREEMENT_SEND_MONEY, "在您撤回同意前允许他们代表您<a href='%1$s'>付款</a>。");
        f1151a.put(cB.CONSENT_AGREEMENT_TITLE, "同意");
        f1151a.put(cB.EMAIL, "电子邮件");
        f1151a.put(cB.ENVIRONMENT_MOCK_DATA, "模拟数据");
        f1151a.put(cB.ENVIRONMENT_SANDBOX, "Sandbox");
        f1151a.put(cB.EXPIRES_ON_DATE, "到期：");
        f1151a.put(cB.FINANCIAL_INSTRUMENTS_LEGAL_DETAILS, "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些付款方式可供使用。</p>");
        f1151a.put(cB.FORGOT_PASSWORD, "忘了密码？");
        f1151a.put(cB.FROM_ACCOUNT, "从");
        f1151a.put(cB.FUTURE_PAYMENT_METHOD_QUESTION, "您希望如何为以后向%1$s的付款提供资金？");
        f1151a.put(cB.FUTURE_PAYMENT_LEGAL_DETAILS, "<h1><strong>日后付款协议</strong></h1><p>此商家将使用您的默认资金来源支付日后的PayPal付款。</p><p>若要取消此协议，请登录到您的PayPal账户，前往<strong>用户信息</strong> &gt; <strong>设置</strong> &gt; <strong>使用PayPal登录</strong>，然后从列表中删除此商家。</p><p>此时适用<a href='%s'>PayPal用户协议</a>“循环付款”部分的规定。</p><p>为确保可通过您的PayPal账户付款，此应用程序将模拟一次小型的测试交易，但是不会转移资金。</p>");
        f1151a.put(cB.INTERNAL_ERROR, "内部错误");
        f1151a.put(cB.JAPANESE_COMPLIANCE_AGREEMENT, "<p>点击下面的按钮，即表示本人同意<a href='%1$s'>PayPal用户协议</a>的条款，并声明本人遵守日本的法律法规（包括根据<a href='%2$s'>外汇与外贸实施条例</a>对朝鲜和伊朗实施的付款制裁措施）来完成交易。</p>");
        f1151a.put(cB.LOG_IN, "登录");
        f1151a.put(cB.LOG_IN_TO_PAYPAL, "使用PayPal登录");
        f1151a.put(cB.LOG_OUT_BUTTON, "退出");
        f1151a.put(cB.LOG_OUT, "退出");
        f1151a.put(cB.OK, "确定");
        f1151a.put(cB.PASSWORD, "密码");
        f1151a.put(cB.PAY_AFTER_DELIVERY, "交货后付款");
        f1151a.put(cB.PAY_WITH, "付款方式");
        f1151a.put(cB.PAY_WITH_CARD, "用卡付款");
        f1151a.put(cB.PAYPAL_BALANCE, "PayPal余额");
        f1151a.put(cB.PAYPAL_CREDIT, "PayPal信用");
        f1151a.put(cB.PHONE, "电话");
        f1151a.put(cB.PIN, "识别码");
        f1151a.put(cB.PREFERRED_PAYMENT_METHOD, "首选付款方式");
        f1151a.put(cB.PRIVACY, "PayPal会保护您的<a href='%s'>隐私</a>和财务信息。");
        f1151a.put(cB.PROCESSING, "处理中");
        f1151a.put(cB.REMEMBER_CARD, "记住卡的信息");
        f1151a.put(cB.REQUEST_MONEY, "收款");
        f1151a.put(cB.REQUEST_OR_SEND_MONEY_LEGAL_DETAILS, "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>设置下的<strong>使用PayPal登录</strong>选项并移除该商家。</p><p>对于合作伙伴执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1151a.put(cB.SAVINGS_ACCOUNT_FOR_INSTITUTION, "储蓄");
        f1151a.put(cB.SEND_MONEY, "付款");
        f1151a.put(cB.SERVER_PROBLEM, "与PayPal服务器通信时发生了问题。请重试。");
        f1151a.put(cB.SESSION_EXPIRED_MESSAGE, "请重新登录到PayPal。");
        f1151a.put(cB.SESSION_EXPIRED_TITLE, "会话已超时");
        f1151a.put(cB.SHIPPING_ADDRESS, "送货地址");
        f1151a.put(cB.SIGN_UP, "尚未注册？注册");
        f1151a.put(cB.STAY_LOGGED_IN, "保持登录状态");
        f1151a.put(cB.SYSTEM_ERROR_WITH_CODE, "系统错误 (%s)。请稍后重试。");
        f1151a.put(cB.TRY_AGAIN, "重试");
        f1151a.put(cB.TWO_FA_REQUIRED_ERROR, "无法登录，因为您的账户已启用双因素验证。");
        f1151a.put(cB.TWO_FACTOR_AUTH_TITLE, "安全码");
        f1151a.put(cB.TWO_FACTOR_AUTH_SUBTITLE, "发送短信到您的手机。您收到的6位数代码在5分钟内有效。");
        f1151a.put(cB.TWO_FACTOR_AUTH_SENDING_DIALOG, "正在发送短信");
        f1151a.put(cB.TWO_FACTOR_AUTH_ENTER_SECURITY_CODE, "输入6位数安全代码");
        f1151a.put(cB.TWO_FACTOR_AUTH_ENTER_MOBILE_NUMBER, "您的手机号码");
        f1151a.put(cB.TWO_FACTOR_AUTH_SEND_SMS, "发送短信");
        f1151a.put(cB.TWO_FACTOR_AUTH_SEND_SMS_AGAIN, "重新发送短信");
        f1151a.put(cB.TWO_FACTOR_AUTH_NO_ACTIVE_TOKENS_ERROR, "无法登录，因为您的账户已启用双因素验证。请访问PayPal网站以激活您的密钥。");
        f1151a.put(cB.UNAUTHORIZED_DEVICE_MESSAGE, "不允许通过此设备付款。");
        f1151a.put(cB.UNAUTHORIZED_DEVICE_TITLE, "未经授权的设备");
        f1151a.put(cB.UNAUTHORIZED_MERCHANT_MESSAGE, "不允许向此商家付款（客户端ID无效）。");
        f1151a.put(cB.UNAUTHORIZED_MERCHANT_TITLE, "无效的商家");
        f1151a.put(cB.UNEXPECTED_PAYMENT_FLOW, "处理您的付款时遇到了问题。请重试。");
        f1151a.put(cB.UNKNOWN_FUNDING_SOURCE, "无法识别的源");
        f1151a.put(cB.WE_ARE_SORRY, "很抱歉");
        f1151a.put(cB.YOUR_ORDER, "您的订单");
        f1151a.put(cB.CLEAR_CC_ALERT_TITLE, "清除卡？");
        f1151a.put(cB.CONSENT_FAILED_ALERT_TITLE, "同意失败");
        f1151a.put(cB.CONNECTION_FAILED_TITLE, "连接失败");
        f1151a.put(cB.LOGIN_FAILED_ALERT_TITLE, "登录失败");
        f1151a.put(cB.LOGIN_WITH_EMAIL, "使用密码登录");
        f1151a.put(cB.LOGIN_WITH_PHONE, "使用识别码登录");
        f1151a.put(cB.ONE_MOMENT, "请稍候…");
        f1151a.put(cB.PAY_FAILED_ALERT_TITLE, "付款失败");
        f1151a.put(cB.SCAN_CARD_ICON_DESCRIPTION, "扫描");
        f1151a.put(cB.TWO_FACTOR_AUTH_INVALID_ONE_TIME_PASSWORD, "安全代码不正确。请重试。");
        f1151a.put(cB.VIA_LABEL, "通过");
        f1151a.put(cB.PP_SERVICE_ERROR_JSON_PARSE_ERROR, "系统错误。请稍后重试。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|AT", "共享与您的PayPal账户关联的<a href='%1$s'>资金来源</a>的信息。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|BE", "共享与您的PayPal账户关联的<a href='%1$s'>资金来源</a>的信息。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|BG", "在您撤回同意前代表您共享<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|CH", "共享与您的PayPal账户关联的<a href='%1$s'>资金来源</a>的信息。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|CY", "在您撤回同意前代表您共享<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|CZ", "在您撤回同意前代表您共享<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|DE", "共享与您的PayPal账户关联的<a href='%1$s'>资金来源</a>的信息。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|DK", "共享与您的PayPal账户关联的<a href='%1$s'>付款方式</a>的信息。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|EE", "在您撤回同意前代表您共享<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|ES", "与他们共享与您的PayPal账户关联的<a href='%1$s'>资金来源</a>的信息。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|FI", "在您撤回同意前代表您共享<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|GB", "共享与您的PayPal账户关联的<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|GR", "在您撤回同意前代表您共享<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|HU", "在您撤回同意前代表您共享<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|IE", "在您撤回同意前代表您共享<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|IT", "共享与您的PayPal账户关联的<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|LI", "在您撤回同意前代表您共享<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|LT", "在您撤回同意前代表您共享<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|LU", "在您撤回同意前代表您共享<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|LV", "在您撤回同意前代表您共享<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|MT", "在您撤回同意前代表您共享<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|NL", "共享与您的PayPal账户关联的<a href='%1$s'>资金来源</a>的信息。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|NO", "共享与您的PayPal账户关联的<a href='%1$s'>付款方式</a>的信息。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|PL", "共享与您的PayPal账户关联的<a href='%1$s'>资金来源</a>的信息。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|PT", "在您撤回同意前代表您共享<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|SE", "共享与您的PayPal账户关联的<a href='%1$s'>付款方式</a>的信息。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|SI", "在您撤回同意前代表您共享<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|SK", "在您撤回同意前代表您共享<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|SM", "在您撤回同意前代表您共享<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FINANCIAL_INSTRUMENTS|VA", "在您撤回同意前代表您共享<a href='%1$s'>资金来源</a>。");
        f1152b.put("CONSENT_AGREEMENT_FUTURE_PAYMENTS|AU", "<p>对以后用PayPal付款的%2$s购物<a href='%1$s'>授权付款</a>。您授权PayPal支付%3$s请求的所有金额。</p><p>请阅读<a href='https://www.paypal.com/webapps/mpp/ua/recurringpymts-full'>PayPal循环付款和结算协议</a>，了解更多信息。</p>");
        f1152b.put("CONSENT_AGREEMENT_FUTURE_PAYMENTS|CN", "<p>对以后用PayPal付款的%2$s购物<a href='%1$s'>授权付款</a>。您授权PayPal支付%3$s请求的所有金额。</p><p>请阅读<a href='https://cms.paypal.com/c2/cgi-bin/?cmd=_render-content&content_ID=ua/UserAgreement_full'>PayPal循环付款和结算协议</a>，了解更多信息。</p>");
        f1152b.put("CONSENT_AGREEMENT_FUTURE_PAYMENTS|MY", "对以后用PayPal付款的购物<a href='%1$s'>授权付款</a>。您授权并指示PayPal支付所有金额。");
        f1152b.put("CONSENT_AGREEMENT_FUTURE_PAYMENTS|NZ", "对以后用PayPal付款的购物<a href='%1$s'>授权付款</a>。您授权并指示PayPal支付所有金额。");
        f1152b.put("CONSENT_AGREEMENT_FUTURE_PAYMENTS|SG", "对以后用PayPal付款的购物<a href='%1$s'>授权付款</a>。您授权并指示PayPal支付所有金额。");
        f1152b.put("CONSENT_AGREEMENT_FUTURE_PAYMENTS|US", "预先核准通过您的PayPal账户进行日后付款，而不需要每次都登录到PayPal。<a href='%1$s'>查看其他条款</a>，包括付款方式以及如何取消日后付款。");
        f1152b.put("CONSENT_AGREEMENT_REQUEST_MONEY|AT", "在您撤回同意前允许%2$s代表您<a href='%1$s'>收款</a>。");
        f1152b.put("CONSENT_AGREEMENT_REQUEST_MONEY|BE", "在您撤回同意前允许%2$s代表您<a href='%1$s'>收款</a>。");
        f1152b.put("CONSENT_AGREEMENT_REQUEST_MONEY|CH", "在您撤回同意前允许%2$s代表您<a href='%1$s'>收款</a>。");
        f1152b.put("CONSENT_AGREEMENT_REQUEST_MONEY|DE", "在您撤回同意前允许%2$s代表您<a href='%1$s'>收款</a>。");
        f1152b.put("CONSENT_AGREEMENT_REQUEST_MONEY|GB", "在您撤回同意前允许%2$s代表您<a href='%1$s'>收款</a>。");
        f1152b.put("CONSENT_AGREEMENT_REQUEST_MONEY|NL", "在您撤回同意前允许%2$s代表您<a href='%1$s'>收款</a>。");
        f1152b.put("CONSENT_AGREEMENT_REQUEST_MONEY|PL", "在您撤回同意前允许%2$s代表您<a href='%1$s'>收款</a>。");
        f1152b.put("CONSENT_AGREEMENT_SEND_MONEY|AT", "在您撤回同意前允许%2$s代表您<a href='%1$s'>付款</a>。");
        f1152b.put("CONSENT_AGREEMENT_SEND_MONEY|BE", "在您撤回同意前允许%2$s代表您<a href='%1$s'>付款</a>。");
        f1152b.put("CONSENT_AGREEMENT_SEND_MONEY|CH", "在您撤回同意前允许%2$s代表您<a href='%1$s'>付款</a>。");
        f1152b.put("CONSENT_AGREEMENT_SEND_MONEY|DE", "在您撤回同意前允许%2$s代表您<a href='%1$s'>付款</a>。");
        f1152b.put("CONSENT_AGREEMENT_SEND_MONEY|GB", "在您撤回同意前允许%2$s代表您<a href='%1$s'>付款</a>。");
        f1152b.put("CONSENT_AGREEMENT_SEND_MONEY|NL", "在您撤回同意前允许%2$s代表您<a href='%1$s'>付款</a>。");
        f1152b.put("CONSENT_AGREEMENT_SEND_MONEY|PL", "在您撤回同意前允许%2$s代表您<a href='%1$s'>付款</a>。");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|AT", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|BE", "<h1><strong>付款方式</strong></h1><p>PayPal共享的信息仅限于您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|BG", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|CH", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|CY", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|CZ", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|DE", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|EE", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|ES", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|FI", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|GR", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|HU", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|IE", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|IT", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|LI", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|LT", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|LU", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|LV", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|MT", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|NL", "<h1><strong>付款方式</strong></h1><p>PayPal共享的信息仅限于您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|PL", "<h1><strong>付款方式</strong></h1><p>PayPal共享的信息仅限于您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|PT", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|SI", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|SK", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|SM", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FINANCIAL_INSTRUMENTS_LEGAL_DETAILS|VA", "<h1><strong>付款方式</strong></h1><p>PayPal仅共享您的哪些资金来源可供使用。</p>");
        f1152b.put("FUTURE_PAYMENT_LEGAL_DETAILS|AU", "<h1><strong>日后付款协议</strong></h1><p>为确保以后可从您的PayPal账户收款，此应用程序将模拟一次小型的测试交易，但是不会转移资金。</p><p>您的默认付款方式（PayPal余额、关联的银行账户、借记卡或信用卡，照此顺序使用）将用于支付PayPal购物款项。请注意，如果您的默认付款方式中没有足够的资金来支付购物款，您的银行或卡提供商可能会向您收取费用。</p><p>若要取消此协议，请登录到您的PayPal账户，前往<strong>用户信息</strong>，点击<strong>设置</strong>，再点击“使用PayPal登录”旁边的<strong>更改</strong>。</p>");
        f1152b.put("FUTURE_PAYMENT_LEGAL_DETAILS|BR", "<h1><strong>日后付款协议</strong></h1><p>为确保以后可从您的PayPal账户收款，此应用程序将模拟一次小型的测试交易，但是不会转移资金。</p><p>您的PayPal余额或首选信用卡或借记卡将用于支付PayPal购物款项。</p><p>若要取消此协议，请登录到您的PayPal账户，前往<strong>用户信息</strong> &gt; <strong>设置</strong> &gt; <strong>使用PayPal登录</strong>，然后从列表中删除此商家。</p>");
        f1152b.put("FUTURE_PAYMENT_LEGAL_DETAILS|CN", "<h1><strong>日后付款协议</strong></h1><p>为确保以后可从您的PayPal账户收款，此应用程序将模拟一次小型的测试交易，但是不会转移款项。</p><p>您的默认付款方式将用于支付PayPal购物款项。</p><p>若要取消此协议，请登录到您的PayPal账户，前往<strong>用户信息</strong> &gt; <strong>设置</strong> &gt; <strong>使用PayPal登录</strong>，然后从列表中删除此商家。</p>");
        f1152b.put("FUTURE_PAYMENT_LEGAL_DETAILS|GB", "<h1><strong>日后付款协议</strong></h1><p>您的默认资金来源将用于支付以后在此商家的PayPal付款。</p><p>若要取消此协议，请登录到您的PayPal账户，前往<strong>用户信息</strong> &gt; <strong>设置</strong> &gt; <strong>使用PayPal登录</strong>，然后从列表中删除此商家。</p><p>适用<a href='%s'>PayPal《用户协议》</a>“循环付款”部分的规定。</p><p>为确保可通过您的PayPal账户付款，此应用程序将模拟一次小型的测试交易，但是不会转移资金。</p>");
        f1152b.put("FUTURE_PAYMENT_LEGAL_DETAILS|HK", "<h1><strong>日后付款授权</strong></h1><p>为确保以后可从您的PayPal账户收款，此应用程序将模拟一次小型的测试交易，但是不会转移款项。</p><p>您的默认付款方式将用于支付PayPal购物款项。</p><p>若要取消此授权，请登录到您的PayPal账户，前往<strong>用户信息</strong> &gt; <strong>我的账户设置</strong> &gt; <strong>使用PayPal登录</strong>，然后从列表中删除此商家。</p><p>如需了解更多信息，请阅读<a href='%s'>PayPal《用户协议》</a>的“预核准付款”部分。</p>");
        f1152b.put("FUTURE_PAYMENT_LEGAL_DETAILS|JP", "<h1><strong>日后付款授权</strong></h1><p>为确保以后可从您的PayPal账户收款，此应用程序将模拟一次小型的测试交易，但是不会转移款项。</p><p>您的默认付款方式将用于支付PayPal购物款项。</p><p>若要取消此授权，请登录到您的PayPal账户，前往<strong>用户信息</strong> &gt; <strong>我的账户设置</strong> &gt; <strong>使用PayPal登录</strong>，然后从列表中删除此商家。</p><p>如需了解更多信息，请阅读<a href='%s'>PayPal《用户协议》</a>的“预核准付款”部分。</p>");
        f1152b.put("FUTURE_PAYMENT_LEGAL_DETAILS|MX", "<h1><strong>日后付款协议</strong></h1><p>为确保以后可从您的PayPal账户收款，此应用程序将模拟一次小型的测试交易，但是不会转移资金。</p><p>您的PayPal余额或首选信用卡或借记卡将用于支付PayPal购物款项。</p><p>若要取消此协议，请登录到您的PayPal账户，前往<strong>用户信息</strong> &gt; <strong>设置</strong> &gt; <strong>使用PayPal登录</strong>，然后从列表中删除此商家。</p>");
        f1152b.put("FUTURE_PAYMENT_LEGAL_DETAILS|MY", "<h1><strong>日后付款授权</strong></h1><p>为确保以后可从您的PayPal账户收款，此应用程序将模拟一次小型的测试交易，但是不会转移款项。</p><p>您的默认付款方式将用于支付PayPal购物款项。</p><p>若要取消此授权，请登录到您的PayPal账户，前往<strong>用户信息</strong> &gt; <strong>我的账户设置</strong> &gt; <strong>使用PayPal登录</strong>，然后从列表中删除此商家。</p><p>如需了解更多信息，请阅读<a href='%s'>PayPal《用户协议》</a>的“预核准付款”部分。</p>");
        f1152b.put("FUTURE_PAYMENT_LEGAL_DETAILS|NZ", "<h1><strong>日后付款授权</strong></h1><p>为确保以后可从您的PayPal账户收款，此应用程序将模拟一次小型的测试交易，但是不会转移款项。</p><p>您的默认付款方式将用于支付PayPal购物款项。</p><p>若要取消此授权，请登录到您的PayPal账户，前往<strong>用户信息</strong> &gt; <strong>我的账户设置</strong> &gt; <strong>使用PayPal登录</strong>，然后从列表中删除此商家。</p><p>如需了解更多信息，请阅读<a href='%s'>PayPal《用户协议》</a>的“预核准付款”部分。</p>");
        f1152b.put("FUTURE_PAYMENT_LEGAL_DETAILS|SG", "<h1><strong>日后付款授权</strong></h1><p>为确保以后可从您的PayPal账户收款，此应用程序将模拟一次小型的测试交易，但是不会转移款项。</p><p>您的默认付款方式将用于支付PayPal购物款项。</p><p>若要取消此授权，请登录到您的PayPal账户，前往<strong>用户信息</strong> &gt; <strong>我的账户设置</strong> &gt; <strong>使用PayPal登录</strong>，然后从列表中删除此商家。</p><p>如需了解更多信息，请阅读<a href='%s'>PayPal《用户协议》</a>的“预核准付款”部分。</p>");
        f1152b.put("FUTURE_PAYMENT_LEGAL_DETAILS|US", "<h1><strong>日后付款协议</strong></h1><p>PayPal将首先使用您的PayPal余额为购物付款。如果PayPal余额不足，则依次使用您的银行账户、PayPal Credit、借记卡、信用卡以及电子支票。</p><p>若要取消此协议，请前往www.paypal.com<strong>用户信息</strong> &gt; <strong>设置</strong> &gt; <strong>使用PayPal登录</strong>，然后从列表中删除此商家。</p><p>为确保以后可从您的PayPal账户收款，可能需要您提供小额付款授权。授权将被作废，并且不会向您收款。</p>");
        f1152b.put("LOG_IN_TO_PAYPAL|AU", "使用PayPal登录");
        f1152b.put("LOG_IN_TO_PAYPAL|GB", "使用PayPal登录");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|AD", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|AL", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|AT", "<h1><strong>%s</strong></h1><p>将与合作伙伴共享任何相关交易详情。</p><p>要撤回同意，请登录您的PayPal账户并点击齿轮图标。转到<strong>安全</strong>，选择<strong>使用PayPal登录</strong>并移除该合作伙伴。</p><p>对于合作伙伴执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|AU", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>设置下的<strong>使用PayPal登录</strong>选项并移除该商家。</p><p>对于合作伙伴执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|BA", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|BE", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录您的PayPal账户，然后转到您的<strong>用户信息</strong>设置下的<strong>使用PayPal登录</strong>选项并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|BG", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|CH", "<h1><strong>%s</strong></h1><p>将与合作伙伴共享任何相关交易详情。</p><p>要撤回同意，请登录您的PayPal账户并点击齿轮图标。转到<strong>安全</strong>，选择<strong>使用PayPal登录</strong>并移除该合作伙伴。</p><p>对于合作伙伴执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|CY", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|CZ", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|DE", "<h1><strong>%s</strong></h1><p>将与合作伙伴共享任何相关交易详情。</p><p>要撤回同意，请登录您的PayPal账户并点击齿轮图标。转到<strong>安全</strong>，选择<strong>使用PayPal登录</strong>并移除该合作伙伴。</p><p>对于合作伙伴执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|DK", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录您的PayPal账户，然后转到<strong>用户信息</strong>设置下的<strong>使用PayPal登录</strong>选项并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|EE", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|ES", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录您的PayPal账户，点击右上角的齿轮图标，选择<strong>安全中心</strong>，选择<strong>使用PayPal登录</strong>，然后移除该商家。如果您仍在使用经典版网站，请转到<strong>我的用户信息</strong>，选择<strong>我的账户设置</strong>，选择<strong>使用PayPal登录</strong>，然后移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|FI", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|GB", "<h1><strong>%s</strong></h1><p>将与合作伙伴共享任何相关交易详情。</p><p>要撤回同意，请登录您的PayPal账户，然后转到<strong>用户信息</strong>设置下的<strong>使用PayPal登录</strong>并移除该合作伙伴。</p><p>对于合作伙伴执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|GR", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|HR", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|HU", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|IE", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|IS", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|IT", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.it，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|LI", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|LT", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|LU", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|LV", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|MT", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|NL", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录您的PayPal账户，然后转到您的<strong>用户信息</strong>设置下的<strong>使用PayPal登录</strong>选项并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|NO", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录您的PayPal账户，然后转到<strong>用户信息</strong>设置下的<strong>使用PayPal登录</strong>选项并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|PL", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录您的PayPal账户，然后转到您的<strong>用户信息</strong>设置下的<strong>使用PayPal登录</strong>选项并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|PT", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|RO", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|RU", "<h1><strong>%s</strong></h1><p>将与合作伙伴共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.ru，点击右上角的齿轮图标，选择<strong>安全</strong>选项卡并在<strong>使用PayPal登录</strong>选项中移除该合作伙伴。</p><p>对于合作伙伴执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|SE", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录您的PayPal账户，然后转到<strong>用户信息</strong>设置下的<strong>使用PayPal登录</strong>选项并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|SI", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|SK", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|SM", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|TR", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com.tr，点击右上角的齿轮图标，选择<strong>安全</strong>选项卡并在<strong>使用PayPal登录</strong>选项中移除该合作伙伴。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|UA", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|US", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>设置下的<strong>使用PayPal登录</strong>选项并移除该商家。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|VA", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1152b.put("REQUEST_OR_SEND_MONEY_LEGAL_DETAILS|ZA", "<h1><strong>%s</strong></h1><p>将与商家共享任何相关交易详情。</p><p>要撤回同意，请登录paypal.com，然后转到<strong>用户信息</strong>、<strong>安全</strong>，找到<strong>使用PayPal登录</strong>并移除该商家。</p><p>对于商家执行的任何操作或发生的任何错误，PayPal概不负责。</p>");
        f1153c.put("AMOUNT_MISMATCH", "购物车物品总金额与销售额不符。");
        f1153c.put("AUTHORIZATION_ALREADY_COMPLETED", "此授权已完成。");
        f1153c.put("AUTHORIZATION_CANNOT_BE_VOIDED", "授权处于无法作废的状态。");
        f1153c.put("AUTHORIZATION_EXPIRED", "授权已经到期。");
        f1153c.put("AUTHORIZATION_ID_DOES_NOT_EXIST", "请求的授权号不存在。");
        f1153c.put("AUTHORIZATION_VOIDED", "授权已作废。");
        f1153c.put("CANNOT_REAUTH_CHILD_AUTHORIZATION", "只能重新批准原始授权，而不能重新授权。");
        f1153c.put("CANNOT_REAUTH_INSIDE_HONOR_PERIOD", "在支付期内不允许重新授权。");
        f1153c.put("CAPTURE_AMOUNT_LIMIT_EXCEEDED", "金额超出了允许的限额。");
        f1153c.put("CARD_TOKEN_PAYER_MISMATCH", "无法访问保存的卡信息。");
        f1153c.put("CREDIT_CARD_CVV_CHECK_FAILED", "卡信息无效。请更正并重新提交。");
        f1153c.put("CREDIT_CARD_REFUSED", "卡被拒绝。");
        f1153c.put("CURRENCY_MISMATCH", "获取的币种必须与授权的币种一样。");
        f1153c.put("CURRENCY_NOT_ALLOWED", "PayPal目前不支持此币种。");
        f1153c.put("DATA_RETRIEVAL", "系统错误。请稍后重试。");
        f1153c.put("DUPLICATE_REQUEST_ID", "系统错误。请稍后重试。");
        f1153c.put("EXPIRED_CREDIT_CARD", "卡已过期");
        f1153c.put("EXPIRED_CREDIT_CARD_TOKEN", "备案中已没有此卡的信息。\n请重新提交。");
        f1153c.put("FEATURE_UNSUPPORTED_FOR_PAYEE", "此供应商不支持该功能。");
        f1153c.put("FULL_REFUND_NOT_ALLOWED_AFTER_PARTIAL_REFUND", "此交易的部分款项已退还。");
        f1153c.put("IMMEDIATE_PAY_NOT_SUPPORTED", "传递的意图不支持立即付款。");
        f1153c.put("INSTRUMENT_DECLINED", "您选择的付款方式不被接受。请选择另一种方式。");
        f1153c.put("INSUFFICIENT_FUNDS", "买家无法付款——资金不足。");
        f1153c.put("INTERNAL_SERVICE_ERROR", "系统错误。请稍后重试。");
        f1153c.put("INVALID_ACCOUNT_NUMBER", "账号不存在。");
        f1153c.put("INVALID_ARGUMENT", "参数无效，交易被拒绝");
        f1153c.put("INVALID_CITY_STATE_ZIP", "市/州/邮编组合无效。");
        f1153c.put("INVALID_FACILITATOR_CONFIGURATION", "由于一个服务商配置无效，此交易无法处理。");
        f1153c.put("INVALID_PAYER_ID", "系统错误（付款人ID无效）。请稍后重试。");
        f1153c.put("INVALID_RESOURCE_ID", "系统错误。请稍后重试。");
        f1153c.put("PAYEE_ACCOUNT_INVALID", "供应商账户中没有经过确认的电子邮件。");
        f1153c.put("PAYEE_ACCOUNT_LOCKED_OR_CLOSED", "此供应商目前无法接收付款。");
        f1153c.put("PAYEE_ACCOUNT_NO_CONFIRMED_EMAIL", "供应商账户中没有经过确认的电子邮件。");
        f1153c.put("PAYEE_ACCOUNT_RESTRICTED", "此供应商目前无法接收付款。");
        f1153c.put("PAYER_ACCOUNT_LOCKED_OR_CLOSED", "您的账户已被锁定或注销。");
        f1153c.put("PAYER_ACCOUNT_RESTRICTED", "您的账户已受到限制。");
        f1153c.put("PAYER_CANNOT_PAY", "您不能使用PayPal为此交易付款。");
        f1153c.put("PAYER_EMPTY_BILLING_ADDRESS", "非PayPal信用卡交易需要账单地址。");
        f1153c.put("PAYER_ID_MISSING_FOR_CARD_TOKEN", "无法访问保存的卡信息。");
        f1153c.put("PAYMENT_APPROVAL_EXPIRED", "付款核准已过期。");
        f1153c.put("PAYMENT_EXPIRED", "付款已过期。");
        f1153c.put("PAYMENT_NOT_APPROVED_FOR_EXECUTION", "付款人未批准付款。");
        f1153c.put("PAYMENT_REQUEST_ID_INVALID", "PayPal请求ID无效。请稍后重试。");
        f1153c.put("PAYMENT_STATE_INVALID", "鉴于当前的付款状态，此请求无效。");
        f1153c.put("PERMISSION_DENIED", "没有权限执行请求的操作。");
        f1153c.put("REFUND_EXCEEDED_TRANSACTION_AMOUNT", "请求的退款金额超出了原始交易金额。");
        f1153c.put("REFUND_TIME_LIMIT_EXCEEDED", "此交易时间太久，无法再退款。");
        f1153c.put("REQUIRED_SCOPE_MISSING", "系统错误。请稍后重试。");
        f1153c.put("TOO_MANY_REAUTHORIZATIONS", "不允许再重新批准此授权。");
        f1153c.put("TRANSACTION_ALREADY_REFUNDED", "此交易已退款。");
        f1153c.put("TRANSACTION_LIMIT_EXCEEDED", "金额超出了允许的限额。");
        f1153c.put("TRANSACTION_REFUSED", "交易被拒绝。");
        f1153c.put("TRANSACTION_REFUSED_BY_PAYPAL_RISK", "交易被拒绝。");
        f1153c.put("TRANSACTION_REFUSED_PAYEE_PREFERENCE", "商家用户信息习惯设定已设置为自动拒绝某些交易。");
        f1153c.put("UNKNOWN_ERROR", "系统错误。请稍后重试。");
        f1153c.put("UNSUPPORTED_PAYEE_COUNTRY", "您的国家或地区不受支持。");
        f1153c.put("VALIDATION_ERROR", "付款信息无效。请更正并重新提交。");
        f1153c.put("ORDER_ALREADY_COMPLETED", "订单已作废、过期或完成。");
        f1153c.put("MAXIMUM_ALLOWED_AUTHORIZATION_REACHED_FOR_ORDER", "该订单已达到允许授权的最大值。");
        f1153c.put("ORDER_VOIDED", "订单已作废。");
        f1153c.put("ORDER_CANNOT_BE_VOIDED", "订单处于无法作废的状态。");
        f1153c.put("INVALID_EXPERIENCE_PROFILE_ID", "系统错误。请稍后重试。");
        f1153c.put("UNAUTHORIZED_PAYMENT", "商家不接受此类型的付款。");
        f1153c.put("DCC_UNSUPPORTED_CURRENCY_CC_TYPE", "卡类型不支持该币种。");
        f1153c.put("DCC_CC_TYPE_NOT_SUPPORTED", "卡类型不受支持。");
        f1153c.put("ADDRESS_ADDITION_ERROR", "添加送货地址到PayPal账户时遇到错误。");
        f1153c.put("DUPLICATE_TRANSACTION", "重复交易。");
        f1153c.put("INVALID_SHIPPING_ADDRESS", "提供的送货地址无效。");
        f1153c.put("PAYMENT_CREATION_ERROR", "设置此付款时出现问题。请访问PayPal网站并检查您的账户。");
        f1153c.put("PAYMENT_CREATION_ERROR_EXPIRED_PAYMENT_CARD", "设置此付款时出现问题——您的卡已过期。请访问PayPal网站并检查您的账户。");
        f1153c.put("PAYMENT_CREATION_ERROR_INSTANT_PAYMENT_REQUIRED", "设置此付款时出现问题——需要进行即时付款，例如信用卡付款。请访问PayPal网站并检查您的账户。");
        f1153c.put("PAYMENT_CREATION_ERROR_NEED_CONFIRMED_CARD", "设置此付款时出现问题——卡必须经过确认。请访问PayPal网站并检查您的账户。");
        f1153c.put("PAYMENT_CREATION_ERROR_NEED_PHONE_NUMBER", "设置此付款时出现问题——此应用程序要求在账户中登记电话号码。请访问PayPal网站并检查您的账户。");
        f1153c.put("PAYMENT_CREATION_ERROR_NEED_VALID_FUNDING_INSTRUMENT", "设置此付款时出现问题——账户需要有效的资金来源，例如银行账户或支付卡。请访问PayPal网站并检查您的账户。");
        f1153c.put("PAYMENT_CREATION_ERROR_NEGATIVE_BALANCE", "设置此付款时出现问题——您的余额为负数。请访问PayPal网站并检查您的账户。");
        f1153c.put("PAYMENT_CREATION_ERROR_SENDING_LIMIT_REACHED", "设置此付款时出现问题——您已达到支付限额。请访问PayPal网站并检查您的账户。");
        f1153c.put("AUTH_RC_RISK_FAILURE", "因风险被拒绝。");
        f1153c.put("AUTH_RC_OFAC_BLOCKED_IP", "客户端未获授权。");
        f1153c.put("AUTH_RC_IP_COMPLIANCE_FAILURE", "客户端未获授权。");
        f1153c.put("invalid_user", "用户名/密码不正确。请重试。");
        f1153c.put("locked_user", "您的PayPal账户暂时被锁定。请稍后重试，或前往www.paypal.com立即解锁您的PayPal账户。");
        f1153c.put("max_attempts_exceeded", "登录失败次数过多。请稍后重试。");
        f1153c.put("invalid_request", "发生错误。");
        f1153c.put("unauthorized_client", "请求未经授权。");
        f1153c.put("access_denied", "请求未经授权。");
        f1153c.put("unsupported_response_type", "发生错误。");
        f1153c.put("invalid_scope", "请求未经授权。");
        f1153c.put("server_error", "系统错误。请稍后重试。");
        f1153c.put("temporarily_unavailable", "系统错误。请稍后重试。");
        f1153c.put("stepup_required", "暂时无法完成您的登录。请稍后重试，或转到www.paypal.com解决任何与您的PayPal账户相关的安全问题。");
    }

    public final String mo3720a() {
        return "zh-Hans";
    }

    public final /* synthetic */ String mo3721a(Enum enumR, String str) {
        cB cBVar = (cB) enumR;
        String str2 = cBVar.toString() + "|" + str;
        return f1152b.containsKey(str2) ? (String) f1152b.get(str2) : (String) f1151a.get(cBVar);
    }

    public final String mo3722a(String str) {
        return (String) f1153c.get(str);
    }
}