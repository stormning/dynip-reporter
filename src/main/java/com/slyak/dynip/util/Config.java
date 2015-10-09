package com.slyak.dynip.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/10/9.
 */
@ConfigurationProperties(prefix = "cfg")
public class Config {

    private Type type;

    private String serverUrl;


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }
}
