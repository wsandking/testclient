package com.genband.util.rabbitmq.handler;

import com.genband.util.broker.model.Message;
import com.genband.util.broker.model.OperationReceipt;
import com.genband.util.broker.rabbitmq.annotation.RabbitmqMessageController;
import com.genband.util.broker.rabbitmq.annotation.RabbitmqMessageHandler;

@RabbitmqMessageController(state = "work")
public class RabbitmqProcess {

    @RabbitmqMessageHandler(listenChannel = "self")
    public OperationReceipt handleMessage(Message message) {
        OperationReceipt receipt = new OperationReceipt();
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("Message: \n " + message.getMessageBody());
        System.out.println("Type: \n " + message.getMessageParams().getType());
        System.out.println("Transcation-ID: \n " + message.getMessageParams().getTransactionId());
        System.out.println("Message-ID: \n " + message.getMessageParams().getMessageId());
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        return receipt;
    }

    @RabbitmqMessageHandler(listenChannel = "unallocated")
    public OperationReceipt handleNewCommingMessage(Message message) {
        OperationReceipt receipt = new OperationReceipt();
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("Unrouted Message: \n " + message.getMessageBody());
        System.out.println("Type: \n " + message.getMessageParams().getType());
        System.out.println("Transcation-ID: \n " + message.getMessageParams().getTransactionId());
        System.out.println("Message-ID: \n " + message.getMessageParams().getMessageId());
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        return receipt;
    }

}
