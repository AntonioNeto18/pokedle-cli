package com.antonio.entity;

import java.util.List;

public class GuessFeedback {

    private String name;
    private List<String> typesFeedback;
    private String heightFeedback;
    private String weightFeedback;

    public GuessFeedback(String name, List<String> typesFeedback, String heightFeedback, String weightFeedback) {
        this.name = name;
        this.typesFeedback = typesFeedback;
        this.heightFeedback = heightFeedback;
        this.weightFeedback = weightFeedback;
    }

    @Override
    public String toString() {
        return "%s | %s | %s | %s".formatted(name, typesFeedback, heightFeedback, weightFeedback);
    }
}
