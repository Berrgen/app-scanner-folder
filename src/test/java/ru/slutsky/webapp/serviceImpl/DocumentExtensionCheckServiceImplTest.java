package ru.slutsky.webapp.serviceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.slutsky.webapp.services.DocumentExtensionCheckService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DocumentExtensionCheckServiceImpl.class)
class DocumentExtensionCheckServiceImplTest {

    @Autowired
    private DocumentExtensionCheckService documentExtensionCheckService;

    @Test
    void testPositiveGetExtension() {
        String result = documentExtensionCheckService.getFileExtension("file.txt");
        assertEquals("txt", result);
    }
  
}