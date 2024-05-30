package ibf2023.csf.day37.services;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class UploadService {

   @Autowired
   private AmazonS3 s3;

   public String upload(MultipartFile file) throws IOException {

      // User metadata 
      Map<String, String> userData = new HashMap<>();
      userData.put("upload-timestamp", (new Date()).toString());
      userData.put("name", "chuk");
      userData.put("filename", file.getOriginalFilename());

      // Metadata for the file
      ObjectMetadata metadata = new ObjectMetadata();
      metadata.setContentType(file.getContentType());
      metadata.setContentLength(file.getSize());
      metadata.setUserMetadata(userData);

      String key = UUID.randomUUID().toString().substring(0, 8);

      // bucket name, key, input stream, metadata
      PutObjectRequest putReq = new PutObjectRequest("day37", key
            , file.getInputStream(), metadata);
      // Make the object publically available
      putReq = putReq.withCannedAcl(CannedAccessControlList.PublicRead);

      s3.putObject(putReq);

      return s3.getUrl("day37", key).toString();
   }
   
}
