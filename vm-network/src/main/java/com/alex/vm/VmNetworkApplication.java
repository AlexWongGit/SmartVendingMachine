package com.alex.vm;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import java.io.File;
import java.util.Map;

public class VmNetworkApplication {
    public static void main(String[] args) {
        try {
            start(args);
        } catch (Exception e) {
            System.out.println("服务启动失败 " + e);
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private static void start(String[] args) throws ParseException {
        Options options = buildOptions();
        DefaultParser parser = new DefaultParser();
        CommandLine commandLine = parser.parse(options, args);

        String jmqttHome = null;
        String loggerLevel = null;
        if (commandLine != null) {
            loggerLevel = commandLine.getOptionValue("l");
        }

        // 日志配置加载
        try {
            LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
            File file = new File(jmqttHome + File.separator + "log4j2.xml");
            context.setConfigLocation(file.toURI());
            Configuration configuration = context.getConfiguration();
            Map<String, LoggerConfig> loggerConfigMap = configuration.getLoggers();
            Level newLevel = loggerLevel == null? null : Level.getLevel(loggerLevel);
            if (newLevel == null) {
                newLevel = Level.INFO;
            }
            for (LoggerConfig value : loggerConfigMap.values()) {
                value.setLevel(newLevel);
            }
            context.updateLoggers(configuration);
        } catch (Exception ex) {
            System.err.print("Log4j2 load error,ex:" + ex);
        }

    }

    private static Options buildOptions(){
        Options options = new Options();
        Option opt = new Option("h",true,"print help message");
        opt.setRequired(false);
        options.addOption(opt);

        opt = new Option("c",true,"file");
        opt.setRequired(false);
        options.addOption(opt);

        opt = new Option("l",true,"DEBUG");
        opt.setRequired(false);
        options.addOption(opt);

        return options;
    }
}
