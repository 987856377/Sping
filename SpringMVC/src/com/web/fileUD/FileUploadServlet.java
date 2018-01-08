package com.web.fileUD;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
                String savePath = "d://upload";
                
                String tempPath = "d://temp";
                File tmpFile = new File(tempPath);
                if (!tmpFile.exists()) {
                  
                    tmpFile.mkdir();
                }
                
              
                String message = "";
                try{
                     
                    DiskFileItemFactory factory = new DiskFileItemFactory();
                    
                    factory.setSizeThreshold(1024*1024); 
                  
                    factory.setRepository(tmpFile);
                   
                    ServletFileUpload upload = new ServletFileUpload(factory);
                   
                    upload.setProgressListener(new ProgressListener(){
                        public void update(long pBytesRead, long pContentLength, int arg2) {
                            System.out.println(pContentLength + pBytesRead);
                            
                        }
                    });
                     
                    upload.setHeaderEncoding("GBK"); 
                    
                    if(!ServletFileUpload.isMultipartContent(request)){
                       
                        return;
                    }
                    
                    
                    upload.setFileSizeMax(1024*1024);
                    
                    upload.setSizeMax(1024*1024*100);
                   
                    List<FileItem> list = upload.parseRequest(request);
                    for(FileItem item : list){
                       
                        if(item.isFormField()){
                            String name = item.getFieldName();
                            
                            String value = item.getString("GBK");
                            System.out.println(name + "=" + value);
                        }else{ 
                           
                            String filename = item.getName();
                            System.out.println(filename);
                            if(filename==null || filename.trim().equals("")){
                                continue;
                            }
                            
                            filename = filename.substring(filename.lastIndexOf("\\")+1);
                             
                            String fileExtName = filename.substring(filename.lastIndexOf(".")+1);
                           
                            System.out.println("�ϴ����ļ�����չ���ǣ�"+fileExtName);
                          
                            InputStream in = item.getInputStream();
                          
                            String saveFilename = makeFileName(filename);
                            
                            String realSavePath = makePath(saveFilename, savePath);
                            
                            FileOutputStream out = new FileOutputStream(realSavePath + "\\" + saveFilename);
                           
                            byte buffer[] = new byte[1024];
                            
                            int len = 0;
                            
                            while((len=in.read(buffer))>0){
                                
                                out.write(buffer, 0, len);
                            }
                             
                            in.close();
                           
                            out.close();
                            
                            //item.delete();
                            message = "上传成功";
                        }
                    }
                }catch (FileUploadBase.FileSizeLimitExceededException e) {
                    e.printStackTrace();
                    request.setAttribute("message", "文件大小受限制");
                    request.getRequestDispatcher("/webFileUD/message.jsp").forward(request, response);
                    return;
                }catch (FileUploadBase.SizeLimitExceededException e) {
                    e.printStackTrace();
                    request.setAttribute("message", "文件上传出错");
                    request.getRequestDispatcher("/webFileUD/message.jsp").forward(request, response);
                    return;
                }catch (Exception e) {
                    message= "上传失败";
                    e.printStackTrace();
                }
                request.setAttribute("message",message);
                request.getRequestDispatcher("/webFileUD/message.jsp").forward(request, response);
    }
    
  
    private String makeFileName(String filename){  //2.jpg
        
        return UUID.randomUUID().toString() + "_" + filename;
    }
 
    private String makePath(String filename,String savePath){
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf;  //0--15
        int dir2 = (hashcode&0xf0)>>4;  //0-15
      
        String dir = savePath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
        
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