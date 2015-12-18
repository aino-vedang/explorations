package com.ainosoft.server;

import java.util.ArrayList;
import java.util.List;

import com.ainosoft.client.AddressBookService;
import com.ainosoft.server.converter.PojoToSlimConverter;
import com.ainosoft.server.converter.SlimToPojoConverter;
import com.ainosoft.server.dao.AddressDao;
import com.ainosoft.server.dao.domain.AddressPojo;
import com.ainosoft.shared.AddressSlim;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class AddressBookServiceImpl extends RemoteServiceServlet implements
		AddressBookService {

	public String greetServer(String input) throws IllegalArgumentException {
		return input;

	}

	@Override
	public boolean addAddress(AddressSlim addressSlim)
			throws IllegalArgumentException {
		try{
			SlimToPojoConverter converter = new SlimToPojoConverter(addressSlim);
			AddressDao aDao = new AddressDao();
			aDao.saveAddress(converter.getPojoFromSlim());
		}catch(Exception e){
			throw e;
		}
		return true;
	}

	@Override
	public List<AddressSlim> viewAddresses() {
		List<AddressSlim> addrSlimList= new ArrayList<AddressSlim>();
		try{			
			PojoToSlimConverter converter;
			AddressDao aDao = new AddressDao();
			List<AddressPojo> aPojoList = aDao.getAddressList();
			for(AddressPojo aPojo : aPojoList){
				converter = new PojoToSlimConverter(aPojo);
				addrSlimList.add(converter.getSlimFromPojo());
			}
		}catch(RuntimeException e){
			throw e;
		}
		
		return addrSlimList;
	}

	@Override
	public boolean editAddress(AddressSlim addressSlim)
			throws IllegalArgumentException {
		try{
			SlimToPojoConverter converter = new SlimToPojoConverter(addressSlim);
			AddressDao aDao = new AddressDao();
			aDao.updateAddress(converter.getPojoFromSlim());
		}catch(Exception e){
			throw e;
		}
		return true;
	}

	@Override
	public boolean deleteAddress(AddressSlim addressSlim)
			throws IllegalArgumentException {
		try{
			SlimToPojoConverter converter = new SlimToPojoConverter(addressSlim);
			AddressDao aDao = new AddressDao();
			aDao.deleteAddress(converter.getPojoFromSlim());
		}catch(Exception e){
			throw e;
		}
		return true;
	}
}
