package pl.Marcin.Milionerzy.question;

public class Question {

    private String category;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correctAnswerNr;

    public Question() {}

    public Question(String category, String question, String answer1, String answer2, String answer3, String answer4, String correctAnswerNr) {
        this.category = category;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswerNr = correctAnswerNr;
    }

    public String getCategory() {
        return category;
    }
    public String getQuestion() {
        return question;
    }
    public String getAnswer1() {
        return answer1;
    }
    public String getAnswer2() {
        return answer2;
    }
    public String getAnswer3() {
        return answer3;
    }
    public String getAnswer4() {
        return answer4;
    }
    public String getCorrectAnswerNr() {
        return correctAnswerNr;
    }

    @Override
    public String toString() {
        return "Question{" +
                "category='" + category + '\'' +
                ", question='" + question + '\'' +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                ", answer4='" + answer4 + '\'' +
                ", correctAnswerNr='" + correctAnswerNr + '\'' +
                '}';
    }
}
