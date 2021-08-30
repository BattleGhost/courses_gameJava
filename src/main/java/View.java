package com.company.hwork2;

public class View {

    public static final String INPUT_INT_MESSAGE = "Try to guess number: ";
    public static final String INPUT_WRONG_TYPE_MESSAGE = "Wrong input. Please enter an integer number.";
    public static final String INPUT_WRONG_NUMBER_MESSAGE = "Wrong input. " +
            "Please enter a number only from allowable range.";
    public static final String BOUNDS_START_MESSAGE = "Secret number lies between ";
    public static final String BOUNDS_MIDDLE_MESSAGE = " and ";
    public static final String BOUNDS_END_MESSAGE = " (both not included).";
    public static final String MISS_LOWER_MESSAGE = "Miss. The secret number is lower than yours.";
    public static final String MISS_HIGHER_MESSAGE = "Miss. The secret number is higher than yours.";
    public static final String CORRECT_GUESS = "Congrats! You guessed the secret number.";
    public static final String RESULT_START_MESSAGE = "The secret number was ";
    public static final String RESULT_MIDDLE_MESSAGE = " and it took you ";
    public static final String RESULT_END_MESSAGE = " tries to guess it!";

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showBoundsMessage(String messageStart, String messageMiddle,
                                  String messageEnd, int firstBound, int secondBound) {
        showMessage(messageStart + firstBound + messageMiddle + secondBound + messageEnd);
    }


}
