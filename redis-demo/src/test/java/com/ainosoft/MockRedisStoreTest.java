package com.ainosoft;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MockRedisStoreTest {

	private MockRedisStore mockRedisStore;

	@Before
	public void setUp() {
		mockRedisStore = new MockRedisStore();
		mockRedisStore.configureStore();

	}

	@Test
	public void testGetRSetMultimap() {
		assertNotNull(mockRedisStore.getRSetMultimap());
	}

	@Test
	public void testGetRMap() {
		assertNotNull(mockRedisStore.getRMap());
	}

	@Test
	public void testAddItemToRSetMultimap() {
		assertTrue(mockRedisStore.getRSetMultimap().put("one", "Amol"));
		assertTrue(mockRedisStore.getRSetMultimap().put("two", "Vedang"));

		assertTrue(mockRedisStore.getRSetMultimap().get("one").contains("Amol"));
		assertTrue(mockRedisStore.getRSetMultimap().get("two").contains("Vedang"));
	}

	@Test
	public void testRemoveFromRSetMultimap() {
		assertTrue(mockRedisStore.getRSetMultimap().put("one", "Amol"));
		assertTrue(mockRedisStore.getRSetMultimap().put("two", "Vedang"));

		Set<Object> removedItems = mockRedisStore.getRSetMultimap().removeAll("one");
		assertTrue(removedItems != null);
		assertTrue(!removedItems.isEmpty());

		removedItems = mockRedisStore.getRSetMultimap().removeAll("two");
		assertTrue(removedItems != null);
		assertTrue(!removedItems.isEmpty());

		assertFalse(mockRedisStore.getRSetMultimap().get("one").contains("Amol"));
		assertFalse(mockRedisStore.getRSetMultimap().get("two").contains("Vedang"));

		assertTrue(mockRedisStore.getRSetMultimap().put("one", "Amol"));
		assertTrue(mockRedisStore.getRSetMultimap().put("two", "Vedang"));

		assertEquals(2, mockRedisStore.getRSetMultimap().fastRemove("one", "two"));

		assertFalse(mockRedisStore.getRSetMultimap().get("one").contains("Amol"));
		assertFalse(mockRedisStore.getRSetMultimap().get("two").contains("Vedang"));

	}

	@Test
	public void testAddItemToRMap() {
		mockRedisStore.getRMap().put("one", "Ajay");
		mockRedisStore.getRMap().put("two", "Kunal");

		assertEquals("Ajay", mockRedisStore.getRMap().get("one"));
		assertEquals("Kunal", mockRedisStore.getRMap().get("two"));

	}

	@Test
	public void testRemoveItemFromRMap() {
		mockRedisStore.getRMap().put("one", "Ajay");
		mockRedisStore.getRMap().put("two", "Kunal");

		assertEquals("Ajay", mockRedisStore.getRMap().remove("one"));
		assertEquals("Kunal", mockRedisStore.getRMap().remove("two"));

		assertFalse(mockRedisStore.getRMap().containsKey("one"));
		assertFalse(mockRedisStore.getRMap().containsKey("two"));

		mockRedisStore.getRMap().put("one", "Ajay");
		mockRedisStore.getRMap().put("two", "Kunal");

		assertEquals(2, mockRedisStore.getRMap().fastRemove("one", "two"));
		assertFalse(mockRedisStore.getRMap().containsKey("one"));
		assertFalse(mockRedisStore.getRMap().containsKey("two"));

	}

	@Test
	public void testAddItemToRSet() {
		mockRedisStore.getRSet().add("Ajay");
		mockRedisStore.getRSet().add("Kunal");

		assertTrue(mockRedisStore.getRSet().contains("Ajay"));
		assertTrue(mockRedisStore.getRSet().contains("Kunal"));

	}

	@Test
	public void testRemoveItemFromRSet() {
		mockRedisStore.getRSet().add("Ajay");
		mockRedisStore.getRSet().add("Kunal");

		assertTrue(mockRedisStore.getRSet().remove("Ajay"));
		assertTrue(mockRedisStore.getRSet().remove("Kunal"));

		assertFalse(mockRedisStore.getRSet().contains("Ajay"));
		assertFalse(mockRedisStore.getRSet().contains("Kunal"));

	}

	@Test
	public void testAddItemToRList() {
		mockRedisStore.getRList().add("Ajay");
		mockRedisStore.getRList().add("Kunal");

		assertTrue(mockRedisStore.getRList().contains("Ajay"));
		assertTrue(mockRedisStore.getRList().contains("Kunal"));

	}

	@Test
	public void testRemoveItemFromRList() {
		mockRedisStore.getRList().add("Ajay");
		mockRedisStore.getRList().add("Kunal");

		assertTrue(mockRedisStore.getRList().remove("Ajay"));
		assertTrue(mockRedisStore.getRList().remove("Kunal"));

		assertFalse(mockRedisStore.getRList().contains("Ajay"));
		assertFalse(mockRedisStore.getRList().contains("Kunal"));

	}

	@After
	public void tearDown() {
		mockRedisStore.getRMap().clear();
		mockRedisStore.getRSetMultimap().clear();
		mockRedisStore.getRSet().clear();
		mockRedisStore.getRList().clear();
	}

}
