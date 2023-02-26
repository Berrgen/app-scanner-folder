package ru.slutsky.webapp.services;

public interface ScannerService {
    int getCount(String filePath);
    String getExtension();
}
