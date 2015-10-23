package com.ainosoft.server.binding;

import java.util.concurrent.ConcurrentSkipListMap;

import org.appops.common.service.Initializer;
import org.appops.core.annotation.InitializationOrder;
import org.appops.core.provision.ServiceModule;
import org.appops.shared.altcore.StaticsRegistry;

import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.AbstractMatcher;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import com.google.inject.util.Types;

/**
 * @author vedang@ainosoft.com
 * @CreatedOn 08-Oct-2015
 * @Responsibility
 */
public class AddressBookGuiceModule extends ServiceModule {

	/**
	 * @param serv
	 */
	public AddressBookGuiceModule() {
		super("addressbook");
	}

	@Override
	public void configureService() {
		bind(StaticsRegistry.class).to(AddressBookStaticRegistryStore.class).in(Singleton.class);
		final ConcurrentSkipListMap<Integer, Class<? extends Initializer>> initializationMap = new ConcurrentSkipListMap<Integer, Class<? extends Initializer>>();

		bindListener(new AbstractMatcher<TypeLiteral<?>>() {
			@Override
			public boolean matches(TypeLiteral<?> typeLiteral) {
				return Initializer.class.isAssignableFrom(typeLiteral.getRawType());
			}
		}, new TypeListener() {
			@Override
			public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {
				if (type.getRawType().isAnnotationPresent(InitializationOrder.class)) {
					Integer initializationOrder = type.getRawType().getAnnotation(InitializationOrder.class).order();

					initializationMap.put(initializationOrder, (Class<? extends Initializer>) type.getType());
				}

			}
		});

		bind((TypeLiteral) TypeLiteral.get(Types.mapOf(Integer.class, Initializer.class)))
				.toInstance(initializationMap);
	}

}
