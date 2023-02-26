package ru.slutsky.webapp.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.stereotype.Service;
import ru.slutsky.webapp.consts.ConstError;
import ru.slutsky.webapp.services.ScannerService;

import java.io.FileInputStream;

@Service
@Slf4j
public class ScannerPdfServiceImpl implements ScannerService {

    private final static String PDF = "pdf";

    @Override
    public int getCount(String filePath) {
        try (PDDocument document = PDDocument.load(new FileInputStream(filePath))) {
            return document.getNumberOfPages();
        } catch (Exception e) {
            log.error(ConstError.ERROR_FILE_READ, e);
            return 0;
        }
    }

    @Override
    public String getExtension() {
        return PDF;
    }

}
