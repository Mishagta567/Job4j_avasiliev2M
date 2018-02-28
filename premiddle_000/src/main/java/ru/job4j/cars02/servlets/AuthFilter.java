package ru.job4j.cars02.servlets;

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
         //return;
      } else {
         HttpSession session = request.getSession();
         synchronized (session) {
            if (session.getAttribute("login") == null) {
               //((HttpServletResponse) resp).sendRedirect(String.format("%s/signin02?out=from_Auth_filter_lgin_null", request.getContextPath())); // работало. перестало.
               req.setAttribute("message", "You have to be signed it for that"); // Пашет
               req.getRequestDispatcher("/WEB-INF/views/cars02/loginView.jsp?out=get_UserController_NOT_Signed").forward(req, resp); // or //
               // Почему нельзя использовать это:
               //req.getRequestDispatcher("/WEB-INF/views/cars02/loginView.jsp?Out_get=From_signinController_Not_signed").forward(req, resp); // or //
               return;
            }
            if (request.getRequestURI().contains("upload") || request.getRequestURI().contains("soldout")) {
               String test = "test";
               int paramUserid = Integer.parseInt(req.getParameter("userid"));
               int sesUserId = (Integer) session.getAttribute("userid");

               if (paramUserid != sesUserId) {
                  //((HttpServletResponse) resp).sendRedirect("/j004b/filter06/notAdmin.jsp");  // Work
                  // Могу ли вместо этого использовать что ниже? Если нет почему и что делать? (этот не работал)
                  req.setAttribute("error", "Добавить фото или сменить статус можно только для своего объявления"); // Пашет
                  req.getRequestDispatcher("/carsAds.jsp?Out=From_AuthController_not_my_ad").forward(req, resp); // or //
                  return;
               }
            }
         }
         chain.doFilter(req, resp);
      }

   }

   @Override
   public void destroy() {

   }
}
