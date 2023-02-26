package ru.slutsky.webapp.serviceImpl;

import org.springframework.stereotype.Service;
import ru.slutsky.webapp.services.DocumentExtensionCheckService;

@Service
public class DocumentExtensionCheckServiceImpl implements DocumentExtensionCheckService {

    public String getFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf(".");

        if (dotIndex > 0 && dotIndex < filename.length() - 1) {
            return filename.substring(dotIndex + 1).toLowerCase();
        } else {
            return "";
        }
    }

}
