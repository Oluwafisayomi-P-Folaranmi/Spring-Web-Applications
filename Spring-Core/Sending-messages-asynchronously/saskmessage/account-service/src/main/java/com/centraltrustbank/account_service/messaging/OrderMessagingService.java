package com.centraltrustbank.account_service.messaging;

import com.centraltrustbank.account_service.model.TacosOrder;

public interface OrderMessagingService {

    public void sendOrder(TacosOrder order);
}
