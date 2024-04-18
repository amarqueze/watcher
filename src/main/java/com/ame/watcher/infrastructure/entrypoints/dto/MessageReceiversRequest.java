package com.ame.watcher.infrastructure.entrypoints.dto;

import com.ame.watcher.domain.Device;
import com.ame.watcher.domain.Message;
import lombok.Data;

import java.util.List;

@Data
public class MessageReceiversRequest {
    private List<DeviceDTO> devices;

    public List<Device> toDevices() {
        return devices.stream()
                .map(d -> {
                    Device device = new Device(d.getId());
                    device.setMessageCaptured(new Message(d.getMessage()));
                    return device;
                })
                .toList();
    }
}
