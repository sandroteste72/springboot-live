package com.digitalinnovationone.live.controller;

import com.digitalinnovationone.live.model.Company;
import com.digitalinnovationone.live.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping
    public Company createCompany (@RequestBody Company company) {
        return companyService.save(company);
    }

    @GetMapping
    public List<Company> getCompanyList () {
        return companyService.findAll();
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompanyByID(@PathVariable("companyId") Long companyId) throws Exception {
        return  ResponseEntity.ok(companyService.findById(companyId).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping
    public Company updateCompany(@RequestBody Company company){
        return companyService.updateCompany(company);
    }

    @DeleteMapping(value = "/{companyId}")
    public ResponseEntity<Company> deleteById(@PathVariable Long companyId){
        companyService.deleteCompany(companyId);
        return ResponseEntity.noContent().build();
    }
}
