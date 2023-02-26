package ru.slutsky.webapp.mapper;

import org.mapstruct.Mapper;
import ru.slutsky.webapp.dto.ReportDto;
import ru.slutsky.webapp.models.Report;

@Mapper
public interface ReportMapper {
    ReportDto toDto(Report report);
}
