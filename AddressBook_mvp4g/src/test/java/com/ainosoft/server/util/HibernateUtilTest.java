package com.ainosoft.server.util;

import org.junit.Assert;
import org.junit.Test;

public class HibernateUtilTest {

	@Test
	public void testGetSessionFactory() {
		Assert.assertTrue(HibernateUtil.getSessionFactory()!=null);
	}

}
