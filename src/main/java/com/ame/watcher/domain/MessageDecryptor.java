package com.ame.watcher.domain;

import java.util.List;

public interface MessageDecryptor {
    String decrypt(List<Message> messages);
}
