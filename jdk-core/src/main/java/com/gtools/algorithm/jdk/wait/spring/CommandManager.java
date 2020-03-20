package com.gtools.algorithm.jdk.wait.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author ghy
 * @Date 2019/12/10 15:13
 */
@Component("commandManager")
public class CommandManager implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private Command crateCommand() {
        return (Command) this.applicationContext.getBean("asyncCommand");
    }

    public Object process() {
        Command command = crateCommand();
        return command.execute();
    }

    /*private Command prCommand;

    public CommandManager() {
        prCommand = crateCommand();
    }

    public Object processFix() {
        return prCommand.execute();
    }*/

}
