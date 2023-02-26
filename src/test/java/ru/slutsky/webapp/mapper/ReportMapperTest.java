package ru.slutsky.webapp.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.slutsky.webapp.dto.ReportDto;
import ru.slutsky.webapp.models.Report;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ReportMapperImpl.class)
class ReportMapperTest {

    @Autowired
    private ReportMapper reportMapper;

    @Test
    void testPositiveToDto() {
        Report report = new Report(10, 20);

        ReportDto reportDto = reportMapper.toDto(report);

        assertNotNull(reportDto);
        assertEquals(report.getFileCount(), reportDto.getFileCount());
        assertEquals(report.getPageCount(), reportDto.getPageCount());
    }

}