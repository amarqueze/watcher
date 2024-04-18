package com.ame.watcher.infrastructure.entrypoints.dto;

import com.ame.watcher.domain.Device;
import com.ame.watcher.domain.Message;
import lombok.Data;

@Data
public class MessageReceiverRequest {
    private String[] message;

    public Device toDevice(String deviceId) {
        var device = new Device(deviceId);
        device.setMessageCaptured(new Message(message));
        return device;
    }
}
