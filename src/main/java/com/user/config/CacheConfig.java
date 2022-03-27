package com.user.config;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.user.utlity.UserKeyGenrator;

@Configuration
//@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {
//	 @Bean
//	 public CacheManager cacheManager() {
//	  List<ConcurrentMapCache> caches = Arrays.asList(new ConcurrentMapCache("myUserCache"));
//	  SimpleCacheManager cacheManager = new SimpleCacheManager();
//	  cacheManager.setCaches(caches);
//	  return cacheManager;
//	 }

	@Override
	@Bean("userKeyGenrator")
	public KeyGenerator keyGenerator() {
		return (Object target, Method method, Object... params)->{
			Object[] objects = params;
			String parm = "";
			for (int i = 0;i < objects.length;i++) {

				if (!(objects[i] instanceof HttpServletRequest)) {

					parm = parm + "_" + objects[i].toString();
				}
			}

//			return target.getClass().toString() + "_" + method.getName().toString() + "_"
//					+ StringUtils.arrayToDelimitedString(params, "_");
			return target.getClass().toString() + "_" + method.getName().toString() + parm;

		};
	}
	}


