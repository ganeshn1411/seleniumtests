package tests.selenium;

public class RequestHandler {

	public static void main(String[] args) {
		EstoreOrder estoreOrder = new EstoreOrder();
		try {
			estoreOrder.setUp();
			estoreOrder.testEstoreOrder();
			estoreOrder.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
