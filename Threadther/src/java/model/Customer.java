package model;
// Generated Apr 16, 2018 10:03:05 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Customer generated by hbm2java
 */
public class Customer  implements java.io.Serializable {


     private int userId;
     private User user;
     private Integer balance;
     private Integer phoneNumber;
     private Date birthDate;

    public Customer() {
    }

	
    public Customer(User user) {
        this.user = user;
    }
    public Customer(User user, Integer balance, Integer phoneNumber, Date birthDate) {
       this.user = user;
       this.balance = balance;
       this.phoneNumber = phoneNumber;
       this.birthDate = birthDate;
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
    public Integer getBalance() {
        return this.balance;
    }
    
    public void setBalance(Integer balance) {
        this.balance = balance;
    }
    public Integer getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Date getBirthDate() {
        return this.birthDate;
    }
    
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }




}


