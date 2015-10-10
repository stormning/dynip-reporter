package com.slyak.dynip.util;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/10/9.
 */
public class IpHolder {

    private String ip;
    private long updateAt;

    public IpHolder(String ip, long updateAt) {
        this.ip = ip;
        this.updateAt = updateAt;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public String getIp() {
        return ip;
    }

    public long getUpdateAt() {
        return updateAt;
    }
}
