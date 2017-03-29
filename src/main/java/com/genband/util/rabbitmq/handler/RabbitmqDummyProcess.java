package com.genband.util.rabbitmq.handler;

import com.genband.util.broker.model.Message;
import com.genband.util.broker.model.OperationReceipt;
import com.genband.util.broker.rabbitmq.annotation.RabbitmqMessageController;
import com.genband.util.broker.rabbitmq.annotation.RabbitmqMessageHandler;

@RabbitmqMessageController(state = "debug")
public class RabbitmqDummyProcess {

    @RabbitmqMessageHandler(listenChannel = "self")
    public OperationReceipt handleMessage(Message message) {
        OperationReceipt receipt = new OperationReceipt();

        return receipt;
    }

    @RabbitmqMessageHandler(listenChannel = "unallocated")
    public OperationReceipt handleNewCommingMessage(Message message) {
        OperationReceipt receipt = new OperationReceipt();

        return receipt;
    }

}
