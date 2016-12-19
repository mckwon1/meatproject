package com.meatproject.service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.meatproject.dao.EhCacheDAO;

@Service
public class EhCacheService {

	private final SecureRandom random = new SecureRandom();
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EhCacheDAO ehCacheDAO;
	
	public Map<String, Object> getNormalDataNonCaching(String param) {

        return generateMap(param);
    }

    @Cacheable(value = "normal", key = "#param")
    public Map<String, Object> getNormalDataCaching(String param) {

        return generateMap(param);
    }

    @CacheEvict(value = "normal", key = "#param")
    public Map<String, Object> getNormalDataEraseCache(String param) {

        return generateMap(param);
    }

    @Cacheable(value = "multi-param")
    public Map<String, Object> getNormalDataDefaultKeyStrategy(String param1, String param2, String param3) {

        logger.info("Parameter Values - Param1 : {}, Param2 : {}, Param3 : {}", param1, param2, param3);

        return generateMap(param1);
    }

    public Map<String, String> getMybatisDataNonCaching(Long id) {
    	System.out.println("aaaa");
        return findDataFromDB(id);
    }

    @Cacheable(value = "mybatis", key = "#id")
    public Map<String, String> getMybatisDataCaching(Long id) {

        return findDataFromDB(id);
    }

    /**
     * 임의의 Long 객체 생성하여 Map 에 저장하여 리턴
     *
     * @param param
     * @return
     */
    private Map generateMap(String param) {

        Map<String, Object> map = new HashMap<>();
        map.put("long", random.nextLong());

        logger.info("## PARAM : {}", param);
        logger.info("## RESULT : {}", map);

        return map;
    }

    /**
     * MyBatis Mapper 를 통해 DB 의 해당 데이터 조회하여 리턴
     *
     * @param id
     * @return
     */
    private Map<String, String> findDataFromDB(Long id) {

        Map<String, String> character = ehCacheDAO.ehcaheTest();

        logger.info("PARAM ID : {}", id);
        logger.info("CHARACTER : {}", character);

        return character;
    }
}
