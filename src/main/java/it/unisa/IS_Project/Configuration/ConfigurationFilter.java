package it.unisa.IS_Project.Configuration;

import it.unisa.IS_Project.WebFilter.NoCacheFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

@Configuration

public class ConfigurationFilter {

    @Bean

    public FilterRegistrationBean noChaceFilter(){

        NoCacheFilter filter = new NoCacheFilter();

        final FilterRegistrationBean filt = new FilterRegistrationBean(filter);
        filt.addUrlPatterns("/*");

        return filt;

    }

}
