package org.example.gradingapp.component;

import org.springframework.stereotype.Component;

@Component
public class Utility {

    public String evaluateGrade(Double marks){

        if(marks >= 75){
            return "A";
        }
        else if(marks >= 65){
            return "B";
        }
        else if(marks >= 50){
            return "C";
        }
        else if(marks >= 35){
            return "D";
        }
        else{
            return "F";
        }
    }
}
