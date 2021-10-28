package com.gtools.algorithm.jvm;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class JvmArgumentTranslate {
    public static void main(String[] args) {
        String miniwms_ws = "-Dlog.path.prefix=/export/Logs/miniwms-ws/server1 -Ddeploy.app.id=6738 -Ddeploy.app.name=miniwms-ws -Ddeploy.instance.id=2314367 -Ddeploy.data.path=/export/Instances/miniwms-ws -Ddeploy.logs.path=/export/Logs/miniwms-ws -Ddeploy.instance.logs.path=/export/Logs/miniwms-ws/server1 -Dins_id=2314367 -Ddeploy.dynamic.config.dir=/export/Packages/miniwms-ws/20211014145830/WEB-INF/classes -Djava.util.logging.config.file=/export/Instances/miniwms-ws/server1/conf/logging.properties -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager -Djava.library.path=/usr/local/lib -Xms2048m -Xmx2048m -XX:MaxPermSize=512m -XX:+UnlockExperimentalVMOptions -Xmn768M -Xss256k -XX:ParallelGCThreads=4 -XX:+UseParNewGC -XX:+UseConcMarkSweepGC -XX:+ExplicitGCInvokesConcurrent -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=75 -XX:+CMSScavengeBeforeRemark -XX:+CMSParallelRemarkEnabled -Djava.awt.headless=true -Dsun.net.client.defaultConnectTimeout=60000 -Dsun.net.client.defaultReadTimeout=60000 -Djmagick.systemclassloader=no -Dnetworkaddress.cache.ttl=300 -Dsun.net.inetaddr.ttl=300 -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/export/Instances/miniwms-ws/server1/logs -XX:ErrorFile=/export/Instances/miniwms-ws/server1/logs/java_error_%p.log -Djdk.tls.ephemeralDHKeySize=2048 -Djava.protocol.handler.pkgs=org.apache.catalina.webresources -Dorg.apache.catalina.security.SecurityListener.UMASK=0027 -javaagent:/export/pfinder/lib/pfinder-profiler-agent-20210630.jar -Dignore.endorsed.dirs= -Dcatalina.base=/export/Instances/miniwms-ws/server1 -Dcatalina.home=/export/servers/tomcat8.5.32 -Djava.io.tmpdir=/export/Instances/miniwms-ws/server1/temp";
        String miniwms_master = "-Dlog.path.prefix=/export/Logs/miniwms-master -Ddeploy.app.id=6725 -Ddeploy.app.name=miniwms-master -Ddeploy.instance.id=1389988 -Ddeploy.instance.name=server1 -Ddeploy.logs.path=/export/Logs/miniwms-master -Ddeploy.data.path=/export/Data/miniwms-master -Dins_id=1389988 -Ddeploy.instance.logs.path=/export/Logs/miniwms-master -javaagent:/export/pfinder/lib/pfinder-profiler-agent-20210630.jar -Djava.library.path=/usr/local/lib -Xms1024m -Xmx2048m -XX:MaxPermSize=256m -Djava.awt.headless=true -Dsun.net.client.defaultReadTimeout=60000 -Djmagick.systemclassloader=no -Dnetworkaddress.cache.ttl=300 -Dsun.net.inetaddr.ttl=300 -Xms2048m -Xmx2048m -Xmn768m -XX:SurvivorRatio=8 -XX:MetaspaceSize=512m -Xss512k -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:+CMSParallelRemarkEnabled -XX:+UseCMSCompactAtFullCollection -XX:CMSFullGCsBeforeCompaction=0 -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=75 -XX:+CMSClassUnloadingEnabled -XX:+CMSPermGenSweepingEnabled -XX:+PrintClassHistogram -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintHeapAtGC -XX:ParallelGCThreads=2 -Xloggc:/export/Logs/miniwms-master/gc.log -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/export/Logs/miniwms-master/java_pid<pid>.hprof -Dbasedir=/export/Instances/miniwms-master/server1/runtime -Dfile.encoding=UTF-8";
        String zybc_worker = "-Dlog.path.prefix=/export/Logs/zybc-web-worker/server1 -Ddeploy.app.id=52407 -Ddeploy.app.name=zybc-web-worker -Ddeploy.instance.id=2172090 -Ddeploy.data.path=/export/Instances/zybc-web-worker -Ddeploy.logs.path=/export/Logs/zybc-web-worker -Ddeploy.instance.logs.path=/export/Logs/zybc-web-worker/server1 -Dins_id=2172090 -Ddeploy.dynamic.config.dir=/export/Packages/zybc-web-worker/20211021194852/WEB-INF/classes -Djava.util.logging.config.file=/export/Instances/zybc-web-worker/server1/conf/logging.properties -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager -Djava.library.path=/usr/local/lib -Xms4096m -Xmx10240m -XX:MaxPermSize=512m -XX:+UnlockExperimentalVMOptions -Djava.awt.headless=true -Dsun.net.client.defaultConnectTimeout=60000 -Dsun.net.client.defaultReadTimeout=60000 -Djmagick.systemclassloader=no -Dnetworkaddress.cache.ttl=300 -Dsun.net.inetaddr.ttl=300 -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/export/Instances/zybc-web-worker/server1/logs -XX:ErrorFile=/export/Instances/zybc-web-worker/server1/logs/java_error_%p.log -Djdk.tls.ephemeralDHKeySize=2048 -Djava.protocol.handler.pkgs=org.apache.catalina.webresources -Dorg.apache.catalina.security.SecurityListener.UMASK=0027 -javaagent:/export/pfinder/lib/pfinder-profiler-agent-1.0.8-20210118054705-d396982c.jar -Dignore.endorsed.dirs= -Dcatalina.base=/export/Instances/zybc-web-worker/server1 -Dcatalina.home=/export/servers/tomcat8.5.32 -Djava.io.tmpdir=/export/Instances/zybc-web-worker/server1/temp";
                List<String> list = translateToChinese(miniwms_master);
        if (list != null) {
            list.forEach(System.out::println);
        }
    }

    public static List<String> translateToChinese(String args) {
        List<String> arguments = Arrays.asList(args.split(" "));

        Map<String, String> map = new LinkedHashMap<>();
        Map<String, String> memoryMap = new LinkedHashMap<>();
        List<String> waitList = new LinkedList<>();
        List<String> unknownList = new LinkedList<>();
        List<String> bizList = new LinkedList<>();

        for (String argument : arguments) {
            if (argument.contains("-D")) {
                bizList.add(argument);
            } else if (argument.contains("-XX")) {
                if (argument.contains("=")) {
                    String[] temps = argument.split("=");
                    if (temps.length == 2) {
                        String value = JvmArgumentDictionary.translateArgument2Meaning(temps[0]);
                        if (!JvmArgumentDictionary.UNKNOWN_ARGUMENT.equals(value)) {
                            map.put(argument, value);
                        } else {
                            waitList.add(argument);
                        }
                    } else {
                        waitList.add(argument);
                    }
                } else if (argument.contains(":")) {
                    String value = JvmArgumentDictionary.translateArgument2Meaning(argument);
                    if (!JvmArgumentDictionary.UNKNOWN_ARGUMENT.equals(value)) {
                        map.put(argument, value);
                    } else {
                        waitList.add(argument);
                    }
                } else {
                    waitList.add(argument);
                }
            } else if (argument.contains("-X")) {
                if(argument.contains(":")){
                    String value = JvmArgumentDictionary.translateArgument2Meaning(argument.split(":")[0]);
                    if (!JvmArgumentDictionary.UNKNOWN_ARGUMENT.equals(value)) {
                        map.put(argument, value);
                    } else {
                        waitList.add(argument);
                    }
                }else {
                    String value = JvmArgumentDictionary.translateArgument2Meaning(argument);
                    if (!JvmArgumentDictionary.UNKNOWN_ARGUMENT.equals(value)) {
                        memoryMap.put(argument, value);
                    } else {
                        unknownList.add(argument);
                    }
                }
            } else if (argument.contains("-javaagent")) {
                bizList.add(argument);
            } else {
                unknownList.add(argument);
            }

        }
        List<String> translateList = new LinkedList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                translateList.add(entry.getKey());
            } else {
                translateList.add(entry.getKey() + "【" + entry.getValue() + "】");
            }
        }
        List<String> memoryList = new LinkedList<>();
        for (Map.Entry<String, String> entry : memoryMap.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                memoryList.add(entry.getKey());
            } else {
                memoryList.add(entry.getKey() + "【" + entry.getValue() + "】");
            }
        }

        List<String> responses = new LinkedList<>();
        responses.add("---------------------------------------------------------------------------------translateList----");
        responses.addAll(translateList);
        responses.add("---------------------------------------------------------------------------------memoryList----");
        responses.addAll(memoryList);
        responses.add("---------------------------------------------------------------------------------waitList----");
        responses.addAll(waitList);
        responses.add("---------------------------------------------------------------------------------unknownList----");
        responses.addAll(unknownList);
        responses.add("---------------------------------------------------------------------------------javaArgumentList----");
        responses.addAll(bizList);
        return responses;
    }
}
