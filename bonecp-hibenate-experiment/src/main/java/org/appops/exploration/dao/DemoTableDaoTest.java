package org.appops.exploration.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.appops.exploration.dao.domain.DemoTable;
import org.junit.Test;

/**
 * @author vedang@ainosoft.com
 * @Responisibility :
 * @CreatedOn : 28-Sep-2017
 */
public class DemoTableDaoTest {

	/**
	 * Test method for
	 * {@link org.appops.exploration.dao.DemoTableDao#persist(org.appops.exploration.dao.domain.DemoTable)}.
	 */
	@Test
	public void test() {
		DemoTableDao demoTableDao = new DemoTableDao();

		DemoTable demoTable = new DemoTable("testValue1", 1234l);
		DemoTable saved = demoTableDao.persist(demoTable);
		assertNotNull(saved);
		assertEquals("testValue1", demoTable.getDemoTablecol1());
		assertTrue(1234l == demoTable.getDemoTablecol2());

		DemoTable found = demoTableDao.findById(saved.getId());
		assertNotNull(found);
		assertEquals("testValue1", found.getDemoTablecol1());
		assertTrue(1234l == found.getDemoTablecol2());

		assertTrue(demoTableDao.delete(saved));
	}

}
