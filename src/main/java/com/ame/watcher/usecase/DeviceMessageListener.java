package com.ame.watcher.usecase;

import com.ame.watcher.domain.Device;
import com.ame.watcher.domain.DeviceProvider;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeviceMessageListener {
    private final DeviceProvider deviceProvider;

    public void addDeviceWithMessage(Device device) {
        deviceProvider.addDevice(device);
    }
}
