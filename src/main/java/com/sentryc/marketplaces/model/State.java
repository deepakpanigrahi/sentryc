package com.sentryc.marketplaces.model;

import java.util.Arrays;
import java.util.Random;

public enum State {
    REGULAR,
    WHITELISTED,
    GREYLISTED,
    BLACKLISTED;

    State() {
    }

    public static State getRandomState() {
        return Arrays.stream(State.values()).toList().get(new Random().nextInt(0, 3));
    }
}
