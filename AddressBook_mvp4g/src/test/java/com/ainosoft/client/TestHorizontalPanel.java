package com.ainosoft.client;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.appops.altshared.shared.altcore.InstanceProvider;
import org.appops.json.client.async.ClientCallback;

import com.ainosoft.client.sample.TestAddressBookService;
import com.ainosoft.shared.AddressSlim;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.Inject;

/**
 * @author vedang@ainosoft.com
 * @CreatedOn 07-Oct-2015
 * @Responsibility
 */
public class TestHorizontalPanel extends HorizontalPanel {
	private Button					saveButton;
	private TestAddressBookService	testService;

	Logger							logger	= Logger.getLogger(this.getClass().getCanonicalName());
	private InstanceProvider		instanceProvider;

	public TestHorizontalPanel() {
		saveButton = new Button();

	}

	public void createUi() {
		saveButton.setText("Save Address");
		add(saveButton);
		getSaveButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				AddressSlim aSlim = instanceProvider.getInstance(AddressSlim.class);
				aSlim.setId(1L);
				aSlim.setName("Vedang");
				aSlim.setStreet("JM Road");
				aSlim.setCity("Pune");
				aSlim.setCountry("India");
				aSlim.setZip("411002");
				testService.saveAddress(aSlim, new ClientCallback() {

					@Override
					public void onFailure(Throwable caught) {
						logger.log(Level.WARNING, "Invocation failed :" + caught);
					}

					@Override
					public void onSuccess(Serializable result) {
						if (result instanceof AddressSlim) {
							AddressSlim slim = (AddressSlim) result;
							logger.log(Level.INFO, slim.toString());
						}
					}
				});

			}
		});

		RootPanel.get().add(this);
	}

	public Button getSaveButton() {
		return saveButton;
	}

	@Inject
	public void setInstanceProvider(InstanceProvider instanceProvider) {
		this.instanceProvider = instanceProvider;
	}

	@Inject
	public void setTestService(TestAddressBookService testService) {
		this.testService = testService;
	}
}
