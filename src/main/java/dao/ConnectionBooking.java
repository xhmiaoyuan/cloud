package dao;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import model.BookingEntity;

import com.microsoft.windowsazure.services.core.storage.CloudStorageAccount;
import com.microsoft.windowsazure.services.core.storage.StorageException;
import com.microsoft.windowsazure.services.table.client.CloudTableClient;
import com.microsoft.windowsazure.services.table.client.TableOperation;

public class ConnectionBooking {
	static CloudStorageAccount storageAccount;
	static CloudTableClient tableClient;
	public static void addBookingEntity(BookingEntity bookingentity) {

		try {
			storageAccount = CloudStorageAccount.parse(Configuration.storageConnectionString);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tableClient = storageAccount.createCloudTableClient();
		TableOperation insertCustomer = TableOperation.insert(bookingentity);
		try {
			tableClient.execute("booking", insertCustomer);
		} catch (StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
