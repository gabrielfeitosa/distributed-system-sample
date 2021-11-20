package com.gabrielfeitosa.user.services;

import com.gabrielfeitosa.user.config.UserProperties;
import com.gabrielfeitosa.user.dto.UserDTO;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserNotification {

    private NotificationMessagingTemplate messagingTemplate;
    private UserProperties userProperties;

    public UserNotification(NotificationMessagingTemplate messagingTemplate, UserProperties userProperties) {
        this.messagingTemplate = messagingTemplate;
        this.userProperties = userProperties;
    }

    public void publishNewUser(UserDTO user) {
        messagingTemplate.sendNotification(userProperties.getSns().getNewUser(), user, "new user");
    }
}
