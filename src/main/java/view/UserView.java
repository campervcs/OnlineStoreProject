package view;

import controller.UserController;

public class UserView {
    public UserView(){
        System.out.println((new UserController()).showUsers());
    }
}
