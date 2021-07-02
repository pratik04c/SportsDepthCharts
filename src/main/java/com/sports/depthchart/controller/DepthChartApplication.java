package com.sports.depthchart.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan(basePackages = {"com.sports.depthchart", "..."})
public class DepthChartApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepthChartApplication.class, args);
    }

}