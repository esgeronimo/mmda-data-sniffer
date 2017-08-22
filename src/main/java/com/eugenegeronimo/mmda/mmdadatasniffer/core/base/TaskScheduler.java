package com.eugenegeronimo.mmda.mmdadatasniffer.core.base;

public interface TaskScheduler {
    public void start(Task task);
    public boolean isEnabled();
}
