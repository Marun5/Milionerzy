package pl.Marcin.Milionerzy.game;

import pl.Marcin.Milionerzy.question.Question;
import pl.Marcin.Milionerzy.dao.QuestionDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Game {
    private int score = 0;
    private boolean gameLoop;
    private final QuestionDao questionDao;
    public Game() {
        questionDao = new QuestionDao();
    }
    private final Scanner scanner = new Scanner(System.in);

    public void game() {

        System.out.println("\nYou started the game. Good luck ;)\n");
        gameLoop = true;
        String categoryLevel;
        List<Question> gameList = new ArrayList<>();

        while (gameLoop) {

            if (score < 3) {
                categoryLevel = "1";
                showQuestion(categoryLevel, gameList);

            } else if (score < 6) {
                categoryLevel = "2";
                showQuestion(categoryLevel, gameList);

            } else if (score < 9) {
                categoryLevel = "3";
                showQuestion(categoryLevel, gameList);

            } else {
                System.out.println("\nYOU WON");
                System.out.println("Congratulations!!!");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("\nPress enter to return to menu");
                scanner.nextLine();
                System.out.println("\n\n\n\n\n");
                gameLoop = false;
            }
        }
    }

    private void showQuestion(String category, List<Question> gameList) {

        Stream<Question> questions = questionDao.findQuestionsFromCategory(category);
        List<Question> questionList = questionDao.getArrayFromStream(questions);

        Question question;
        int x;
        do {
            x = 1;
            question = questionDao.getRandomElement(questionList);

            for (Question value : gameList) {
                if (value.getQuestion().equals(question.getQuestion())) {
                    x = 0;
                }
            }
        } while (x == 0);

        gameList.add(question);

        System.out.println(question.getQuestion());
        System.out.println("1) " + question.getAnswer1());
        System.out.println("2) " + question.getAnswer2());
        System.out.println("3) " + question.getAnswer3());
        System.out.println("4) " + question.getAnswer4());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String inputAnswer = scanner.nextLine();
            if (inputAnswer.equals("1") || inputAnswer.equals("2") || inputAnswer.equals("3") || inputAnswer.equals("4")) {
                if (inputAnswer.equals(question.getCorrectAnswerNr())) {
                    System.out.println("Correct answer!");
                    score++;
                    System.out.println("Your score: " + score);
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("\n\n\n\n");
                } else {
                    System.out.println("Wrong answer");
                    System.out.println("YOU LOSE!\n");
                    System.out.println("Correct answer: " + question.getCorrectAnswerNr() + "\n");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Press enter to return to menu");
                    scanner.nextLine();
                    System.out.println("\n\n\n\n\n");
                    score=0;
                    gameLoop = false;
                }
                break;
            } else System.out.println("Press: 1, 2, 3 or 4");

        }
    }
}
