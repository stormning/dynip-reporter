package com.slyak.dynip.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/10/9.
 */
@Component
public class Task {

    private URL url;
    private Config config;

    @Autowired
    public void init(Config config) {
        this.config = config;
        try {
            url = new URL(config.getServerUrl() + "/ip/upload");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "30 * * * * ?")
    public void report() {
        if (config.getType() == Type.CLIENT) {
            System.out.print("posting.....");
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setUseCaches(false);
                connection.setRequestMethod("GET");
                connection.setReadTimeout(5000);
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    System.out.print("Connection OK.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        }
    }
}
