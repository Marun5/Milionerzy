package pl.Marcin.Milionerzy.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.Marcin.Milionerzy.Question;

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
    private List<Question> getQuestions() {

        try {
            return objectMapper.readValue(Files.readString(Paths.get("./questions.txt")), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error on getQuestions");
            return new ArrayList<>();
        }
    }

    public List<Question> findAll() {
        return getQuestions();
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

//    public Question findCategory(String category) {
//
//        if (findOneByCategory(category).isPresent()) {
//            return findOneByCategory(category).get();
//        } else {
//            return null;
//        }
//    }
//
//    public List<Question> categoryList(String category) {
//        if (findOneByCategory(category).isPresent()) {
//            return findOneByCategory(category).stream().toList();
//        } else {
//            return null;
//        }
//    }
//
//    private Optional<Question> findOneByCategory(String category) {
//        return getQuestions().stream()
//                .filter(c -> c.getCategory().equals(category))
//                .findAny();
//
//    }
//
//    public Question findQuestion(String questionName) {
//        if (findOneByQuestionName(questionName).isPresent()) {
//            return findOneByQuestionName(questionName).get();
//        } else {
//            return null;
//        }
//    }
//
//    private Optional<Question> findOneByQuestionName(String questionName) {
//        return getQuestions().stream()
//                .filter(c -> c.getQuestion().equals(questionName))
//                .findAny();
//    }
}