package com.fabao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableScheduling
public class OpenapiApplication implements EmbeddedServletContainerCustomizer {

    //使用命令行启动的ip和端口 -ip 127.0.0.1 -port 8087
    private static int httpPort;
    private static String ip;

    public static void main(String[] args) {
        if (args != null && args.length > 1) {
            ip = args[1];
            httpPort = Integer.parseInt(args[3]);
        } else {
            System.exit(0);
        }
        SpringApplication.run(OpenapiApplication.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        try {
            configurableEmbeddedServletContainer.setAddress(InetAddress.getByName(ip));
            configurableEmbeddedServletContainer.setPort(httpPort);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
