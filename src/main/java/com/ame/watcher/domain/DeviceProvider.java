package com.ame.watcher.domain;

import java.util.List;

public interface DeviceProvider {
    Device addDevice(Device device);
    List<Message> getAllMessageCaptured();
}
