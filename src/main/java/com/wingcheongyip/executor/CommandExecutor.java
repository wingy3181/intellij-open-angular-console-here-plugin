package com.wingcheongyip.executor;

import java.io.IOException;

public abstract class CommandExecutor {
    protected String targetPath;

    abstract String getAngularConsolePath();
    abstract Command buildCommand();

    public void openAngularConsole() {

        Command cmd = this.buildCommand();

        try {
            Runtime.getRuntime().exec(cmd.getCmdArray(), cmd.getEnvp(), cmd.getDir());
        } catch (IOException e) {
            // ignored
        }
    };

    public String getTargetPath() {
        return targetPath;
    }

    public void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }
}