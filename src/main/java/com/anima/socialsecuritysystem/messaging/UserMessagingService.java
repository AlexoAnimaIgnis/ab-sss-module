package com.anima.socialsecuritysystem.messaging;

import com.anima.socialsecuritysystem.entities.model.User;

public interface UserMessagingService {

    void sendUser(User user);
}
