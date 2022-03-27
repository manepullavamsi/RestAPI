package com.user.utlity;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cache.interceptor.KeyGenerator;

public class UserKeyGenrator implements KeyGenerator {

	@Override
	public Object generate(Object target, Method method, Object... params) {
		// TODO Auto-generated method stub
		Object[] objects = params;
		String parm = "";
		for (int i = 0; i < objects.length; i++) {

			if (!(objects[i] instanceof HttpServletRequest)) {

				parm = parm + "_" + objects[i].toString();
			}
		}

//		return target.getClass().toString() + "_" + method.getName().toString() + "_"
//				+ StringUtils.arrayToDelimitedString(params, "_");
		return target.getClass().toString() + "_" + method.getName().toString() + parm;

	}

}
