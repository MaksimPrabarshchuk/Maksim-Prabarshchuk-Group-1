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

@WebServlet(description = "Company Servlet", urlPatterns = {"/CompanyServlet", "/CompanyServlet.do"})
public class CompanyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    CompanyManagerLocal companyManagerLocal;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Company> companies = companyManagerLocal.list();
        request.setAttribute("companies", companies);
        request.getRequestDispatcher("WEB-INF/jsps/companies.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
}
