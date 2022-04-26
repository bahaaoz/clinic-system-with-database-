package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class doctor{
	 
	 IntegerProperty id = new SimpleIntegerProperty();
	 StringProperty namedc = new SimpleStringProperty();
	 IntegerProperty age = new SimpleIntegerProperty();
	 IntegerProperty numPhone = new SimpleIntegerProperty();
	 StringProperty sex = new SimpleStringProperty();
	 IntegerProperty idLab = new SimpleIntegerProperty();
	 IntegerProperty SIN = new SimpleIntegerProperty();
	 
	 public IntegerProperty idProperty() { 
           return id;
       }
	 
	 public StringProperty namedcProperty() {
           return namedc;
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
	 
	 
	 public IntegerProperty idLabProperty() { 
           return idLab;
       }
	 
	 public doctor(int idvalue, String namedcvalue, int agevalue, int numPhonevalue, String sexvalue, int idLabvalue, int SINValue ) {
           id.set(idvalue);
           namedc.set(namedcvalue);
           age.set(agevalue);
           numPhone.set(numPhonevalue);
           sex.set(sexvalue);
           idLab.set(idLabvalue);
           SIN.set(SINValue);
       }

       doctor(){}
	 
}