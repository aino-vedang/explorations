package com.ainosoft.client.addressform;

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

@Presenter(view = AddressFormView.class)
public class AddressFormPresenter extends BasePresenter<AddressFormView, AddressBookEventBus> implements IAddressFormPresenter {

	@Override
	public void bind(){
		view.getSaveBtn().addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent arg0) {
				AddressBookServiceAsync abService = GWT.create(AddressBookService.class);
				AddressSlim a = new AddressSlim(view.getNameText().getText(),view.getStreetText().getText(), view.getCityText().getText(), view.getCountryText().getText(), view.getZipText().getText());
				abService.addAddress(a,new AsyncCallback<Boolean>() {
					
					@Override
					public void onSuccess(Boolean result) {
						String message = "Address Saved Successfully";
						view.displayPopupPanel(message);																		
					}
					
					@Override
					public void onFailure(Throwable caught) {
						String message = "Address Not Saved";
						view.displayPopupPanel(message);
					}
				});
			}
		});
		
		view.getUpdateBtn().addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent arg0) {
				AddressBookServiceAsync abService = GWT.create(AddressBookService.class);
				AddressSlim a = new AddressSlim(view.getAddressSlim().getId(),view.getNameText().getText(),view.getStreetText().getText(), view.getCityText().getText(), view.getCountryText().getText(), view.getZipText().getText());
				abService.editAddress(a,new AsyncCallback<Boolean>() {					
					@Override
					public void onSuccess(Boolean result) {
						String message = "Address Updated Successfully with Id "+view.getAddressSlim().getId();
						view.displayPopupPanel(message);																		
					}					
					@Override
					public void onFailure(Throwable caught) {
						String message = "Address Not Updated";
						view.displayPopupPanel(message);
					}
				});
			}
		});
	}
	
	public void onGetAddressForm(){
		view.createUI();
		eventBus.setAddressForm(view);
	}
	
	public void onGetEditAddressForm(AddressSlim addressSlim){
		view.populateForm(addressSlim);
		eventBus.setAddressForm(view);
	}
	
	public void onUpdateAddressForm(Dictionary dictionary){
		view.changeLanguage(dictionary);
	}
}
