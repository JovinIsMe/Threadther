package model;
// Generated Mar 16, 2018 9:31:50 PM by Hibernate Tools 4.3.1



/**
 * Admin generated by hbm2java
 */
public class Admin  implements java.io.Serializable {


     private int userId;
     private User user;
     private String address;

    public Admin() {
    }

	
    public Admin(User user) {
        this.user = user;
    }
    public Admin(User user, String address) {
       this.user = user;
       this.address = address;
    }
   
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }




}


