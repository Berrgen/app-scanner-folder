package ru.slutsky.webapp.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.slutsky.webapp.models.Report;
import ru.slutsky.webapp.services.DocumentExtensionCheckService;
import ru.slutsky.webapp.services.ReportService;
import ru.slutsky.webapp.services.ScannerService;

import java.io.File;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final DocumentExtensionCheckService documentExtensionCheckService;

    @Autowired
    @Qualifier("scannerServicesMap")
    private final Map<String, ScannerService> scannerServiceMap;

    public Report getFolderInfo(String rootPath) {
        File rootFolder = new File(rootPath);

        if (!rootFolder.isDirectory()) {
            return null;
        }

        File[] files = rootFolder.listFiles();

        if (files == null) {
            return null;
        }

        int fileCount = 0;
        int pageCount = 0;
        for (File file : files) {
            if (file.isDirectory()) {
                Report subReport = getFolderInfo(file.getAbsolutePath());
                if (subReport != null) {
                    fileCount += subReport.getFileCount();
                    pageCount += subReport.getPageCount();
                }
            } else {
                ScannerService scanner = scannerServiceMap.get(
                        documentExtensionCheckService.getFileExtension(file.getName()));
                if (scanner != null) {
                    fileCount++;
                    pageCount += scanner.getCount(file.getAbsolutePath());
                }
            }
        }
        return new Report(fileCount, pageCount);
    }

}
