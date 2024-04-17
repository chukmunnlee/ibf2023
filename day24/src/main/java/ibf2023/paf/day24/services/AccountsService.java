package ibf2023.paf.day24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibf2023.paf.day24.repositories.AccountsRepository;

@Service
public class AccountsService {

   @Autowired
   private AccountsRepository accountsRep;

   // Rollback if it is an unchecked exception
   // Will not rollback if its a checked exception
   @Transactional
   //@Transactional(rollbackFor = AccountsException.class)
   public void fundsTransfer(String fromAcct, String toAcct, float amount) 
         throws AccountsException {

      // start transaction

      if (!accountsRep.updateBalanceById(fromAcct, -amount))
         throw new AccountsException("Cannot perform transfer");

      //if (!accountsRep.updateBalanceById(toAcct, amount))
         throw new AccountsException("Cannot perform transfer");

      // commit
   }
   
}
