package ra.baitap12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ra.baitap12.model.dto.response.ApiResponse;
import ra.baitap12.model.dto.response.RevenueReportResponse;
import ra.baitap12.service.ReportService;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/revenue")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<List<RevenueReportResponse>> getRevenueReport(
            @RequestParam String type
    ) {
        return reportService.getRevenueReport(type);
    }
}