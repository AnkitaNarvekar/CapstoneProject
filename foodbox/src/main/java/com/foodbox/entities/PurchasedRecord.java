package com.foodbox.entities;

public class PurchasedRecord {

	private long id_Purchase;
	private String purchase_User;
	private String purchase_UserEmail;
	private String purchase_UserContact;
	private String purchase_UserShippingAddress;
	private String purchase_Date;
	private String purchase_Category;
	private String purchase_DeliveryStatus;
	private String purchase_PaymentMode;
	private String purchase_TotalAmount;
	private String purchase_ExpectedMinutesForDelivery;

	public String getPurchase_ExpectedMinutesForDelivery() {
		return purchase_ExpectedMinutesForDelivery;
	}

	public void setPurchase_ExpectedMinutesForDelivery(String purchase_ExpectedMinutesForDelivery) {
		this.purchase_ExpectedMinutesForDelivery = purchase_ExpectedMinutesForDelivery;
	}

	public long getId_Purchase() {
		return id_Purchase;
	}

	public void setId_Purchase(long id_Purchase) {
		this.id_Purchase = id_Purchase;
	}

	public String getPurchase_User() {
		return purchase_User;
	}

	public void setPurchase_User(String purchase_User) {
		this.purchase_User = purchase_User;
	}

	public String getPurchase_UserEmail() {
		return purchase_UserEmail;
	}

	public void setPurchase_UserEmail(String purchase_UserEmail) {
		this.purchase_UserEmail = purchase_UserEmail;
	}

	public String getPurchase_UserContact() {
		return purchase_UserContact;
	}

	public void setPurchase_UserContact(String purchase_UserContact) {
		this.purchase_UserContact = purchase_UserContact;
	}

	public String getPurchase_UserShippingAddress() {
		return purchase_UserShippingAddress;
	}

	public void setPurchase_UserShippingAddress(String purchase_UserShippingAddress) {
		this.purchase_UserShippingAddress = purchase_UserShippingAddress;
	}

	public String getPurchase_Date() {
		return purchase_Date;
	}

	public void setPurchase_Date(String purchase_Date) {
		this.purchase_Date = purchase_Date;
	}

	public String getPurchase_Category() {
		return purchase_Category;
	}

	public void setPurchase_Category(String purchase_Category) {
		this.purchase_Category = purchase_Category;
	}

	public String getPurchase_DeliveryStatus() {
		return purchase_DeliveryStatus;
	}

	public void setPurchase_DeliveryStatus(String purchase_DeliveryStatus) {
		this.purchase_DeliveryStatus = purchase_DeliveryStatus;
	}

	public String getPurchase_PaymentMode() {
		return purchase_PaymentMode;
	}

	public void setPurchase_PaymentMode(String purchase_PaymentMode) {
		this.purchase_PaymentMode = purchase_PaymentMode;
	}

	public String getPurchase_TotalAmount() {
		return purchase_TotalAmount;
	}

	public void setPurchase_TotalAmount(String purchase_TotalAmount) {
		this.purchase_TotalAmount = purchase_TotalAmount;
	}

	@Override
	public String toString() {
		return "PurchasedRecord [id_Purchase=" + id_Purchase + ", purchase_User=" + purchase_User
				+ ", purchase_UserEmail=" + purchase_UserEmail + ", purchase_UserContact=" + purchase_UserContact
				+ ", purchase_UserShippingAddress=" + purchase_UserShippingAddress + ", purchase_Date=" + purchase_Date
				+ ", purchase_Category=" + purchase_Category + ", purchase_DeliveryStatus=" + purchase_DeliveryStatus
				+ ", purchase_PaymentMode=" + purchase_PaymentMode + ", purchase_TotalAmount=" + purchase_TotalAmount
				+ ", purchase_ExpectedMinutesForDelivery=" + purchase_ExpectedMinutesForDelivery + "]";
	}

}
