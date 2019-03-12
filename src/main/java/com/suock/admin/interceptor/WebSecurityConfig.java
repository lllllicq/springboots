package com.suock.admin.interceptor;

import com.suock.api.interceptor.CORSInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class WebSecurityConfig extends WebMvcConfigurerAdapter {

    public static final String SESSION_KEY = "user";

    @Bean
    public LoginInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getLoginInterceptor());
        // 以下不拦截
        addInterceptor.excludePathPatterns("/","/api/**","/login.html");
        // 拦截配置
        addInterceptor.addPathPatterns("/**");
        //这里可以添加多个拦截器
        registry.addInterceptor(new CORSInterceptor()).addPathPatterns("/**");//接口，字符编码拦截器
        super.addInterceptors(registry);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //中文乱码解决
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        converters.add(0, stringConverter);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态资源释放
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}