package Location;

public class LocVO {
	private int location_id;
	private String street_address;
	private String postal_code;
	private String city;
	private int country_country_id;
	private String country_name;

	public LocVO(int location_id, String street_address, String postal_code, String city, int country_country_id,
			String country_name) {
		super();
		this.location_id = location_id;
		this.street_address = street_address;
		this.postal_code = postal_code;
		this.city = city;
		this.country_country_id = country_country_id;
		this.country_name = country_name;
	}

	public LocVO() {
		super();
	}

	public LocVO(int location_id, String street_address, String postal_code, String city, int country_country_id) {
		super();
		this.location_id = location_id;
		this.street_address = street_address;
		this.postal_code = postal_code;
		this.city = city;
		this.country_country_id = country_country_id;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public String getStreet_address() {
		return street_address;
	}

	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCountry_country_id() {
		return country_country_id;
	}

	public void setCountry_country_id(int country_country_id) {
		this.country_country_id = country_country_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	@Override
	public String toString() {
		return	"┃ 지역번호 : " + location_id + "\t" + "주 소 : " + street_address + "\t" + "우편번호 : "+postal_code+"\t"+
		"도시명 : " + city + "     " + "국가코드 : " + country_country_id + "     " + "국가이름 : " + country_name;
	}
	
	public String AllLoc() {
		return "┃ " + location_id + "\t" + street_address + "\t\t" + postal_code + "\t     " + city + "\t     " + 
	country_country_id + "\t\t" + country_name;
	}

	public String InsertResult() {
		return "지역번호 : " + location_id + "  " + "주  소 : " + street_address + "  " + "우편번호 : " + postal_code + "  "
				+ "도시명 : " + city + "  " + "국가코드 : " + country_country_id;
	}
}