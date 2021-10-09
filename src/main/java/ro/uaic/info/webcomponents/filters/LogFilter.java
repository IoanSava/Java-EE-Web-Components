package ro.uaic.info.webcomponents.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

@WebFilter(urlPatterns = {"/records"})
public class LogFilter implements Filter {
    private static final String USER_AGENT_HEADER = "User-Agent";

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        logRequest(req);

        chain.doFilter(request, response);
    }

    private void logRequest(HttpServletRequest request) {
        System.out.println((
                String.format("Method: %s | ", request.getMethod()) +
                String.format("IP-address of the client: %s | ", request.getRemoteAddr()) +
                String.format("User-agent: %s | ", request.getHeader(USER_AGENT_HEADER)) +
                String.format("Client language(s): %s |  ", getClientLanguagesFromRequest(request)) +
                String.format("Parameters: %s", getParametersOfRequest(request))
        ));
    }

    private String getClientLanguagesFromRequest(HttpServletRequest request) {
        StringBuilder clientLanguages = new StringBuilder();
        Enumeration<Locale> locales = request.getLocales();
        while (locales.hasMoreElements()) {
            clientLanguages.append(String.format("%s ", locales.nextElement()));
        }
        return clientLanguages.toString();
    }

    private String getParametersOfRequest(HttpServletRequest request) {
        StringBuilder parametersOfTheRequest = new StringBuilder();
        Enumeration<String> parameters = request.getParameterNames();
        while (parameters.hasMoreElements()) {
            String currentParameter = parameters.nextElement();
            parametersOfTheRequest.append(String.format("%s=%s ", currentParameter, request.getParameterValues(currentParameter)[0]));
        }
        return parametersOfTheRequest.toString();
    }
}
