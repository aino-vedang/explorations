package com.ainosoft.client;

import java.util.List;

import com.ainosoft.shared.AddressSlim;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface AddressBookService extends RemoteService {
  String greetServer(String name) throws IllegalArgumentException;
  
  	boolean addAddress(AddressSlim addressBookSlim) throws IllegalArgumentException;
	
	List<AddressSlim> viewAddresses();
	
	boolean editAddress(AddressSlim addressBookSlim) throws IllegalArgumentException;
	
	boolean deleteAddress(AddressSlim addressBookSlim) throws IllegalArgumentException;
}
