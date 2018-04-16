/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WS;

import controller.CustomerCtrl;
import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Customer;
import model.User;

/**
 *
 * @author Jovin Angelico
 */
@WebService(serviceName = "WSCustomer")
public class WSCustomer {

    @WebMethod(operationName = "register")
    public Boolean register(@WebParam(name = "first_name") String first_name, @WebParam(name = "last_name") String last_name, @WebParam(name = "email") String email, @WebParam(name = "password") String password, @WebParam(name = "profile_picture") String profile_picture, @WebParam(name = "phone_number") Integer phone_number, @WebParam(name = "birth_date") Date birth_date){
        User user = new User(first_name, last_name, email, password, profile_picture);
        Customer customer = new Customer(user, 0, phone_number, birth_date);
        user.setCustomer(customer);
        
        // register user , customer?
        return new CustomerCtrl().register(user);
    }
}
