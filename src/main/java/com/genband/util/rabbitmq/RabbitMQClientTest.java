package com.genband.util.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.genband.util.broker.BrokerMessagingService;
import com.genband.util.broker.BrokerType;
import com.genband.util.broker.MessagingService;
import com.genband.util.broker.model.Message;
import com.genband.util.broker.util.MessageUtils;

public class RabbitMQClientTest {

    public static void main(String args[]) throws IOException, TimeoutException {

         MessagingService svc = BrokerMessagingService.getService(BrokerType.RABBITMQ);
        // MessagingService svc = BrokerMessagingService.getService(BrokerType.RABBITMQ, "172.28.249.155", 32158, 32160,
        // "kandy-test-2", "testQueue");
         
        svc.bindRoutingKey("Jimmy");
        svc.bindRoutingKey("Shimmy");
        System.out.println("Queue binding size: " + svc.getRoutingKeys().size());
        svc.startConsumeMessaging();

        MessageUtils util = MessageUtils.getInstance();
        Message msg = util.buildMessage("The lazy green", "Jimmy", "kandy-test-2");
        Message msgfR = util.buildMessage("The answer back", "Jimmy", "kandy-test-2");
        try {
            // svc.sendRequest(msg);
            Thread.sleep(3000);
            svc.sendSynchronizedRequest(msg);
            // System.out.println("*********************************************");
            // System.out.println("***********You should be Happy to see this!!! *********");
            // System.out.println("*********************************************");
            // svc.sendResponse("019a1543-c5ff-4ef4-992a-e829230e38f2", msgfR);
            // svc.sendResponse("019a1543-c5ff-4ef4-992a-e829230e38f2", msgfR);
            // svc.sendRequest(msg);
            // svc.sendNotification(msg);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // svc.startConsumeMessaging();

    }

}
