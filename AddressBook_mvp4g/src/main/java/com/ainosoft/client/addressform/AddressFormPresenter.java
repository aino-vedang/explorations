package com.ainosoft.client.addressform;

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

@Presenter(view = AddressFormView.class)
public class AddressFormPresenter extends BasePresenter<AddressFormView, AddressBookEventBus> implements
		IAddressFormPresenter {

	@Override
	public void bind() {
		view.getSaveBtn().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				AddressBookService abService = GWT.create(AddressBookService.class);
				AddressSlim aSlim = GWT.create(AddressSlim.class);
				aSlim.setName(view.getNameText().getText());
				aSlim.setStreet(view.getStreetText().getText());
				aSlim.setCity(view.getCityText().getText());
				aSlim.setCountry(view.getCountryText().getText());
				aSlim.setZip(view.getZipText().getText());

				abService.saveAddress(aSlim, new ClientCallback() {

					@Override
					public void onFailure(Throwable caught) {
						String message = "Address Not Saved";
						view.displayPopupPanel(message);
					}

					@Override
					public void onSuccess(Serializable result) {
						String message = "Address Saved Successfully";
						view.displayPopupPanel(message);
					}
				});
			}
		});

		view.getUpdateBtn().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				AddressBookService abService = GWT.create(AddressBookService.class);
				AddressSlim aSlim = GWT.create(AddressSlim.class);
				aSlim.setId(view.getAddressSlim().getId());
				aSlim.setName(view.getNameText().getText());
				aSlim.setStreet(view.getStreetText().getText());
				aSlim.setCity(view.getCityText().getText());
				aSlim.setCountry(view.getCountryText().getText());
				aSlim.setZip(view.getZipText().getText());
				abService.editAddress(aSlim, new ClientCallback() {
					@Override
					public void onFailure(Throwable caught) {
						String message = "Address Not Updated";
						view.displayPopupPanel(message);
					}

					@Override
					public void onSuccess(Serializable result) {
						String message = "Address Updated Successfully with Id " + view.getAddressSlim().getId();
						view.displayPopupPanel(message);
					}
				});
			}
		});
	}

	public void onGetAddressForm() {
		view.createUI();
		eventBus.setAddressForm(view);
	}

	public void onGetEditAddressForm(AddressSlim addressSlim) {
		view.populateForm(addressSlim);
		eventBus.setAddressForm(view);
	}

	public void onUpdateAddressForm(Dictionary dictionary) {
		view.changeLanguage(dictionary);
	}
}
