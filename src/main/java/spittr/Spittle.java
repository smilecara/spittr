package spittr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Spittle {
	private final Long id;
	private final String message;
	private final Date time;
	private Double latitude;
	private Double longtitude;
	
	public Spittle (Long id,String message, Date time,Double latitude,Double longtitude) {
		this.id = id;
		this.message = message;
		this.time = time;
		this.latitude = latitude;
		this.longtitude = longtitude;
	}
	
	public Spittle(String message, Date time) {
    	this(null,message, time, null, null);
    }
    
    
	public Long getId() {
		return id;
	}
	public Date getTime() {
		return time;
	}

	public String getMessage() {
		return message;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongtitude() {
		return longtitude;
	}
	
	
     @Override
     public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id", "time");
      }
      
      @Override
      public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
      }
	
}
