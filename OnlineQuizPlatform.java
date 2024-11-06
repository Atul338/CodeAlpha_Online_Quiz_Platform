import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String question;
    private String[] options;
    int correctAnswerIndex;

    public Question(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrectAnswer(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }
}

public class OnlineQuizPlatform {
    private List<Question> questions;

    public OnlineQuizPlatform() {
        questions = new ArrayList<>();
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question("What is the capital of France?", new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"},
                2));
        questions.add(new Question("What is 2 + 2?", new String[]{"1. 3", "2. 4", "3. 5", "4. 6"}, 1));
        questions.add(new Question("What is the largest planet in our solar system?", new String[]{"1. Earth", "2. Jupiter", "3. Mars", "4. Saturn"},
                1));
        questions.add(new Question("Which element has the chemical symbol 'O'?", new String[]{"1. Gold", "2. Oxygen", "3. Silver", "4. Hydrogen"},
                1));
        questions.add(new Question("What is the smallest prime number?", new String[]{"1. 0", "2. 1", "3. 2", "4. 3"},
                2));
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Online Quiz!");
        System.out.println("-----------------------------");

        for (Question question : questions) {
            System.out.println(question.getQuestion());
            for (String option : question.getOptions()) {
                System.out.println(option);
            }

            System.out.print("Enter the number of your answer: ");
            int answerIndex = scanner.nextInt() - 1; // Convert to 0-based index
            if (question.isCorrectAnswer(answerIndex)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong answer. The correct answer was: " + question.getOptions()[question.correctAnswerIndex] + "\n");
            }
        }

        System.out.println("Quiz finished! Your score: " + score + "/" + questions.size());
        scanner.close();
    }

    public static void main(String[] args) {
        OnlineQuizPlatform quizPlatform = new OnlineQuizPlatform();
        quizPlatform.startQuiz();
    }
}