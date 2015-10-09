<#-- @ftlvariable name="latestIp" type="com.slyak.dynip.util.IpHolder" -->
<html>
    <head></head>
    <body>
        <#if latestIp??>
            IP：${latestIp.ip} 最后更新时间：${latestIp.updateAt?number_to_datetime}
        </#if>
    </body>
</html>