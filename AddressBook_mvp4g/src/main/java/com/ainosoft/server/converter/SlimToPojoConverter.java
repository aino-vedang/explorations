package com.ainosoft.server.converter;

import com.ainosoft.server.dao.domain.AddressPojo;
import com.ainosoft.shared.AddressSlim;

public class SlimToPojoConverter {
	
	private AddressSlim addrSlim;
	
	public SlimToPojoConverter(AddressSlim addressSlim) {
		addrSlim = addressSlim;
	}

	public AddressPojo getPojoFromSlim(){
		AddressPojo aPojo =null;
		if(addrSlim.getId() == null){
			aPojo = new AddressPojo(addrSlim.getName(), addrSlim.getStreet(), addrSlim.getCity(), addrSlim.getCountry(), addrSlim.getZip());
		}
		else{
			aPojo = new AddressPojo(addrSlim.getId(),addrSlim.getName(), addrSlim.getStreet(), addrSlim.getCity(), addrSlim.getCountry(), addrSlim.getZip());
		}
			
		return aPojo;
	}
}
