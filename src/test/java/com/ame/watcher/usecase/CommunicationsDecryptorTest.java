package com.ame.watcher.usecase;

import com.ame.watcher.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CommunicationsDecryptorTest {

    @Autowired
    private CommunicationsDecryptor communicationsDecryptor;

    @MockBean
    private DeviceProvider deviceProvider;

    @MockBean
    private MessageDecryptor messageDecryptor;

    @Test
    public void testDecryptWithDevices() {
        List<Message> messages = new ArrayList<>();
        when(deviceProvider.getAllMessageCaptured()).thenReturn(messages);
        when(messageDecryptor.decrypt(anyList())).thenReturn("Decrypted Message");

        String decryptedMessage = communicationsDecryptor.decrypt();
        assertEquals("Decrypted Message", decryptedMessage);
    }

    @Test
    public void testDecryptWithoutDevices() {
        when(deviceProvider.getAllMessageCaptured()).thenReturn(new ArrayList<>());
        when(messageDecryptor.decrypt(anyList())).thenThrow(new DecryptionFailed());

        assertThrows(DecryptionFailed.class, () -> {
            communicationsDecryptor.decrypt();
        });
    }
}
