package com.example.helloworld.listener;

import com.example.helloworld.utils.CloudFoundryUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 项目启动前 监听
 * @author dongdong.jiang
 * @date 2018/9/7 10:29
 */
@WebListener("ServletListener")
public class ServeletListener implements ServletContextListener {
    public ServeletListener() {}

    @Override
    public void contextInitialized(ServletContextEvent e){
        try {
            System.out.println("----------------Servlet Initialiszed.-----------------");
            CloudFoundryUtil.getDatabaseFromSystemVariables();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent e) {
        System.out.println("------------------------Servlet Destroyed.-------------------");
    }
}
