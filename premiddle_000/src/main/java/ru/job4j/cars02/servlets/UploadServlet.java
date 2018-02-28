package ru.job4j.cars02.servlets;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.cars02.AllCarsAds;
import ru.job4j.cars02.models.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Создадим сервлет, который будет дергать UserStore03.
 * Saving UserCS data in the PostgreSQL
 * @author Alex Vasiliev 9720560@gmail.com
 * @version $Id$
 * @since 0.1
 */
// Import required java libraries

public class UploadServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

   // location to store file uploaded
   private static final String UPLOAD_DIRECTORY = "upload";

   // upload settings
   private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
   private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
   private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB


   @Override
   public void init() {
      // Get the file location where it would be stored.
   }

   @Override
   public void doGet(HttpServletRequest request,  HttpServletResponse response)
           throws ServletException, java.io.IOException {
      throw new ServletException("GET method used with " + getClass().getName() + ": POST method required.");
   }   //  */

   /**
    * Upon receiving file upload submission, parses the request to read
    * upload data and saves the file on disk.
    */
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      /*String adId = req.getParameter("adId");
      PrintWriter writer = resp.getWriter();
      writer.println("Error: Form must has enctype=multipart/form-data.+ " + adId);
      writer.flush();*/

      // checks if the request actually contains upload file
      if (!ServletFileUpload.isMultipartContent(req)) {
         // if not, we stop here
         PrintWriter writer = resp.getWriter();
         writer.println("Error: Form must has enctype=multipart/form-data.");
         writer.flush();
         return;
      } else {
         // configures upload settings
         DiskFileItemFactory factory = new DiskFileItemFactory();
         // sets memory threshold - beyond which files are stored in disk
         factory.setSizeThreshold(MEMORY_THRESHOLD);
         // sets temporary location to store files
         factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
         ServletFileUpload upload = new ServletFileUpload(factory);
         // sets maximum size of upload file
         upload.setFileSizeMax(MAX_FILE_SIZE);
         // sets maximum size of request (include file + form data)
         upload.setSizeMax(MAX_REQUEST_SIZE);
         // constructs the directory path to store upload file
         // this path is relative to application's directory
         //String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
         String uploadPath = "C:\\projects\\avasiliev2\\premiddle_000\\src\\main\\webapp\\images\\cars";
         //String uploadPath = "";

         // creates the directory if it does not exist
         File uploadDir = new File(uploadPath);
         if (!uploadDir.exists()) {
            uploadDir.mkdir();
         }
         try {
            // parses the request's content to extract file data
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(req);

            if (formItems != null && formItems.size() > 0) {
               // iterates over form's fields
               for (FileItem item : formItems) {
                  // processes only fields that are not form fields
                  if (!item.isFormField()) {

                     AllCarsAds allCarsAds = new AllCarsAds();
                     String adId = req.getParameter("adId");
                     int photoId = allCarsAds.newPhoto(Integer.parseInt(adId));

                     String fileName = new File(item.getName()).getName();
                     //String filePath = uploadPath + File.separator + fileName;
                     String filePath = uploadPath + File.separator + photoId + ".jpg";
                     File storeFile = new File(filePath);
                     // saves the file on disk
                     item.write(storeFile);


                     req.setAttribute("message", String.format("Upload has been done successfully! AdId=%s, PhotoId= %s", adId, photoId));
                     //req.setAttribute("adId", req.getParameter("adId"));
                  }
               }
            }
         } catch (Exception ex) {
            req.setAttribute("message", "There was an error: " + ex.getMessage());
         }
         // redirects client to message page
         getServletContext().getRequestDispatcher("/carAd_JSTL.jsp").forward(req, resp);
      }  //  */
   }

}