package com.ame.watcher.infrastructure.drivenadapters;

import com.ame.watcher.domain.Device;
import com.ame.watcher.domain.DeviceProvider;
import com.ame.watcher.domain.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class CacheMemoryDeviceProvider implements DeviceProvider {
    private List<Device> devices = new ArrayList<>();

    @Override
    public Device addDevice(Device device) {
        Device deviceExisted = getDevice(device.getId());
        if(!Objects.isNull(deviceExisted)) {
            deviceExisted.setMessageCaptured(device.getMessageCaptured());
            return deviceExisted;
        }

        devices.add(device);
        return device;
    }

    @Override
    public List<Message> getAllMessageCaptured() {
        return devices.stream()
                .map(d -> d.getMessageCaptured())
                .filter(m -> !Objects.isNull(m.words()) && m.words().length > 0)
                .toList();
    }

    private Device getDevice(String deviceId) {
        return devices.stream()
                .filter(d -> d.getId().equals(deviceId))
                .findFirst()
                .orElse(null);
    }
}
