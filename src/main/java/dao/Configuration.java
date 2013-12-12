package dao;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import com.microsoft.windowsazure.services.core.storage.CloudStorageAccount;
import com.microsoft.windowsazure.services.core.storage.StorageException;
import com.microsoft.windowsazure.services.table.client.CloudTable;
import com.microsoft.windowsazure.services.table.client.CloudTableClient;

public class Configuration {
	public static final String storageConnectionString = "DefaultEndpointsProtocol=http;"
			+ "AccountName=b2035974;" + "AccountKey=dNQY9cwf1HyOT67d9fvrGb+fHOPadsH4hhSo9TeSctJMY6MXzsZqwE8ywkJqWfdIFgkg7QhHLDEqRWgn2mMV4Q==";
	public static String tablename1="customer";
	public static String tablename2="commodity";
	public static String tablename3="booking";

	static void run() {
		CloudStorageAccount storageAccount = null;
		try {
			storageAccount = CloudStorageAccount.parse(storageConnectionString);
		} catch (InvalidKeyException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Create the table client.
		CloudTableClient tableClient = storageAccount.createCloudTableClient();

		// Create the table if it doesn't exist.


		CloudTable cloudtable = null;
		try {
			cloudtable = tableClient.getTableReference(tablename1);
			cloudtable.createIfNotExist();
			cloudtable = tableClient.getTableReference(tablename2);
			cloudtable.createIfNotExist();
			cloudtable = tableClient.getTableReference(tablename3);
			cloudtable.createIfNotExist();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
