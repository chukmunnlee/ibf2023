package ibf2023.paf.day24.repositories;

public class Constants {

   public static final String SQL_LI_INSERT_LINEITEM = """
      insert into line_items(item, quantity, po_id) values (?, ?, ?)
   """;

   public static final String SQL_PO_INSERT_PURCHASEORDER = """
      insert into purchase_order(po_id, email, delivery_date, rush, comments) values
         (?, ?, ?, ?, ?)
   """;
}
