package com.web.fileUD;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String fileName = request.getParameter("filename");  
        fileName = new String(fileName.getBytes("GBK"),"GBK");
     
        String fileSaveRootPath = "d://upload";
  
        String path = findFileSavePathByFileName(fileName,fileSaveRootPath);
 
        File file = new File(path + "\\" + fileName);

        if(!file.exists()){
            request.setAttribute("message", "��Ҫ���ص���Դ�ѱ�ɾ������");
            request.getRequestDispatcher("/webFileUD/message.jsp").forward(request, response);
            return;
        }

        String realname = fileName.substring(fileName.indexOf("_")+1);

        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));

        FileInputStream in = new FileInputStream(path + "\\" + fileName);

        OutputStream out = response.getOutputStream();

        byte buffer[] = new byte[1024];
        int len = 0;
   
        while((len=in.read(buffer))>0){
           
            out.write(buffer, 0, len);
        }
      
        in.close();

        out.close();
    }
    

    public String findFileSavePathByFileName(String filename,String saveRootPath){
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf;  //0--15
        int dir2 = (hashcode&0xf0)>>4;  //0-15
        String dir = saveRootPath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
        File file = new File(dir);
        if(!file.exists()){
  
            file.mkdirs();
        }
        return dir;
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}