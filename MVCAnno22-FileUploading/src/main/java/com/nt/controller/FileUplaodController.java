package com.nt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.commons.UploadCommand;
import com.nt.service.DownloadOperationService;

@Controller
public class FileUplaodController {
	
	@Autowired
	private DownloadOperationService service;
	
	@GetMapping("/upload.htm")
	public String showForm(@ModelAttribute("uplCmd")UploadCommand cmd) {
		return "file_uplaod";
	}
	
	@PostMapping("/upload.htm")
	public String uploadForm(Map<String, Object>map,
			                 @ModelAttribute("uplCmd")UploadCommand cmd,
			                 HttpServletRequest req,
			                 BindingResult errors)throws Exception {
		ServletContext sc=null;
		String location=null;
		File file=null;
		String resumefile=null,photofile=null;
		InputStream ris=null,pis=null;
		OutputStream ros=null,pos=null;
		//get access to servletContext Object
		sc=req.getServletContext();
		//read contextParam Value
		location=sc.getInitParameter("uploadFolder");
		//check the folder availability, if not available createit
		file=new File(location);
		if(!file.exists())
			file.mkdir();
		//get the name of Uplaod files 
		resumefile=cmd.getEresume().getOriginalFilename();
		photofile=cmd.getEpotho().getOriginalFilename();
		//get InputStreams representing  uploaded files content
        ris= cmd.getEresume().getInputStream();
        pis=cmd.getEpotho().getInputStream();
        //Create OutputStreams pointing empty destination files on the  server machnine file system
        ros=new FileOutputStream(location+"/"+resumefile);
        pos=new FileOutputStream(location+"/"+photofile);
        //complete file copy operation 
        IOUtils.copy(ris,ros);
        IOUtils.copy(pis,pos);
        //close streams
        ris.close();
        ros.close();
        pis.close();
        pos.close();
        //keep the names of uploaded files as the model attributes
        map.put("filename1",resumefile);
        map.put("filename2",photofile);
        //return lvn
		return "success_upload";
	}
	
	@RequestMapping("/list_files.htm")
	public String  listUploadedFiles(Map<String,Object>map,HttpServletRequest req) {
		ServletContext sc=null;
		String uploadDir=null;
		List<String>filesList=null;
		//get Access to ServletContext object
		sc=req.getServletContext();
		uploadDir=sc.getInitParameter("uploadFolder");
		//use service
		filesList=service.featchFile(uploadDir);
		//modelAttribute
		map.put("filesList",filesList);
		//return lvn
		return "show_files";
		
	}

}
