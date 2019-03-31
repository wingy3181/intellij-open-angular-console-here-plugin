package com.wingcheongyip.action;

import java.io.File;

import com.intellij.notification.NotificationType;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.SystemInfo;
import com.intellij.openapi.vfs.VirtualFile;

import org.jetbrains.annotations.NotNull;

import com.wingcheongyip.executor.CommandExecutor;
import com.wingcheongyip.executor.MacExecutor;
import com.wingcheongyip.executor.WinExecutor;
import com.wingcheongyip.util.FileUtil;
import com.wingcheongyip.util.NotificationTool;

public class OpenAngularConsoleHereAction extends AnAction {
    public static final String PLUGIN_NAME = "OpenAngularConsoleHereAction";

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Project project = event.getProject();
        if (project == null) {
            return;
        }

        if (!isProjectAngularJsonExist(event.getProject())) {
            NotificationTool.notify(project, PLUGIN_NAME,
                    "Folder selected to 'Open Angular Console Here' does not contain 'angular.json'.", NotificationType.INFORMATION);
            return;
        }

        perform(project);
    }

    @Override
    public void update(@NotNull AnActionEvent event) {
        boolean isVisible = isProjectAngularJsonExist(event.getProject());
        event.getPresentation().setVisible(isVisible);
    }

    private boolean isProjectAngularJsonExist(Project project) {
        VirtualFile selectedFile = FileUtil.getSelectedProjectFile(project);
        return (selectedFile!=null && new File(selectedFile.getPath() + "/angular.json").exists());
    }

    private void perform(Project project) {
        VirtualFile selectedFile = FileUtil.getSelectedProjectFile(project);
        if (selectedFile == null) {
            return;
        }

        String targetPath = selectedFile.getPath();
        CommandExecutor executor = null;
        if (SystemInfo.isMac) {
            executor = new MacExecutor(targetPath);
        } else if (SystemInfo.isWindows) {
            executor = new WinExecutor(targetPath);
        }

        if (executor == null) {
            NotificationTool.notify(project, PLUGIN_NAME,
                    "Your operating system is not supported temporarily.", NotificationType.ERROR);
            return;
        }

        executor.openAngularConsole();
    }
}
