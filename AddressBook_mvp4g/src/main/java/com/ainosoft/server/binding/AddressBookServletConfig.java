package com.ainosoft.server.binding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.appops.common.service.Initializer;
import org.appops.entities.hibernate.HibernateServiceModule;
import org.appops.invoker.bindings.InvokerServletModule;
import org.appops.invoker.call.ServiceCallStack;
import org.appops.invoker.call.lifecycle.Call;
import org.appops.search.module.SearchModule;
import org.appops.server.UiAppopsGuiceModule;
import org.appops.server.binding.JsonizerModule;
import org.appops.services.service.ServicesServiceModule;
import org.appops.shared.altcore.altoperations.AltInterface;
import org.appops.shared.altcore.altoperations.AltOperation;
import org.appops.shared.altcore.altutil.AltAppOpsException;
import org.appops.shared.altdto.AltService;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletScopes;
import com.google.inject.util.Types;

/**
 * @author vedang@ainosoft.com
 * @CreatedOn 08-Oct-2015
 * @Responsibility
 */
public class AddressBookServletConfig extends GuiceServletContextListener {

	static class InitializerUtil implements Callable<Initializer> {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.concurrent.Callable#call()
		 */
		@SuppressWarnings("unchecked")
		@Override
		public Initializer call() throws Exception {
			final ConcurrentSkipListMap<Integer, Class<? extends Initializer>> initializationMap = (ConcurrentSkipListMap<Integer, Class<? extends Initializer>>) injector
					.getInstance(Key.get(Types.mapOf(Integer.class, Initializer.class)));

			for (Integer initializationOrder : initializationMap.keySet()) {
				injector.getInstance(initializationMap.get(initializationOrder)).init();

			}
			return null;
		}

	}

	static Injector	injector;

	// Only top level modules should be added to this list
	protected Set<Class<? extends Module>> discoverModulesOnClassPath() {

		// Scan classpath to identify modules
		//

		final Set<Class<? extends Module>> guiceModules = null;

		return guiceModules;
	}

	@Override
	protected Injector getInjector() {

		injector = Guice.createInjector(new ServicesServiceModule(), new HibernateServiceModule(),
				new JsonizerModule(), new InvokerServletModule(), new UiAppopsGuiceModule(), new SearchModule(),
				new AddressBookGuiceModule());

		final AltService platformService = new AltService("org_appops_platform");
		final AltInterface platformInterface = new AltInterface("platform_interface", platformService);
		final AltOperation platformOperation = new AltOperation("initialization_operation", platformInterface);

		final ServiceCallStack stack = new ServiceCallStack();
		final Call call = new Call(platformOperation, null);
		stack.add(call);

		final HashMap<Key<?>, Object> map = new HashMap<Key<?>, Object>();
		map.put(Key.get(ServiceCallStack.class), stack);

		final Map<Key<?>, Object> imap = ImmutableMap.copyOf(map);

		final Callable<?> callable = injector.getInstance(InitializerUtil.class);

		final Callable<?> initializer = ServletScopes.scopeRequest(callable, imap);

		try {
			final ExecutorService executor = Executors.newSingleThreadExecutor();
			executor.submit(initializer);
			executor.shutdown();
			executor.awaitTermination(1000, TimeUnit.SECONDS);
		} catch (final Exception ex) {
			throw new AltAppOpsException("Failed to create initializer servlet scope");
		}

		return injector;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Set<? extends Module> getPlatformCommonModules() {

		final Set<? extends Module> moduleSet = new HashSet();

		return moduleSet;

	}

}
