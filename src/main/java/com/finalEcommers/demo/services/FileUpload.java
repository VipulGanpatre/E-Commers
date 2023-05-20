package com.finalEcommers.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileUpload {
    public String UploadImage (String url, MultipartFile file){

//        String originalFilename=file.getOriginalFilename();
//        String randomImageNAme =UUID.randomUUID().toString();
//        String randomImageNAmewithextension=randomImageNAme.concat(originalFilename.substring(originalFilename.lastIndexOf(".")));
//        String path=File.separator+randomImageNAmewithextension;
//        File Folderfile=new File(path);
//
//
//        if (!Folderfile.exists()){
//            Folderfile.mkdir();
////            make a directory mkdir
//        }
//        try{
//
//            Files.copy(file.getInputStream(), Paths.get(fullpath));
//        }
//            catch(IOException e)
//            {
//                e.printStackTrace();
//            }
//        return randomImageNAmewithextension;
          return  null;

    }
}
