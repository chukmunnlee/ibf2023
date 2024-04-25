package ibf2023.paf.day29;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class AppConfig {

   @Bean
   public CommonsRequestLoggingFilter log() {
      CommonsRequestLoggingFilter logger = new CommonsRequestLoggingFilter();
      logger.setIncludeClientInfo(true);
      logger.setIncludeQueryString(true);
      return logger;
   }
   
}
