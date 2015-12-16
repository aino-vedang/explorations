package com.ainosoft.client.sample;

import org.appops.json.client.async.ClientCallback;
import org.appops.json.client.async.ClientService;
import org.appops.json.client.binding.AppTokenAnnotation;
import org.appops.json.client.binding.OpToken;
import org.appops.json.client.binding.RequestUrl;

import com.ainosoft.shared.AddressSlim;

/**
 * @author vedang@ainosoft.com
 * @CreatedOn 06-Oct-2015
 * @Responsibility
 */
@RequestUrl(url = "OpInvoke/Op")
@AppTokenAnnotation(token = "addressbook_testLocation_AddressBookApp")
public interface TestAddressBookService extends ClientService {
	@OpToken(Signature = "_addresscrud_saveAddress")
	void saveAddress(AddressSlim aSlim, ClientCallback callback);

}
