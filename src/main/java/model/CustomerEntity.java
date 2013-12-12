package model;

import com.microsoft.windowsazure.services.table.client.TableServiceEntity;

public class CustomerEntity extends TableServiceEntity {
	public CustomerEntity(String name, String email) {
        this.partitionKey = name;
        this.rowKey = email;
    }

    public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public CustomerEntity() { }

    String phoneNumber;
    String password;
    String country;
    
    public String getPassword(){
    	return this.password;
    }
    public void setPassword(String password){
    	this.password=password;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
