package com.ainosoft.server.converter;

import com.ainosoft.server.dao.domain.Address;
import com.ainosoft.shared.AddressSlim;

public class PojoToSlimConverter {

	private Address addrPojo;
	
	public PojoToSlimConverter(Address addressPojo) {
		addrPojo = addressPojo;
	}
	
	public AddressSlim getSlimFromPojo(){
		AddressSlim aSlim =null;
		if(addrPojo.getId() == null){
			aSlim = new AddressSlim(addrPojo.getName(), addrPojo.getStreet(), addrPojo.getCity(), addrPojo.getCountry(), addrPojo.getZip());
		}
		else{
			aSlim = new AddressSlim(addrPojo.getId(),addrPojo.getName(), addrPojo.getStreet(), addrPojo.getCity(), addrPojo.getCountry(), addrPojo.getZip());
		}
			
		return aSlim;
	}
}
