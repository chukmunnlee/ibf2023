package ibf2023.paf.day24;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ibf2023.paf.day24.models.LineItem;
import ibf2023.paf.day24.models.PurchaseOrder;
import ibf2023.paf.day24.services.PurchaseOrderService;

@SpringBootApplication
public class Day24Application implements CommandLineRunner {

	@Autowired
	private PurchaseOrderService poSvc;

	public static void main(String[] args) {
		SpringApplication.run(Day24Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<LineItem> lineItems = new LinkedList<>();
		LineItem li = new LineItem();
		li.setItem("apple");
		li.setQuantity(10);
		lineItems.add(li);

		li = new LineItem();
		li.setItem("orange");
		li.setQuantity(5);
		lineItems.add(li);

		PurchaseOrder po = new PurchaseOrder();
		po.setEmail("acme@gmail.com");
		po.setDeliveryDate(new Date());
		po.setRush(true);
		po.setComments("Test order");
		po.setLineItems(lineItems);

		poSvc.insertPurchaseOrder(po);

		System.exit(0);
	}

}
