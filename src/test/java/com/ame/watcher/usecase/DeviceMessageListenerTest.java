package com.ame.watcher.usecase;

import com.ame.watcher.domain.Device;
import com.ame.watcher.domain.DeviceProvider;
import com.ame.watcher.domain.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class DeviceMessageListenerTest {

    @Autowired
    private DeviceMessageListener deviceMessageListener;

    @MockBean
    private DeviceProvider deviceProvider;

    @Test
    public void testAddDeviceWithMessage() {
        Device device = new Device("1");
        device.setMessageCaptured(new Message(new String[] { "", "es", "", "mensaje" }));
        deviceMessageListener.addDeviceWithMessage(device);

        verify(deviceProvider).addDevice(device);
    }
}
