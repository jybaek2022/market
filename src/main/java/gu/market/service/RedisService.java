package gu.market.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import gu.market.repository.model.Product;

@Service
public class RedisService {
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private String getProductionInformationKey(int start, int cnt) {
		return "allProduction/" + start + "/" + cnt;
	}

	// redis에 품목 정보 등록하기
	public void setProductInfomation(int start, int cnt, List<Product> productList) {
		ValueOperations<String, Object> setOP = (ValueOperations<String, Object>) redisTemplate.opsForValue();
		String key = getProductionInformationKey(start, cnt);
		String json = Product.arrayToJson(productList);
		setOP.set(key, json, 30, TimeUnit.SECONDS);
	}

	// redis에 품목 정보 가져오기
	public List<Product> getProductInfomation(int start, int cnt) {
		String key = getProductionInformationKey(start, cnt);
		ValueOperations<String, Object> setOP = (ValueOperations<String, Object>) redisTemplate.opsForValue();
		String json = (String) setOP.get(key);
		if (json != null) {
			List<Product> list = Product.jsonToProductList(json);
			return list;
		}
		return null;
	}
}