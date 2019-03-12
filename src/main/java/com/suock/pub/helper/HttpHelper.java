package com.suock.pub.helper;

import com.suock.admin.model.UrlPermission;
import com.suock.admin.service.UrlPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Component
public class HttpHelper implements ServletContextListener {
    @Autowired
    private RequestMappingHandlerMapping handlerMapping;

    @Autowired
    private UrlPermissionService urlPermissionService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Set<RequestMappingInfo> rmSet = handlerMapping.getHandlerMethods().keySet();
        for (RequestMappingInfo rm : rmSet) {
            if(rm.getPatternsCondition().toString().contains("/api/")){
                String url=rm.getPatternsCondition().toString().replace("[","").replace("]","");
                UrlPermission urlPermission= urlPermissionService.find(url);
                if(urlPermission==null){
                    urlPermission=new UrlPermission();
                    urlPermission.setUrl(url);
                    urlPermissionService.save(urlPermission);
                }
            }
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
