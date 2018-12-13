package com.geeklib.tango.websocket;

import java.io.IOException;
import java.util.Map;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.geeklib.tango.features.entity.Project;

public class ServerEncoder implements Encoder.Text<Map<String, String>> {

	@Override
	public void destroy() {

	}

	@Override
	public void init(EndpointConfig arg0) {

	}
	
	@Override
	public String encode(Map<String, String> message) throws javax.websocket.EncodeException {
		
		
		JsonFactory factory = new JsonFactory();
		JsonParser jsonParser = null;
		try {
			jsonParser = factory.createParser(message.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		String json = null;
		try {
			json = jsonParser.getText();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}


}
