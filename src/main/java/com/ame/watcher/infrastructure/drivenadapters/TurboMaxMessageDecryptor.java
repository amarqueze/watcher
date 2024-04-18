package com.ame.watcher.infrastructure.drivenadapters;

import com.ame.watcher.domain.DecryptionFailed;
import com.ame.watcher.domain.MessageDecryptor;
import com.ame.watcher.domain.Message;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class TurboMaxMessageDecryptor implements MessageDecryptor {
    @Override
    public String decrypt(List<Message> messages) {
        if (Objects.isNull(messages) || messages.isEmpty())
            throw new DecryptionFailed();

        int maxLength = messages.stream().mapToInt(message -> message.words().length).max().orElse(0);
        if(maxLength == 0)
            throw new DecryptionFailed();

        String realMessage = IntStream.range(0, maxLength)
                .mapToObj(i -> findWordNotEmpty(messages.stream()
                        .map(message -> i < message.words().length ? message.words()[i] : "")
                        .toArray(String[]::new)))
                .collect(Collectors.joining(" "));

        if (realMessage.trim().isEmpty())
            throw new DecryptionFailed();

        return realMessage;
    }

    private static String findWordNotEmpty(String[] wordCount) {
        return Stream.of(wordCount)
                .filter(word -> !word.isEmpty())
                .findFirst()
                .orElse("");
    }
}
