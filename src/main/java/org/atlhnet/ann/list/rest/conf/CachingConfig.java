package org.atlhnet.ann.list.rest.conf;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class CachingConfig implements CachingConfigurer {

	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		final EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cmfb.setShared(true);
		return cmfb;
	}

	@Bean
	@Override
	public CacheManager cacheManager() {
		final EhCacheCacheManager cacheManager = new EhCacheCacheManager();
		cacheManager.setCacheManager(ehCacheCacheManager().getObject());
		return cacheManager;
	}

	@Bean
	@Override
	public KeyGenerator keyGenerator() {
		return new SimpleKeyGenerator();
	}

	@Override
	public CacheResolver cacheResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CacheErrorHandler errorHandler() {
		// TODO Auto-generated method stub
		return null;
	}

}
