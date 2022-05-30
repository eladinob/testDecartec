package co.com.decartec.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataApiModel implements Serializable{
	
	public static final long serialVersionUID = 1L;

	private String ip;
	private String type;
	private String continent_code;
	private String continent_name;
	private String country_code;
	private String country_name;
	private String region_code;
	private String region_name;
	private String city;
	private String zip;
	private String latitude;
	private String longitude;
	//private LocationModel location; 
	//private List<Lenguages> lenguages;
}
