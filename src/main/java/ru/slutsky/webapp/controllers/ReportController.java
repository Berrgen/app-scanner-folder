package ru.slutsky.webapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.slutsky.webapp.dto.ReportDto;
import ru.slutsky.webapp.mapper.ReportMapper;
import ru.slutsky.webapp.services.ReportService;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;
    private final ReportMapper reportMapper;

    @PostMapping("api/v1/report")
    public ReportDto getFolderInfo(@RequestBody String path) {
        return reportMapper.toDto(reportService.getFolderInfo(path));
    }

}