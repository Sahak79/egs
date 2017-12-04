package com.egs.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by SahakBabayan on 12/5/2017.
 */
@SpringBootApplication(scanBasePackages = {
        "com.egs.comon",
        "com.egs.data",
        "com.egs.web"
})
public class WebApplication extends SpringBootServletInitializer{
    /**
     * in case of application is deployed under traditional server
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class);
    }
}
