package com.ame.watcher.domain;

import java.util.List;

public interface DeviceProvider {
    public Device addDevice(Device device);
    public List<Message> getAllMessageCaptured();
}
