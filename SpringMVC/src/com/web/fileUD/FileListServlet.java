package com.web.fileUD;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownloadServlet
 */
@WebServlet("/servlet/ListFileServlet")
public class FileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
        String uploadFilePath = "d://upload";
       
        Map<String,String> fileNameMap = new HashMap<String,String>();
       
        listfile(new File(uploadFilePath),fileNameMap); 
         
        request.setAttribute("fileNameMap", fileNameMap);
        request.getRequestDispatcher("/webFileUD/FileList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void listfile(File file,Map<String,String> map){
        
        if(!file.isFile()){
           
            File files[] = file.listFiles();
           
            for(File f : files){
               
                listfile(f,map);
            }
        }else{
             
            String realName = file.getName().substring(file.getName().indexOf("_")+1);
            
            map.put(file.getName(), realName);
        }
    }
}
