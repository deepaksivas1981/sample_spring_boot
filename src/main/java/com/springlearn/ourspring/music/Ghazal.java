package com.springlearn.ourspring.music;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class Ghazal implements  Music{

    Ghazal() {
        System.out.println("Starting class " + getClass().getName());
    }

    @Override
    public String getMusicTheme() {
        return "It is so soothing and relaxing!!";
    }
}
