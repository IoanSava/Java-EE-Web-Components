package ro.uaic.info.webcomponents.filters;

import ro.uaic.info.webcomponents.wrappers.SimpleResponseWrapper;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "ResponseDecorator", urlPatterns = {"/*"})
public class ResponseDecorator implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        SimpleResponseWrapper wrapper
                = new SimpleResponseWrapper((HttpServletResponse) response);

        //Send the decorated object as a replacement for the original response
        chain.doFilter(request, wrapper);

        //Get the dynamically generated content from the decorator
        String content = wrapper.toString();

        // Modify the content
        content = getHeader() + content + getFooter();

        //Send the modified content using the original response
        PrintWriter out = response.getWriter();
        out.write(content);
    }

    private String getHeader() {
        return "<header> <h1>Welcome to Java Web Components</h1> </header>";
    }

    private String getFooter() {
        return "<footer> <p>Made by Ioan Sava</p> </footer>";
    }
}
