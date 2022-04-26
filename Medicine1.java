package application;
/////////////////////////////// Ajyad && Sujood///////////////////////////////////
import java.sql.Date;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.IntegerPropertyBase;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.WritableDoubleValue;

public class Medicine1 {
	int idmed;
	int id;
	String BillDate;
	
	String medName;
	
	
	String type ;
	
	String productDate;
	
	String expireDate;
	
	
	double cost;
	
	
	int quantity ;


	public int getIdmed() {
		return idmed;
	}


	public void setIdmed(int idmed) {
		this.idmed = idmed;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBillDate() {
		return BillDate;
	}


	public void setBillDate(String billDate) {
		BillDate = billDate;
	}


	public String getMedName() {
		return medName;
	}


	public void setMedName(String medName) {
		this.medName = medName;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getProductDate() {
		return productDate;
	}


	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}


	public String getExpireDate() {
		return expireDate;
	}


	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public Medicine1(int idmed, String billDate, String medName, String type, String productDate, String expireDate,
			double cost, int quantity, int id) {
		super();
		this.id = id;
		this.idmed = idmed;
		BillDate = billDate;
		this.medName = medName;
		this.type = type;
		this.productDate = productDate;
		this.expireDate = expireDate;
		this.cost = cost;
		this.quantity = quantity;
	}


	public Medicine1() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	
	
	
}
