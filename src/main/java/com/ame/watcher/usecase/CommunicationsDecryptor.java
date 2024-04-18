package com.ame.watcher.usecase;

import com.ame.watcher.domain.Device;
import com.ame.watcher.domain.DeviceProvider;
import com.ame.watcher.domain.MessageDecryptor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CommunicationsDecryptor {
    private final DeviceProvider deviceProvider;
    private final MessageDecryptor messageDecryptor;

    public String decrypt(List<Device> messages) {
        return "";
    }

    public String decrypt() {
        return "";
    }
}
