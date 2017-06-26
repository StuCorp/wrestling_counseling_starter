package example.codeclan.com.wrestling;

import java.sql.ResultSet;
import java.util.Scanner;

import db.SqlRunner;

import static android.graphics.BlurMaskFilter.Blur.INNER;
import static db.SqlRunner.executeQuery;

/**
 * Created by stuartbryce on 2017-06-26.
 */

public class Subject {

    private int id;
    private String name;
    private String description;
    private int counselorId;

    public Subject(int id, String name, String description, int counselorId){
        this.id = id;
        this.name = name;
        this.description = description;
        this.counselorId = counselorId;
    }

    public static void allSubjects(){
        String sql = "SELECT * FROM SUBJECTS;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try{
            while(rs.next()){
                String subject = rs.getString("name");
                String description = rs.getString("description");
                int id = rs.getInt("id");
                System.out.println(String.format("%d) %s",id, subject));
            }
        }catch (Exception ex){
            System.exit(0);
        }
    }

    public static void subjectDetails(int choice){
        String sql = String.format("SELECT subjects.description, subjects.name, " +
                "counselors.first_name, counselors.nick_name, counselors.last_name, " +
                "counselors.telephone, counselors.email, counselors.member_since " +
                "FROM subjects INNER JOIN counselors " +
                "ON subjects.counselor_Id = counselors.id WHERE subjects.id = %d;", choice);
        ResultSet rs = SqlRunner.executeQuery(sql);
        try{
            while(rs.next()){
                String subject = rs.getString("name");
                String description = rs.getString("description");
                String firstName = rs.getString("first_name");
                String nickName = rs.getString("nick_name");
                String lasttName = rs.getString("last_name");
                String telephone = rs.getString("telephone");
                String email = rs.getString("email");
                String memberSince = rs.getString("member_since");

                System.out.println(String.format("Subject: %s", subject));
                System.out.println(String.format("Description: \n %s", description));
                System.out.println();
                System.out.println(String.format("Instructor avaialble: %s \'%s beater\' %s", firstName, nickName,lasttName));
                System.out.println(String.format("Instructoring since: %s", memberSince));
                System.out.println(String.format("Contact deetz: %s %s", telephone, email));

            }

        }catch(Exception ex){
            System.exit(0);
        }
    }

    public static int getChoice(){
        Scanner sc = new Scanner(System.in);
        int answer;
        do {
            System.out.println("choose! choose! choose!");
            while(!sc.hasNextInt() ) {
                System.out.println("number!");
                sc.next();
            }
            answer = sc.nextInt();
        } while (!(answer > 0 && answer < 10));
        return answer;
    }
}
