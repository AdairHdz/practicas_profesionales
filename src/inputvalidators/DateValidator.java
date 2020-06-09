/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputvalidators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Adair Hernández
 */
public class DateValidator {

    private DateTimeFormatter dateTimeFormatter;
    private SimpleDateFormat sdformat;
    
    public DateValidator(){
        this.dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.sdformat = new SimpleDateFormat("yyyy-MM-dd");
    }
    
    public boolean validateStartingAndEndingDate(LocalDate startingDate, LocalDate endingDate) {
        boolean validDates = false;        
        try{
            validDates = this.handleStartingAndEndingDateValidation(startingDate, endingDate);
        }catch(ParseException | NullPointerException e){
            System.out.println(e.getMessage());
        }
        return validDates;
    }

    private boolean handleStartingAndEndingDateValidation(LocalDate startingDate, LocalDate endingDate) throws ParseException, NullPointerException {        
        if(startingDate == null || endingDate == null){
            throw new NullPointerException("Null Date value");
        }
        
        String startingDateString = startingDate.format(dateTimeFormatter);
        String endingDateString = endingDate.format(dateTimeFormatter);
        
        Date d = sdformat.parse(startingDateString);
        Date d2 = sdformat.parse(endingDateString);

        return d.compareTo(d2) < 0;
    }
}
