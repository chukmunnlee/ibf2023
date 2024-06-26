package ibf2023.paf.day24.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountsRepository {

   @Autowired
   private JdbcTemplate template;

   public static final String SQL_UPDATE_ACCOUNT_BY_ID = """
      update accounts
         set balance = balance + ?
         where acc_id = ?
   """;

   public boolean updateBalanceById(String accId, float amount) {
      return template.update(SQL_UPDATE_ACCOUNT_BY_ID, amount, accId) >= 1;
   }
   
}
