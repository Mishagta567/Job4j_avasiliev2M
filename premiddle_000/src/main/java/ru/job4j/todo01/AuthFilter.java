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
      if (request.getRequestURI().contains("login") || request.getRequestURI().contains("signin")) {  // если обращения идут к login-page
         chain.doFilter(req, resp);
      } else {
         HttpSession session = request.getSession();
         synchronized (session) {
            if (session.getAttribute("login") == null) {
               ((HttpServletResponse) resp).sendRedirect(String.format("%s/signin06?out=from_Auth_filter_lgin_null", request.getContextPath())); // работало. перестало.
               // Почему нельзя использовать это:
               //req.getRequestDispatcher("/WEB-INF/filter06/loginView.jsp?Out_get=From_signinController_Not_signed").forward(req, resp); // or //
               return;
            }
            if (request.getRequestURI().contains("User01")) {
               if (!session.getAttribute("role").equals("admin") && !session.getAttribute("login").equals(req.getParameter("login"))) {
                  //((HttpServletResponse) resp).sendRedirect("/j004b/filter06/notAdmin.jsp");  // Work
                  // Могу ли вместо этого использовать что ниже? Если нет почему и что делать? (этот не работал)
                  req.getRequestDispatcher("/WEB-INF/filter06/notAdmin.jsp?Out_get=From_AuthController_sgned").forward(req, resp); // or //
                  return;
               }
            }
            if (request.getRequestURI().contains("Role") && !session.getAttribute("role").equals("admin")) {
               //((HttpServletResponse) resp).sendRedirect("/j004b/filter06/notAdmin.jsp");  // Work
               req.getRequestDispatcher("/WEB-INF/filter06/notAdmin.jsp?Out_get=From_AuthController_sgned").forward(req, resp); // or //
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
