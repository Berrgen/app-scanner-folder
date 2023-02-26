package ru.slutsky.webapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Report {
    private int fileCount;
    private int pageCount;
}
