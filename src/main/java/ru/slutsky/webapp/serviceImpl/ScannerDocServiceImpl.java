package ru.slutsky.webapp.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.springframework.stereotype.Service;
import ru.slutsky.webapp.consts.ConstError;
import ru.slutsky.webapp.services.ScannerService;

import java.io.FileInputStream;

@Service
@Slf4j
public class ScannerDocServiceImpl implements ScannerService {

    private static final String DOC = "doc";

    @Override
    public int getCount(String filePath) {
        try (WordExtractor document = new WordExtractor(new FileInputStream(filePath))) {
            return document.getSummaryInformation().getPageCount();
        } catch (Exception e) {
            log.error(ConstError.ERROR_FILE_READ, e);
            return 0;
        }
    }

    @Override
    public String getExtension() {
        return DOC;
    }

}
