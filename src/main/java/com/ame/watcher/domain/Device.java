package com.ame.watcher.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

import static com.ame.watcher.domain.util.ArgumentChecker.checkIsValidString;

@Getter
public class Device {
    private final String id;
    @Setter private Message messageCaptured;

    public Device(String id) {
        checkIsValidString(id, "Invalid device");
        this.id = id;
        this.messageCaptured = !Objects.isNull(messageCaptured) ? messageCaptured : Message.empty();
    }
}
