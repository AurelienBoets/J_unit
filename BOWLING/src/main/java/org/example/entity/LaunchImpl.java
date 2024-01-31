package org.example.entity;

import org.example.entity.Launch;

import java.util.Random;

public class LaunchImpl implements Launch {
    @Override
    public int generateLaunch(int keel) {
        return new Random().nextInt(keel+1);
    }


}
