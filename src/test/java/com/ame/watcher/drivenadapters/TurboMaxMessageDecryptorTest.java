package com.ame.watcher.drivenadapters;

import com.ame.watcher.domain.DecryptionFailed;
import com.ame.watcher.domain.Message;
import com.ame.watcher.infrastructure.drivenadapters.TurboMaxMessageDecryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class TurboMaxMessageDecryptorTest {
    @Autowired
    private TurboMaxMessageDecryptor decryptor;

    @Test
    public void testDecryptWithValidMessages() {
        List<Message> messages = Arrays.asList(
                new Message(new String[]{"","Hello", "world"}),
                new Message(new String[]{"This", "", "", "is", "a", "test"})
        );

        String decryptedMessage = decryptor.decrypt(messages);
        assertEquals("This Hello world is a test", decryptedMessage);
    }

    @Test
    public void testDecryptWithEmptyList() {
        assertThrows(DecryptionFailed.class, () -> {
            decryptor.decrypt(Collections.emptyList());
        });
    }

    @Test
    public void testDecryptWithEmptyMessages() {
        List<Message> messages = Arrays.asList(
                new Message(new String[]{}),
                new Message(new String[]{}),
                new Message(new String[]{})
        );

        assertThrows(DecryptionFailed.class, () -> {
            decryptor.decrypt(messages);
        });
    }

    @Test
    public void testDecryptWithNullMessages() {
        assertThrows(DecryptionFailed.class, () -> {
            decryptor.decrypt(null);
        });
    }
}
