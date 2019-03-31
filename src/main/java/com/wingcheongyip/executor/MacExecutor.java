package com.wingcheongyip.executor;

import java.io.File;

public class MacExecutor extends CommandExecutor {
    private static final String MAC_CMD = "/Applications/Angular Console.app/Contents/MacOS/Angular Console";

    public MacExecutor(String targetPath) {
        setTargetPath(targetPath);
    }

    @Override
    public String getAngularConsolePath() {
        return MAC_CMD;
    }

    @Override
    Command buildCommand() {
        String angularConsolePath = this.getAngularConsolePath();
        String[] cmdArr = { angularConsolePath } ;
        // String[] cmdArr = { "open", "-a", "Angular Console" } ;

        return new Command(cmdArr, null, new File(getTargetPath()));
    }
}