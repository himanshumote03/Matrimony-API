package com.appxbuild.matrimony.rest;

import com.appxbuild.matrimony.entity.FinancialStatuses;
import com.appxbuild.matrimony.service.FinancialStatusesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FinancialStatusesRestController {
    private FinancialStatusesService financialStatusesService;

    public FinancialStatusesRestController(FinancialStatusesService financialStatusesService) {
        this.financialStatusesService = financialStatusesService;
    }

    // "/financialStatuses" -> get list of all FinancialStatuses
    @GetMapping("/financialStatuses")
    public List<FinancialStatuses> getFinancialStatuses() {
        return financialStatusesService.findAll();
    }
}
