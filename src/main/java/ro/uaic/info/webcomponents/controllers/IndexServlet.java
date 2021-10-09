package ro.uaic.info.webcomponents.controllers;

import ro.uaic.info.webcomponents.daos.CategoriesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndexServlet", urlPatterns = "/")
public class IndexServlet extends HttpServlet {
    private static final String CATEGORIES_ATTRIBUTE = "categories";
    private static final String INPUT_PAGE = "/pages/input.jsp";

    private CategoriesDao categoriesDao;

    @Override
    public void init() throws ServletException {
        super.init();
        categoriesDao = new CategoriesDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(CATEGORIES_ATTRIBUTE, categoriesDao.getCategories());
        getServletContext().getRequestDispatcher(INPUT_PAGE).forward(request, response);
    }
}