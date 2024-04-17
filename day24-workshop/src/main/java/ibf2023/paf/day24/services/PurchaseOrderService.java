package ibf2023.paf.day24.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.introspector.PropertyUtils;

import ibf2023.paf.day24.models.PurchaseOrder;
import ibf2023.paf.day24.repositories.LineItemsRepository;
import ibf2023.paf.day24.repositories.PurchaseOrderRepository;

@Service
public class PurchaseOrderService {

   @Autowired
   private PurchaseOrderRepository poRepo;

   @Autowired
   private LineItemsRepository liRepo;

   @Transactional(rollbackFor = PurchaseOrderException.class)
   public void insertPurchaseOrder(PurchaseOrder po) 
         // rollback
         throws PurchaseOrderException{

      // start transaction
      try {
         String poId = UUID.randomUUID().toString().substring(0, 8);
         poRepo.createPurchaseOrder(poId, po);
         liRepo.createLineItems(poId, po.getLineItems());
      } catch (Exception ex) {
         throw new PurchaseOrderException(ex.getMessage());
      }
      // commit
   }
   
}
