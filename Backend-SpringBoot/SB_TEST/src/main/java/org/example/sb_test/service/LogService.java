package org.example.sb_test.service;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class LogService {

    private static final int MAX_LOGS = 100;
    private static final LinkedList<String> logs = new LinkedList<>();

    public void logInfo(String message) {
        addLog("INFO: " + message);
    }

    public void logWarn(String message) {
        addLog("WARN: " + message);
    }

    public void logError(String message, Throwable throwable) {
        addLog("ERROR: " + message + " - " + throwable.getMessage());
    }

    private void addLog(String log) {
        synchronized (logs) {
            if (logs.size() >= MAX_LOGS) {
                logs.removeFirst();
            }
            logs.add(log);
        }
    }

    public static List<String> getRecentLogs() {
        synchronized (logs) {
            return new LinkedList<>(logs);
        }
    }
}
