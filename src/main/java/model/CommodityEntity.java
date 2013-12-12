package model;

import com.microsoft.windowsazure.services.table.client.TableServiceEntity;

public class CommodityEntity extends TableServiceEntity {

	public CommodityEntity(String name, String id) {
        this.partitionKey = name;
        this.rowKey = id;
    }
	public CommodityEntity(){}
	String price;
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
