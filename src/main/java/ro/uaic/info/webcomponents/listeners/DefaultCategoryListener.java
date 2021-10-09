package ro.uaic.info.webcomponents.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class DefaultCategoryListener implements ServletContextListener {
    private static final String DEFAULT_CATEGORY_PARAMETER = "default-category";

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        String defaultCategory = servletContext.getInitParameter(DEFAULT_CATEGORY_PARAMETER);
        servletContext.setAttribute(DEFAULT_CATEGORY_PARAMETER, defaultCategory);
    }
}
