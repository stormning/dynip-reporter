package com.slyak.dynip.controller;

import com.slyak.dynip.util.IpHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * .
 * <p/>
 *
 * @author <a href="mailto:stormning@163.com">stormning</a>
 * @version V1.0, 2015/10/9.
 */
@Controller
@RequestMapping("/ip")
public class IpController {

    private static IpHolder latestIp = new IpHolder("Not upload yet!", 0);

    @RequestMapping("/show")
    public void show(Model model) {
        model.addAttribute("latestIp", latestIp);
    }

    @RequestMapping("/upload")
    @ResponseBody
    public void upload(HttpServletRequest request) {
        latestIp.setIp(getIP(request));
        latestIp.setUpdateAt(System.currentTimeMillis());
    }

    private static String getIP(HttpServletRequest request) {
        String xForwardedFor = request.getHeader("$wsra");
        if (xForwardedFor != null) {
            return xForwardedFor;
        }
        xForwardedFor = request.getHeader("X-Real-IP");
        if (xForwardedFor != null) {
            return xForwardedFor;
        }
        xForwardedFor = request.getHeader("X-Forwarded-For");
        if (xForwardedFor != null) {
            int spaceIndex = xForwardedFor.indexOf(',');
            if (spaceIndex > 0) {
                return xForwardedFor.substring(0, spaceIndex);
            } else {
                return xForwardedFor;
            }
        }
        return request.getRemoteAddr();
    }
}
