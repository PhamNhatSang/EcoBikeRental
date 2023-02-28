package entity.payment;
    /**
     * this is CreditCard
     * @author NhatSang
     * @version 1.0
     */
public class CreditCard {
	private String cardCode;
	private String owner;
	private int cvvCode;
	private String dateExpired;
    /**
     * CreditCard constructor
     * @param cardCode
     * @param owner
     * @param cvvCode
     * @param dateExpired
     */
	public CreditCard(String cardCode, String owner, int cvvCode, String dateExpired) {
		super();
		this.cardCode = cardCode;
		this.owner = owner;
		this.cvvCode = cvvCode;
		this.dateExpired = dateExpired;
	}
}
