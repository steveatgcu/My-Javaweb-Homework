package me.shaobin.framework.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import me.shaobin.framework.annotation.RequestMapping;

public class ControllerMapping {
	
	public static Map<String,String> scanMappingInfo(Class<?> reflectClass ){
		Map<String,String> requestMap = new HashMap<String,String>();
		Method[] methods = reflectClass.getDeclaredMethods();
		for(Method method:methods){
			Annotation[] annotations = method.getAnnotations();
			for(Annotation annotation:annotations){
				if(annotation instanceof RequestMapping){
					requestMap.put(((RequestMapping) annotation).value(), method.getName());
					break;
				}
			}
		}
		return requestMap;
	}

}
