package models;

import java.util.ArrayList;

public class MyUser {
    private static MyUser ourInstance = new MyUser();

    Register getMyusers_reg(int index) {
        return myusers.get(index);
    }

    static private ArrayList<Register> myusers = new ArrayList<>() ;

    public static MyUser getInstance() {
        if(ourInstance == null) {
            ourInstance = new MyUser();
        }
        return ourInstance;
    }

    private MyUser() {
    }
    public void adduser(Register newuser){
        int index = indexofstring(newuser.getUsername() );
        if(index == -1) {
            myusers.add(newuser);
        }
        else
            System.out.println("This User Has Registered Before");
    }
    public int indexofstring(String comperstring){
            for (int i = 0 ; i<myusers.size(); i++ ){
                if(myusers.get(i).getUsername().equals(comperstring))
                    return i;
            }
            return -1;
    }
    public static Register FindUser(String id){
        for (Register user : myusers) {
            if(user.getId().equals(id))
                return user;
        }
        return null;
    }
    public static void addTempUser(){

        Skills first = new Skills("HTML" , 5 );
        Skills second = new Skills("JavaScript" , 4 );
        Skills third = new Skills("C++" , 2 );
        Skills forth = new Skills("Java" , 3 );

        ArrayList<Skills> skill = null;
        skill.add(first);
        skill.add(second);
        skill.add(third);
        skill.add(forth);

        Register tempUser = new Register("1" , "Ali" , "SharifZade" , "WebProgrammer"
                ,"",skill,":)");

        ourInstance.adduser(tempUser);
    }
}
