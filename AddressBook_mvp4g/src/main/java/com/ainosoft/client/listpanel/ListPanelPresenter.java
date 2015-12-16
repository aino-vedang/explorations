package com.ainosoft.client.listpanel;

import java.io.Serializable;
import java.util.ArrayList;

import org.appops.json.client.async.ClientCallback;

import com.ainosoft.client.AddressBookService;
import com.ainosoft.client.event.AddressBookEventBus;
import com.ainosoft.shared.AddressSlim;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.user.client.ui.IsWidget;
import com.mvp4g.client.annotation.Presenter;
import com.mvp4g.client.presenter.BasePresenter;

@Presenter(view = ListPanelView.class)
public class ListPanelPresenter extends BasePresenter<ListPanelView, AddressBookEventBus> implements
		IListPanelPresenter {

	public void onGetListPanel() {
		AddressBookService abService = GWT.create(AddressBookService.class);
		abService.viewAddresses(new ClientCallback() {

			@Override
			public void onFailure(Throwable caught) {
				String msg = "Error in Fetching list from Database : \n" + caught.getMessage();
				view.displayPopupPanel(msg);
			}

			@Override
			public void onSuccess(Serializable result) {
				ArrayList<AddressSlim> slimList = (ArrayList<AddressSlim>) result;
				int rowIndex = 1;
				view.populateFlex();
				if (slimList != null) {
					for (AddressSlim addrSlim : slimList) {
						eventBus.getAddressDisplayer(addrSlim, rowIndex++);

					}
				}
			}
		});

		eventBus.setListPanel(view);
	}

	public void onRefreshListPanel() {
		view.refreshFlexTable();
		onGetListPanel();
	}

	public void onSetAddressDisplayer(IsWidget aDisplayer, int rowIndex) {
		view.addDisplayer(aDisplayer, rowIndex);
	}

	public void onUpdateListPanel(Dictionary dictionary) {
		view.changeLanguage(dictionary);

	}
}
