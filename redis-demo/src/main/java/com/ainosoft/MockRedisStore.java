package com.ainosoft;

import org.redisson.Redisson;
import org.redisson.api.RList;
import org.redisson.api.RMap;
import org.redisson.api.RSet;
import org.redisson.api.RSetMultimap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class MockRedisStore {

	private RedissonClient					redisson;
	private RSetMultimap<Object, Object>	setMultimap;
	private RMap<Object, Object>			rMap;
	private RSet<Object>					rSet;
	private RList<Object>					rList;

	public MockRedisStore() {

	}

	public void configureStore() {
		Config config = new Config();
		config.useClusterServers().addNodeAddress("redis://10.10.10.113:6379", "redis://10.10.10.112:6381",
				"redis://10.10.10.114:6380");

		redisson = Redisson.create(config);

	}

	public RSetMultimap<Object, Object> getRSetMultimap() {
		if (setMultimap == null) {
			setMultimap = redisson.getSetMultimap("mockSetMultimap");
		}
		return setMultimap;
	}

	public RMap<Object, Object> getRMap() {
		if (rMap == null) {
			rMap = redisson.getMap("mockMap");
		}
		return rMap;

	}

	public RSet<Object> getRSet() {
		if (rSet == null) {
			rSet = redisson.getSet("mockSet");
		}
		return rSet;
	}

	public RList<Object> getRList() {
		if (rList == null) {
			rList = redisson.getList("mockList");
		}
		return rList;
	}

}
