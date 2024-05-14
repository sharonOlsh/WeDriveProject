package database;

import entity.ServerClient;

import java.util.HashMap;
import java.util.HashSet;

public class Users {
    private static HashMap<String, ServerClient> webUsers;
    private boolean isFirstUser;


    public Users() {
        Users.webUsers = new HashMap<>();
        isFirstUser =false;
    }
    public static boolean addNewUser(String fullName, String email, String phoneNumber, String password){

        if(!checkUserExists(fullName)){
            webUsers.put(fullName, new ServerClient(fullName,email,phoneNumber,password));
            //לבדןק שזה באמת מספר ולא סתם
            return true;
        }
        return false;
    }
    public static boolean checkUserExists(String fullName){
        return webUsers.containsKey(fullName);
    }

    public HashMap<String,ServerClient> getWebUsers() {
        return webUsers;
    }
    public synchronized boolean isFirstUser() {
        return isFirstUser;
    }

    public synchronized void setFirstUser(boolean firstUser) {
        isFirstUser = firstUser;
    }
}
