package ibf2023.paf.day26;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class AppConfig {

   @Value("${spring.data.mongodb.uri}")
   private String mongoUrl;

   @Bean
   public MongoTemplate createMongoTemplate() {
      MongoClient client = MongoClients.create(mongoUrl);
      return new MongoTemplate(client, Constants.SHOWS_DB);
   }
}
