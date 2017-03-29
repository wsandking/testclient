package com.genband.util.hazelcast.dummy;

import com.genband.util.hazelcastclient.service.ReplicateDataAccessServiceFactory;
import com.genband.util.hazelcastclient.service.ReplicateDataService;
import com.genband.util.hazelcastclient.service.ReplicateDataServiceType;

public class DummyClient {

    public static void main(String args[]) {
        try {
            System.out.println(System.getenv("HAZELCAST_SVC_NAME"));
            ReplicateDataService service = ReplicateDataAccessServiceFactory
                    .getService(ReplicateDataServiceType.HAZELCAST_DATA_CLUSTER);
            service.storeValue("Test1", "Maps", "Queens");
            System.out.println("Get value: " + service.getValueFromMap("Maps","Test1"));

            Thread.sleep(34000);

            System.out.println("Get value: " + service.getValueFromMap("Maps","Test1"));

            Thread.sleep(34000);
            System.out.println("Get value: " + service.getValue("Maps"));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
