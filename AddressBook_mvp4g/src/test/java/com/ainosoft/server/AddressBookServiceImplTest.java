package com.ainosoft.server;

import java.util.List;

import org.junit.Test;

import com.ainosoft.shared.AddressSlim;

public class AddressBookServiceImplTest {

	
	@Test
	public void testAddAddress() {
		
		AddressSlim addressSlim = new AddressSlim("Prasad", "JM Raod", "Mumbai", "India", "411032");
		AddressBookServiceImpl impl = new AddressBookServiceImpl();
		impl.addAddress(addressSlim);
		
		List<AddressSlim> addrList =impl.viewAddresses();

		for(AddressSlim addr: addrList){
			if(addr.getName().equals("Prasad")){
				addressSlim = addr;
			}
		}
		
		impl.deleteAddress(addressSlim);
		
	}

	@Test
	public void testViewAddresses() {
		
	}

	@Test
	public void testEditAddress() {
		AddressBookServiceImpl impl = new AddressBookServiceImpl();
		
		AddressSlim addressSlim = new AddressSlim("Amar", "JM Raod", "Mumbai", "India", "411032");
		impl.addAddress(addressSlim);
				
		List<AddressSlim> addrList =impl.viewAddresses();
		
		for(AddressSlim addr: addrList){
			if(addr.getName().equals("Amar")){
				addressSlim = addr;
			}
		}
		addressSlim.setCity("Pune");
		impl.editAddress(addressSlim);
		impl.deleteAddress(addressSlim);		
	}

	@Test
	public void testDeleteAddress() {		
		AddressBookServiceImpl impl = new AddressBookServiceImpl();
		
		AddressSlim addressSlim = new AddressSlim("Amar", "JM Raod", "Mumbai", "India", "411032");
		impl.addAddress(addressSlim);
				
		List<AddressSlim> addrList =impl.viewAddresses();
		
		for(AddressSlim addr: addrList){
			if(addr.getName().equals("Amar")){
				addressSlim = addr;
			}
		}
		
		impl.deleteAddress(addressSlim);
	}

}
