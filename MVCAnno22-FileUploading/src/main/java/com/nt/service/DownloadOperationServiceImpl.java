package com.nt.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("downloadService")
public class DownloadOperationServiceImpl implements DownloadOperationService {

	
	public List<String> featchFile(String uploadDir) {
		File uplDir=null;
		File files[]=null;
		List<String> listFiles=null;
		//get all file name from uploaded folder store
		uplDir=new File(uploadDir);
		files=uplDir.listFiles();
		listFiles=new ArrayList();
		for(File file:files) {
			if(!file.isDirectory())
				listFiles.add(file.getName());
		}
			
		// TODO Auto-generated method stub
		return listFiles;
	}

}
