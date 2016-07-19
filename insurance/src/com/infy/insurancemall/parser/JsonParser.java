package com.infy.insurancemall.parser;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.infy.insurancemall.entity.OrderEntity;

public class JsonParser {
	public OrderEntity parseOrderData(String json) throws Exception {
		
		JSONObject jsonObject = JSONObject.fromObject(json);
		OrderEntity orderEntity = (OrderEntity) JSONObject.toBean(jsonObject,
				OrderEntity.class);
		return orderEntity;
	}
}
