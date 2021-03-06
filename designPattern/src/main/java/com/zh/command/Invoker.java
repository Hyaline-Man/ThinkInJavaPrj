package com.zh.command;

import com.zh.command.command.Command;

/**
 * 调用者
 */
public class Invoker {

    private Command command;

    public void doSomething() {
        command.execute();
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
