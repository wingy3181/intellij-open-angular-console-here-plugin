package com.wingcheongyip.util;

import com.wingcheongyip.action.OpenAngularConsoleHereAction;
import com.intellij.notification.*;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;

public class NotificationTool {
    public static void notify(final Project project, final String title, final String message, final NotificationType notificationType) {
        ApplicationManager.getApplication().runWriteAction(new Runnable() {
                                                               @Override
                                                               public void run() {
                                                                   String groupId = OpenAngularConsoleHereAction.PLUGIN_NAME;
                                                                   NotificationsConfiguration.getNotificationsConfiguration().register(groupId, NotificationDisplayType.BALLOON, false);
                                                                   final Notification notification = new Notification(groupId, title, message,
                                                                           notificationType, null);
                                                                   Notifications.Bus.notify(notification, project);
                                                               }
                                                           }
        );
    }
}