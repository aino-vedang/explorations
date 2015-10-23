package com.ainosoft.client;

import org.appops.ui.common.UiAppopsGinModule;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * @author vedang@ainosoft.com
 * @CreatedOn 07-Oct-2015
 * @Responsibility
 */
@GinModules({ TestGinModule.class, UiAppopsGinModule.class })
public interface TestGInjector extends Ginjector {

	TestHorizontalPanel getTestPanel();

}