package com.epam.ear.companies;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CompanyManager {

    void createCompany(String name);

    List<Company> list();
}

