package example.codeclan.com.wrestling;

/**
 * Created by stuartbryce on 2017-06-26.
 */

public class Runner {

    public static void main(String[] args) {

        System.out.println("Select a subject, ya turkey");
        Subject.allSubjects();
        int choice = Subject.getChoice();
        Subject.subjectDetails(choice);

    }
}
