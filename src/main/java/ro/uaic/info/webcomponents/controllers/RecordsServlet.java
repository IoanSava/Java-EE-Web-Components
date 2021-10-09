package ro.uaic.info.webcomponents.controllers;

import ro.uaic.info.webcomponents.daos.RecordsDao;
import ro.uaic.info.webcomponents.models.Record;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RecordsServlet", urlPatterns = "/records")
public class RecordsServlet extends HttpServlet {
    private static final String KEY_PARAMETER = "key";
    private static final String VALUE_PARAMETER = "value";
    private static final String CATEGORY_PARAMETER = "category";
    private static final String DEFAULT_CATEGORY_ATTRIBUTE = "default-category";
    private static final String RECORDS_ATTRIBUTE = "records";
    private static final String SELECTED_CATEGORY_COOKIE_NAME = "RecordsServlet.selectedCategoryCookie";
    private static final String RECORDS_PAGE = "/pages/result.jsp";

    private RecordsDao recordsDao;

    @Override
    public void init() throws ServletException {
        super.init();
        recordsDao = new RecordsDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(RECORDS_ATTRIBUTE, recordsDao.getRecords());
        getServletContext().getRequestDispatcher(RECORDS_PAGE).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter(KEY_PARAMETER);
        String value = request.getParameter(VALUE_PARAMETER);
        String category = getCategory(request);
        Record record = new Record(key, value, category);

        recordsDao.addRecord(record);
        request.setAttribute(RECORDS_ATTRIBUTE, recordsDao.getRecords());

        Cookie selectedCategoryCookie = getSelectedCategoryCookie(category);
        response.addCookie(selectedCategoryCookie);

        getServletContext().getRequestDispatcher(RECORDS_PAGE).forward(request, response);
    }

    private String getCategory(HttpServletRequest request) {
        String category = request.getParameter(CATEGORY_PARAMETER);
        if (category == null || category.equals("")) {
            category = (String) getServletContext().getAttribute(DEFAULT_CATEGORY_ATTRIBUTE);
        }
        return category;
    }

    private Cookie getSelectedCategoryCookie(String category) {
        Cookie selectedCategoryCookie = new Cookie(SELECTED_CATEGORY_COOKIE_NAME, category);
        selectedCategoryCookie.setMaxAge(30 * 60); // 30 minutes
        return selectedCategoryCookie;
    }
}
