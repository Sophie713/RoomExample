package com.sophie.miller.roomwithlivedata.utils;

import androidx.annotation.MainThread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {
    private static AppExecutors executor;
    public static final Object OBJECT = new Object();
    private Executor databaseExecutor;
    private Executor networkExecutor;

    private AppExecutors(Executor databaseExecutor, Executor networkExecutor) {
        this.databaseExecutor = databaseExecutor;
        this.networkExecutor = networkExecutor;
    }

    public static AppExecutors getInstance() {
        if (executor == null) {
            synchronized (OBJECT) {
                executor = new AppExecutors(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(3));
            }
        }
        return executor;
    }

    public Executor getDatabaseExecutor() {
        return databaseExecutor;
    }

    public Executor getNetworkExecutor() {
        return networkExecutor;
    }
}
