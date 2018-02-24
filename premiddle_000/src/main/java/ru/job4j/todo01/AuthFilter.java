package ru.job4j.todo01;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthFilter implements Filter {

   @Override
   public void init(FilterConfig filterConfig) throws ServletException {

   }

   @Override
   public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
      HttpServletRequest request = (HttpServletRequest) req;
      if (request.getRequestURI().contains("signin") || request.getRequestURI().contains("login")) {  // если обращения идут к login-page
         chain.doFilter(req, resp);
         //return;
      } else {
         HttpSession session = request.getSession();
         synchronized (session) {
            if (session.getAttribute("login") == null) {
               //req.getRequestDispatcher("/WEB-INF/filter06/loginView.jsp?Out_get=From_signinController_Not_signed").forward(req, resp); // or //
               ((HttpServletResponse) resp).sendRedirect(String.format("%s/signin01?out=from_Auth_filter_lgin_null", request.getContextPath())); // работало. перестало.
               return;
            }
         }
         chain.doFilter(req, resp);
      }
   }

   @Override
   public void destroy() {

   }
}