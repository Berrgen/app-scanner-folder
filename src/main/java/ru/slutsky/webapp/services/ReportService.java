package ru.slutsky.webapp.services;

import ru.slutsky.webapp.models.Report;

public interface ReportService {
    Report getFolderInfo(String rootPath);
}
