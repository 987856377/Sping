package com.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.entity.User;

		
@Controller
@RequestMapping(value="user")
public class UserController {
	private Logger log = Logger.getLogger(UserController.class);
	
	@ModelAttribute("user")	// 在调用方法之前，会优先调用ModelAttribute注解的方法
	// 优先实例化User会防止出现异常
	public User userDeploy(){
		User user = new User();
		return user;
	}
		
	@RequestMapping(value="login", produces="text/html;charset=UTF-8")
	public String login(){
		log.info("Loading page success");
		return "login";
	}
	
	@RequestMapping(value="list", produces="text/html;charset=UTF-8")
	public String getUser(Model model,@RequestParam("name") String name,@RequestParam("password") String password){
		model.addAttribute("message", "hello SpringMVC");
		model.addAttribute("name", name);
		model.addAttribute("password", password);
		
		return "list";
	}
	
	
	@RequestMapping("userInfo")	
	public String getUserInfo(@ModelAttribute("user") User user){
//		user = new User(); 重新new出User实例，不能返回ModelAttribute
		
		user.setName("jeck");
		user.setPassword("123456");
		
		
		System.out.println("user: "+user.getName()+"--"+user.getPassword());
		return "userInfo";
	}
	
	@RequestMapping(value="toUpload")
	public String getUploadJSP(){
		return "upload";
	}
	
	@RequestMapping(value="uploadResult")
	public String uploadController(@RequestParam MultipartFile[] myfiles,HttpServletRequest request,Model model){
		for(MultipartFile file : myfiles){     
     
			try {
				
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
            if(file.isEmpty()){   
                System.out.println("文件不存在!");  
            }  
            else{  
        
                String path = request.getServletContext().getRealPath("/uploads/");
                System.out.println(path);
             
                String filename = new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"-"+file.getOriginalFilename();
                System.out.println(filename);
                File filepath = new File(path,filename);
 
                if (!filepath.getParentFile().exists()) { 
                    filepath.getParentFile().mkdirs();
                }
                try {
					file.transferTo(filepath);
					model.addAttribute("message", "上传成功");
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					model.addAttribute("message", "上传的文件不符规范");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					model.addAttribute("message", "上传失败");
				}  
            }  
        } 
		
		return "message";
	}
	
	public void getFiles(File file,Map<String, String> map){
		if(!file.isFile()){
			File[] files = file.listFiles();
			for(File f : files){
				getFiles(f,map);
			}
		}
		else{
			String filename = file.getName().substring(file.getName().lastIndexOf("-")+1);
			map.put(file.getName(), filename);
		}
	}
	
	@RequestMapping(value="downloadList",produces="text/html;charset=UTF-8")
	public String downloadList(HttpServletRequest request){
		
		String path = request.getServletContext().getRealPath("/uploads/");
		
		Map<String, String> map = new HashMap<String, String>();
		File file = new File(path);
		
		getFiles(file,map);
		request.getSession().setAttribute("fileNameMap", map);
		return "fileList";
	}
	
	@RequestMapping(value="downloadResult",produces="text/html;charset=UTF-8")
	 public ResponseEntity<byte[]> download(HttpServletRequest request,@RequestParam("filename") String filename,
	            Model model) throws IOException{
		 
	        String downloadFilePath = request.getServletContext().getRealPath("/uploads/");
	        File file = new File(downloadFilePath+File.separator+filename);
	        
	        HttpHeaders headers = new HttpHeaders();
	        String downloadFileName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
//	        Content-Disposition: attachment;
//            filename="$encoded_fname";
//            filename*=utf-8''$encoded_fname;
	        
	        headers.setContentDispositionFormData("attachment", downloadFileName);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        
	        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	    }
	
	 
	@RequestMapping(value="ajax",method=RequestMethod.GET)
	@ResponseBody
	public Map<String ,Object> getInfo(){
		Map<String, Object> map = new HashMap<String, Object>(3);
		User user = new User();
		user.setName("jeck");
		user.setPassword("123");
		map.put("first", user);
		return map;
	}
}
