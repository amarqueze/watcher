package com.ame.watcher.infrastructure.entrypoints;

import com.ame.watcher.infrastructure.entrypoints.dto.MessageReceiverRequest;
import com.ame.watcher.infrastructure.entrypoints.dto.MessageReceiversRequest;
import com.ame.watcher.infrastructure.entrypoints.dto.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/watcher")
public class WatcherController {

    @PostMapping("/message")
    public ResponseEntity<ResponseData> decrypt(@RequestBody MessageReceiversRequest messageReceiversRequest) {
        return new ResponseEntity<>(new ResponseData("SUCCESS"), HttpStatus.OK);
    }

    @GetMapping("/message_split/")
    public ResponseEntity<ResponseData> decrypt() {
        return new ResponseEntity<>(new ResponseData("SUCCESS"), HttpStatus.OK);
    }

    @PostMapping("/message_split/{deviceId}")
    public ResponseEntity<ResponseData> track(@PathVariable String deviceId, @RequestBody MessageReceiverRequest messageReceiverRequest) {
        return new ResponseEntity<>(new ResponseData("SUCCESS"), HttpStatus.OK);
    }
}
