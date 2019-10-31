package cn.speedit.settlement.factory;

import cn.speedit.settlement.service.SettlementSubService;
import cn.speedit.settlement.service.impl.SettlementSubServiceImpl;

/**
 * @author Zoujidi
 * @title: FinanceApi
 * @projectName settlement
 * @description: 提供业务系统访问接口实例
 * @date 2019/9/19 17:15
 */
public final class FinanceApi {

    private static SettlementSubService settlementSubService = null;

    public static SettlementSubService getSettlementSubService(){
        if (settlementSubService == null){
            settlementSubService = new SettlementSubServiceImpl();
        }
        return settlementSubService;
    }

}
