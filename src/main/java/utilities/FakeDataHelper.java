package utilities;

import com.github.javafaker.Faker;

public class FakeDataHelper {
	
	Faker fake = new Faker();
	
	public static FakeDataHelper getFakeDataHelper() {
		return new FakeDataHelper();
	}
	
	public String getFirstName() {
		return fake.address().firstName();
	}
	
	public String getLastName() {
		return fake.address().lastName();
	}
	
	public String getEmailAddress() {
		return fake.internet().emailAddress();
	}
	
	public String getPassword() {
		return fake.internet().password(8, 10, true, true);
	}
	
	public String getCountry() {
		return fake.address().country();
	}
	
	public String getZipCode() {
		return fake.address().zipCode();
	}
	
	public String getCity() {
		return fake.address().city();
	}
	
	public String getAddress() {
		return fake.address().streetAddress();
	}
	
	public String getCompany() {
		return fake.company().name();
	}
	
	public String getPhoneNumber() {
		return fake.phoneNumber().phoneNumber();
	}
	
	public String getCardNumber() {
		return fake.finance().creditCard();
	}
}
