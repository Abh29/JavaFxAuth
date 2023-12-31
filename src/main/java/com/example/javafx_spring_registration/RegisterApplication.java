package com.example.javafx_spring_registration;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


public class RegisterApplication extends Application {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void start(Stage stage) {
        applicationContext.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void init(){
        applicationContext = new SpringApplicationBuilder(JavafxSpringRegistrationApplication.class).run();
    }

    @Override
    public void stop(){
        applicationContext.close();
        Platform.exit();
    }
}
