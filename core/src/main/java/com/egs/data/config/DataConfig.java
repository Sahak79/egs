package com.egs.data.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by SahakBabayan on 12/5/2017.
 */
@Configuration
@PropertySource("classpath:db-config.properties")
@EntityScan("com.egs.common.data.model")
@EnableJpaRepositories("com.egs.data")
@EnableTransactionManagement
public class DataConfig {
}
