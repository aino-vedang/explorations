package com.ainosoft.client.event;

import com.ainosoft.client.addressdisplayer.AddressDisplayerPresenter;
import com.ainosoft.client.addressdisplayer.AddressDisplayerView;
import com.ainosoft.client.addressform.AddressFormPresenter;
import com.ainosoft.client.base.AddressBookBasePresenter;
import com.ainosoft.client.listpanel.ListPanelPresenter;
import com.ainosoft.client.navigator.NavigatorPresenter;
import com.ainosoft.shared.AddressSlim;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.annotation.Event;
import com.mvp4g.client.annotation.Events;
import com.mvp4g.client.annotation.InitHistory;
import com.mvp4g.client.annotation.Start;
import com.mvp4g.client.event.EventBusWithLookup;

@Events(startPresenter = AddressBookBasePresenter.class, historyOnStart = true)
public interface AddressBookEventBus extends EventBusWithLookup {

	@Start
	@Event(handlers = {AddressBookBasePresenter.class})
	void start();

	@InitHistory
	@Event(handlers = AddressBookBasePresenter.class)
	void init();
	
	@Event(handlers = {NavigatorPresenter.class})
	void getNavigator();
	
	@Event(handlers = {AddressBookBasePresenter.class})
	void setNavigator(IsWidget navigator);

	@Event(handlers = {AddressFormPresenter.class})
	void getAddressForm();
	
	@Event(handlers = {AddressBookBasePresenter.class})
	void setAddressForm(IsWidget addrForm);

	@Event(handlers = {ListPanelPresenter.class})
	void getListPanel();
	
	@Event(handlers = {AddressBookBasePresenter.class})
	void setListPanel(IsWidget addrForm);

	@Event(/*handlers = {AddressDisplayerPresenter.class},*/generate = AddressDisplayerPresenter.class )
	void getAddressDisplayer(AddressSlim addrSlim, int rowIndex);

	@Event(handlers = {ListPanelPresenter.class})
	void setAddressDisplayer(IsWidget addressDisplayer,int rowIndex);

	@Event(handlers = {ListPanelPresenter.class})
	void refreshListPanel();

	@Event(handlers = {AddressFormPresenter.class})
	void getEditAddressForm(AddressSlim addrSlim);

	@Event(handlers = {AddressBookBasePresenter.class})
	void updateBasePanel(Dictionary dictionary);

	@Event(handlers = {AddressFormPresenter.class})
	void updateAddressForm(Dictionary dictionary);

	@Event(handlers = {ListPanelPresenter.class})
	void updateListPanel(Dictionary dictionary);

	@Event(handlers = {AddressDisplayerPresenter.class})
	void updateAddressDisplayer(Dictionary dictionary);
	
	
}
