package io.khasang.ba.config;

import io.khasang.ba.config.application.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Аналог web xml , чтоб класс стал классом java конфигурации а не xml то нужно наследовать
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //  Где брать основной конфигурационный классы нашего проекта
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    //  Где взять основной конфигурационный класс servlet'ов
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    //  По умолчанию символ разделения
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
