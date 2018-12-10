package spittr;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;;


public class Spitter {
	private Long id;
	
	@NotNull
	@Size(min=2,max=30,message ="{firstName.size}")
	private String firstName;
	
	@NotNull
	@Size(min=2,max=30, message = "{lastName.size}")
	private String lastName;
	
	@NotNull
	@Size(min=5,max=16, message = "{userName.size}")
	private String userName;
	@NotNull
	@Size(min=5,max=25, message = "{password.size}")
	private String password;
	
	public Spitter() {}
	public Spitter(Long id, String firstName,String lastName,String userName,String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}
	
	public Spitter( String firstName,String lastName,String userName,String password) {
		this(null, firstName, lastName, userName, password);
	}
	
    public String getFirstName() {
    	return firstName;
    }
    public String getLastName() {
    	return lastName;
    }
    public Long getId() {
    	return id;
    }
    public String getPassword() {
    	return password;
    }
    public String getUserName() {
    	return userName;
    }
    
    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
    
    public void setId(Long id) {
		this.id = id;
	}
    
    public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    
    public void setPassword(String password) {
		this.password = password;
	}
    
    public void setUserName(String userName) {
		this.userName = userName;
	}
    
      @Override
      public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "firstName", "lastName", "userName", "password");
      }
      
      @Override
      public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "firstName", "lastName", "userName", "password");
      }

}
