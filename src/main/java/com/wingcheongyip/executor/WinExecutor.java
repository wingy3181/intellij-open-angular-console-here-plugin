package com.wingcheongyip.executor;

import java.io.File;

public class WinExecutor extends CommandExecutor {
    // https://github.com/electron/electron/blob/master/docs/api/app.md#appgetpathname
    private static final String WIN_CMD = "\"" + System.getenv("LOCALAPPDATA") + "\\Programs\\angular-console\\Angular Console.exe\"";

    public WinExecutor(String targetPath) {
        super.targetPath = targetPath;
    }

    @Override
    public String getAngularConsolePath() {
        return WIN_CMD;
    }

    @Override
    public Command buildCommand() {
        String angularConsolePath = this.getAngularConsolePath();
        String[] cmdArr = { angularConsolePath };

        return new Command(cmdArr, null, new File(getTargetPath()));
    }
}