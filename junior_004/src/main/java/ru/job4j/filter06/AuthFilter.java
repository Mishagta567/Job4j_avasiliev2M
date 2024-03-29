package ru.job4j.filter06;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
   @Override
   public void init(FilterConfig filterConfig) throws ServletException {

   }

   @Override
   public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
      HttpServletRequest request = (HttpServletRequest) req;
      if (request.getRequestURI().contains("Login") || request.getRequestURI().contains("signin")) {
         chain.doFilter(req, resp);
      } else {
         HttpSession session = request.getSession();
         synchronized (session) {
            if (session.getAttribute("login") == null) {
               ((HttpServletResponse) resp).sendRedirect("/items/LoginView.jsp?from=AuthFilter_04");
               return;
            }
         }
      }

   }

   @Override
   public void destroy() {

   }
}
