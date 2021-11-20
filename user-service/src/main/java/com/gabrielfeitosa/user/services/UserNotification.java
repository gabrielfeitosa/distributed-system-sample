package com.gabrielfeitosa.user.services;

import com.amazonaws.services.sns.AmazonSNS;
import com.gabrielfeitosa.user.config.UserProperties;
import com.gabrielfeitosa.user.dto.UserDTO;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserNotification {

    private NotificationMessagingTemplate messagingTemplate;
    private UserProperties userProperties;

    public UserNotification(AmazonSNS amazonSNS, UserProperties userProperties) {
        this.messagingTemplate = new NotificationMessagingTemplate(amazonSNS);
        this.userProperties = userProperties;
    }

    public void publishNewUser(UserDTO user) {
        messagingTemplate.sendNotification(userProperties.getSns().getNewUser(), user, "new user");
    }
}
