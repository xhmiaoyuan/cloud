package dao;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import model.CustomerEntity;

import com.microsoft.windowsazure.services.core.storage.CloudStorageAccount;
import com.microsoft.windowsazure.services.core.storage.StorageException;
import com.microsoft.windowsazure.services.table.client.CloudTableClient;
import com.microsoft.windowsazure.services.table.client.TableBatchOperation;
import com.microsoft.windowsazure.services.table.client.TableConstants;
import com.microsoft.windowsazure.services.table.client.TableOperation;
import com.microsoft.windowsazure.services.table.client.TableQuery;
import com.microsoft.windowsazure.services.table.client.TableQuery.QueryComparisons;

public  class ConnectionCustomer {
	static CloudStorageAccount storageAccount;
	static CloudTableClient tableClient;

	public static void addCustomer(CustomerEntity customerentity){

		try {
			storageAccount = CloudStorageAccount
					.parse(Configuration.storageConnectionString);
			tableClient = storageAccount.createCloudTableClient();
			TableBatchOperation batchOperation = new TableBatchOperation();
			batchOperation.insert(customerentity);
			tableClient.execute("customer", batchOperation);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (StorageException e){
			e.printStackTrace();
		}
		
	}

	public static CustomerEntity getCustomer(String email) {
		try {
			storageAccount = CloudStorageAccount
					.parse(Configuration.storageConnectionString);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Create the table client.
		CloudTableClient tableClient = storageAccount.createCloudTableClient();

		// Create a filter condition where the partition key is "Smith".
		String partitionFilter = TableQuery.generateFilterCondition(
				TableConstants.ROW_KEY, QueryComparisons.EQUAL, email);

		// Specify a partition query, using "Smith" as the partition key filter.
		TableQuery<CustomerEntity> partitionQuery = TableQuery.from("customer",
				CustomerEntity.class).where(partitionFilter);

		// Loop through the results, displaying information about the entity.
		Iterable<CustomerEntity> re=tableClient.execute(partitionQuery);
		if(re!=null){
		for (CustomerEntity entity : tableClient.execute(partitionQuery)) {
			return entity;
		}
		}
		return null;

	}

	public static void deleteCustomer(CustomerEntity customerentity) {
		TableOperation deleteSmithJeff = TableOperation.delete(customerentity);
		try {
			tableClient.execute("customer", deleteSmithJeff);
		} catch (StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
