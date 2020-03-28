package com.acme.jbp.config;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 对象映射器配置
 */
@SpringBootConfiguration
public class OrikaConfig {

    @Bean
    public MapperFactory getFactory(){
        return new DefaultMapperFactory.Builder().build();
    }
}
