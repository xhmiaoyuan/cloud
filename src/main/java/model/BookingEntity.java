package model;

import com.microsoft.windowsazure.services.table.client.TableServiceEntity;

public class BookingEntity extends TableServiceEntity {
	public BookingEntity(String id, String email) {
        this.partitionKey = id;
        this.rowKey = email;
    }
	
	public BookingEntity(){}
	String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
