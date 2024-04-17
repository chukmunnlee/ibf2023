package ibf2023.paf.day24.repositories;

import static ibf2023.paf.day24.repositories.Constants.SQL_PO_INSERT_PURCHASEORDER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf2023.paf.day24.models.PurchaseOrder;

@Repository
public class PurchaseOrderRepository {

   @Autowired
   private JdbcTemplate template;

   public void createPurchaseOrder(String poId, PurchaseOrder po) {

      // insert into purchase_order(po_id, email, delivery_date, rush, comments) values
      template.update(SQL_PO_INSERT_PURCHASEORDER, poId, po.getEmail(), po.getDeliveryDate()
            , po.isRush(), po.getComments());

   }
   
}
