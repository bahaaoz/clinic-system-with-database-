package application;

import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;


import javafx.animation.FillTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Main<newRow, EmojisLabel> extends Application {

	// Data Base (bahaa)
	private String DBUserName = "root";
	private String DBPasswd = "1191524";
	private String DBURL = "127.0.0.1";
	private String DBPort = "3306";
	private String DBName = "dbclinic";

	private Connection con;

	@Override
	public void start(Stage stage) {
		try {

			// Data Base Connection
			DBConnection connect = new DBConnection(DBURL, DBPort, DBName, DBUserName, DBPasswd);
			con = connect.connectDB();

			// patient().show();
			// admin(stage).show();
			//Pharmacy().show();
			// TableViewDoc(stage).show();
			 signIn().show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	// ___________
	// ___________
	// ___________
	// ___________
	// ___________
	// ___________

	// we want check if the user doctor or patient!!!!!!!!!!!!!!!

	// _________
	// _________
	// _________
	// ___Admin____
	// ________
	// _______________________________________________________________________
	// _______________________________________________________________________
	// _______________________________________________________________________
	// ___________________________Admin________________________________
	// __________________________________________________________________
	public Stage admin(Stage stage) throws SQLException {
		Group group = new Group();
		Scene scene = new Scene(group, 1000, 630);
		Rectangle rec = new Rectangle(1000, 650);
		rec.setFill(Color.LAVENDER);

		Text text = new Text("Doctors");
		text.setFont(new Font("Tohama", 20));
		text.setFill(Color.WHITE);
		text.setStroke(Color.LIGHTSKYBLUE);

		Rectangle rectangle = new Rectangle();
		rectangle.setHeight(85);
		rectangle.setWidth(85);
		rectangle.setArcWidth(35);
		rectangle.setArcHeight(35);
		rectangle.setFill(Color.LINEN);
		rectangle.setStroke(Color.BLACK);

		RotateTransition rotate = new RotateTransition();
		rotate.setDuration(Duration.seconds(2));
		rotate.setNode(rectangle);
		rotate.setCycleCount(-1);
		rotate.setByAngle(180);
		rotate.setAutoReverse(true);
		rotate.play();

		StackPane stack = new StackPane();
		stack.setLayoutX(250);
		stack.setLayoutY(180);
		stack.getChildren().addAll(rectangle, text);

		Text textNur = new Text("Nurses");
		textNur.setFont(new Font("Tohama", 20));
		textNur.setFill(Color.WHITE);
		textNur.setStroke(Color.LIGHTSKYBLUE);

		Rectangle rectangle2 = new Rectangle();
		rectangle2.setHeight(85);
		rectangle2.setWidth(85);
		rectangle2.setArcWidth(35);
		rectangle2.setArcHeight(35);
		rectangle2.setFill(Color.LINEN);
		rectangle2.setStroke(Color.BLACK);

		RotateTransition rotate2 = new RotateTransition();
		rotate2.setDuration(Duration.seconds(2));
		rotate2.setNode(rectangle2);
		rotate2.setCycleCount(-1);
		rotate2.setByAngle(180);
		rotate2.setAutoReverse(true);
		rotate2.play();

		StackPane stack2 = new StackPane();
		stack2.setLayoutX(250);
		stack2.setLayoutY(460);
		stack2.getChildren().addAll(rectangle2, textNur);

		Text textClinic = new Text("Clinic");
		textClinic.setFont(new Font("Tohama", 50));
		textClinic.setStroke(Color.STEELBLUE);

		FillTransition fill = new FillTransition();
		fill.setDuration(Duration.seconds(5));
		fill.setShape(textClinic);
		fill.setFromValue(Color.BEIGE);
		fill.setToValue(Color.LIGHTCORAL);
		fill.setCycleCount(-1);
		fill.setAutoReverse(true);
		fill.play();

		StackPane stack3 = new StackPane();
		stack3.setLayoutX(450);
		stack3.setLayoutY(280);
		stack3.getChildren().addAll(textClinic);

		TextArea textarea2 = new TextArea();
		textarea2.setLayoutX(550);
		textarea2.setLayoutY(380);
		textarea2.setPrefSize(280, 150);

		// setting
		ComboBox<String> Setting = new ComboBox<>();
		Setting.getItems().addAll("Logout", "change password", "delete account");

		// Page
		Label title = new Label("Admin Page");
		title.setFont(Font.font("", FontWeight.BOLD, 20));
		title.setLayoutX(350);
		title.setLayoutY(1);

		// new Doc
		Label addNewDoc = new Label("Add new doctor : \t");
		addNewDoc.setFont(Font.font("", FontWeight.BOLD, 15));

		Label nameOfDoctor = new Label("doctor name : \t");
		nameOfDoctor.setTextFill(Color.SEAGREEN);
		TextField nameText = new TextField();
		nameText.setPromptText("String");
		nameText.setPrefSize(80, 20);
		nameText.setOnMouseClicked(e -> {
			nameText.setText("");
		});
		HBox name = new HBox(5);
		name.getChildren().addAll(nameOfDoctor, nameText);

		Label SINDoc = new Label("SINDoc :\t\t");
		SINDoc.setTextFill(Color.SEAGREEN);
		TextField SINDocText = new TextField();
		SINDocText.setPromptText("Number");
		SINDocText.setPrefSize(80, 20);
		SINDocText.setOnMouseClicked(e -> {
			SINDocText.setText("");
		});
		HBox SINHbox = new HBox(5);
		SINHbox.getChildren().addAll(SINDoc, SINDocText);

		Label ageOfDoctor = new Label("doctor age : \t");
		ageOfDoctor.setTextFill(Color.SEAGREEN);
		TextField ageText = new TextField("");
		ageText.setPromptText("Number");
		ageText.setPrefSize(80, 20);
		ageText.setOnMouseClicked(e -> {
			ageText.setText("");
		});
		HBox age = new HBox(5);
		age.getChildren().addAll(ageOfDoctor, ageText);

		Label phoneOfDoctor = new Label(" phone : \t\t");
		phoneOfDoctor.setTextFill(Color.SEAGREEN);
		TextField phoneText = new TextField();
		phoneText.setPromptText("Number");
		phoneText.setPrefSize(80, 20);
		phoneText.setOnMouseClicked(e -> {
			phoneText.setText("");
		});

		HBox phone = new HBox(5);
		phone.getChildren().addAll(phoneOfDoctor, phoneText);

		Label sexOfDoctor = new Label(" sex : \t\t");
		sexOfDoctor.setTextFill(Color.SEAGREEN);
		ComboBox<String> sexText = new ComboBox<String>();
		sexText.setPrefSize(80, 20);
		sexText.getItems().addAll("Male", "Female");
		HBox sex = new HBox(5);
		sex.getChildren().addAll(sexOfDoctor, sexText);

		Button Enter = new Button("Enter");
		Enter.setTextFill(Color.CORAL);
		Label resEnter = new Label("");
		HBox EnterHBox = new HBox(10);
		EnterHBox.getChildren().addAll(Enter, resEnter);

		VBox doc = new VBox(10);
		doc.getChildren().addAll(addNewDoc, name, SINHbox, age, phone, sex, EnterHBox);
		doc.setLayoutX(20);
		doc.setLayoutY(30);

		Enter.setOnAction(e -> {
			Statement ss;
			try {
				ss = con.createStatement();
				ss.executeUpdate("insert into doctors (namedc, age, numPhone, sex, SIN)  value ( '" + nameText.getText()
						+ "', '" + Integer.valueOf(ageText.getText()) + "', '" + Integer.valueOf(phoneText.getText())
						+ "', '" + sexText.getValue() + "', '" + Integer.valueOf(SINDocText.getText()).toString()
						+ "') ;");

				resEnter.setText("Done!!!");
				resEnter.setTextFill(Color.GREEN);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				resEnter.setText("Wrong Input!!!");
				resEnter.setTextFill(Color.RED);
			}
		});

		// time

		// -------------------Add New Nurse-------------------

		// new Nurse (Hiba)
		Label addNewNurse = new Label("Add new Nurse : \t");
		addNewNurse.setFont(Font.font("", FontWeight.BOLD, 15));

		Label nameOfNurse = new Label("Nurse name : \t");
		nameOfNurse.setTextFill(Color.SEAGREEN);
		TextField nameText1 = new TextField();
		nameText1.setPromptText("String");
		nameText1.setPrefSize(80, 20);
		nameText1.setOnMouseClicked(e -> {
			nameText1.setText("");
		});

		HBox name1 = new HBox(5);
		name1.getChildren().addAll(nameOfNurse, nameText1);

		Label SINNur = new Label("SINNur :\t\t");
		SINNur.setTextFill(Color.SEAGREEN);
		TextField SINNurText = new TextField();
		SINNurText.setPromptText("Number");
		SINNurText.setPrefSize(80, 20);
		SINNurText.setOnMouseClicked(e -> {
			SINNurText.setText("");
		});
		HBox SINNurHbox = new HBox(5);
		SINNurHbox.getChildren().addAll(SINNur, SINNurText);

		Label ageOfNurse = new Label("Nurse age : \t");
		ageOfNurse.setTextFill(Color.SEAGREEN);
		TextField ageText1 = new TextField();
		ageText1.setPromptText("Number");
		ageText1.setPrefSize(80, 20);
		ageText1.setOnMouseClicked(e -> {
			ageText1.setText("");
		});
		HBox age1 = new HBox(5);
		age1.getChildren().addAll(ageOfNurse, ageText1);

		Label phoneOfNurse = new Label(" phone : \t\t");
		phoneOfNurse.setTextFill(Color.SEAGREEN);
		TextField phoneText1 = new TextField();
		phoneText1.setPromptText("Number");
		phoneText1.setPrefSize(80, 20);
		phoneText1.setOnMouseClicked(e -> {
			phoneText1.setText("");
		});
		HBox phone1 = new HBox(5);
		phone1.getChildren().addAll(phoneOfNurse, phoneText1);

		Label sexOfNurse = new Label(" sex : \t\t");
		sexOfNurse.setTextFill(Color.SEAGREEN);
		ComboBox<String> sexText1 = new ComboBox<String>();
		sexText1.setPrefSize(80, 20);
		sexText1.getItems().addAll("Male", "Female");
		HBox sex1 = new HBox(5);
		sex1.getChildren().addAll(sexOfNurse, sexText1);

		Button Enter1 = new Button("Enter");
		Enter1.setTextFill(Color.CORAL);
		Label resEnter1 = new Label("");
		HBox EnterHBox1 = new HBox(10);
		EnterHBox1.getChildren().addAll(Enter1, resEnter1);

		VBox Nurse = new VBox(10);
		Nurse.getChildren().addAll(addNewNurse, name1, SINNurHbox, age1, phone1, sex1, EnterHBox1);
		Nurse.setLayoutX(20);
		Nurse.setLayoutY(310);

		Enter1.setOnAction(e -> {
			Statement ss1;
			try {
				ss1 = con.createStatement();
				ss1.executeUpdate("insert into nurses (nameNurse, SIN, age, numPhone, sex)  value ( '"
						+ nameText1.getText() + "', '" + Integer.valueOf(SINNurText.getText()) + "', '"
						+ Integer.valueOf(ageText1.getText()) + "', '" + Integer.valueOf(phoneText1.getText()) + "', '"
						+ sexText1.getValue().toString() + "') ;");

				resEnter1.setText("Done!!!");
				resEnter1.setTextFill(Color.GREEN);
			} catch (Exception e11) {
				// TODO Auto-generated catch block
				e11.printStackTrace();
				resEnter1.setText("Wrong Input!!!");
				resEnter1.setTextFill(Color.RED);
			}
		});

		// ------------------End Add Nurse-----------------
		// -------------------------------------------------------------------------------

		// ------------------Add new specialty----------------------------------------
		// ---------------------------------------------------------------------------

		Label addNewSpecialty = new Label("Add new Specialty : \t");
		addNewSpecialty.setFont(Font.font("", FontWeight.BOLD, 15));

		Label nameSpecialty = new Label("Specialty :   ");
		nameSpecialty.setTextFill(Color.SEAGREEN);
		TextField nameSpecialtyText = new TextField();
		nameSpecialtyText.setPromptText("String");
		nameSpecialtyText.setPrefSize(80, 20);
		nameSpecialtyText.setOnMouseClicked(e -> {
			nameSpecialtyText.setText("");
		});

		HBox NameSpecialtyHBox = new HBox(5);
		NameSpecialtyHBox.getChildren().addAll(nameSpecialty, nameSpecialtyText);

		Button Enter5 = new Button("Enter");
		Enter5.setTextFill(Color.CORAL);
		Label resEnter5 = new Label("");
		HBox EnterHBox5 = new HBox(10);
		EnterHBox5.getChildren().addAll(Enter5, resEnter5);

		//////////////// Add Spciality od Doctor/////////////////////
		Button Enter6 = new Button("View each doctor's spec");
		Enter6.setPrefSize(150, 20);
		Enter6.setTextFill(Color.CORAL);
		Label resEnter6 = new Label("");
		HBox EnterHBox6 = new HBox(10);
		EnterHBox6.getChildren().addAll(Enter6, resEnter6);

		Enter6.setOnAction(e -> {
			Statement ss;
			try {
				ss = con.createStatement();

				ResultSet resultSet = null;
				resultSet = ss.executeQuery(
						"select ds.idDoc, d.namedc, s.nameofspe from doctors  d, specialization  s, doc2spec ds where d.id = ds.idDoc and s.id = ds.idSpec");

				String string = " ";

				while (resultSet.next()) {
					string += "IdDoc: " + resultSet.getString(1) + " , " + " nameDoc: " + resultSet.getString(2) + " , "
							+ "spcialize : " + resultSet.getString(3) + " \n";
				}

				textarea2.setText(string);

				resEnter6.setText("Done!!!");
				resEnter6.setTextFill(Color.GREEN);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				resEnter6.setText("Wrong Input!!!");
				resEnter6.setTextFill(Color.RED);
			}
		});

		// This Button to insert doctor and specialize

		Label idOfDoctor = new Label("doctor ID :  ");
		idOfDoctor.setTextFill(Color.SEAGREEN);
		TextField idText = new TextField();
		idText.setPromptText("Number");
		idText.setPrefSize(80, 20);
		idText.setOnMouseClicked(e -> {
			idText.setText("");
		});
		HBox id = new HBox(5);
		id.getChildren().addAll(idOfDoctor, idText);

		Button Enter77 = new Button("Enter Doctor spec");
		Enter77.setPrefSize(120, 20);
		Enter77.setTextFill(Color.CORAL);
		Label resEnter77 = new Label("");
		HBox EnterHBox77 = new HBox(10);
		EnterHBox77.getChildren().addAll(Enter77, resEnter77);

		Label idSpecialty = new Label("id Specialty:");
		idSpecialty.setTextFill(Color.SEAGREEN);
		TextField idTextSpecialty = new TextField();
		idTextSpecialty.setPromptText("String");
		idTextSpecialty.setPrefSize(80, 20);
		idTextSpecialty.setOnMouseClicked(e -> {
			idTextSpecialty.setText("");
		});

		HBox idSpecialtyHBox = new HBox(5);
		idSpecialtyHBox.getChildren().addAll(idSpecialty, idTextSpecialty);

		Enter77.setOnAction(e -> {
			Statement ss;
			try {
				ss = con.createStatement();
				ss.executeUpdate("insert into doc2spec (idDoc, idSpec)  value ( '" + Integer.valueOf(idText.getText())
						+ "', '" + Integer.valueOf(idTextSpecialty.getText()).toString() + "') ;");

				resEnter77.setText("Done!!!");
				resEnter77.setTextFill(Color.GREEN);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				resEnter77.setText("Wrong Input!!!");
				resEnter77.setTextFill(Color.RED);
			}
		});

		Enter5.setOnAction(e -> {
			Statement ss;
			try {
				ss = con.createStatement();
				ss.executeUpdate("insert into specialization (nameofspe) value ( '"
						+ nameSpecialtyText.getText().toString() + "') ;");

				resEnter5.setText("Done!!!");
				resEnter5.setTextFill(Color.GREEN);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				resEnter5.setText("Wrong Input!!!");
				resEnter5.setTextFill(Color.RED);
			}
		});
		//////////////////////////////////////////////////////////
		ComboBox<String> SpcialitiyText = new ComboBox<String>();
		SpcialitiyText.setPrefSize(80, 20);
		Statement statm = con.createStatement();
		ResultSet result = statm.executeQuery("select * from specialization");
		while (result.next()) {
			SpcialitiyText.getItems().add(result.getString(2));
		}

		SpcialitiyText.setOnAction(ee -> {
			try {
				Statement stat1 = con.createStatement();
				ResultSet res1 = statm.executeQuery("select * from specialization");
				for (int i = 0; i < SpcialitiyText.getItems().indexOf(SpcialitiyText.getValue()) + 1; i++) {
					res1.next();
				}
				System.out.println(res1.getString(2));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		Button viewSpeciality = new Button("View Spec and ID");
		viewSpeciality.setPrefSize(120, 20);
		viewSpeciality.setTextFill(Color.CORAL);
		Label resEnter88 = new Label("");
		HBox EnterHBox88 = new HBox(10);
		EnterHBox88.getChildren().addAll(viewSpeciality, resEnter88);

		viewSpeciality.setOnAction(ee -> {
			Statement ss3;
			try {
				ss3 = con.createStatement();
				ResultSet resultSet88 = null;
				resultSet88 = ss3.executeQuery("select * from specialization");

				String string = " ";

				while (resultSet88.next()) {
					string += "idSpec: " + resultSet88.getString(1) + "\t\t" + "nameSpec: " + resultSet88.getString(2)
							+ "\n";
				}

				textarea2.setText(string);

			} catch (Exception e33) {
				// TODO Auto-generated catch block
				e33.printStackTrace();
				resEnter88.setText("Wrong Input!!!");
				resEnter88.setTextFill(Color.RED);
			}

		});

		VBox SpecialtyVBox = new VBox(10);
		SpecialtyVBox.getChildren().addAll(addNewSpecialty, NameSpecialtyHBox, EnterHBox5, SpcialitiyText, id,
				idSpecialtyHBox, EnterHBox77, EnterHBox6, EnterHBox88);
		SpecialtyVBox.setLayoutX(640);
		SpecialtyVBox.setLayoutY(30);

		// ------------------delete Doctor-----------------

		// delete Doctor (Hiba)
		Label deleteDoc = new Label("Delete Doctor : \t");
		deleteDoc.setFont(Font.font("", FontWeight.BOLD, 15));

		Label idOfDoctor1 = new Label("doctor ID : \t");
		idOfDoctor1.setTextFill(Color.SEAGREEN);
		ComboBox<String> idTextdoc = new ComboBox<>();

		try {
			ResultSet resDelete = con.createStatement().executeQuery("select id from doctors ;");

			while (resDelete.next()) {
				idTextdoc.getItems().add(resDelete.getString(1));
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		idTextdoc.setPrefSize(80, 20);

		HBox iddoc = new HBox(5);
		iddoc.getChildren().addAll(idOfDoctor1, idTextdoc);

		Button deletedoc = new Button("delete");
		deletedoc.setTextFill(Color.CORAL);
		Label resdelete = new Label("");
		HBox deleteHBox = new HBox(10);
		deleteHBox.getChildren().addAll(deletedoc, resdelete);

		///////////////////
		Button TableViewAdddoc = new Button(" Table view Doctor");
		TableViewAdddoc.setTextFill(Color.CORAL);
		Label restableviewdoc = new Label("");
		HBox TableViewHBoxdoc = new HBox(10);
		TableViewHBoxdoc.getChildren().addAll(TableViewAdddoc, restableviewdoc);

		TableViewAdddoc.setOnAction(e -> {
			Statement ss1;
			try {
				ss1 = con.createStatement();
				Group group1 = new Group();
				Scene scene1 = new Scene(group1, 500, 500);
				Stage stage1 = new Stage();

				scene1.setFill(Color.AZURE);
				stage1.setMaxWidth(500);
				stage1.setTitle("Data Of Doctors");

				buildData();
				Parent root = tableViewdoc;

				tableViewdoc.setPrefSize(450, 400);
				tableViewdoc.setLayoutX(30);
				tableViewdoc.setLayoutY(80);

				Label label = new Label("Table View Doctors");
				label.setLayoutX(30);
				label.setLayoutY(5);
				label.setPrefSize(200, 100);
				label.setFont(Font.font("Arial", FontWeight.BOLD, 20));

				group1.getChildren().addAll(tableViewdoc, label);

				stage1.setScene(scene1);
				stage1.show();
				// return stage;

				restableviewdoc.setText("Done!!!");
				restableviewdoc.setTextFill(Color.GREEN);
			} catch (Exception e11) {
				// TODO Auto-generated catch block
				e11.printStackTrace();
				restableviewdoc.setText("Wrong Input!!!");
				restableviewdoc.setTextFill(Color.RED);
			}
		});

		VBox deletdoc = new VBox(10);
		deletdoc.getChildren().addAll(deleteDoc, iddoc, deleteHBox, TableViewHBoxdoc);/////
		deletdoc.setLayoutX(230);
		deletdoc.setLayoutY(30);

		// action in line 840

		// ---------------------------------------------------------
		// ------------------delete Nurse---------------------------

		// delete Nurse (Hiba)
		Label deleteNur = new Label("Delete Nurse : \t");
		deleteNur.setFont(Font.font("", FontWeight.BOLD, 15));

		Label idOfNurse1 = new Label("Nurse ID : \t");
		idOfNurse1.setTextFill(Color.SEAGREEN);
		ComboBox<String> idTextNurse = new ComboBox<>();
		try {
			ResultSet resDelete = con.createStatement().executeQuery("select id from nurses ;");

			while (resDelete.next()) {
				idTextNurse.getItems().add(resDelete.getString(1));
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		idTextNurse.setPrefSize(80, 20);

		HBox idNur = new HBox(5);
		idNur.getChildren().addAll(idOfNurse1, idTextNurse);

		Button deleteNurse = new Button("delete");
		deleteNurse.setTextFill(Color.CORAL);
		Label resdeleteNur = new Label("");
		HBox deleteNurHBox = new HBox(10);
		deleteNurHBox.getChildren().addAll(deleteNurse, resdeleteNur);

		Button TableViewAddNurse = new Button(" Table view Nurses");
		TableViewAddNurse.setTextFill(Color.CORAL);
		Label restableviewNurse = new Label("");
		HBox TableViewHBoxNuurse = new HBox(10);
		TableViewHBoxNuurse.getChildren().addAll(TableViewAddNurse, restableviewNurse);

		TableViewAddNurse.setOnAction(e -> {
			Statement ss2;
			try {
				ss2 = con.createStatement();
				Group group2 = new Group();
				Scene scene2 = new Scene(group2, 500, 500);
				Stage stage2 = new Stage();

				scene2.setFill(Color.FLORALWHITE);
				stage2.setMaxWidth(500);
				stage2.setTitle("Data Of Nurses");

				buildData1();
				Parent root = tableViewNur;

				tableViewNur.setPrefSize(450, 400);
				tableViewNur.setLayoutX(30);
				tableViewNur.setLayoutY(80);

				Label label = new Label("Table View Nurses");
				label.setLayoutX(30);
				label.setLayoutY(5);
				label.setPrefSize(200, 100);
				label.setFont(Font.font("Arial", FontWeight.BOLD, 20));

				group2.getChildren().addAll(tableViewNur, label);

				stage2.setScene(scene2);
				stage2.show();
				// return stage;
//--module-path "C:\Program Files\Java\javafx-sdk-17.0.0.1\lib" --add-modules javafx.controls,javafx.fxml
				restableviewNurse.setText("Done!!!");
				restableviewNurse.setTextFill(Color.GREEN);
			} catch (Exception e11) {
				// TODO Auto-generated catch block
				e11.printStackTrace();
				restableviewNurse.setText("Wrong Input!!!");
				restableviewNurse.setTextFill(Color.RED);
			}
		});

		VBox deletNur = new VBox(10);
		deletNur.getChildren().addAll(deleteNur, idNur, deleteNurHBox, TableViewHBoxNuurse);
		deletNur.setLayoutX(230);
		deletNur.setLayoutY(310);

		deleteNurse.setOnAction(e -> {
			Statement ss3;
			try {
				ss3 = con.createStatement();
				ss3.executeUpdate("delete from nurses where id= ( '"
						+ Integer.valueOf(idTextNurse.getValue()).toString() + "') ;");
				idTextNurse.getItems().clear();
				try {
					ResultSet resDelete = con.createStatement().executeQuery("select id from nurses ;");

					while (resDelete.next()) {
						idTextNurse.getItems().add(resDelete.getString(1));
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				resdeleteNur.setText("Done!!!");
				resdeleteNur.setTextFill(Color.GREEN);
			} catch (Exception e33) {
				// TODO Auto-generated catch block
				e33.printStackTrace();
				resdeleteNur.setText("Wrong Input!!!");
				resdeleteNur.setTextFill(Color.RED);
			}
		});

		// --------------------------------------------------
		// -------------------Reservation--------------------
		// new Reservation
		Label addRes = new Label("Add new Reservation : \t");

		addRes.setFont(Font.font("", FontWeight.BOLD, 15));

		Label idOfDoctor3 = new Label("doctor ID : \t");
		idOfDoctor3.setTextFill(Color.SEAGREEN);
		ComboBox<String> idText3 = new ComboBox<String>();
		idText3.setPrefSize(80, 20);
		Label details = new Label();
		Statement stat = con.createStatement();
		ResultSet res = stat.executeQuery("select* from doctors;");
		while (res.next()) {
			idText3.getItems().add(res.getString(1));
		}

		idText3.setOnAction(ee -> {
			try {
				Statement stat1 = con.createStatement();
				ResultSet res1 = stat.executeQuery("select* from doctors;");
				for (int i = 0; i < idText3.getItems().indexOf(idText3.getValue()) + 1; i++) {
					res1.next();
				}
				System.out.println(res1.getString(1) + " " + res1.getString(2));
				details.setText("name :" + res1.getString(2) + " | age :" + res1.getString(3) + "\nPhone :"
						+ res1.getString(4) + " | sex :" + res1.getString(5));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		deletedoc.setOnAction(e -> {
			Statement ss2;
			try {
				ss2 = con.createStatement();
				ss2.executeUpdate("delete from doctors where id = '" + Integer.valueOf(idTextdoc.getValue()) + "';");
				idTextdoc.getItems().clear();
				idText3.getItems().clear();
				try {
					ResultSet resDelete = con.createStatement().executeQuery("select id from doctors ;");

					while (resDelete.next()) {
						idTextdoc.getItems().add(resDelete.getString(1));
						idText3.getItems().add(resDelete.getString(1));
						details.setText("");
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				resdelete.setText("Done!!!");
				resdelete.setTextFill(Color.GREEN);
			} catch (Exception e22) {
				// TODO Auto-generated catch block
				e22.printStackTrace();
				resdelete.setText("Wrong Input!!!");
				resdelete.setTextFill(Color.RED);
			}
		});

		HBox id3 = new HBox(5);
		id3.getChildren().addAll(idOfDoctor3, idText3);

		Label Time = new Label("Time : \t\t");
		Time.setTextFill(Color.SEAGREEN);
		TextField TextFieldTime = new TextField();
		TextFieldTime.setPromptText("HH:MM:SS");
		TextFieldTime.setPrefSize(80, 20);
		TextFieldTime.setOnMouseClicked(e -> {
			TextFieldTime.setText("");
		});
		HBox TimeHBox = new HBox(5);
		TimeHBox.getChildren().addAll(Time, TextFieldTime);

		Label date = new Label("Date : \t\t");
		date.setTextFill(Color.SEAGREEN);
		TextField TextFieldDate = new TextField();
		TextFieldDate.setPromptText("YY:MM:DD");
		TextFieldDate.setPrefSize(80, 20);
		TextFieldDate.setOnMouseClicked(e -> {
			TextFieldDate.setText("");
		});
		HBox dateHBox = new HBox(5);
		dateHBox.getChildren().addAll(date, TextFieldDate);

		Button Enter3 = new Button("Enter");
		Enter3.setTextFill(Color.CORAL);
		Label resEnter3 = new Label("");
		HBox EnterHBox3 = new HBox(10);
		EnterHBox3.getChildren().addAll(Enter3, resEnter3);

		VBox Reservation = new VBox(10);
		Reservation.getChildren().addAll(addRes, id3, details, TimeHBox, dateHBox, EnterHBox3);
		Reservation.setLayoutX(430);
		Reservation.setLayoutY(30);

		Enter3.setOnAction(e -> {
			Statement ss4;
			try {
				ss4 = con.createStatement();
				ss4.executeUpdate("insert into doctorsdate ( doctorId, dates, timee)  value ('"
						+ Integer.valueOf(idText3.getValue()) + "','" + TextFieldDate.getText() + "','"
						+ TextFieldTime.getText() + "')");

				System.out.println(idText3.getItems().indexOf(idText3.getValue()));

				resEnter3.setText("Done!!!");
				resEnter3.setTextFill(Color.GREEN);
			} catch (Exception e44) {
				// TODO Auto-generated catch block
				e44.printStackTrace();
				resEnter3.setText("Wrong Input!!!");
				resEnter3.setTextFill(Color.RED);
			}
		});

		// ----------------------------------------------------------
		// ----------------ButtonsQuiary------------------------------

		Button ViewOtherQueries = new Button("View Other Queries");
		ViewOtherQueries.setTextFill(Color.CORAL);
		ViewOtherQueries.setPrefSize(150, 30);
		Label resEnter7 = new Label("");
		HBox EnterHBox7 = new HBox(10);
		EnterHBox7.setLayoutX(430);
		EnterHBox7.setLayoutY(240);
		EnterHBox7.getChildren().addAll(ViewOtherQueries, resEnter7);

		ViewOtherQueries.setOnAction(e -> {
			Statement ss2;
			try {
				ss2 = con.createStatement();
				Group group4 = new Group();
				Scene scene4 = new Scene(group4, 500, 500);
				Stage stage4 = new Stage();

				TextArea textArea = new TextArea();
				textArea.setPrefSize(230, 150);
				textArea.setLayoutX(200);
				textArea.setLayoutY(300);

				Button countDoctors = new Button("Count Doctors");
				countDoctors.setPrefSize(100, 30);
				Label resEnter8 = new Label("");
				HBox EnterHBox8 = new HBox(10);
				EnterHBox8.getChildren().addAll(countDoctors, resEnter8);

				countDoctors.setOnAction(ee -> {
					Statement ss3;
					try {
						ss3 = con.createStatement();
						ResultSet resultSet1 = null;
						resultSet1 = ss3.executeQuery("SELECT COUNT(id) FROM doctors");
						resultSet1.next();

						resEnter8.setText(resultSet1.getString(1));
						resEnter8.setTextFill(Color.GREEN);

					} catch (Exception e33) {
						// TODO Auto-generated catch block
						e33.printStackTrace();
						resEnter8.setText("Wrong Input!!!");
						resEnter8.setTextFill(Color.RED);
					}

				});
				// -------------------------------------------------------

				Button countNurses = new Button("Count Nurses");
				countNurses.setPrefSize(100, 30);
				Label resEnter9 = new Label("");
				HBox EnterHBox9 = new HBox(10);
				EnterHBox9.getChildren().addAll(countNurses, resEnter9);

				countNurses.setOnAction(ee -> {
					Statement ss3;
					try {
						ss3 = con.createStatement();
						ResultSet resultSet2 = null;
						resultSet2 = ss3.executeQuery("SELECT COUNT(id) FROM nurses");
						resultSet2.next();

						resEnter9.setText(resultSet2.getString(1));
						resEnter9.setTextFill(Color.GREEN);

					} catch (Exception e33) {
						// TODO Auto-generated catch block
						e33.printStackTrace();
						resEnter9.setText("Wrong Input!!!");
						resEnter9.setTextFill(Color.RED);
					}

				});
				// ----------------------------------------------------

				Button countPatient = new Button("Count Patient");
				countPatient.setPrefSize(100, 30);
				Label resEnter10 = new Label("");
				HBox EnterHBox10 = new HBox(10);
				EnterHBox10.getChildren().addAll(countPatient, resEnter10);

				countPatient.setOnAction(ee -> {
					Statement ss3;
					try {
						ss3 = con.createStatement();
						ResultSet resultSet3 = null;
						resultSet3 = ss3.executeQuery("SELECT COUNT(id) FROM patient");
						resultSet3.next();

						resEnter10.setText(resultSet3.getString(1));
						resEnter10.setTextFill(Color.GREEN);

					} catch (Exception e33) {
						// TODO Auto-generated catch block
						e33.printStackTrace();
						resEnter10.setText("Wrong Input!!!");
						resEnter10.setTextFill(Color.RED);
					}

				});
				// -----------------------------------------------------

				Button AssendingDoctors = new Button("ASC Doctors");
				AssendingDoctors.setPrefSize(100, 30);
				Label resEnter11 = new Label("");
				HBox EnterHBox11 = new HBox(10);
				EnterHBox11.getChildren().addAll(AssendingDoctors, resEnter11);

				AssendingDoctors.setOnAction(ee -> {
					Statement ss3;
					try {
						ss3 = con.createStatement();
						ResultSet resultSet4 = null;
						resultSet4 = ss3.executeQuery("SELECT * FROM doctors ORDER BY id,namedc ASC");
						resultSet4.next();

						resEnter11.setText("Done!");
						resEnter11.setTextFill(Color.RED);

					} catch (Exception e33) {
						// TODO Auto-generated catch block
						e33.printStackTrace();
						resEnter11.setText("Wrong Input!!!");
						resEnter11.setTextFill(Color.RED);
					}

				});

				// -----------------------------------------------------------

				Button AssendingNurses = new Button("ASC Nurses");
				AssendingNurses.setPrefSize(100, 30);
				Label resEnter12 = new Label("");
				HBox EnterHBox12 = new HBox(10);
				EnterHBox12.getChildren().addAll(AssendingNurses, resEnter12);

				AssendingNurses.setOnAction(ee -> {
					Statement ss3;
					try {
						ss3 = con.createStatement();
						ResultSet resultSet5 = null;
						resultSet5 = ss3.executeQuery("SELECT * FROM nurses ORDER BY id,nameNurse,age ASC");
						resultSet5.next();

						resEnter12.setText("Done!");
						resEnter12.setTextFill(Color.RED);

					} catch (Exception e33) {
						// TODO Auto-generated catch block
						e33.printStackTrace();
						resEnter12.setText("Wrong Input!!!");
						resEnter12.setTextFill(Color.RED);
					}

				});

				// -------------------------------------------------------

				// --------------------------------------------------------------------

				Button Corona1 = new Button("Receive Corona 1");
				Corona1.setPrefSize(150, 30);
				Label resEnter14 = new Label("");
				HBox EnterHBox14 = new HBox(10);
				EnterHBox14.getChildren().addAll(Corona1, resEnter14);

				Corona1.setOnAction(ee -> {
					Statement ss3;
					try {
						ss3 = con.createStatement();
						ResultSet resultSet7 = null;
						resultSet7 = ss3.executeQuery("SELECT name,id FROM patient where Corona_doses_received=1");

						String string = " ";

						while (resultSet7.next()) {
							string += resultSet7.getString(1) + " , " + resultSet7.getString(2) + "\n";
						}

						textArea.setText(string);

					} catch (Exception e33) {
						// TODO Auto-generated catch block
						e33.printStackTrace();
						resEnter14.setText("Wrong Input!!!");
						resEnter14.setTextFill(Color.RED);
					}

				});

				// --------------------------------------------------------------------

				Button Corona2 = new Button("Receive Corona 2");
				Corona2.setPrefSize(150, 30);
				Label resEnter15 = new Label("");
				HBox EnterHBox15 = new HBox(10);
				EnterHBox15.getChildren().addAll(Corona2, resEnter15);

				Corona2.setOnAction(ee -> {
					Statement ss3;
					try {
						ss3 = con.createStatement();
						ResultSet resultSet8 = null;
						resultSet8 = ss3.executeQuery("SELECT name,id FROM patient where Corona_doses_received=2");
						String string = " ";

						while (resultSet8.next()) {
							string += resultSet8.getString(1) + " , " + resultSet8.getString(2) + "\n";
						}

						textArea.setText(string);

					} catch (Exception e33) {
						// TODO Auto-generated catch block
						e33.printStackTrace();
						resEnter15.setText("Wrong Input!!!");
						resEnter15.setTextFill(Color.RED);
					}

				});
				// ---------------------------------------------------------

				Button Corona3 = new Button("Receive Corona 3");
				Corona3.setPrefSize(150, 30);
				Label resEnter16 = new Label("");
				HBox EnterHBox16 = new HBox(10);
				EnterHBox16.getChildren().addAll(Corona3, resEnter16);

				Corona3.setOnAction(ee -> {
					Statement ss3;
					try {
						ss3 = con.createStatement();
						ResultSet resultSet9 = null;
						resultSet9 = ss3.executeQuery("SELECT name,id FROM patient where Corona_doses_received=3");
						String string = " ";

						while (resultSet9.next()) {
							string += resultSet9.getString(1) + " , " + resultSet9.getString(2) + "\n";
						}

						textArea.setText(string);

					} catch (Exception e33) {
						// TODO Auto-generated catch block
						e33.printStackTrace();
						resEnter16.setText("Wrong Input!!!");
						resEnter16.setTextFill(Color.RED);
					}

				});

				// -------------------------------------------------------------

				Button CountCorona1 = new Button("Count Corona 1");
				CountCorona1.setPrefSize(100, 30);
				Label resEnter17 = new Label("");
				HBox EnterHBox17 = new HBox(10);
				EnterHBox17.getChildren().addAll(CountCorona1, resEnter17);

				CountCorona1.setOnAction(ee -> {
					Statement ss3;
					try {
						ss3 = con.createStatement();
						ResultSet resultSet10 = null;
						resultSet10 = ss3.executeQuery("SELECT COUNT(id) FROM patient where Corona_doses_received=1");
						resultSet10.next();

						resEnter17.setText(resultSet10.getString(1));
						resEnter17.setTextFill(Color.GREEN);

					} catch (Exception e33) {
						// TODO Auto-generated catch block
						e33.printStackTrace();
						resEnter17.setText("Wrong Input!!!");
						resEnter17.setTextFill(Color.RED);
					}

				});

				// ----------------------------------------------------------------

				Button CountCorona2 = new Button("Count Corona 2");
				CountCorona2.setPrefSize(100, 30);
				Label resEnter18 = new Label("");
				HBox EnterHBox18 = new HBox(10);
				EnterHBox18.getChildren().addAll(CountCorona2, resEnter18);

				CountCorona2.setOnAction(ee -> {
					Statement ss3;
					try {
						ss3 = con.createStatement();
						ResultSet resultSet11 = null;
						resultSet11 = ss3.executeQuery("SELECT COUNT(id) FROM patient where Corona_doses_received=2");
						resultSet11.next();

						resEnter18.setText(resultSet11.getString(1));
						resEnter18.setTextFill(Color.GREEN);

					} catch (Exception e33) {
						// TODO Auto-generated catch block
						e33.printStackTrace();
						resEnter18.setText("Wrong Input!!!");
						resEnter18.setTextFill(Color.RED);
					}

				});

				Button CountCorona3 = new Button("Count Corona 3");
				CountCorona3.setPrefSize(100, 30);
				Label resEnter19 = new Label("");
				HBox EnterHBox19 = new HBox(10);
				EnterHBox19.getChildren().addAll(CountCorona3, resEnter19);

				CountCorona3.setOnAction(ee -> {
					Statement ss3;
					try {
						ss3 = con.createStatement();
						ResultSet resultSet12 = null;
						resultSet12 = ss3.executeQuery("SELECT COUNT(id) FROM patient where Corona_doses_received=3");
						resultSet12.next();

						resEnter19.setText(resultSet12.getString(1));
						resEnter19.setTextFill(Color.GREEN);

					} catch (Exception e33) {
						// TODO Auto-generated catch block
						e33.printStackTrace();
						resEnter19.setText("Wrong Input!!!");
						resEnter19.setTextFill(Color.RED);
					}

				});

				// ----------------------------------------------------------------------

				VBox CounterVBox = new VBox(10);
				CounterVBox.getChildren().addAll(EnterHBox8, EnterHBox9, EnterHBox10, EnterHBox11, EnterHBox12,
						EnterHBox17, EnterHBox18, EnterHBox19);
				CounterVBox.setLayoutX(10);
				CounterVBox.setLayoutY(15);

				VBox CounterVBox2 = new VBox(10);
				CounterVBox2.getChildren().addAll(EnterHBox14, EnterHBox15, EnterHBox16);
				CounterVBox2.setLayoutX(190);
				CounterVBox2.setLayoutY(15);

				group4.getChildren().addAll(CounterVBox, CounterVBox2, textArea);

				scene4.setFill(Color.LEMONCHIFFON);
				stage4.setMaxWidth(500);
				stage4.setTitle("Quiers");
				stage4.setScene(scene4);
				stage4.show();

				resEnter7.setText("Done!!!");
				resEnter7.setTextFill(Color.GREEN);
			} catch (Exception e11) {
				// TODO Auto-generated catch block
				e11.printStackTrace();
				resEnter7.setText("Wrong Input!!!");
				resEnter7.setTextFill(Color.RED);
			}
		});

		group.getChildren().addAll(rec, title, doc, Nurse, deletdoc, deletNur, Reservation, SpecialtyVBox, EnterHBox7,
				stack, stack2, stack3, textarea2);

		// bahaa

		// add Pharmacy

		ComboBox<String> patient = new ComboBox<>();
		ResultSet patientRes = con.createStatement().executeQuery("select * from patient where boolpharmacy != true");

		while (patientRes.next()) {
			String str = patientRes.getString(1) + " " + patientRes.getString(2);
			patient.getItems().add(str);
		}

		Button addPharnacy = new Button("Add a pharmacist");
		Label resAdd = new Label("");

		HBox addPh = new HBox(10);
		addPh.getChildren().addAll(patient, addPharnacy, resAdd);
		addPh.setLayoutX(20);
		addPh.setLayoutY(570);

		Line line = new Line(20, 560, 400, 560);

		addPharnacy.setOnAction(e -> {
			Statement statAddPh;
			try {
				String ss[] = patient.getValue().split(" ");
				statAddPh = con.createStatement();
				statAddPh.executeUpdate(
						"update patient p set p.boolpharmacy =true where p.id ='" + Integer.valueOf(ss[0]) + "';");

				ResultSet patientRes1 = con.createStatement()
						.executeQuery("select * from patient where boolpharmacy != true");

				patient.getItems().clear();
				while (patientRes1.next()) {
					String str = patientRes1.getString(1) + " " + patientRes1.getString(2);
					patient.getItems().add(str);
				}

				resAdd.setText("Done");
				resAdd.setTextFill(Color.GREEN);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		// remove Pharmacy

		ComboBox<String> patientRemove = new ComboBox<>();
		ResultSet patientResRemove = con.createStatement()
				.executeQuery("select * from patient where boolpharmacy = true");

		while (patientResRemove.next()) {
			String str = patientResRemove.getString(1) + " " + patientResRemove.getString(2);
			patientRemove.getItems().add(str);
		}

		Button removePharnacy = new Button("Remove a pharmacist");
		Label resRemove = new Label("");

		HBox removePh = new HBox(10);
		removePh.getChildren().addAll(patientRemove, removePharnacy, resRemove);
		removePh.setLayoutX(20);
		removePh.setLayoutY(600);

		removePharnacy.setOnAction(e -> {
			Statement statRemovePh;
			try {
				String ss[] = patientRemove.getValue().split(" ");
				statRemovePh = con.createStatement();
				statRemovePh.executeUpdate(
						"update patient p set p.boolpharmacy =false where p.id ='" + Integer.valueOf(ss[0]) + "';");

				ResultSet patientResRemove1 = con.createStatement()
						.executeQuery("select * from patient where boolpharmacy = true");

				patientRemove.getItems().clear();
				while (patientResRemove1.next()) {
					String str = patientResRemove1.getString(1) + " " + patientResRemove1.getString(2);
					patientRemove.getItems().add(str);
				}

				ResultSet patientRes1 = con.createStatement()
						.executeQuery("select * from patient where boolpharmacy != true");

				patient.getItems().clear();
				while (patientRes1.next()) {
					String str = patientRes1.getString(1) + " " + patientRes1.getString(2);
					patient.getItems().add(str);
				}

				resRemove.setText("Done");
				resRemove.setTextFill(Color.GREEN);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
			}
		});

		addPharnacy.setOnAction(e -> {
			Statement statAddPh;
			try {
				String ss[] = patient.getValue().split(" ");
				statAddPh = con.createStatement();
				statAddPh.executeUpdate(
						"update patient p set p.boolpharmacy =true where p.id ='" + Integer.valueOf(ss[0]) + "';");

				ResultSet patientRes1 = con.createStatement()
						.executeQuery("select * from patient where boolpharmacy != true");

				patient.getItems().clear();
				while (patientRes1.next()) {
					String str = patientRes1.getString(1) + " " + patientRes1.getString(2);
					patient.getItems().add(str);
				}

				ResultSet patientResRemove1 = con.createStatement()
						.executeQuery("select * from patient where boolpharmacy = true");

				patientRemove.getItems().clear();
				while (patientResRemove1.next()) {
					String str = patientResRemove1.getString(1) + " " + patientResRemove1.getString(2);
					patientRemove.getItems().add(str);
				}
				resAdd.setText("Done");
				resAdd.setTextFill(Color.GREEN);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		group.getChildren().addAll(line, addPh, removePh);

		stage.setScene(scene);
		stage.setMaxWidth(850);
		stage.setMaxHeight(700);

		return stage;

	}

	// ________________________________________________________________________________
	// ________________________________________________________________________________

	// __________
	// __________

	// (bahaa)

	// this id for patient who sign in
	int ID;
	String Name;
	String passwd;

	public Stage signIn() {

		Stage stage = new Stage();
		stage.setTitle("Sign In");
		stage.setResizable(false);

		Group group = new Group();
		Scene scene = new Scene(group, 400, 500);
		Rectangle rec = new Rectangle(400, 500);
		rec.setFill(Color.rgb(39, 162, 215));

		// choose
		HBox inup = new HBox(7);
		inup.setMinWidth(380);
		inup.setMinHeight(100);
		inup.setLayoutY(5);
		inup.setLayoutX(5);

		String styleBun = "-fx-background-radius : 10; -fx-pref-height: 40px; -fx-background-color:white; -fx-text-fill:black;";

		Button in = new Button("Sign In");
		in.setMinWidth(190);

		in.setStyle(styleBun);

		String styleinup = "-fx-background-radius : 20; -fx-pref-height: 50px;-fx-background-color:white;";
		in.setOnMouseEntered(e -> {
			in.setStyle(styleinup);
		});
		in.setOnMouseExited(e -> {
			in.setStyle(styleBun);
		});

		Button up = new Button("Sign Up");
		up.setMinWidth(190);
		up.setStyle(styleBun);
		up.setOnMouseEntered(e -> {
			up.setStyle(styleinup);
		});
		up.setOnMouseExited(e -> {
			up.setStyle(styleBun);
		});

		Line line = new Line(5, 50, 395, 50);

		inup.getChildren().addAll(in, up);

		// _________
		// sign In
		VBox signInVbox = new VBox(20);
		signInVbox.setLayoutX(70);
		signInVbox.setLayoutY(170);

		String textField = "-fx-pref-height:30px; " + "-fx-pref-width:250px";
		TextField username = new TextField("UserName");
		username.setOnMouseClicked(e -> {
			username.setText("");
		});
		username.setStyle(textField);

		TextField passwd = new TextField("Password");
		passwd.setOnMouseClicked(e -> {
			passwd.setText("");
		});
		passwd.setStyle(textField);
		Button signInButn = new Button("Enter");
		signInButn.setStyle("-fx-border-radius: 10;" + "-fx-background-color:white;" + "-fx-text-fill:black;"
				+ "-fx-pref-width:50px;");
		signInButn.setOnMouseEntered(e -> {
			signInButn.setStyle("-fx-border-radius: 10;" + "-fx-background-color:rgb(233, 125, 229);"
					+ "-fx-text-fill:black;" + "-fx-pref-width:50px;");
		});
		signInButn.setOnMouseExited(e -> {
			signInButn.setStyle("-fx-border-radius: 10;" + "-fx-background-color:white;" + "-fx-text-fill:black;"
					+ "-fx-pref-width:50px;");
		});
		Label resultSignIn = new Label();
		resultSignIn.setTextFill(Color.RED);
		resultSignIn.setFont(Font.font("Arial", FontWeight.BOLD, 12));

		signInVbox.getChildren().addAll(username, passwd, signInButn, resultSignIn);
		// ___________
		// sign up
		VBox signUpVbox = new VBox(10);
		signUpVbox.setLayoutX(70);
		signUpVbox.setLayoutY(170);
		signUpVbox.setVisible(false);

		TextField username1 = new TextField("UserName");
		username1.setOnMouseClicked(e -> {
			username1.setText("");
		});
		username1.setStyle(textField);

		TextField email = new TextField("Email");
		Label emailLabel = new Label("@gmail.com");

		HBox emailBox = new HBox();
		emailBox.getChildren().addAll(email, emailLabel);
		email.setOnMouseClicked(e -> {
			email.setText("");
		});
		email.setStyle("-fx-pref-width:180px; -fx-pref-height:30px; -fx-background-radius:0;");
		emailLabel.setStyle("-fx-background-color:white; -fx-pref-height:30px; ");
		emailLabel.setFont(Font.font("", FontWeight.BOLD, 12));

		TextField passwd1 = new TextField("Password");
		passwd1.setOnMouseClicked(e -> {
			passwd1.setText("");
		});
		passwd1.setStyle(textField);
		Button signUpButn = new Button("Next");
		signUpButn.setStyle("-fx-border-radius: 10;" + "-fx-background-color:gray;" + "-fx-text-fill:white;"
				+ "-fx-pref-width:50px;");
		Label resultSignUp = new Label();
		resultSignUp.setTextFill(Color.RED);
		resultSignUp.setFont(Font.font("Arial", FontWeight.BOLD, 12));

		signUpVbox.getChildren().addAll(username1, emailBox, passwd1, signUpButn, resultSignUp);

		// _________+

		// label info
		Label labelInfo = new Label("please enter your information  ");
		labelInfo.setTextFill(Color.PURPLE);
		labelInfo.setFont(new Font("Cambria", 15));

		labelInfo.setLayoutX(50);
		labelInfo.setLayoutY(50);

		Label nameAcount = new Label("Name");
		nameAcount.setTextFill(Color.BLACK);
		nameAcount.setFont(new Font("Cambria", 15));

		TextField nameAcountText = new TextField("string ");
		HBox hb = new HBox(16);
		hb.getChildren().addAll(nameAcount, nameAcountText);

		nameAcountText.setOnMouseClicked(e -> {
			nameAcountText.setText("");
		});
		Label ageAcountLabel = new Label("Age");
		ageAcountLabel.setTextFill(Color.BLACK);
		ageAcountLabel.setFont(new Font("Cambria", 15));

		TextField ageAcountText = new TextField(" number ");
		HBox hb1 = new HBox(25);
		hb1.getChildren().addAll(ageAcountLabel, ageAcountText);
		ageAcountText.setOnMouseClicked(e -> {
			ageAcountText.setText("");
		});
		Label addressLabelAcount = new Label("Address");
		addressLabelAcount.setTextFill(Color.BLACK);
		addressLabelAcount.setFont(new Font("Cambria", 15));
		TextField addressAcountText = new TextField("string");
		HBox hb3 = new HBox(10);
		hb3.getChildren().addAll(addressLabelAcount, addressAcountText);
		addressAcountText.setOnMouseClicked(e -> {
			addressAcountText.setText("");
		});

		Label phoneAcountLabel = new Label("PhoneNo");
		phoneAcountLabel.setTextFill(Color.BLACK);
		phoneAcountLabel.setFont(new Font("Cambria", 15));

		TextField phoneAcountText = new TextField("(number");
		HBox hb4 = new HBox(10);
		hb4.getChildren().addAll(phoneAcountLabel, phoneAcountText);
		phoneAcountText.setOnMouseClicked(e -> {
			phoneAcountText.setText("");
		});

		Label sexAcountLabel = new Label("Gender");
		sexAcountLabel.setTextFill(Color.BLACK);
		sexAcountLabel.setFont(new Font("Cambria", 15));

		ComboBox<String> cb = new ComboBox<String>();
		cb.getItems().addAll("Male", "Female");
		HBox hb2 = new HBox(15);
		hb2.getChildren().addAll(sexAcountLabel, cb);

		Button Enter = new Button("Enter");
		Label resEnter = new Label("");
		HBox EnterHBox = new HBox(10);
		EnterHBox.getChildren().addAll(Enter, resEnter);

		VBox vb = new VBox(20);
		vb.getChildren().addAll(nameAcount, ageAcountLabel, addressLabelAcount, phoneAcountLabel, sexAcountLabel);
		vb.setLayoutX(40);
		vb.setLayoutY(90);

		VBox vb1 = new VBox(15);
		vb1.getChildren().addAll(nameAcountText, ageAcountText, addressAcountText, phoneAcountText, cb, EnterHBox);
		vb1.setLayoutX(110);
		vb1.setLayoutY(90);

		HBox hbox = new HBox(5);
		hbox.getChildren().addAll(vb, vb1);

		hbox.setLayoutX(50);
		hbox.setLayoutY(100);
		hbox.setVisible(false);
		// .............................................

		// show info last widow

		Label infoL = new Label("");
		infoL.setFont(Font.font("", FontWeight.BOLD, 15));

		Button Done = new Button("Done");
		Done.setOnAction(e -> {
			in.fire();
		});

		VBox info = new VBox(10);
		info.getChildren().addAll(infoL, Done);
		info.setVisible(false);
		info.setLayoutX(70);
		info.setLayoutY(100);

		// .............................................

		signUpButn.setOnAction(e -> {

			try {
				user = username1.getText();
				System.out.println(user);
				if (user == null || user == "" || user.trim().equalsIgnoreCase("UserName"))
					throw new Exception();

				eMail = email.getText();
				if (eMail == null || eMail == "" || eMail.trim().equalsIgnoreCase("Email"))
					throw new Exception();
				eMail += "@gmail.com";
				String str = email.getText().trim();
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '.' || str.charAt(i) == '@' || str.charAt(i) == ' ') {
						throw new Exception("1");
					}
				}

				pass = passwd1.getText();

				if (pass == null || pass == "" || pass.trim().equalsIgnoreCase("Password"))
					throw new Exception("2");

				Statement stat = con.createStatement();
				ResultSet res = stat.executeQuery("select* from signInTable;");

				boolean check1 = false;
				while (res.next()) {
					if (res.getString(1).equals(user.trim())) {
						check1 = true;
					}
				}

				if (check1) {
					throw new com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException();
				}

				signUpVbox.setVisible(false);
				hbox.setVisible(true);

				resultSignUp.setText("Done");
				resultSignUp.setTextFill(Color.GREEN);

			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException tt) {
				resultSignUp.setText("Username already exists");
				resultSignUp.setTextFill(Color.RED);
			} catch (Exception ee) {
				if (ee.getMessage() == null || ee.getMessage() == "2") {
					resultSignUp.setText("Wrong input!! check");
				} else if (ee.getMessage().equals("1")) {
					resultSignUp.setText("check email (It should not contain @ . space)");
				}

				resultSignUp.setTextFill(Color.RED);

			}

		});

		Enter.setOnAction(e -> {// Enter for sign up Fnsh
			Statement ss;
			try {
				ss = con.createStatement();
				ss.executeUpdate(
						"insert into patient ( name, age, Address, numPhone, sex, email, boolpharmacy)  value ( '"
								+ nameAcountText.getText() + "', '" + Integer.valueOf(ageAcountText.getText()) + "', '"
								+ addressAcountText.getText() + "', '" + Integer.valueOf(phoneAcountText.getText())
								+ "', '" + cb.getValue().toString() + "', '" + eMail + "','" + 0 + "') ;");

				Statement st = con.createStatement();
				ResultSet r = st.executeQuery("select id from patient;");
				int count = 0;
				while (r.next()) {
					count++;
				}

				ResultSet r2 = con.createStatement()
						.executeQuery("SELECT id FROM patient LIMIT " + (count - 1) + ", 1;");
				r2.next();
				int id = Integer.valueOf(r2.getString(1));

				Statement stat = con.createStatement();

				stat.executeUpdate("insert into signInTable  value ( '" + user + "', '" + eMail + "', '" + pass + "', '"
						+ id + "') ;");
				stat.close();

				resEnter.setText("Done!!!");
				resEnter.setTextFill(Color.GREEN);

				infoL.setText("Username : " + username1.getText() + "\n" + "Email : " + email.getText() + "\n"
						+ "Password : " + passwd1.getText() + "\n" + "Name : " + nameAcountText.getText() + "\n");

				hbox.setVisible(false);
				info.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				resEnter.setText("Wrong Input!!!");
				resEnter.setTextFill(Color.RED);
				e1.printStackTrace();
			}
		});

		// _________-

		in.setOnAction(e -> {
			signInVbox.setVisible(true);
			signUpVbox.setVisible(false);
			hbox.setVisible(false);
			info.setVisible(false);
		});
		up.setOnAction(e -> {
			signUpVbox.setVisible(true);
			signInVbox.setVisible(false);
			hbox.setVisible(false);
			username1.setText("Username");
			email.setText("Email");
			passwd1.setText("Password");
			info.setVisible(false);

		});

		// ...............................

		signInButn.setOnAction(e -> {
			try {

				String user = username.getText();
				if (user == null || user == "" || user == "UserName")
					throw new Exception();

				String pass = passwd.getText();
				this.passwd = pass;
				if (pass == null || pass == "" || pass == "Password")
					throw new Exception();

				Statement stat = con.createStatement();
				ResultSet res = stat.executeQuery("select* from signInTable;");

				boolean check1 = false;
				while (res.next()) {
					System.out.println(res.getString(1) + " " + user);
					if (res.getString(1).equals(user.trim()) && res.getString(3).equals(pass.trim())) {
						System.out.println("/////////////////////////////////////");
						check1 = true;
						ID = Integer.valueOf(res.getString(4));
						ResultSet result = con.createStatement()
								.executeQuery("select * from patient where id = '" + ID + "';");
						result.next();
						Name = result.getString(2);
						break;
					}
				}

				if (check1 == false)
					throw new Exception();

				System.out.println(ID + " id");

				patient().show();
				stage.close();
				resultSignIn.setText("Done");
				resultSignIn.setTextFill(Color.GREEN);

			} catch (Exception ee) {
				resultSignIn.setText("Wrong input!! check and sign again");
				resultSignIn.setTextFill(Color.RED);

				ee.printStackTrace();
			}
		});

		group.getChildren().addAll(rec, line, inup, signInVbox, signUpVbox, hbox, info);
		stage.setScene(scene);
		return stage;
	}

	String user;
	String eMail;
	String pass;
	///// ///////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////// sujood &ajyad

	public Stage patient() throws SQLException {
		Stage stage = new Stage();
		Pane pane = new Pane();
		Scene s = new Scene(pane, 1000, 700);
		stage.setScene(s);

		// (bahaa)
		Label id = new Label("Your ID => " + ID);
		id.setTextFill(Color.PURPLE);
		id.setLayoutX(20);
		id.setLayoutY(20);
		id.setFont(new Font("Cambria", 20));

		// ______bahaa ^

		/// add photo to background

		Image img = new Image(
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQf6WLMEHEThylz-5bMaZBGkWd_t0LF4t_kew&usqp=CAU");
		BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background bGround = new Background(bImg);
		pane.setBackground(bGround);

		// labelwelcome
		Label l1 = new Label("Welcome to our clinic ");
		l1.setTextFill(Color.PURPLE);
		l1.setFont(new Font("Cambria", 30));
		pane.getChildren().add(l1);
		l1.setLayoutX(270);

		// l8= label steps
		Label l8 = new Label("Please follow these steps to book an appointment ");
		l8.setTextFill(Color.PURPLE);
		l8.setFont(new Font("Cambria", 15));
		pane.getChildren().add(l8);
		l8.setLayoutX(40);
		l8.setLayoutY(60);

		// l9= label Specialties
		Label l9 = new Label("Specialties ");
		l9.setTextFill(Color.PURPLE);
		l9.setFont(new Font("Cambria", 15));

		String Specialties[] = { "Doctor of Dentist", "internal Medicine doctor", "eyes doctor", "Pediatrician",
				"orthopedist" };

		// cb1= combobox Specialties
		ComboBox<String> cb1 = new ComboBox<String>();
		// l10= label NameOfDoctors
		Label l10 = new Label("NameOfDoctors ");
		l10.setTextFill(Color.PURPLE);
		l10.setFont(new Font("Cambria", 15));

		Statement st1 = con.createStatement();
		ResultSet res = st1.executeQuery("select * from specialization");

		ArrayList<Integer> arr = new ArrayList<Integer>();
		while (res.next()) {
			cb1.getItems().add(res.getString(2));
			arr.add(Integer.valueOf(res.getString(1)));
		}

		// cb2= combobox name
		ComboBox<String> cb2 = new ComboBox<String>();

		Label l11 = new Label("time ");
		l11.setTextFill(Color.PURPLE);
		l11.setFont(new Font("Cambria", 15));
		ArrayList<Integer> arr2 = new ArrayList<Integer>();

		// cb3= combobox time
		ComboBox<String> cb3 = new ComboBox<String>();

		cb1.setOnAction(e -> {
			try {
				cb2.getItems().clear();
				cb3.getItems().clear();
				Statement st2 = con.createStatement();
				ResultSet res2 = st2.executeQuery(
						"select  d.id, d.namedc from doc2spec ds, doctors d  where ds.idDoc=d.id and " + "ds.idSpec='"
								+ Integer.valueOf(arr.get(cb1.getItems().indexOf(cb1.getValue()))) + "';");
				arr2.clear();
				while (res2.next()) {
					cb2.getItems().add(res2.getString(2));
					arr2.add(Integer.valueOf(res2.getString(1)));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		cb2.setOnAction(e -> {
			try {
				Statement stat3 = con.createStatement();
				ResultSet res3 = stat3.executeQuery("select * from doctorsdate where doctorId='"
						+ Integer.valueOf(arr2.get(cb2.getItems().indexOf(cb2.getValue()))) + "';");
				cb3.getItems().clear();
				while (res3.next()) {
					String str = res3.getString(2) + " " + res3.getString(3);
					cb3.getItems().add(str);
				}

			} catch (Exception ee) {
				//
			}

		});

		Button enterDATE = new Button("Enter");
		Label resEnter1 = new Label("");
		HBox EnterHBox1 = new HBox(10);
		EnterHBox1.getChildren().addAll(enterDATE, resEnter1);
		// bahaa edit
		enterDATE.setStyle("-fx-border-color:rgb(151, 54, 211); " + "-fx-background-color:white;");
		enterDATE.setMinHeight(29);
		enterDATE.setTextFill(Color.rgb(151, 54, 211));
		enterDATE.setOnMouseEntered(e -> {
			enterDATE.setTextFill(Color.WHITE);
			enterDATE.setStyle("-fx-border-color:rgb(151, 54, 211);" + " -fx-background-color:rgb(151, 54, 211);");
		});
		enterDATE.setOnMouseExited(e -> {
			enterDATE.setTextFill(Color.rgb(151, 54, 211));
			enterDATE.setStyle("-fx-border-color:rgb(151, 54, 211);" + " -fx-background-color:white;");
		});

		// ^^

		enterDATE.setOnAction(e -> {
			try {
				String[] str = cb3.getValue().split(" ");
				int idDoc = arr2.get(cb2.getItems().indexOf(cb2.getValue()));
				ResultSet rr = con.createStatement().executeQuery("select * from doctors where id = '" + idDoc + "';");
				rr.next();
				String phone = rr.getString(4);
				Statement statDate = con.createStatement();

				System.out.println(idDoc + " " + str[0] + " " + str[1]);
				statDate.executeUpdate(
						"insert into dates (doctorId, dateD, timeD, phoneNumberD, patientId) value ('" + idDoc + "', '"
								+ str[0] + "', '" + str[1] + "', '" + Integer.valueOf(phone) + "', '" + ID + "');");

				resEnter1.setText("Done!?!");
				resEnter1.setTextFill(Color.GREEN);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				resEnter1.setText("Wrong Input!!!");
				resEnter1.setTextFill(Color.RED);
			}
		});

		VBox vb2 = new VBox(20);
		vb2.getChildren().addAll(l9, l10, l11);
		vb2.setLayoutX(40);
		vb2.setLayoutY(100);
		pane.getChildren().add(vb2);

		VBox vb3 = new VBox(17);
		vb3.getChildren().addAll(cb1, cb2, cb3, EnterHBox1);
		vb3.setLayoutX(200);
		vb3.setLayoutY(100);
		pane.getChildren().add(vb3);

		// button Booked appointments
		Button booked = new Button("Booked appointments");
		// bahaa edit
		booked.setStyle("-fx-border-color:rgb(151, 54, 211); " + "-fx-background-color:white;");
		booked.setMinHeight(29);
		booked.setTextFill(Color.rgb(151, 54, 211));
		booked.setOnMouseEntered(e -> {
			booked.setTextFill(Color.WHITE);
			booked.setStyle("-fx-border-color:rgb(151, 54, 211);" + " -fx-background-color:rgb(151, 54, 211);");
		});
		booked.setOnMouseExited(e -> {
			booked.setTextFill(Color.rgb(151, 54, 211));
			booked.setStyle("-fx-border-color:rgb(151, 54, 211); " + "-fx-background-color:white;");
		});

		// ^^

		ComboBox<String> comboSort = new ComboBox<>();// bahaa

		TextArea textAreaBookedappointments = new TextArea();

		textAreaBookedappointments.setPrefHeight(180);
		textAreaBookedappointments.setPrefWidth(550);
		textAreaBookedappointments.setFont(Font.font("", FontWeight.BOLD, 12));

		// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< <-> >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		Label deleteappointments = new Label("delete appointments : \t");
		deleteappointments.setTextFill(Color.PURPLE);
		deleteappointments.setFont(new Font("Cambria", 15));

		Label iddate = new Label(" ID Date : \t");
		iddate.setTextFill(Color.PURPLE);
		iddate.setFont(new Font("Cambria", 15));

		// edit by bahaa
		ComboBox<String> idTextdate = new ComboBox<>();
		try {
			ResultSet resDelete = con.createStatement()
					.executeQuery("select id from dates where patientId='" + ID + "';");

			while (resDelete.next()) {
				idTextdate.getItems().add(resDelete.getString(1));
			}
			System.out.println("bahaa");

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/// ^^^

		HBox iddate1 = new HBox(5);
		iddate1.getChildren().addAll(iddate, idTextdate);

		Button deletedate = new Button("delete");
		Label resdelete = new Label("");
		HBox deleteHBox = new HBox(10);

		// bahaa edit
		deleteHBox.getChildren().addAll(deletedate, resdelete);
		deletedate.setStyle("-fx-border-color:rgb(151, 54, 211); " + "-fx-background-color:white;");
		deletedate.setMinHeight(29);
		deletedate.setTextFill(Color.rgb(151, 54, 211));
		deletedate.setOnMouseEntered(e -> {
			deletedate.setTextFill(Color.WHITE);
			deletedate.setStyle("-fx-border-color:rgb(151, 54, 211);" + " -fx-background-color:rgb(151, 54, 211);");
		});
		deletedate.setOnMouseExited(e -> {
			deletedate.setTextFill(Color.rgb(151, 54, 211));
			deletedate.setStyle("-fx-border-color:rgb(151, 54, 211);" + " -fx-background-color:white;");
		});

		// ^^

		VBox vboxDelete = new VBox(8);
		vboxDelete.getChildren().addAll(deleteappointments, iddate1, deleteHBox);
		vboxDelete.setLayoutX(450);
		vboxDelete.setLayoutY(60);

		pane.getChildren().add(vboxDelete);

		/////

		Label bye = new Label("Thank You For Visiting Our Clinic ");
		bye.setTextFill(Color.PURPLE);
		bye.setFont(new Font("Cambria", 20));
		bye.setLayoutX(600);
		bye.setLayoutY(570);
		pane.getChildren().add(bye);

		Label bye1 = new Label("Have A Nice Day ");
		bye1.setTextFill(Color.PURPLE);
		bye1.setFont(new Font("Cambria", 20));
		bye1.setLayoutX(600);
		bye1.setLayoutY(600);

		pane.getChildren().add(bye1);

		booked.setOnAction(e -> {
			// textAreaBookedappointments

			try {
				ResultSet resBook = con.createStatement()
						.executeQuery("select * from dates where patientId='" + ID + "';");

				String str = "";

				while (resBook.next()) {
					String ss = "";
					ResultSet rrr = con.createStatement()
							.executeQuery("select d.namedc from doctors d where id = '" + resBook.getString(1) + "';");
					while (rrr.next()) {
						ss = rrr.getString(1);
					}

					str += "ID : " + resBook.getString(5) + "\tName of Doc : " + ss + " | Date : "
							+ resBook.getString(2) + " | Time : " + resBook.getString(3) + " | Phone : "
							+ resBook.getString(4) + "\n";

					str += "____________________________________________________________________________________________\n";
				}

				System.out.println("bahaa");
				if (str == "")
					str = "No any dates";
				textAreaBookedappointments.setText(str);

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		enterDATE.setOnAction(e -> {
			try {
				String[] str = cb3.getValue().split(" ");
				int idDoc = arr2.get(cb2.getItems().indexOf(cb2.getValue()));
				ResultSet rr = con.createStatement().executeQuery("select * from doctors where id = '" + idDoc + "';");
				rr.next();
				String phone = rr.getString(4);
				Statement statDate = con.createStatement();

				System.out.println(idDoc + " " + str[0] + " " + str[1]);
				statDate.executeUpdate(
						"insert into dates (doctorId, dateD, timeD, phoneNumberD, patientId) value ('" + idDoc + "', '"
								+ str[0] + "', '" + str[1] + "', '" + Integer.valueOf(phone) + "', '" + ID + "');");

				resEnter1.setText("Done!?!");
				resEnter1.setTextFill(Color.GREEN);
				booked.fire();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				resEnter1.setText("Wrong Input!!!");
				resEnter1.setTextFill(Color.RED);
			}

			try {
				idTextdate.getItems().clear();
				ResultSet resDelete = con.createStatement()
						.executeQuery("select id from dates where patientId='" + ID + "';");

				while (resDelete.next()) {
					idTextdate.getItems().add(resDelete.getString(1));
				}
				System.out.println("bahaa");

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		deletedate.setOnAction(e -> {
			try {

				Statement stdelete = con.createStatement();
				stdelete.executeUpdate(
						"delete from dates where id = '" + Integer.valueOf(idTextdate.getValue()) + "';");
				resdelete.setText("Done^_^");
				resdelete.setTextFill(Color.GREEN);
				booked.fire();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				resdelete.setText("check your input!");
				resdelete.setTextFill(Color.RED);

			}
		});

		// ( Bahaa ) // log off // change password ...

		HBox acount = new HBox();

		Label nameA = new Label(Name);
		nameA.setStyle("-fx-pref-width:105; -fx-padding:5;" + "-fx-stroke-color:black");
		nameA.setFont(Font.font("", FontWeight.BOLD, 13));
		nameA.setTextFill(Color.WHITE);

		Button dropDown = new Button("Drop");
		dropDown.setStyle("-fx-border-color:rgb(151, 54, 211); " + "-fx-background-color:white;");
		dropDown.setMinHeight(29);
		dropDown.setTextFill(Color.rgb(151, 54, 211));
		dropDown.setOnMouseEntered(e -> {
			dropDown.setTextFill(Color.WHITE);
			dropDown.setStyle("-fx-border-color:rgb(151, 54, 211);" + " -fx-background-color:rgb(151, 54, 211);");
		});
		dropDown.setOnMouseExited(e -> {
			dropDown.setTextFill(Color.rgb(151, 54, 211));
			dropDown.setStyle("-fx-border-color:rgb(151, 54, 211);" + " -fx-background-color:white;");
		});
		acount.getChildren().addAll(nameA, dropDown);
		acount.setStyle("-fx-background-color:rgb(151, 54, 211);" + " -fx-background-radius:3;");

		// drop
		Button settings = new Button("Change Password");
		Button logoff = new Button("Logoff");
		settings.setVisible(false);
		logoff.setVisible(false);
		String style = "-fx-background-radius:5;" + " -fx-border-color:black;" + " -fx-border-width:2; "
				+ "-fx-border-radius:5; " + "-fx-background-color:White;";
		settings.setTextFill(Color.BLACK);
		logoff.setTextFill(Color.BLACK);
		settings.setStyle(style);
		logoff.setStyle(style);

		settings.setOnMouseEntered(e -> {
			settings.setTextFill(Color.WHITE);
			settings.setStyle("-fx-background-radius:5;" + " -fx-border-color:black; " + "-fx-border-width:2;"
					+ " -fx-border-radius:5;" + " -fx-background-color:black;");
		});
		settings.setOnMouseExited(e -> {
			settings.setTextFill(Color.BLACK);
			settings.setStyle("-fx-background-radius:5; " + "-fx-border-color:black;" + " -fx-border-width:2;"
					+ " -fx-border-radius:5; " + "-fx-background-color:white;");
		});

		logoff.setOnMouseEntered(e -> {
			logoff.setTextFill(Color.WHITE);
			logoff.setStyle("-fx-background-radius:5; " + "-fx-border-color:black; " + "-fx-border-width:2; "
					+ "-fx-border-radius:5;" + " -fx-background-color:black;");
		});
		logoff.setOnMouseExited(e -> {
			logoff.setTextFill(Color.BLACK);
			logoff.setStyle("-fx-background-radius:5; " + "-fx-border-color:black; " + "-fx-border-width:2;"
					+ " -fx-border-radius:5; " + "-fx-background-color:white;");
		});
		logoff.setOnAction(e -> {
			stage.close();
			signIn().show();
		});

		VBox vboxA = new VBox(5);
		vboxA.getChildren().addAll(acount, settings, logoff);
		vboxA.setStyle("" + "-fx-pref-width:150;");
		vboxA.setLayoutX(800);
		vboxA.setLayoutY(50);

		dropDown.setOnAction(e -> {
			if (wow == 0) {
				settings.setVisible(true);
				logoff.setVisible(true);
				wow = 1;
			} else {
				settings.setVisible(false);
				logoff.setVisible(false);
				wow = 0;
			}
		});
		settings.setOnAction(ee -> {
			change().show();
		});

		pane.getChildren().add(vboxA);

		// ..end setting..\

		HBox hboxBooked = new HBox(10);
		hboxBooked.getChildren().addAll(booked, comboSort);

		VBox vboxBook = new VBox(5);
		vboxBook.getChildren().addAll(hboxBooked, textAreaBookedappointments);// bahaa
		vboxBook.setLayoutX(20);
		vboxBook.setLayoutY(450);

		// sort setting /bahaa\
		comboSort.getItems().addAll("sort by date", "sort by time");

		comboSort.setOnAction(e -> {
			String str = comboSort.getValue();

			if (str == null) {

			} else if (str.equals("sort by date")) {
				System.out.println("bahaa >...");
				textAreaBookedappointments.setText("");
				try {
					ResultSet resBook = con.createStatement()
							.executeQuery("select * from dates where patientId = '" + ID + "' order by dateD asc ;");

					String string = "";

					while (resBook.next()) {
						String ss = "";
						ResultSet rrr = con.createStatement().executeQuery(
								"select d.namedc from doctors d where id = '" + resBook.getString(1) + "';");
						while (rrr.next()) {
							ss = rrr.getString(1);
						}

						string += "ID : " + resBook.getString(5) + "\tName of Doc : " + ss + " | Date : "
								+ resBook.getString(2) + " | Time : " + resBook.getString(3) + " | Phone : "
								+ resBook.getString(4) + "\n";

						string += "____________________________________________________________________________________________\n";
					}
					textAreaBookedappointments.setText(string);

				} catch (Exception oo) {
					oo.getStackTrace();
				}

			} else if (str.equals("sort by time")) {
				System.out.println("bahaa <<<|||>>>>");
				textAreaBookedappointments.setText("");
				try {
					ResultSet resBook = con.createStatement()
							.executeQuery("select * from dates where patientId = '" + ID + "' order by timeD asc ;");

					String string = "";

					while (resBook.next()) {
						String ss = "";
						ResultSet rrr = con.createStatement().executeQuery(
								"select d.namedc from doctors d where id = '" + resBook.getString(1) + "';");
						while (rrr.next()) {
							ss = rrr.getString(1);
						}

						string += "ID : " + resBook.getString(5) + "\tName of Doc : " + ss + " | Date : "
								+ resBook.getString(2) + " | Time : " + resBook.getString(3) + " | Phone : "
								+ resBook.getString(4) + "\n";

						string += "____________________________________________________________________________________________\n";
					}
					textAreaBookedappointments.setText(string);

				} catch (Exception oo) {
					oo.getStackTrace();
				}
			}

		});

		pane.getChildren().add(vboxBook);

		// parmetion
		Button adminBtn = new Button("Admin Page");
		adminBtn.setVisible(false);
		adminBtn.setLayoutX(650);
		adminBtn.setLayoutY(10);
		pane.getChildren().add(adminBtn);

		ResultSet ifAdmin = con.createStatement().executeQuery("select * from patient p where p.id = '" + ID + "';");
		ifAdmin.next();

		if (ifAdmin.getString(10) != null && Integer.valueOf(ifAdmin.getString(10)) == 1) {
			adminBtn.setVisible(true);

		}

		adminBtn.setOnAction(e -> {
			try {
				admin(new Stage()).show();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		System.out.println(ifAdmin.getString(10));

		///
		Button pharmacyBtn = new Button("Pharmacy Page");
		pharmacyBtn.setVisible(false);
		pharmacyBtn.setLayoutX(750);
		pharmacyBtn.setLayoutY(10);
		pane.getChildren().add(pharmacyBtn);

		ResultSet ifPharmacy = con.createStatement().executeQuery("select * from patient p where p.id = '" + ID + "';");
		ifPharmacy.next();

		if (ifPharmacy.getString(11) != null && Integer.valueOf(ifPharmacy.getString(11)) == 1) {
			pharmacyBtn.setVisible(true);

		}

		pharmacyBtn.setOnAction(e -> {
			try {
				Pharmacy().show();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		System.out.println(ifPharmacy.getString(10));

		// bahaa ^^

		stage.setResizable(false);
		stage.setTitle("clinic  ");
		stage.show();
		return stage;

	}

	int wow = 0;

	// bahaa change password
	public Stage change() {
		Stage stage = new Stage();
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 300, 200);

		TextField text1 = new TextField("old password");
		text1.setOnMouseClicked(e -> {
			text1.setText("");
		});
		TextField text2 = new TextField("new password");
		text2.setOnMouseClicked(e -> {
			text2.setText("");
		});
		Button change = new Button("Change");
		Label result = new Label();
		HBox hbox = new HBox(5);
		hbox.getChildren().addAll(change, result);

		VBox vbox = new VBox(5);
		vbox.getChildren().addAll(text1, text2, hbox);
		vbox.setLayoutX(20);
		vbox.setLayoutY(20);
		pane.getChildren().add(vbox);

		change.setOnAction(e -> {
			System.out.println(text1.getText() + " " + passwd);
			try {
				if (text1.getText().equals(passwd)) {
					System.out.println("bahaa");
					Statement res = con.createStatement();
					res.executeUpdate("update signintable set passwd = '" + text2.getText() + "' where patientId = '"
							+ ID + "';");
					result.setText("Done");
					result.setTextFill(Color.GREEN);

				} else {
					throw new Exception();
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				result.setText("wrong old password");
				result.setTextFill(Color.RED);
				e1.printStackTrace();
			}
		});

		stage.setScene(scene);
		return stage;
	}

	// ___________________________________________________________________________________
	// ___________________________________________________________________________________
	// ___________________________________________________________________________________

	private TableView<doctor> tableViewdoc = new TableView<>();
	private TableView<nurses> tableViewNur = new TableView<>();

	// ------------------Start TableView Doctor----------------------------
	// ------------------Hiba Khaled---------------------------------------

	public void buildData() throws ClassNotFoundException, SQLException {

		String dbTableName = "doctors";
		String select = "SELECT * FROM " + dbTableName;

		Statement ss;
		ss = con.createStatement();

		ResultSet resultSet = null;
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(select);
			resultSet = preparedStatement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ObservableList dbData = FXCollections.observableArrayList(dataBaseArrayList(resultSet));

		for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
			TableColumn column = new TableColumn<>();
			column.setPrefWidth(70);

			switch (resultSet.getMetaData().getColumnName(i + 1)) {
			case "id":
				column.setText("id");
				break;
			case "namedc":
				column.setText("namedc");
				break;
			case "age":
				column.setText("age");
				break;
			case "numPhone":
				column.setText("numPhone");
				break;
			case "sex":
				column.setText("sex");
				break;
			case "idLab":
				column.setText("idLab");
				break;
			case "SIN":
				column.setText("SIN");
				break;
			default:
				column.setText(resultSet.getMetaData().getColumnName(i + 1)); // if column name in SQL Database is not
																				// found, then TableView column receive
																				// SQL Database current column name (not
																				// readable)
				break;
			}
			column.setCellValueFactory(new PropertyValueFactory<>(resultSet.getMetaData().getColumnName(i + 1))); // Setting
																													// cell
																													// property
																													// value
																													// to
																													// correct
																													// variable
																													// from
																													// doctors
																													// class.
			tableViewdoc.getColumns().add(column);
		}
		// Filling up tableView with data
		tableViewdoc.setItems(dbData);
	}

	// extracting data from ResulSet to ArrayList
	private ArrayList dataBaseArrayList(ResultSet resultSet) throws SQLException {
		ArrayList<doctor> data = new ArrayList<>();
		while (resultSet.next()) {
			doctor doc = new doctor();
			doc.id.set(resultSet.getInt("id"));
			doc.namedc.set(resultSet.getString("namedc"));
			doc.age.set(resultSet.getInt("age"));
			doc.numPhone.set(resultSet.getInt("numPhone"));
			doc.sex.set(resultSet.getString("sex"));
			doc.idLab.set(resultSet.getInt("idLab"));
			doc.SIN.set(resultSet.getInt("SIN"));
			data.add(doc);
		}
		return data;
	}
	// ---------------------End TableView Doctors-------------------------

	// ----------------------Table View Nurse-----------------------------
	// ----------------------Hiba Khaled----------------------------------
	public void buildData1() throws ClassNotFoundException, SQLException {

		String dbTableName = "nurses";
		String select = "SELECT * FROM " + dbTableName;

		ResultSet resultSet = null;
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(select);
			resultSet = preparedStatement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ObservableList dbData1 = FXCollections.observableArrayList(dataBaseArrayList1(resultSet));

		for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
			TableColumn column = new TableColumn<>();
			column.setPrefWidth(89);

			switch (resultSet.getMetaData().getColumnName(i + 1)) {
			case "id":
				column.setText("id");
				break;
			case "nameNurse":
				column.setText("nameNurse");
				break;
			case "age":
				column.setText("age");
				break;
			case "numPhone":
				column.setText("numPhone");
				break;
			case "sex":
				column.setText("sex");
				break;
			case "SIN":
				column.setText("SIN");
				break;
			default:
				column.setText(resultSet.getMetaData().getColumnName(i + 1)); // if column name in SQL Database is not
																				// found, then TableView column receive
																				// SQL Database current column name (not
																				// readable)
				break;
			}
			column.setCellValueFactory(new PropertyValueFactory<>(resultSet.getMetaData().getColumnName(i + 1))); // Setting
																													// cell
																													// property
																													// value
																													// to
																													// correct
																													// variable
																													// from
																													// nurses
																													// class.
			tableViewNur.getColumns().add(column);
		}
		// Filling up tableView with data
		tableViewNur.setItems(dbData1);
	}

	// extracting data from ResulSet to ArrayList
	private ArrayList dataBaseArrayList1(ResultSet resultSet) throws SQLException {
		ArrayList<nurses> data1 = new ArrayList<>();
		while (resultSet.next()) {
			nurses Nurse = new nurses();
			Nurse.id.set(resultSet.getInt("id"));
			Nurse.nameNurse.set(resultSet.getString("nameNurse"));
			Nurse.age.set(resultSet.getInt("age"));
			Nurse.numPhone.set(resultSet.getInt("numPhone"));
			Nurse.sex.set(resultSet.getString("sex"));
			Nurse.SIN.set(resultSet.getInt("SIN"));
			data1.add(Nurse);
		}
		return data1;
	}
	// --------------------------------------------------------
	// ----------------End Table View Nurses-------------------
	// ---------------------------------------------------------

	///// sujood & ajyad /////
	public Stage Pharmacy() throws SQLException {
		Stage stage = new Stage();
		Pane p = new Pane();
		Scene s = new Scene(p, 1000, 697);
		stage.setScene(s);
		Image img = new Image("https://edutesla.com/wp-content/uploads/2021/04/medicine.jpg");
		BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background bGround = new Background(bImg);
		p.setBackground(bGround);

		Label welcome = new Label(" My Pharmacy Store  ");
		welcome.setStyle("-fx-border-color:White; -fx-background-color:purple;");
		welcome.setTextFill(Color.WHITE);
		welcome.setFont(new Font("Cambria", 25));
		welcome.setLayoutX(300);
		welcome.setLayoutY(10);
		p.getChildren().add(welcome);

		// create a date picker

		DatePicker d = new DatePicker();

		d.setShowWeekNumbers(true);
		d.setOnAction(e -> {
			LocalDate i = d.getValue();
		});
		Label date = new Label("BILL DATE ");
		date.setStyle("-fx-border-color:White; -fx-background-color:purple;");
		date.setTextFill(Color.WHITE);
		date.setFont(new Font("Cambria", 15));
		HBox hbox = new HBox(20);
		hbox.getChildren().addAll(date, d);
		hbox.setLayoutX(247);
		hbox.setLayoutY(71);
		p.getChildren().add(hbox);

		Label MEDICINE_NAME = new Label("MEDICINE_NAME ");
		MEDICINE_NAME.setStyle("-fx-border-color:White; -fx-background-color:purple;");
		MEDICINE_NAME.setTextFill(Color.WHITE);
		MEDICINE_NAME.setFont(new Font("Cambria", 15));
		TextField textMedicineName = new TextField();
		textMedicineName.setPromptText("MEDICINE_NAME ");
		textMedicineName.setFocusTraversable(false);
		textMedicineName.setMinSize(170, 15);

		Label TYPE = new Label("TYPE ");
		TYPE.setStyle("-fx-border-color:White; -fx-background-color:purple;");
		TYPE.setTextFill(Color.WHITE);

		TYPE.setFont(new Font("Cambria", 15));
		TextField textTYPE = new TextField();
		textTYPE.setPromptText("TYPE ");
		textTYPE.setFocusTraversable(false);
		textTYPE.setMinSize(170, 15);

		Label PRODUCT_DATE = new Label("PRODUCT_DATE ");
		PRODUCT_DATE.setStyle("-fx-border-color:White; -fx-background-color:purple;");
		PRODUCT_DATE.setTextFill(Color.WHITE);
		PRODUCT_DATE.setFont(new Font("Cambria", 15));

		// create a date picker

		DatePicker d1 = new DatePicker();
		d1.setMinSize(170, 15);

		d1.setShowWeekNumbers(true);
		d1.setOnAction(e -> {
			LocalDate i1 = d1.getValue();
		});

		Label EXPIRE_DATE = new Label("EXPIRE_DATE ");
		EXPIRE_DATE.setStyle("-fx-border-color:White; -fx-background-color:purple;");
		EXPIRE_DATE.setTextFill(Color.WHITE);
		EXPIRE_DATE.setFont(new Font("Cambria", 15));

		// create a date picker

		DatePicker d2 = new DatePicker();
		d2.setMinSize(170, 15);

		d2.setShowWeekNumbers(true);
		d2.setOnAction(e -> {
			LocalDate i2 = d2.getValue();
		});

		Label COST_PRICE = new Label("COST_PRICE ");
		COST_PRICE.setStyle("-fx-border-color:White; -fx-background-color:purple;");
		COST_PRICE.setTextFill(Color.WHITE);

		COST_PRICE.setFont(new Font("Cambria", 15));
		TextField textCOST = new TextField();
		textCOST.setPromptText("Number ");
		textCOST.setFocusTraversable(false);
		textCOST.setMinSize(170, 17);

		Label QUANTITY = new Label("QUANTITY");
		QUANTITY.setStyle("-fx-border-color:White; -fx-background-color:purple;");
		QUANTITY.setTextFill(Color.WHITE);
		QUANTITY.setFont(new Font("Cambria", 15));
		TextField textQUANTITY = new TextField();
		textQUANTITY.setPromptText("Number");
		textQUANTITY.setFocusTraversable(false);
		textQUANTITY.setMinSize(170, 17);

		Button ViewOtherQueries = new Button(" Queries");
		ViewOtherQueries.setOnAction(e -> {
			try {
				Query().show();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		ViewOtherQueries.setFont(new Font("Cambria", 15));
		ViewOtherQueries.setStyle("-fx-background-color: purple");
		ViewOtherQueries.setTextFill(Color.WHEAT);
		ViewOtherQueries.setPrefSize(85, 60);
		Label resEnter7 = new Label("");
		HBox EnterHBox7 = new HBox(10);
		EnterHBox7.setLayoutX(830);
		EnterHBox7.setLayoutY(400);
		EnterHBox7.getChildren().addAll(ViewOtherQueries, resEnter7);
		p.getChildren().addAll(EnterHBox7);

		Button print = new Button("print");
		print.setStyle("-fx-border-color:purple; -fx-border-width: 5px;");
		print.setMinSize(120, 17);
		print.setTextFill(Color.PURPLE);
		Label restableviewdoc = new Label("");
		HBox TableViewHBoxdoc = new HBox(10);

		TableViewHBoxdoc.getChildren().addAll(print, restableviewdoc);

		print.setOnAction(e -> {
			Statement ss1;
			try {
				ss1 = con.createStatement();

				tableMed();
				Parent root = tableViewmed;

				tableViewmed.setPrefSize(600, 300);
				tableViewmed.setLayoutX(200);
				tableViewmed.setLayoutY(320);

				p.getChildren().addAll(tableViewmed);

			} catch (Exception e11) {
				// TODO Auto-generated catch block
				e11.printStackTrace();

			}
		});

		Button ADD_TO_BILL = new Button("ADD TO BILL");
		ADD_TO_BILL.setStyle("-fx-border-color:purple; -fx-border-width: 5px;");
		ADD_TO_BILL.setMinSize(120, 17);
		ADD_TO_BILL.setTextFill(Color.PURPLE);

		ADD_TO_BILL.setOnAction(e -> {
			Statement ss;
			try {
				ss = con.createStatement();
				ss.executeUpdate(
						"insert into medicine1 (idmed, BillDate, medName,type, productDate, expireDate,cost, quantity)  value ( '"
								+ ID + "', '" + d.getValue().toString() + "', '" + textMedicineName.getText() + "', '"
								+ textTYPE.getText() + "', '" + d1.getValue().toString() + "', '"
								+ d2.getValue().toString() + "', '" + Double.valueOf(textCOST.getText()) + "', '"
								+ Integer.valueOf(textQUANTITY.getText()) + "') ;");

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

			}
		});

		HBox hbox1 = new HBox(13);
		hbox1.getChildren().addAll(MEDICINE_NAME, textMedicineName);

		HBox hbox2 = new HBox(90);
		hbox2.getChildren().addAll(TYPE, textTYPE);

		HBox hbox3 = new HBox(17);
		hbox3.getChildren().addAll(PRODUCT_DATE, d1);

		HBox hbox4 = new HBox(34);
		hbox4.getChildren().addAll(EXPIRE_DATE, d2);

		HBox hbox5 = new HBox(15);
		hbox5.getChildren().addAll(COST_PRICE, textCOST);

		Button clear = new Button("CLEAR");
		HBox hbox8 = new HBox(25);
		hbox8.getChildren().addAll(QUANTITY, textQUANTITY, ADD_TO_BILL, clear);

		VBox vbox = new VBox(25);
		vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4);

		VBox vbox1 = new VBox(25);
		vbox1.getChildren().addAll(hbox, hbox5, hbox8);

		HBox hbox9 = new HBox(65);
		hbox9.getChildren().addAll(vbox, vbox1);
		hbox9.setLayoutX(65);
		hbox9.setLayoutY(82);
		p.getChildren().add(hbox9);

		Button DELETE = new Button("DELETE");

		DELETE.setStyle("-fx-border-color:purple; -fx-border-width: 5px;");
		TextField textid = new TextField();
		 textid.setPromptText("id");
		 textid.setFocusTraversable(false);
		 textid.setMinSize(170, 15);
		DELETE.setOnAction(e -> {
			Statement ss3;
			try {
				ss3 = con.createStatement();
				ss3.executeUpdate("delete from medicine1 where id= ( '" + Integer.valueOf(textid.getText()).toString()
						+ "') ;");


				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Delete Done!");
				alert.show();
				Statement ss1;
				try {
					ss1 = con.createStatement();

					tableMed();
					Parent root = tableViewmed;

					tableViewmed.setPrefSize(600, 300);
					tableViewmed.setLayoutX(200);
					tableViewmed.setLayoutY(320);

					p.getChildren().addAll(tableViewmed);

				} catch (Exception e11) {
					// TODO Auto-generated catch block
					e11.printStackTrace();

				}

			} catch (Exception e33) {
				// TODO Auto-generated catch block
				e33.printStackTrace();
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("ID Not Exist!");
				alert.show();

			}
		});
		DELETE.setTextFill(Color.PURPLE);
		DELETE.setMinSize(120, 20);
		 
		 
		clear.setOnAction(e -> {
			d.getEditor().clear();
			textMedicineName.setText("");
			textTYPE.setText("");
			d1.getEditor().clear();
			d2.getEditor().clear();
			textCOST.setText("");
			textQUANTITY.setText("");

		});
		clear.setTextFill(Color.PURPLE);
		clear.setStyle("-fx-border-color:purple; -fx-border-width: 5px;");

		clear.setMinSize(120, 20);

		Button close = new Button("CLOSE");
		close.setStyle("-fx-border-color:purple; -fx-border-width: 5px;");
		close.setOnAction(e -> {
			System.exit(1);

		});
		close.setTextFill(Color.PURPLE);
		close.setMinSize(120, 20);

		HBox hbox10 = new HBox(50);
		hbox10.getChildren().addAll(print, DELETE,textid, close);
		hbox10.setLayoutX(250);
		hbox10.setLayoutY(650);
		p.getChildren().add(hbox10);

		stage.setTitle("Pharmacy   ");
		stage.show();
		return stage;

	}

	private TableView<Medicine1> tableViewmed = new TableView<>();

	public void tableMed() throws ClassNotFoundException, SQLException {

		// String medicine1 = "medicine1";
		String select = "SELECT * FROM  medicine1  ";
		/*
		 * if (!sell.equals("") && !discount.equals("")) {
		 * 
		 * Double valueOfSell = new Double(sell); Double valueOfDiscount = new
		 * Double(discount); sell = (valueOfDiscount != 0) ? valueOfSell - (valueOfSell
		 * * valueOfDiscount) / 100 + "" : valueOfSell + "";
		 * 
		 * }
		 */
		Statement ss;
		ss = con.createStatement();

		ResultSet resultSet = null;
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(select);
			resultSet = preparedStatement.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ObservableList dbData = FXCollections.observableArrayList(arrayMed(resultSet));

		for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
			TableColumn column = new TableColumn<>();
			column.setPrefWidth(75);

			switch (resultSet.getMetaData().getColumnName(i + 1)) {
			case "id":
				column.setText("id");
				break;
			case "idmed":
				column.setText("idmed");
				break;
			case "BillDate":
				column.setText("BillDate");
				break;
			case "medName":
				column.setText("medName");
				break;
			case "type":
				column.setText("type");
				break;
			case "productDate":
				column.setText("productDate");
				break;
			case "expireDate":
				column.setText("expireDate");
				break;
			case "cost":
				column.setText("cost");
				break;
			case "quantity":
				column.setText("quantity");
				break;
			default:
				column.setText(resultSet.getMetaData().getColumnName(i + 1)); // if column name in SQL Database is not
																				// found, then TableView column receive
																				// SQL Database current column name (not
																				// readable)
				break;
			}
			column.setCellValueFactory(new PropertyValueFactory<>(resultSet.getMetaData().getColumnName(i + 1)));

			tableViewmed.getColumns().add(column);
		}
		// Filling up tableView with data
		tableViewmed.setItems(dbData);
	}

	private ArrayList arrayMed(ResultSet resultSet) throws SQLException {
		ArrayList<Medicine1> data = new ArrayList<>();

		while (resultSet.next()) {

			Medicine1 med = new Medicine1();
			med.setId(resultSet.getInt("id"));
			med.setIdmed(resultSet.getInt("idmed"));
			med.setBillDate(resultSet.getString("BillDate"));
			med.setMedName(resultSet.getString("medName"));
			med.setType(resultSet.getString("type"));
			med.setProductDate(resultSet.getString("productDate"));
			med.setExpireDate(resultSet.getString("expireDate"));
			med.setCost(resultSet.getDouble("cost"));
			med.setQuantity(resultSet.getInt("quantity"));

			data.add(med);
		}

		return data;
	}

	public Stage Query() throws SQLException {
		Stage stage = new Stage();
		Pane p = new Pane();
		Scene s1 = new Scene(p, 650, 650);
		stage.setScene(s1);
		stage.setTitle("SceneQuery");

		Image img = new Image(
				"https://graphicriver.img.customer.envatousercontent.com/files/354162163/preview.jpg?auto=compress%2Cformat&q=80&fit=crop&crop=top&max-h=8000&max-w=590&s=ceff0f5f59e7cab5a2bb26320ae67f16");
		BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
				BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background bGround = new Background(bImg);
		p.setBackground(bGround);

		Button close = new Button("CLOSE");
		close.setStyle("-fx-border-color:purple; -fx-border-width: 5px;");
		close.setOnAction(e -> {
			System.exit(1);

		});
		close.setTextFill(Color.PURPLE);
		close.setMinSize(120, 20);
		close.setLayoutX(500);
		close.setLayoutY(600);
		p.getChildren().add(close);

		TextField textquery = new TextField("");
		textquery.setPrefSize(400, 100);
		textquery.setLayoutX(130);
		textquery.setLayoutY(450);
		p.getChildren().add(textquery);

		Button query1 = new Button("Count Coustmer");
		query1.setTextFill(Color.PURPLE);
		query1.setStyle("-fx-border-color:purple; -fx-border-width: 5px;");

		Button query2 = new Button("query to chosse type of medicine to id=1");
		query2.setTextFill(Color.PURPLE);
		query2.setStyle("-fx-border-color:purple; -fx-border-width: 5px;");

		Button query3 = new Button("query to chosse name of medicine have cost >22");
		query3.setTextFill(Color.PURPLE);
		query3.setStyle("-fx-border-color:purple; -fx-border-width: 5px;");

		Button query4 = new Button("query to find Min price of midicine ");
		query4.setTextFill(Color.PURPLE);
		query4.setStyle("-fx-border-color:purple; -fx-border-width: 5px;");

		Button query5 = new Button("query to find Max price of midicine ");
		query5.setTextFill(Color.PURPLE);
		query5.setStyle("-fx-border-color:purple; -fx-border-width: 5px;");
		
		Button query6 = new Button("query to chosse  medicine Name order by id ASC");
		query6.setTextFill(Color.PURPLE);
		query6.setStyle("-fx-border-color:purple; -fx-border-width: 5px;");
		
		Button query7 = new Button("query to chosse  medicine Name order by id DESC");
		query7.setTextFill(Color.PURPLE);
		query7.setStyle("-fx-border-color:purple; -fx-border-width: 5px;");

		query1.setOnAction(e -> {
			Statement ss;
			try {
				ss = con.createStatement();
				ResultSet resultSet1 = null;
				resultSet1 = ss.executeQuery("SELECT COUNT(idmed) FROM medicine1");
				resultSet1.next();

				textquery.setText(resultSet1.getString(1));
			} catch (Exception e33) {
				// TODO Auto-generated catch block
				e33.printStackTrace();
				textquery.setText("Wrong Input!!!");

			}

		});

		query2.setOnAction(e -> {
			Statement ss3;
			try {
				ss3 = con.createStatement();
				ResultSet resultSet1 = null;
				resultSet1 = ss3.executeQuery("SELECT m.type FROM medicine1 m where id=1");

				String string = " ";
				while (resultSet1.next()) {
					string += "type : " + resultSet1.getString(1);
				}
				textquery.setText(string);
			} catch (Exception e33) {
				// TODO Auto-generated catch block
				e33.printStackTrace();
				textquery.setText("Wrong Input!!!");
			}

		});

		query3.setOnAction(e -> {
			Statement ss3;
			try {
				ss3 = con.createStatement();
				ResultSet resultSet1 = null;
				resultSet1 = ss3.executeQuery("SELECT m.medName FROM medicine1 m where m.cost>22");
				String string = " ";
				while (resultSet1.next()) {
					string += "   medicine Name : " + resultSet1.getString(1);
				}
				textquery.setText(string);

			} catch (Exception e33) {
				// TODO Auto-generated catch block
				e33.printStackTrace();
				textquery.setText("Wrong Input!!!");

			}

		});

		query4.setOnAction(e -> {
			Statement ss;
			try {
				ss = con.createStatement();
				ResultSet resultSet1 = null;
				resultSet1 = ss.executeQuery("SELECT MIN(m.cost) FROM medicine1 m ");
				resultSet1.next();

				textquery.setText(resultSet1.getString(1));
			} catch (Exception e33) {
				// TODO Auto-generated catch block
				e33.printStackTrace();
				textquery.setText("Wrong Input!!!");

			}

		});

		query5.setOnAction(e -> {
			Statement ss;
			try {
				ss = con.createStatement();
				ResultSet resultSet1 = null;
				resultSet1 = ss.executeQuery("SELECT MAX(m.cost) FROM medicine1 m ");
				resultSet1.next();

				textquery.setText(resultSet1.getString(1));
			} catch (Exception e33) {
				// TODO Auto-generated catch block
				e33.printStackTrace();
				textquery.setText("Wrong Input!!!");

			}

		});
		query6.setOnAction(e -> {
			Statement ss3;
			try {
				ss3 = con.createStatement();
				ResultSet resultSet1 = null;
				resultSet1 = ss3.executeQuery("SELECT m.medName FROM medicine1 m ORDER BY m.id ASC ");

				String string = " ";
				while (resultSet1.next()) {
					string += " Medicine Name : " + resultSet1.getString(1);
				}
				textquery.setText(string);
			} catch (Exception e33) {
				// TODO Auto-generated catch block
				e33.printStackTrace();
				textquery.setText("Wrong Input!!!");
			}

		});
		query7.setOnAction(e -> {
			Statement ss3;
			try {
				ss3 = con.createStatement();
				ResultSet resultSet1 = null;
				resultSet1 = ss3.executeQuery("SELECT m.medName FROM medicine1 m ORDER BY m.id DESC ");

				String string = " ";
				while (resultSet1.next()) {
					string += " Medicine Name : " + resultSet1.getString(1);
				}
				textquery.setText(string);
			} catch (Exception e33) {
				// TODO Auto-generated catch block
				e33.printStackTrace();
				textquery.setText("Wrong Input!!!");
			}

		});

		VBox vbox = new VBox(15);
		vbox.getChildren().addAll(query1, query2, query3, query4, query5,query6,query7);
		vbox.setLayoutX(60);
		vbox.setLayoutY(60);
		p.getChildren().add(vbox);

		return stage;

	}

}