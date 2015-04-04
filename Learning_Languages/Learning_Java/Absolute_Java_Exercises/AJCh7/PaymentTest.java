/* Zack Raver, ravzac14
 * TESTCLASS
 * Belongs to the Ch.7 # 1 Project 
 */

public class PaymentTest {

	public static void main(String[] args) {
		
		//Creating new objects to test Payment, PaymentCash, and PaymentCreditCard
		Payment p1 = new Payment();
		p1.setPaymentValue(24.99d);
		Payment p2 = new Payment(45.99d);
		PaymentCash p3 = new PaymentCash();
		p3.setPaymentValue(80.99d);
		PaymentCash p4 = new PaymentCash(100.99d);
		PaymentCreditCard p5 = new PaymentCreditCard();
		p5.setPaymentValue(105.99d, "Jonh", "08/14", 8888999922223333l);
		PaymentCreditCard p6 = new PaymentCreditCard(115.99d, "Timmy", "09/18", 1111222233334444l);
		
		//Testing the paymentDetails for each of the new objects
		p1.paymentDetails(p1);
		p2.paymentDetails(p2);
		p3.paymentDetails(p3);
		p4.paymentDetails(p4);
		p5.paymentDetails(p5);
		p6.paymentDetails(p6);
	}

}
