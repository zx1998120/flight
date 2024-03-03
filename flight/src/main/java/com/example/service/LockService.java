package com.example.service;

// LockService.java

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service
public class LockService {

    private ConcurrentHashMap<String, Object> locks = new ConcurrentHashMap<>();

    public boolean acquireLock(String customerId) {
        Object lock = new Object();
        Object existingLock = locks.putIfAbsent(customerId, lock);
        if (existingLock == null) {
            return true; // Lock acquired successfully
        } else {
            return false; // Failed to acquire lock
        }
    }

    public void releaseLock(String customerId) {
        locks.remove(customerId);
    }
}

