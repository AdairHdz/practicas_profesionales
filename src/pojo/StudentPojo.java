/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Adair Hernández
 */
public class StudentPojo extends UserPojo{
    private String enrollment;

    public void setEnrollment(String enrollment){
        this.enrollment = enrollment;
    }
    
    public String getEnrollment(){
        return this.enrollment;
    }
}
