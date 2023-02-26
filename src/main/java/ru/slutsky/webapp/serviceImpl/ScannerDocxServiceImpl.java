package ru.slutsky.webapp.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.stereotype.Service;
import ru.slutsky.webapp.consts.ConstError;
import ru.slutsky.webapp.services.ScannerService;

import java.io.FileInputStream;

@Service
@Slf4j
public class ScannerDocxServiceImpl implements ScannerService {

    private final static String DOCX = "docx";

    @Override
    public int getCount(String filePath) {
        try (XWPFDocument document = new XWPFDocument(new FileInputStream(filePath))) {
            return document.getProperties().getExtendedProperties().getPages();
        } catch (Exception e) {
            log.error(ConstError.ERROR_FILE_READ, e);
            return 0;
        }
    }

    @Override
    public String getExtension() {
        return DOCX;
    }

}
