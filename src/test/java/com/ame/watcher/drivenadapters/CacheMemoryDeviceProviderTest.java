package com.ame.watcher.drivenadapters;

import com.ame.watcher.domain.Device;
import com.ame.watcher.domain.Message;
import com.ame.watcher.infrastructure.drivenadapters.CacheMemoryDeviceProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CacheMemoryDeviceProviderTest {

    @Autowired
    private CacheMemoryDeviceProvider cacheMemoryDeviceProvider;

    @Test
    public void testAddDevice() {
        Device device = new Device("1");
        device.setMessageCaptured(new Message(new String[] { "", "es", "", "mensaje" }));

        cacheMemoryDeviceProvider.addDevice(device);
        List<Message> messages = cacheMemoryDeviceProvider.getAllMessageCaptured();

        assertTrue(!messages.isEmpty());
    }

    @Test
    public void testGetAllMessageCaptured() {
        Device device1 = new Device("1");
        device1.setMessageCaptured(new Message(new String[] { "", "es", "", "mensaje" }));

        Device device2 = new Device("2");
        device2.setMessageCaptured(new Message(new String[] { "este", "", "un", "" }));

        cacheMemoryDeviceProvider.addDevice(device1);
        cacheMemoryDeviceProvider.addDevice(device2);
        List<Message> messages = cacheMemoryDeviceProvider.getAllMessageCaptured();
        assertEquals(2, messages.size());
    }
}
