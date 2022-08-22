package strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Exam {
    private Map<Question, String> questionBase = new HashMap<>();
    private Map<Question, Boolean> examResults = new HashMap<>();

    public Exam() {
        // We have implemented two ways to display question: on a web page or in a mobile application.
        // Due to property "displayBehavior" is abstract, we can inject the desired behavior at runtime.
        var displayOnWebPage = new DisplayBehaviorOnWebPage();
        var displayInMobileApplication = new DisplayInMobileApplication();

        // Filling the database with questions
        var questionFirst = Question.builder()
                .id(1L)
                .name("What are the legal signatures of the main method?")
                .displayBehavior(displayOnWebPage)
                .build();

        var questionSecond = Question.builder()
                .id(2L)
                .name("Can we overload main()?")
                .displayBehavior(displayInMobileApplication)
                .build();
        var questionThird = Question.builder()
                .id(3L)
                .name("Will your program execute if you overload the main method?")
                .displayBehavior(displayInMobileApplication)
                .build();

        questionBase.put(questionFirst, """
                The following are the legal signatures of the main method:
                public static void main(String data[])
                public static void main(String[] data)
                public static void main(String… data)
                static void main(String[] data)
                static public void main(String… data)""");
        questionBase.put(questionSecond, "Yes. Technically, we can overload the main method.");
        questionBase.put(questionThird, """
                The Java compiler does not object the overloading of the
                method, which means that the compilation will be successful.
                But when we pass the generated class file to JVM, JVM will try
                to find out the signature that is known to it.""");


    }

    void start() {
        questionBase.forEach((question, answer) -> {
            var answerResult = new Random().nextBoolean();
            question.getDisplayBehavior().showQuestion();
            System.out.printf("Question: %s%n", question.getName());
            System.out.printf("Correct answer: %s%n", answer);
            System.out.printf("Answer is %b%n%n", answerResult);
            examResults.put(question, answerResult);
        });

        // displaying the exam results
        var countOfCorrectAnswers = examResults.entrySet().stream()
                .reduce(0,
                        (subtotal, entry) -> subtotal + (Boolean.TRUE.equals(entry.getValue()) ? 1 : 0),
                        Integer::sum);
        System.out.printf("Your result is: %d of %d%n",
                countOfCorrectAnswers,
                examResults.size());
    }

    public static void main(String[] args) {
        new Exam().start();
    }
}
