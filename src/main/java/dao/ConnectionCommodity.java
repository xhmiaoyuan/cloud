package dao;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import model.CommodityEntity;

import com.microsoft.windowsazure.services.core.storage.CloudStorageAccount;
import com.microsoft.windowsazure.services.core.storage.StorageException;
import com.microsoft.windowsazure.services.table.client.CloudTableClient;
import com.microsoft.windowsazure.services.table.client.TableOperation;
import com.microsoft.windowsazure.services.table.client.TableQuery;

public class ConnectionCommodity {
	static CloudStorageAccount storageAccount;
	static CloudTableClient tableClient;

	public static void addCommodity(CommodityEntity commodityentity) {

		try {
			storageAccount = CloudStorageAccount.parse(Configuration.storageConnectionString);
			tableClient = storageAccount.createCloudTableClient();

			TableOperation insertCustomer = TableOperation.insert(commodityentity);
			tableClient.execute("commodity", insertCustomer);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static Iterable<CommodityEntity> getCommodity(){	
		try {
			storageAccount = CloudStorageAccount.parse(Configuration.storageConnectionString);
			tableClient = storageAccount.createCloudTableClient();
			//	storageAccount = CloudStorageAccount.parse(Configuration.storageConnectionString);
				TableQuery<CommodityEntity> partitionQuery =
					    TableQuery.from("commodity", CommodityEntity.class);	
				Iterable<CommodityEntity> commodities=tableClient.execute(partitionQuery);
/*				if(commodities.hasNext()){
					System.out.println(commodities.next().getPrice());
				}*/
				return commodities;
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
		
	}
}
