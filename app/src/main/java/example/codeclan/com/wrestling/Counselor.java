package example.codeclan.com.wrestling;

/**
 * Created by stuartbryce on 2017-06-26.
 */

public class Counselor {

    private int id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String telephone;
    private String email;
    private String memberSince;


     public Counselor(int id, String firstName, String lastName, String nickName, String telephone, String email, String memberSince){
         this.id = id;
         this.firstName = firstName;
         this.lastName = lastName;
         this.nickName = nickName;
         this.telephone = telephone;
         this.email = email;
         this.memberSince = memberSince;
    }
     public Counselor(String firstName, String lastName, String nickName, String telephone, String email, String memberSince){
         this.firstName = firstName;
         this.lastName = lastName;
         this.nickName = nickName;
         this.telephone = telephone;
         this.email = email;
         this.memberSince = memberSince;
    }


}
