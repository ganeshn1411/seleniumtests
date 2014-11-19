package tests.selenium;

public class RequestHandler {

	public static void main(String[] args) {
		EstoreOrder estoreOrder = new EstoreOrder();
		String service = "bpm";
		try {
			estoreOrder.setUp();
			estoreOrder.testEstoreOrder(service);
			estoreOrder.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
