package com.ainosoft.server;

import org.appops.altshared.shared.altdto.AltService;
import org.appops.entities.core.schema.Schema;
import org.appops.entities.hibernate.impls.helper.HibernateSchemaEditingHelper;
import org.appops.entities.hibernate.types.HibernatePojoType;
import org.appops.entities.hibernate.types.HibernateTypeMap;
import org.appops.entities.hibernate.types.TypeMap;
import org.junit.Assert;
import org.junit.Test;

import com.ainosoft.server.dao.domain.Address;

/**
 * @author vedang@ainosoft.com
 * @CreatedOn 06-Oct-2015
 * @Responsibility
 */
public class AddressBookDynamicSchemaCreationTest {

	@Test
	public void testSetUpSchema() {
		AltService addressBookService = new AltService("AddressBook");

		HibernatePojoType addressPojoType = new HibernatePojoType(Address.class);
		addressPojoType.analysePojoClass();

		final TypeMap typeMap = new HibernateTypeMap(addressBookService);
		addressPojoType.setParentStore(typeMap);

		Assert.assertTrue(typeMap.getTypeCount() == 1);
		
		Schema schema = new Schema(typeMap);
		HibernateSchemaEditingHelper helper = new HibernateSchemaEditingHelper(schema);
		helper.setupSchema(true);

	}

}
