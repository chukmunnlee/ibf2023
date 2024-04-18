package ibf2023.paf.day25.services;

import java.io.StringReader;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Service
public class MessageSubscriber implements MessageListener {

   @Override
   public void onMessage(Message message, @Nullable byte[] pattern) {

      String payload = new String(message.getBody());
		JsonReader reader = Json.createReader(new StringReader(payload));
		JsonObject data = reader.readObject();

      System.out.printf(">>>> message: %s\n", data.toString());
      
   }
}
