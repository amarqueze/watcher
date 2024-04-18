package com.ame.watcher.usecase;

import com.ame.watcher.domain.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class CommunicationsDecryptor {
    private final DeviceProvider deviceProvider;
    private final MessageDecryptor messageDecryptor;

    public String decrypt(List<Device> devices) {
        if (Objects.isNull(devices) || devices.isEmpty())
            throw new DecryptionFailed();

        List<Message> messages = devices.stream()
                .map(Device::getMessageCaptured)
                .filter(m -> !Objects.isNull(m.words()) && m.words().length > 0)
                .toList();
        return messageDecryptor.decrypt(messages);
    }

    public String decrypt() {
        List<Message> messages = deviceProvider.getAllMessageCaptured();
        return messageDecryptor.decrypt(messages);
    }
}
