package com.example.demo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;;

@Service
public class CompanyService {
    
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> listarCompanies(){
        return companyRepository.findAll();
    }

    public Optional<Company> buscarPorId(Long id) {
        return companyRepository.findById(id);
    }

    public Company salvarCompany(Company company) {
        return companyRepository.save(company);
    }

    public void deletarCompany(Long id) {
        companyRepository.deleteById(id);
    }
}