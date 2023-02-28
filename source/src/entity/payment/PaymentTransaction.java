package entity.payment;

import entity.rental.Rental;
    /**
     * this is PaymentTransaction Class
     * @author NhatSang
     * @version 1.0
     */
public class PaymentTransaction {
	private CreditCard card;
	private Rental rental;
	private String transactionId;
	private String transactionDescription;
	private double amount;
	private String createdAt;
	/**
	 * PaymentTransaction constructor
	 * @param card
	 * @param transactionId
	 * @param transactionDescription
	 * @param amount
	 * @param rental
	 * @param createdAt
	 */
	public PaymentTransaction(CreditCard card, String transactionId, String transactionDescription,
			double amount,Rental rental, String createdAt) {
		super();
		this.card = card;
		this.transactionId = transactionId;
		this.transactionDescription = transactionDescription;
		this.amount = amount;
		this.rental=rental;
		this.createdAt = createdAt;
	}
}
