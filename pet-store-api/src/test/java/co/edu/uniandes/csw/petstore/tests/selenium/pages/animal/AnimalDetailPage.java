/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.petstore.tests.selenium.pages.animal;

import co.edu.uniandes.csw.petstore.dtos.minimum.AnimalDTO;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.openqa.selenium.support.FindBys;

public class AnimalDetailPage {

    @FindBy(id = "delete-animal")
    private WebElement deleteBtn;

    @FindBy(id = "edit-animal")
    private WebElement editBtn;

    @FindBy(id = "list-animal")
    private WebElement listBtn;

    
    @FindBy(id = "name")
    private WebElement name;
    @FindBy(id = "birthDate")
    private WebElement birthDate;
    @FindBy(id = "color")
    private WebElement color;
    @FindBy(id = "gender")
    private WebElement gender;

    public void list() {
        listBtn.click();
    }

    public void edit() {
        editBtn.click();
    }

    public void delete() {
        deleteBtn.click();
    }

    public AnimalDTO getData() throws ParseException {
        
        AnimalDTO animal = new AnimalDTO();  
      //  Date dat = Date.valueOf(this.birthDate.getText());
      String g = this.birthDate.getText();    
        animal.setName(this.name.getText());
        Date date = Date.valueOf(getDateformat(this.birthDate.getText()));
        animal.setBirthDate(date);
        animal.setColor(this.color.getText());        
        animal.setGender(this.gender.getText());        
        return animal;
    }
    
    
   private String getDateformat(String rawFormat){
       String month="";
       String rawFormatMonth = (rawFormat.split(",")[0].split(" ")[0]).trim();
   switch(rawFormatMonth){
       case "Jan" : month="01"; break;
       case "Feb" : month="02"; break;
       case "Mar" : month="03"; break;
       case "Apr" : month="04"; break;
       case "May" : month="05"; break;
       case "Jun" : month="06"; break;
       case "Jul" : month="07"; break;
       case "Aug" : month="08"; break;
       case "Sep" : month="09"; break;
       case "Oct" : month="10"; break;
       case "Nov" : month="11"; break;
       case "Dec" : month="12"; break;
       default: month="invalid month"; break;
   }
   return rawFormat.split(",")[1].trim()+"-"+month+"-"+rawFormat.split(",")[0].split(" ")[1].trim();
   }
}
