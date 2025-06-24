package com.example.assignment_2.API;
import com.example.assignment_2.Service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportAPI {
    public ReportService reportService;
    public ReportAPI(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/sales-per-category")
    public Map<String, Double> getSalesPerCategory() {
        return reportService.getSalesPerCategory();
    }

    @GetMapping("/revenue")
    public double getTotalRevenue() {
        return reportService.getTotalRevenue();
    }

    @GetMapping("/order-count")
    public int getTotalOrderCount() {
        return reportService.getTotalOrderCount();
    }

    @GetMapping("/best-sellers")
    public List<Map.Entry<String, Integer>> getBestSellingProducts(
            @RequestParam(defaultValue = "5") int topN) {
        return reportService.getBestSellingProducts(topN);
    }
}
