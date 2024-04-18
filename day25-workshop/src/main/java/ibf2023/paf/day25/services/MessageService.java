package ibf2023.paf.day25.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import ibf2023.paf.day25.Constants;

@Service
public class MessageService {

   @Autowired @Qualifier("myredis")
   private RedisTemplate<String, String> template;

   public void send(String msg) {

		JsonObject data = Json.createObjectBuilder()
			.add("id", Constants.MY_ID)
			.add("message", msg)
			.build();

		ListOperations<String, String> listOps = template.opsForList();
		listOps.leftPush("myqueue", data.toString());
   }
   
}
