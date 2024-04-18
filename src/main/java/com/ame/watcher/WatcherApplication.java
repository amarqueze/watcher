package com.ame.watcher;

import com.ame.watcher.domain.DeviceProvider;
import com.ame.watcher.domain.MessageDecryptor;
import com.ame.watcher.usecase.CommunicationsDecryptor;
import com.ame.watcher.usecase.DeviceMessageListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WatcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WatcherApplication.class, args);
	}

	@Bean
	public CommunicationsDecryptor getCommunicationsDecryptor(DeviceProvider deviceProvider, MessageDecryptor messageDecryptor) {
		return new CommunicationsDecryptor(deviceProvider, messageDecryptor);
	}

	@Bean
	public DeviceMessageListener getDeviceMessageListener(DeviceProvider deviceProvider) {
		return new DeviceMessageListener(deviceProvider);
	}

}
