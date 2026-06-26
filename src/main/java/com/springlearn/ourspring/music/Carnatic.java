package com.springlearn.ourspring.music;

import org.springframework.stereotype.Component;

@Component
public class Carnatic implements  Music{
    @Override
    public String getMusicTheme() {
        return "Carnatic music is always ultra soothing. The calmness providing to the brain is unreal!!";
    }
}
