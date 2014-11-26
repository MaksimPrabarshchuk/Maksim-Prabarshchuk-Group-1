package com.epam.ear.web;

import com.epam.ear.companies.Company;
import com.epam.ear.companies.CompanyManagerLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(description = "Add Company Servlet", urlPatterns = {"/AddCompanyServlet", "/AddCompanyServlet.do"})
public class AddCompanyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    CompanyManagerLocal companyManagerLocal;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        companyManagerLocal.createCompany(name);
        request.getRequestDispatcher("/CompanyServlet.do").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
}
