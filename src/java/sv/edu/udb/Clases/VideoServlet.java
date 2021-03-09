/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.Clases;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Drosselmeyer
 */
public class VideoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public static final String VIDEO_AGREGADO = "Video agregado";
    private ArrayList<Video> videos = new ArrayList<Video>();

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        
        PrintWriter sentToClient = resp.getWriter();
        
        for(Video v : this.videos){
            sentToClient.write(v.getNombre() + ":" + v.getUrl()+"\n");
        }
    }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("nombre");
        String url = req.getParameter("url");
        String duracionStr = req.getParameter("duracion");
        
        System.out.println(req);
        long duracion = -1;
        
        System.out.println(name);
        System.out.println(url);
        System.out.println(duracionStr);
        
        try{
            duracion = Long.parseLong(duracionStr);
        }catch(NumberFormatException u){
            System.out.println(u);
        }
        
        resp.setContentType("text/plain");
        
        if(name == null || url == null || duracionStr == null
                || name.trim().length() < 1 || url.trim().length() < 10
                || duracionStr.trim().length() < 1
                || duracion <= 0){
            resp.sendError(400,"Falta ['nombre','url','duracion']");
        }else{
            Video v = new Video(name, url, duracion);
            
            videos.add(v);
            
            resp.getWriter().write(VIDEO_AGREGADO);
        }
            
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
}
