package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class nurses{
	 
	 IntegerProperty id = new SimpleIntegerProperty();
	 StringProperty nameNurse = new SimpleStringProperty();
	 IntegerProperty age = new SimpleIntegerProperty();
	 IntegerProperty numPhone = new SimpleIntegerProperty();
	 StringProperty sex = new SimpleStringProperty();
	 IntegerProperty SIN = new SimpleIntegerProperty();
	 
	 public IntegerProperty idProperty() { 
           return id;
       }
	 
	 public StringProperty nameNurseProperty() {
           return nameNurse;
       }
	 public IntegerProperty SINProperty() { 
           return SIN;
       }
	 
	 public IntegerProperty ageProperty() { 
           return age;
       }
	 
	 public IntegerProperty numPhoneProperty() { 
           return numPhone;
       }
	 
	 public StringProperty sexProperty() {
           return sex;
       }
	 
	 public nurses(int idvalue, String nameNursevalue, int agevalue, int numPhonevalue, String sexvalue, int SINvalue ) {
           id.set(idvalue);
           nameNurse.set(nameNursevalue);
           age.set(agevalue);
           numPhone.set(numPhonevalue);
           sex.set(sexvalue);
           SIN.set(SINvalue);
       }

       nurses(){}
	 
}
