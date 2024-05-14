/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showbook.dto;

public class Login {
    private String id;
    private String pwd;

    public Login(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }

    public String getPwd() {
        return pwd;
    }
    
}
