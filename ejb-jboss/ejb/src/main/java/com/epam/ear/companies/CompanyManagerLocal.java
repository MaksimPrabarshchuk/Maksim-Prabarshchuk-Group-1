package com.epam.ear.companies;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CompanyManagerLocal {

    void createCompany(String name);

    List<Company> list();
}
