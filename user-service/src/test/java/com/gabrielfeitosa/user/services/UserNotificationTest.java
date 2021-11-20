package com.gabrielfeitosa.user.services;


import com.gabrielfeitosa.user.config.UserProperties;
import com.gabrielfeitosa.user.dto.UserDTO;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserNotificationTest {

    @Mock
    private NotificationMessagingTemplate messagingTemplate;
    @Mock
    private UserProperties userProperties;

    @InjectMocks
    private UserNotification userNotification;

    @Test
    public void publishNewUser() {
        var user = new UserDTO();
        when(userProperties.getSns()).thenReturn(new UserProperties.SNS("blah"));
        userNotification.publishNewUser(user);
        verify(messagingTemplate).sendNotification("blah", user, "new user");
    }
}