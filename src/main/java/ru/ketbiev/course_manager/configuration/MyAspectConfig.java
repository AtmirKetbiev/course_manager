package ru.ketbiev.course_manager.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ru.ketbiev.course_manager.aspect")
@EnableAspectJAutoProxy
public class MyAspectConfig {
}
