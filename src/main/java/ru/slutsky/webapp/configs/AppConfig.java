package ru.slutsky.webapp.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.*;
import ru.slutsky.webapp.services.ScannerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class AppConfig {

    private final List<ScannerService> scannerServices;

    @Bean(name = "scannerServicesMap")
    public Map<String, ScannerService> getScannerServices() {
        Map<String, ScannerService> scannerServiceMap = new HashMap<>();
        for(ScannerService s: scannerServices) {
            scannerServiceMap.put(s.getExtension(), s);
        }
        return scannerServiceMap;
    }

}