package br.com.reflector.domain;

import java.lang.reflect.Field;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.ReflectionUtils;

import br.com.reflector.exception.MissingPropertyException;

public final class Reflector {
	
	private Reflector(){ }
	
	public static Object reflectPrivatePropertyFrom(Object object, String property){
		Field privatePropertyField = retrieveFieldFrom(object, property);
		ReflectionUtils.makeAccessible(privatePropertyField);
		Object result = ReflectionUtils.getField(privatePropertyField, object);
		return result == null ? StringUtils.EMPTY : result;
	}
	
	private static Field retrieveFieldFrom(Object object, String property){
		Field privatePropertyField = ReflectionUtils.findField(object.getClass(), property);
		if (privatePropertyField == null) {
			throw new MissingPropertyException(property + " is missing!");
		}
		return privatePropertyField ;
	}

}
