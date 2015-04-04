/* Zack Raver, ravzac14
 * Belongs to the Ch.7 # 1 Project 
 */

public class PaymentCreditCard extends Payment {
	
	private String name;
	private String expirationDate;
	private long cardNumber;
	
	/* New no-arg and convenience constructors for the subclass PaymentCreditCard */
	
	public PaymentCreditCard(){
		super();
		this.name = "";
		this.expirationDate = "";
		this.cardNumber = 0L;
	}
	
	public PaymentCreditCard(double creditPaymentValue, String name, String expirationDate, long cardNumber){
		super(creditPaymentValue);
		this.name = name;
		this.expirationDate = expirationDate;
		this.cardNumber = cardNumber;
	}
	
	public void setPaymentValue(double creditValue, String newName, String newExpirationDate, long newCardNumber){
		super.setPaymentValue(creditValue);
		name = newName;
		expirationDate = newExpirationDate;
		cardNumber = newCardNumber;
	}
	
	/* Overriding the method paymentDetails to describe that it is also in cash */
	
	public void paymentDetails(Payment p1){
		System.out.printf("The payment was recieved on a credit card. The name on the card is %s, the expiration date is %s, the card number is %d. The payment is valued at: %3.2f\n", name, expirationDate, cardNumber, p1.getPaymentValue());
	}
	
}
