package com.geeklib.tango.websocket;

import java.util.Map;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.geeklib.tango.entity.Project;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ServerEncoder implements Encoder.Text<Map<String, String>> {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String encode(Map<String, String> message) throws javax.websocket.EncodeException {
		Gson gson = new Gson();
		String json = gson.toJson(message);
		
		return json;
	}


}
