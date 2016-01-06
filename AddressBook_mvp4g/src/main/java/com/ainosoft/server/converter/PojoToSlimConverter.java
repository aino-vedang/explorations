package com.ainosoft.server.converter;

import com.ainosoft.server.dao.domain.AddressPojo;
import com.ainosoft.shared.AddressSlim;

public class PojoToSlimConverter {

	private AddressPojo addrPojo;
	
	public PojoToSlimConverter(AddressPojo addressPojo) {
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
