package com.springlearn.ourspring.music;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Carnatic implements  Music{

    Carnatic() {
        System.out.println("Starting class " + getClass().getName());
    }

    @Override
    public String getMusicTheme() {
        return "Carnatic music is always ultra soothing. The calmness providing to the brain is unreal!!";
    }

    @PostConstruct
    public void doPostMake() {
        System.out.println("Post creation of class " + getClass().getName());
    }
}
