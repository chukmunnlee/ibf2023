package vttp2023.ssf.day18.day18.services;

import java.sql.Date;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import vttp2023.ssf.day18.day18.models.User;

@Service
public class HttpbinService {

   public void postByJson(User user) {

      JsonObject data = Json.createObjectBuilder()
            .add("name", user.name())
            .add("email", user.email())
            .build();

      RequestEntity<String> req = RequestEntity
            .post("https://httpbin.org/post")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .header("X-Date", (new java.util.Date()).toString())
            .body(data.toString());

      RestTemplate template = new RestTemplate();
      ResponseEntity<String> resp = template.exchange(req, String.class);

      System.out.printf(">>> body: %s\n", resp.getBody());
   }

   public void postByUrlEncodedForm(User user) {
      MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
      form.add("name", user.name());
      form.add("email", user.email());
      form.add("hobbies", "jogging");
      form.add("hobbies", "swimming");
      form.add("hobbies", "travelling");

      RequestEntity<MultiValueMap<String, String>> post = RequestEntity
            .post("https://httpbin.org/post")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .accept(MediaType.APPLICATION_JSON)
            .body(form);

      RestTemplate template = new RestTemplate();
      ResponseEntity<String> resp = template.exchange(post, String.class);

      System.out.printf(">>> body: %s\n", resp.getBody());
   }
   
}
