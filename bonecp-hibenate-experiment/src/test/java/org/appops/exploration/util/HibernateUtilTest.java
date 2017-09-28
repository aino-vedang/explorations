package org.appops.exploration.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * @author vedang@ainosoft.com
 * @Responisibility :
 * @CreatedOn : 28-Sep-2017
 */
public class HibernateUtilTest {

	/**
	 * Test method for {@link org.appops.exploration.util.HibernateUtil#getSessionFactory()}.
	 */
	@Test
	public void testGetSessionFactory() {
		assertNotNull(HibernateUtil.getSessionFactory());
	}

}
