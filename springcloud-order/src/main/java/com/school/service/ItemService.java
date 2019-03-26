package com.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.school.feign.ItemFeignClient;
import com.school.pojo.Item;

@Service
public class ItemService {

	// Spring框架对RESTful方式的http请求做了封装，来简化操作
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private ItemFeignClient itemFeignClient;
	
	@HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod") // 进行容错处理
	public Item queryItemById(Long id) {
		return this.itemFeignClient.queryItemById(id);
	}
	
	public Item queryItemByIdFallbackMethod(Long id){ // 请求失败执行的方法
		return new Item(id, "查询商品信息出错!", null, null, null);
	}
	
//	@HystrixCommand(fallbackMethod = "queryItemByIdFallbackMethod") // 进行容错处理
//	public Item queryItemById(Long id) {
//		String serviceId = "springcloud-item";
//		return this.restTemplate.getForObject("http://" + serviceId + "/item/" + id, Item.class);
//	}
	
//	public Item queryItemById(Long id) {
//		String serviceId = "springcloud-item";
//		List<ServiceInstance> instances = this.discoveryClient.getInstances(serviceId);
//		if(instances.isEmpty()){
//			return null;
//		}
//		// 为了演示，在这里只获取一个实例
//		ServiceInstance serviceInstance = instances.get(0);
//		String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
//		return this.restTemplate.getForObject("http://" + url + "/item/" + id, Item.class);
//	}

	//硬编码
//	public Item queryItemById(Long id) {
//		return this.restTemplate.getForObject("http://127.0.0.1:8081/item/" + id, Item.class);
//	}
	
}
