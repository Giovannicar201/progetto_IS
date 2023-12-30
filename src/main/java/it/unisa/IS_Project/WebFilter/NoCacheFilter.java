package it.unisa.IS_Project.WebFilter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@Component
@Slf4j

public class NoCacheFilter extends GenericFilterBean {

    @Override

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        try{

            log.debug("eseguo il filtro!");

            ((HttpServletResponse)servletResponse).setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            ((HttpServletResponse)servletResponse).setHeader("Pragma", "no-cache");
            ((HttpServletResponse)servletResponse).setDateHeader("Expires", 0);

            filterChain.doFilter(servletRequest, servletResponse);

        } finally {

            log.debug("richiesta eseguita!");

        }

    }

}
