package com.ame.watcher.infrastructure.entrypoints;

import com.ame.watcher.domain.Device;
import com.ame.watcher.infrastructure.entrypoints.dto.MessageReceiverRequest;
import com.ame.watcher.infrastructure.entrypoints.dto.MessageReceiversRequest;
import com.ame.watcher.infrastructure.entrypoints.dto.ResponseData;
import com.ame.watcher.usecase.CommunicationsDecryptor;
import com.ame.watcher.usecase.DeviceMessageListener;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/watcher")
@RequiredArgsConstructor
public class WatcherController {
    private final CommunicationsDecryptor decryptor;
    private final DeviceMessageListener listener;

    @PostMapping("/message")
    public ResponseEntity<ResponseData> decrypt(@RequestBody MessageReceiversRequest messageReceiversRequest) {
        List<Device> devices =  messageReceiversRequest.toDevices();
        String decryptedMessage = decryptor.decrypt(devices);
        return new ResponseEntity<>(new ResponseData(decryptedMessage), HttpStatus.OK);
    }

    @GetMapping("/message_split/")
    public ResponseEntity<ResponseData> decrypt() {
        String decryptedMessage = decryptor.decrypt();
        return new ResponseEntity<>(new ResponseData(decryptedMessage), HttpStatus.OK);
    }

    @PostMapping("/message_split/{deviceId}")
    public ResponseEntity<ResponseData> track(@PathVariable String deviceId, @RequestBody MessageReceiverRequest messageReceiverRequest) {
        Device device = messageReceiverRequest.toDevice(deviceId);
        listener.addDeviceWithMessage(device);
        return new ResponseEntity<>(new ResponseData("Device Registered"), HttpStatus.OK);
    }
}
