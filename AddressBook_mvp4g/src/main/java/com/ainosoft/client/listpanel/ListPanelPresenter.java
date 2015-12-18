package com.ainosoft.client.listpanel;

import java.util.List;

import com.ainosoft.client.AddressBookService;
import com.ainosoft.client.AddressBookServiceAsync;
import com.ainosoft.client.event.AddressBookEventBus;
import com.ainosoft.shared.AddressSlim;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = ListPanelView.class)
public class ListPanelPresenter extends BasePresenter<ListPanelView, AddressBookEventBus> implements IListPanelPresenter {

	
	
	public void onGetListPanel(){
		AddressBookServiceAsync abService = GWT.create(AddressBookService.class);
		abService.viewAddresses(new AsyncCallback<List<AddressSlim>>() {
			
			@Override
			public void onSuccess(List<AddressSlim> result) {
				int rowIndex = 1;
				view.populateFlex();
				for(AddressSlim addrSlim : result){
					eventBus.getAddressDisplayer(addrSlim,rowIndex++);
					
				}
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				String msg = "Error in Fetching list from Database : \n"+caught.getMessage();
				view.displayPopupPanel(msg);
			}
		});
		
		
		
		eventBus.setListPanel(view);
	}
	
	public void onSetAddressDisplayer(IsWidget aDisplayer,int rowIndex){
		view.addDisplayer(aDisplayer,rowIndex);
	}
	
	public void onRefreshListPanel(){
		view.refreshFlexTable();
		onGetListPanel();
	}
	
	public void onUpdateListPanel(Dictionary dictionary){
		view.changeLanguage(dictionary);
		
	}
}
