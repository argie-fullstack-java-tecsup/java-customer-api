package com.bc_java_tecsup.demo.notification.services;

import com.bc_java_tecsup.demo.notification.contracts.NotificationService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary // primary aca en SMS
public class SmsNotificationService implements NotificationService {

  @Override
  public void notifyServ(String msg) {
    System.out.println("Enviar email" + msg);
  }
}
