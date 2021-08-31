import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ModelTest {
    public static final int EPOCHS = 10000;
    public static final int MAX = 100;
    public static final int MIN = 0;

    private Model model;
    private int secretNumber;

    @Before
    public void createModel() {
        model = new Model();
        secretNumber = model.getGuessedNumber();
    }

    @Test
    public void secretNumberShouldHaveRightBoundaries() {
        for (int i = 0; i < EPOCHS; i++) {
            model = new Model();
            secretNumber = model.getGuessedNumber();
            if (secretNumber >= MAX || secretNumber <= MIN)
                Assert.fail();
        }
    }

    @Test
    public void resetNumberShouldHaveRightBoundaries() {
        for (int i = 0; i < EPOCHS; i++) {
            model.resetGuessedNumber();
            secretNumber = model.getGuessedNumber();
            if (secretNumber >= MAX || secretNumber <= MIN)
                Assert.fail();
        }
    }

    @Test
    public void smallerNumberShouldChangeMinimalBoundary() {
        int smallerNumber = secretNumber - 1;
        int maximalBoundary = model.getGuessedMaximal();

        // Method call
        model.changeGuessedBounds(smallerNumber);
        // Assertion
        Assert.assertEquals(model.getGuessedMinimal(), smallerNumber);
        Assert.assertEquals(model.getGuessedMaximal(), maximalBoundary);
    }

    @Test
    public void biggerNumberShouldChangeMaximalBoundary() {
        int biggerNumber = secretNumber + 1;
        int minimalBoundary = model.getGuessedMinimal();

        // Method call
        model.changeGuessedBounds(biggerNumber);
        // Assertion
        Assert.assertEquals(model.getGuessedMaximal(), biggerNumber);
        Assert.assertEquals(model.getGuessedMinimal(), minimalBoundary);
    }

    @Test
    public void isCorrectGuessShouldReturnTrueForCorrect() {
        int guessNumber = secretNumber;

        // Assertion
        Assert.assertTrue(model.isCorrectGuess(guessNumber));
    }

    @Test
    public void isCorrectGuessShouldReturnFalseForNotCorrect() {
        int guessNumber = secretNumber + 1;

        // Assertion
        Assert.assertFalse(model.isCorrectGuess(guessNumber));
    }

    @Test
    public void isGuessHigherShouldReturnTrueForHigher() {
        int biggerNumber = secretNumber + 1;

        // Assertion
        Assert.assertTrue(model.isGuessHigher(biggerNumber));
    }

    @Test
    public void isGuessHigherShouldReturnFalseForLower() {
        int smallerNumber = secretNumber - 1;

        // Assertion
        Assert.assertFalse(model.isGuessHigher(smallerNumber));
    }

    @Test
    public void isCorrectBoundaryShouldReturnTrueForCorrect() {
        int minimalBoundary = model.getGuessedMinimal();
        int maximalBoundary = model.getGuessedMaximal();

        int numberInBoundary = minimalBoundary + (maximalBoundary - minimalBoundary)/2;

        // Assertion
        Assert.assertTrue(model.isCorrectBoundary(numberInBoundary));
    }

    @Test
    public void isCorrectBoundaryShouldReturnFalseForNotCorrect() {
        int minimalBoundary = model.getGuessedMinimal();
        int maximalBoundary = model.getGuessedMaximal();

        int numberHigherThanBoundaries = maximalBoundary + 1;
        int numberLowerThanBoundaries = minimalBoundary - 1;

        // Assertion
        Assert.assertFalse(model.isCorrectBoundary(numberHigherThanBoundaries));
        Assert.assertFalse(model.isCorrectBoundary(numberLowerThanBoundaries));
    }

    @Test
    public void increaseGuessTriesShouldIncreaseGuessTriesByOne() {
        int currentTries = model.getGuessTries();

        // Method call
        model.increaseGuessTries();

        // Assertion
        Assert.assertEquals(model.getGuessTries(), currentTries+1);
    }
}
