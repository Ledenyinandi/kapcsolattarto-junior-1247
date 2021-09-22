package hu.futureofmedia.task.contactsapi.services;

import hu.futureofmedia.task.contactsapi.entities.Company;
import hu.futureofmedia.task.contactsapi.repositories.CompanyRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }
}
