package com.token.api.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.token.api.model.Token;

@Service
public class TokenService {		
	
	public String generateToken() {
		dropToken();
		
		Calendar calendar = Calendar.getInstance();
		String newToken = String.valueOf(calendar.getTimeInMillis());
		newToken = newToken.substring(newToken.length() - 5);
		
		Token.getTokenMap().put(calendar, newToken);
		
		return newToken;
	}
	
	@SuppressWarnings("unchecked")
	public boolean validateToken(String json) {
		dropToken();
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> parametersMap = new HashMap<>();
		try {
			parametersMap = objectMapper.readValue(json, Map.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}  
		
		if (!Token.getTokenMap().containsValue(parametersMap.get("token"))) {
			return false;
		}
		
		return true;
	}
	
    private void dropToken() {
        Calendar calendarDrop = Calendar.getInstance();
        calendarDrop.add(Calendar.MINUTE, -1);

        Map<Calendar, String> tokenMap = Token.getTokenMap();

        List<Calendar> tokensToRemove = tokenMap.keySet()
                .stream()
                .filter(c -> c.before(calendarDrop))
                .collect(Collectors.toList());

        tokensToRemove.forEach(tokenMap::remove);

        System.out.println("Tokens removed: " + tokensToRemove.size());
    }
}
