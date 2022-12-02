package pl.Marcin.millionaire.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.Marcin.millionaire.question.Question;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class QuestionDao {
    private final ObjectMapper objectMapper;
    public QuestionDao() {
        this.objectMapper = new ObjectMapper();
    }

    public List<Question> getQuestions() {
        try {
            return objectMapper.readValue(Files.readString(Paths.get("./questions.txt")), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error on getQuestions");
            return new ArrayList<>();
        }
    }

    public Stream<Question> findQuestionsFromCategory(String category) {
        return getQuestions().stream()
                .filter(c -> c.getCategory().equals(category));
    }

    public List<Question> getArrayFromStream(Stream<Question> stream) {
        List<Question> list = stream.toList();
        return new ArrayList<>(list);
    }

    public Question getRandomElement(List<Question> questions) {
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }

    public void add(Question question) {
        List<Question> questions = getQuestions();
        questions.add(question);

        saveQuestions(questions);
    }

    private void saveQuestions(List<Question> questions) {
        try {
            Files.writeString(Paths.get("./questions.txt"), objectMapper.writeValueAsString(questions));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error on saveQuestions");
        }
    }
}