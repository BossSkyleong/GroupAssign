package my.edu.utar.groupassign;

public class mode3_1 {
    private final String question;
    private final String[] options;
    private final int correctAns;
    private final int imageId;

    public mode3_1(String question, String[] options, int correctAns,
                   int imageId) {
        this.question = question;
        this.options = options;
        this.correctAns = correctAns;
        this.imageId = imageId;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAns() {
        return correctAns;
    }

    public int getImageId() {
        return imageId;
    }
}