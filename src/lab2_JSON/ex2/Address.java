package lab2_JSON.ex2;

public class Address {
	private long postalCode;
	private String streetAddress;
	private String city;
	private String state;

	public long getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(long postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Address(long postalCode, String streetAddress, String city, String state) {
		super();
		this.postalCode = postalCode;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
	}

	public Address() {
		super();
	}

	@Override
	public String toString() {
		return "Address [postalCode=" + postalCode + ", streetAddress=" + streetAddress + ", city=" + city + ", state="
				+ state + "]";
	}

}
