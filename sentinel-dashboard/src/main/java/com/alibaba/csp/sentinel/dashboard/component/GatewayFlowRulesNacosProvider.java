package com.alibaba.csp.sentinel.dashboard.component;

import com.alibaba.csp.sentinel.dashboard.config.NacosProperties;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.util.NacosConfigUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 推送gatewayFlowRules的实际实现类
 *
 * @author ：zafir zhong
 * @version : 1.0.0
 * @date ：Created in 2021/8/30 下午6:13
 * @modified By：
 */
@Component("gatewayFlowRulesNacosProvider")
public class GatewayFlowRulesNacosProvider implements DynamicRuleProvider<List<GatewayFlowRuleEntity>> {
    @Autowired
    private ConfigService configService;
    @Autowired
    private NacosProperties nacosProperties;

    @Override
    public List<GatewayFlowRuleEntity> getRules(String appName) throws Exception {
        return NacosConfigUtil.getRuleEntitiesFromNacos(configService,appName,nacosProperties.getGatewayFlowRulesSuf(),GatewayFlowRuleEntity.class);
    }

}

