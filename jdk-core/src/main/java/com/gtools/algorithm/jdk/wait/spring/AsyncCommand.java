package com.gtools.algorithm.jdk.wait.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author ghy
 * @Date 2019/12/10 15:13
 */
@Component
@Scope("prototype")
public class AsyncCommand implements Command {
    @Override
    public Object execute() {
        return this;
    }
}
