package com.ainosoft.client;

import org.appops.shared.altcore.InstanceProvider;
import org.appops.shared.altcore.altentity.Primitive;
import org.appops.shared.altcore.altentity.type.AltDynamicEntityType;
import org.appops.shared.altcore.altentity.type.AltEntityType;
import org.appops.shared.altcore.altentity.type.AltPropertyType;
import org.appops.shared.altcore.altentity.type.ClientTypeMap;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mvp4g.client.Mvp4gModule;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class addressbook_mvp4g implements EntryPoint {

	private void initialize() {
		AltEntityType addressType = new AltDynamicEntityType("Address");
		addressType.addPropertyType(new AltPropertyType(addressType, "name", Primitive.STRING));
		addressType.addPropertyType(new AltPropertyType(addressType, "age", Primitive.STRING));
		addressType.addPropertyType(new AltPropertyType(addressType, "phone", Primitive.STRING));
		addressType.addPropertyType(new AltPropertyType(addressType, "email", Primitive.STRING));
		ClientTypeMap.getInstance().addType(addressType);

		InstanceProvider instanceProvider = GWT.create(InstanceProvider.class);
		instanceProvider.instantiateAll();

	}

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		initialize();
		Mvp4gModule module = (Mvp4gModule) GWT.create(Mvp4gModule.class);
		module.createAndStartModule();
		RootPanel.get().add((Widget) module.getStartView());
	}
}