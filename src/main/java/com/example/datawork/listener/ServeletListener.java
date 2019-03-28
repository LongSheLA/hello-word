package com.example.datawork.listener;

import com.example.datawork.utils.CloudFoundryUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * monitor the servlet container
 */
@WebListener("ServletListener")
public class ServeletListener implements ServletContextListener {
    public ServeletListener() {}

    /**
     * The method to be executed before servlet initialised
     */
    @Override
    public void contextInitialized(ServletContextEvent e){
        try {
            System.out.println("----------------Servlet Initialised.-----------------");
            CloudFoundryUtil.getDatabaseAndRabbitInfoFromEnv();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * The method to be executed before servlet destroyed
     */
    @Override
    public void contextDestroyed(ServletContextEvent e) {
        System.out.println("------------------------Servlet Destroyed.-------------------");
    }
}
