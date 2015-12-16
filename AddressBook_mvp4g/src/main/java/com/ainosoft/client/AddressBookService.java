package com.ainosoft.client;

import org.appops.json.client.async.ClientCallback;
import org.appops.json.client.async.ClientService;
import org.appops.json.client.binding.AppTokenAnnotation;
import org.appops.json.client.binding.OpToken;

import com.ainosoft.shared.AddressSlim;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@AppTokenAnnotation(token = "addressbook_testLocation_AddressBookApp")
@RemoteServiceRelativePath("OpInvoke/Op")
public interface AddressBookService extends ClientService {

	@OpToken(Signature = "_addresscrud_deleteAddress")
	void deleteAddress(AddressSlim addressBookSlim, ClientCallback callback);

	@OpToken(Signature = "_addresscrud_updateAddress")
	void editAddress(AddressSlim addressBookSlim, ClientCallback callback);

	@OpToken(Signature = "_addresscrud_saveAddress")
	void saveAddress(AddressSlim aSlim, ClientCallback callback);

	@OpToken(Signature = "_addressfetch_getAddressList")
	void viewAddresses(ClientCallback callback);
}
