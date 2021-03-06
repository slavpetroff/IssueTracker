package domain.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by slavpetroff on 7/20/16.
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private String errorPage;

    public CustomAccessDeniedHandler() {
    }

    public CustomAccessDeniedHandler(String errorPage) {
        this.errorPage = errorPage;
    }

    public String getErrorPage() {
        return errorPage;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException)
            throws IOException, ServletException {

        //do some business logic, then redirect to errorPage url
        response.sendRedirect(errorPage);

    }

}

