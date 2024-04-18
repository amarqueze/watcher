package com.ame.watcher.domain;


public record Message(String[] words) {
    public static Message empty() {
        return new Message(new String[]{});
    }
}
