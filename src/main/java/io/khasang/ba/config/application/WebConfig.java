package io.khasang.ba.config.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Основной конфигурационный класс нашего проекта
 */
//  Аннотация делает класс компонентом spring
@Configuration

// Нужно указать где искать другие компоненты нашего приложения @ComponentScan
@ComponentScan({"io.khasang.ba"})

//  Включим mvc
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    // Точка входа
    //Настройка, где будет находится веб часть проекта (где искать веб-странички)
    // @Bean мы добавляем в springContext какой-то класс, который существует в нашем проекте и добавляем его в DI
    @Bean
    public InternalResourceViewResolver viewResolver() {
        //  Это
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        // prefix путь расположения наших веб страниц (war source dir)
        viewResolver.setPrefix("/WEB-INF/views");

        // serSuffix в каком расширении будем искать эти страницы
        viewResolver.setSuffix(".jsp");

        //  contentType
        viewResolver.setContentType("text/html;charset=UTF-8");

        return viewResolver;
    }
}
