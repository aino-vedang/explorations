package com.ainosoft.server.converter;

import com.ainosoft.server.dao.domain.Address;
import com.ainosoft.shared.AddressSlim;

public class SlimToPojoConverter {
	
	private AddressSlim addrSlim;
	
	public SlimToPojoConverter(AddressSlim addressSlim) {
		addrSlim = addressSlim;
	}

	public Address getPojoFromSlim(){
		Address aPojo =null;
		if(addrSlim.getId() == null){
			aPojo = new Address(addrSlim.getName(), addrSlim.getStreet(), addrSlim.getCity(), addrSlim.getCountry(), addrSlim.getZip());
		}
		else{
			aPojo = new Address(addrSlim.getId(),addrSlim.getName(), addrSlim.getStreet(), addrSlim.getCity(), addrSlim.getCountry(), addrSlim.getZip());
		}
			
		return aPojo;
	}
}
