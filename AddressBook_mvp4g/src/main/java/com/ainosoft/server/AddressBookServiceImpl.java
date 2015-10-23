package com.ainosoft.server;

import org.appops.client.json.async.ClientCallback;

import com.ainosoft.client.AddressBookService;
import com.ainosoft.shared.AddressSlim;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class AddressBookServiceImpl extends RemoteServiceServlet implements AddressBookService {

	/* (non-Javadoc)
	 * @see com.ainosoft.client.AddressBookService#deleteAddress(com.ainosoft.shared.AddressSlim, org.appops.client.json.async.ClientCallback)
	 */
	@Override
	public void deleteAddress(AddressSlim addressBookSlim, ClientCallback callback) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.ainosoft.client.AddressBookService#editAddress(com.ainosoft.shared.AddressSlim, org.appops.client.json.async.ClientCallback)
	 */
	@Override
	public void editAddress(AddressSlim addressBookSlim, ClientCallback callback) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.ainosoft.client.AddressBookService#saveAddress(com.ainosoft.shared.AddressSlim, org.appops.client.json.async.ClientCallback)
	 */
	@Override
	public void saveAddress(AddressSlim aSlim, ClientCallback callback) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.ainosoft.client.AddressBookService#viewAddresses(org.appops.client.json.async.ClientCallback)
	 */
	@Override
	public void viewAddresses(ClientCallback callback) {
		// TODO Auto-generated method stub

	}

}
