package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Order {
	private String itemNumber;
	private String description;
	private String priceEach;
	private String firstName;
	private String lastName;
	private String middleInitial;
	private String shippingAddress;
	private String creditCard;
	private String creditCardNumber;
	private String repeatCreditCardNumber;
}