package br.com.assertiva.comunika.configurations.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import br.com.assertiva.comunika.configurations.ComunikaUserConfigApplication;

import javax.servlet.Filter;

public class CofigurationsInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { ComunikaUserConfigApplication.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
        Filter[] filter = { new CorsFilter()};
        return filter;
    }

}