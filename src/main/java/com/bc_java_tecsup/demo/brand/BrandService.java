package com.bc_java_tecsup.demo.brand;

import com.bc_java_tecsup.demo.notification.contracts.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
  private final NotificationService notificationService;

  public BrandService(@Qualifier("emailNotificationService") NotificationService notifier) {
    this.notificationService = notifier;
  }
}
