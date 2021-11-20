package com.gabrielfeitosa.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("user")
public class UserProperties {

    private SNS sns;

    public UserProperties(SNS sns) {
        this.sns = sns;
    }

    public SNS getSns() {
        return sns;
    }

    public static class SNS {
        private String newUser;

        public SNS(String newUser) {
            this.newUser = newUser;
        }

        public String getNewUser() {
            return newUser;
        }
    }
}
