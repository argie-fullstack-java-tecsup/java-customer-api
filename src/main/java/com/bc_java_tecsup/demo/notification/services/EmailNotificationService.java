package com.bc_java_tecsup.demo.notification.services;

import com.bc_java_tecsup.demo.notification.contracts.NotificationService;
import org.springframework.stereotype.Service;

@Service // Aca no uso @ Primary porque se esta inyectando con @Qualifier
public class EmailNotificationService implements NotificationService {

  @Override
  public void notifyServ(String msg) {
    System.out.println("[" + getClass().getSimpleName() + "] enviar email: " + msg);  }
}
