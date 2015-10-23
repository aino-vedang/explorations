package com.ainosoft.client.sample;

import org.appops.client.binding.AppTokenAnnotation;
import org.appops.client.binding.OpToken;
import org.appops.client.binding.RequestUrl;
import org.appops.client.json.async.ClientCallback;
import org.appops.client.json.async.ClientService;

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
