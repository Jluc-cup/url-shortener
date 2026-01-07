package com.urlshortener.config;

import java.time.Duration;


import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.support.collections.RedisProperties;

@Configuration
@EnableCaching
public class RedisConfig {

//    @Bean
//    public LettuceConnectionFactory redisConnectionFactory(RedisProperties redisProperties) {
//        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
//        configuration.setHostName(redisProperties.getHost());
//        configuration.setPort(redisProperties.getPort());
//        if (redisProperties.getPassword() != null && !redisProperties.getPassword().isEmpty()) {
//            configuration.setPassword(RedisPassword.of(redisProperties.getPassword()));
//        }
//        configuration.setDatabase(redisProperties.getDatabase());
//        return new LettuceConnectionFactory(configuration);
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory connectionFactory) {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//        StringRedisSerializer stringSerializer = new StringRedisSerializer();
//        GenericJackson2JsonRedisSerializer jsonSerializer = new GenericJackson2JsonRedisSerializer();
//
//        template.setKeySerializer(stringSerializer);
//        template.setHashKeySerializer(stringSerializer);
//        template.setValueSerializer(jsonSerializer);
//        template.setHashValueSerializer(jsonSerializer);
//
//        template.afterPropertiesSet();
//        return template;
//    }
//
//    @Bean
//    public CacheManager cacheManager(LettuceConnectionFactory connectionFactory) {
//        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//            .entryTtl(Duration.ofMinutes(10))
//            .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(
//                new GenericJackson2JsonRedisSerializer()
//            ));
//
//        return RedisCacheManager.builder(connectionFactory)
//            .cacheDefaults(cacheConfiguration)
//            .build();
//    }
}
