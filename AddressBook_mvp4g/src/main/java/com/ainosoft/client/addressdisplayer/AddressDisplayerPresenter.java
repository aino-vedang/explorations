package com.ainosoft.client.addressdisplayer;


import com.ainosoft.client.AddressBookService;
import com.ainosoft.client.AddressBookServiceAsync;
import com.ainosoft.client.event.AddressBookEventBus;
import com.ainosoft.shared.AddressSlim;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = AddressDisplayerView.class, multiple = true)
public class AddressDisplayerPresenter extends BasePresenter<AddressDisplayerView, AddressBookEventBus> implements IAddressDisplayerPresenter {

	@Override
	public void bind(){
		view.getDelete().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				AddressBookServiceAsync abService = GWT.create(AddressBookService.class);
				abService.deleteAddress(view.getAddrSlim(), new AsyncCallback<Boolean>() {
					
					@Override
					public void onSuccess(Boolean result) {
						String msg = "Address Deleted Successfully with Id = "+view.getAddrSlim().getId();
						view.displayPopupPanel(msg);
						eventBus.refreshListPanel();
					}
					
					@Override
					public void onFailure(Throwable caught) {
						String msg = "Address Not Deleted"+caught.getMessage();
						view.displayPopupPanel(msg);
					}
				});
				
			}
		});
		
		view.getEdit().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				eventBus.getEditAddressForm(view.getAddrSlim());								
			}
		});
	}
	
	public void onGetAddressDisplayer(AddressSlim addrSlim,int rowIndex){
		view.createUI(addrSlim);
		eventBus.setAddressDisplayer(view,rowIndex);
	}
	
	public void onUpdateAddressDisplayer(Dictionary dictionary){
		view.changeLanguage(dictionary);
	}


}
