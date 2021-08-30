package com.company.hwork2;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        boolean isGameEnded = false;

        while (!isGameEnded) {

            userInput = getUserIntInput(scanner);

            while (!model.isCorrectBoundary(userInput)) {
                view.showMessage(View.INPUT_WRONG_NUMBER_MESSAGE);
                userInput = getUserIntInput(scanner);
            }

            if (model.isCorrectGuess(userInput)) {
                isGameEnded = true;
            } else {
                if (model.isGuessHigher(userInput))
                    view.showMessage(View.MISS_LOWER_MESSAGE);
                else
                    view.showMessage(View.MISS_HIGHER_MESSAGE);
                model.changeGuessedBounds(userInput);
            }
            model.increaseGuessTries();
        }

        view.showMessage(View.CORRECT_GUESS);
        view.showBoundsMessage(View.RESULT_START_MESSAGE, View.RESULT_MIDDLE_MESSAGE, View.RESULT_END_MESSAGE,
                model.getGuessedNumber(), model.getGuessTries());
    }

    public int getUserIntInput(Scanner scanner) {
        view.showBoundsMessage(View.BOUNDS_START_MESSAGE, View.BOUNDS_MIDDLE_MESSAGE, View.BOUNDS_END_MESSAGE,
                model.getGuessedMinimal(), model.getGuessedMaximal());
        view.showMessage(View.INPUT_INT_MESSAGE);

        while (!scanner.hasNextInt()) {
            view.showMessage(View.INPUT_WRONG_TYPE_MESSAGE);
            scanner.next();
        }

        return scanner.nextInt();
    }

}
