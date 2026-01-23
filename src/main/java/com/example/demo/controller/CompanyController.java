package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Company;
import com.example.demo.service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("")
    public List<Company> listarCompanies() {
        return companyService.listarCompanies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> buscarCompany(@PathVariable Long id) {
        return companyService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Company criarCompany(@RequestBody Company company) {
        return companyService.salvarCompany(company);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCompany(@PathVariable Long id){
        companyService.deletarCompany(id);

        return ResponseEntity.noContent().build();
    }
}
