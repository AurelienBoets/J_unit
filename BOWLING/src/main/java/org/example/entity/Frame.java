package org.example.entity;

public class Frame {
    private Launch launch;
    private int score = 0;
    private int round;
    private int count = 0;
    private int keel = 10;

    private boolean allKeelFallen = false;


    public Frame(Launch launch, int round) {
        this.launch = launch;
        this.round = round;
    }

    public void throwBall() {
        if (round == 10) {
            throwFinal();
            return;
        }
        if (count == 2)
            throw new BowlingException();
        int keelFall = launch.generateLaunch(keel);
        keel -= keelFall;
        score += keelFall;
        if (keel == 0 ) {
            count = 2;
        } else {
            count++;
        }

    }

    private void throwFinal() {
        if (!allKeelFallen && count == 2)
            throw new BowlingException();
        if (count == 3)
            throw new BowlingException();
        int keelFall = launch.generateLaunch(keel);
        keel = keel - keelFall;
        score += keelFall;
        count++;
        if (keel == 0) {
            keel = 10;
            allKeelFallen = true;
        }
    }

    public int getScore() {
        return score;
    }
}
