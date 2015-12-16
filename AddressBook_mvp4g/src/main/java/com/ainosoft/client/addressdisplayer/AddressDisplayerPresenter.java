package com.ainosoft.client.addressdisplayer;

import java.io.Serializable;

import org.appops.json.client.async.ClientCallback;

import com.ainosoft.client.AddressBookService;
import com.ainosoft.client.event.AddressBookEventBus;
import com.ainosoft.shared.AddressSlim;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.Dictionary;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = AddressDisplayerView.class, multiple = true)
public class AddressDisplayerPresenter extends BasePresenter<AddressDisplayerView, AddressBookEventBus> implements
		IAddressDisplayerPresenter {

	@Override
	public void bind() {
		view.getDelete().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				AddressBookService abService = GWT.create(AddressBookService.class);
				abService.deleteAddress(view.getAddrSlim(), new ClientCallback() {

					@Override
					public void onFailure(Throwable caught) {
						String msg = "Address Not Deleted" + caught.getMessage();
						view.displayPopupPanel(msg);
					}

					@Override
					public void onSuccess(Serializable result) {
						String msg = "Address Deleted Successfully with Id = " + view.getAddrSlim().getId();
						view.displayPopupPanel(msg);
						eventBus.refreshListPanel();
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

	public void onGetAddressDisplayer(AddressSlim addrSlim, int rowIndex) {
		view.createUI(addrSlim);
		eventBus.setAddressDisplayer(view, rowIndex);
	}

	public void onUpdateAddressDisplayer(Dictionary dictionary) {
		view.changeLanguage(dictionary);
	}

}
