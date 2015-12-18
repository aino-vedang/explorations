package com.ainosoft.client.base;


import com.ainosoft.client.event.AddressBookEventBus;
import com.ainosoft.localization.AddressBookConstants;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = AddressBookBaseView.class)
public class AddressBookBasePresenter extends BasePresenter<AddressBookBaseView, AddressBookEventBus> implements IAddressBookBasePresenter {

	public void bindView(){
		//view.setPresenter(this);
	}
	
	public void onStart() {
		view.createUI();
		eventBus.getNavigator();
		
	}
	
	public void onInit(){
	}
	
	public void onSetNavigator(IsWidget navigator){
		view.addNavigator(navigator);
	}
	
	public void onSetAddressForm(IsWidget addrForm){
			
		view.addAddressForm(addrForm);
	}
	
	public void onSetListPanel(IsWidget listPanel){
		view.addListPanel(listPanel);
	}
	
	public void onUpdateBasePanel(Dictionary dictionary){
		view.changeLanguage(dictionary);
	}
	
	
}
