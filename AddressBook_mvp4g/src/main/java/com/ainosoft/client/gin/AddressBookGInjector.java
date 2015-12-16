package com.ainosoft.client.gin;

import org.appops.json.client.binding.JsonizerGinModule;
import org.appops.ui.common.UiAppopsGinModule;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * @author vedang@ainosoft.com
 * @CreatedOn 07-Oct-2015
 * @Responsibility
 */

@GinModules({ JsonizerGinModule.class, UiAppopsGinModule.class, AddressBookGinModule.class })
public interface AddressBookGInjector extends Ginjector {
	public static final AddressBookGInjector	ADDRESS_BOOK_GINJECTOR	= GWT.create(AddressBookGInjector.class);
}
