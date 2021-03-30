package nhs.gov.ke.view;

import nhs.gov.ke.Main;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Collins Mbwika <elitetech.com>
 */
public class LandingController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @FXML
  TextArea txt_symptoms_advice; 
    @FXML
  TextField txt_id_advice;
        @FXML
  TextField Id;
            @FXML
  TextField txt_med_advice; 
    @FXML
  TextField txt_medic_advice;
    @FXML
  TextField txt_served_by; 
    @FXML
  TextField txt_balance;
        @FXML
  TextField txt_consultation_fee;
        @FXML
  TextField txt_medicine;
        @FXML
  TextField txt_treatment_amt;
        @FXML
  TextField txt_consultation_amt;
        @FXML
  TextField txt_medicine_amt;
        @FXML
  TextField txt_others_amt;
        @FXML
  TextField txt_category1; 
        @FXML
  TextField patientId1;
        @FXML
  TextArea txt_symptoms1; 
        @FXML
  TextField txt_patient_id1;
        @FXML
  TextField txt_treatment1;
        @FXML
  TextField txt_patientNo1;
        @FXML
  TextField txt_full_name1;
        @FXML
  TextField txt_diagnosis1;
        @FXML
  TextField txt_health_facility1;
    @FXML
  TextField txt_category; 
    @FXML
  TextArea txt_symptoms; 
    @FXML
  TextField txt_patient_id;
    @FXML
  TextField txt_treatment; 
    @FXML
  TextField txt_patientNo; 
    @FXML
  TextField txt_full_name;
    @FXML
  TextField txt_medic; 
    @FXML
  TextField txt_health_facility;
  @FXML
  TextField txt_duration;
  @FXML
  TextField txt_diagnosis;
  @FXML
  TextField txt_admitted;
  @FXML
  TextField txt_discharged;
    @FXML
  TextField patientId; 
    @FXML
  TextField txt_patient_no;
  @FXML
  TextField txt_name;
  @FXML
  TextField txt_national_id;
  @FXML
  TextField txt_birth_entry;
  @FXML
  PasswordField txt_password;
  @FXML
    Button clearPatientIdBtn;
  @FXML
    Button savePatientDetailsBtn;
    @FXML
    Button clearDetailsBtn;
    @FXML
    Button saveHealthRecordBtn;
    @FXML
    Button clearHealthRecordBtn;
    @FXML
    Button clearFieldsBtn;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            // TODO
            
        
    } 
    
        @FXML
    private Button backBtn;
        
        @FXML
    private Button addPatientBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Button homeBtn;

    @FXML
    TextField patientNameField;
    
    @FXML
    private Label title;

    @FXML
    private Hyperlink copyrightStatement;
    
        @FXML
    private Button minimizeStageBtn;
    
            @FXML
    void minimizeStage(ActionEvent event) {
        ((Stage)((Button)event.getSource()).getScene().getWindow()).setIconified(true);
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        
        Main.showLogin();
    }

    @FXML
    void copyrightStatementInfo(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) {
        ((Stage)((Button)event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    void logOut(ActionEvent event) throws IOException {
        Main.showLogin();
    }
 
        
    
    //records
         @FXML
    private TableView<LandingController.PatientDetails> recordsTable;

          @FXML
    private TableColumn<LandingController.PatientDetails, String> category;

            @FXML
    private TableColumn<LandingController.PatientDetails, String> symptoms;

             @FXML
    private TableColumn<LandingController.PatientDetails, String> diagnosis;

              @FXML
    private TableColumn<LandingController.PatientDetails, String> treatment;

               @FXML
    private TableColumn<LandingController.PatientDetails, String> duration;
               
               @FXML
    private TableColumn<LandingController.PatientDetails, String> medic;

                @FXML
    private TableColumn<LandingController.PatientDetails, String> health_facility;
        //Initialize observable list to hold db data
    private ObservableList<LandingController.PatientDetails>data;
    
    //records
         @FXML
    private TableView<LandingController.Consultations> consultationsTable;

          @FXML
    private TableColumn<LandingController.Consultations, String> tc_id;

            @FXML
    private TableColumn<LandingController.Consultations, String> tc_patient_no;
            
            @FXML
    private TableColumn<LandingController.Consultations, String> tc_nhif_no;

             @FXML
    private TableColumn<LandingController.Consultations, String> tc_symptoms;

              @FXML
    private TableColumn<LandingController.Consultations, String> tc_duration;

               @FXML
    private TableColumn<LandingController.Consultations, String> tc_treatment;
               
               @FXML
    private TableColumn<LandingController.Consultations, String> tc_medical_advice;
               
               @FXML
    private TableColumn<LandingController.Consultations, String> tc_medic;
//Initialize observable list to hold db data
    private ObservableList<LandingController.Consultations>c_data;
    
    private Main dc;
    @FXML
    Button searchPersonsBtn;
    @FXML
    Button searchPersonsBtn1;
    @FXML
    Button searchPersonsBtn2;
    
    @FXML
    void searchPersons(ActionEvent event) throws SQLException{

                try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hms_db", "root", "");
        //Connection conn = DriverManager.getConnection("jdbc:mysql://http://192.168.43.58:3306/hms_db", "root", "");
        data = FXCollections.observableArrayList();
        
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM patient_tb WHERE patient_no=?") ;
             pst.setString(1, patientNameField.getText());
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
                                  data.add(new LandingController.PatientDetails(rs.getString(4), rs.getString(6), rs.getString(12), rs.getString(13), rs.getString(9), rs.getString(10), rs.getString(11)));
           
           String fname = rs.getString(2);  
 
        }
    } catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        symptoms.setCellValueFactory(new PropertyValueFactory<>("symptoms"));
        diagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        treatment.setCellValueFactory(new PropertyValueFactory<>("treatment"));
        duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        medic.setCellValueFactory(new PropertyValueFactory<>("medic"));
        health_facility.setCellValueFactory(new PropertyValueFactory<>("health_facility"));
        
        recordsTable.setItems(null);
        recordsTable.setItems(data);
            //Define the button cell
  
} 
    @FXML
    void loadConsultations(ActionEvent event) throws SQLException{

                try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hms_db", "root", "");
        //Connection conn = DriverManager.getConnection("jdbc:mysql://http://192.168.43.58:3306/hms_db", "root", "");
        c_data = FXCollections.observableArrayList();
        String medical_record = "";
        
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM consultations_tb") ;
       // pst.setString(1, medical_record);
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
                                  c_data.add(new LandingController.Consultations(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));

 
        }
    } catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        tc_id.setCellValueFactory(new PropertyValueFactory<>("tc_id"));
        tc_patient_no.setCellValueFactory(new PropertyValueFactory<>("tc_patient_no"));
        tc_nhif_no.setCellValueFactory(new PropertyValueFactory<>("tc_nhif_no"));
        tc_symptoms.setCellValueFactory(new PropertyValueFactory<>("tc_symptoms"));
        tc_duration.setCellValueFactory(new PropertyValueFactory<>("tc_duration"));
        tc_treatment.setCellValueFactory(new PropertyValueFactory<>("tc_treatment"));
        tc_medical_advice.setCellValueFactory(new PropertyValueFactory<>("tc_medical_advice"));
        tc_medic.setCellValueFactory(new PropertyValueFactory<>("tc_medic"));
        
        consultationsTable.setItems(null);
        consultationsTable.setItems(c_data);
            //Define the button cell
  
}
    @FXML
    void searchPatientByName(ActionEvent event) throws SQLException{

                try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hms_db", "root", "");
        //Connection conn = DriverManager.getConnection("jdbc:mysql://http://192.168.43.58:3306/hms_db", "root", "");
        data = FXCollections.observableArrayList();
        
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM patient_tb WHERE name=?") ;
             pst.setString(1, patientNameField.getText());
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
                                  data.add(new LandingController.PatientDetails(rs.getString(4), rs.getString(6), rs.getString(12), rs.getString(13), rs.getString(9), rs.getString(10), rs.getString(11)));
           String name = rs.getString(1);  
                   
            
        }
    } catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        symptoms.setCellValueFactory(new PropertyValueFactory<>("symptoms"));
        diagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        treatment.setCellValueFactory(new PropertyValueFactory<>("treatment"));
        duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        medic.setCellValueFactory(new PropertyValueFactory<>("medic"));
        health_facility.setCellValueFactory(new PropertyValueFactory<>("health_facility"));
        
        recordsTable.setItems(null);
        recordsTable.setItems(data);
            //Define the button cell
  
}
 

    public class SubRecord{
        private final SimpleStringProperty fieldSubRecordName;
        private final SimpleIntegerProperty fieldSubRecordValue;
         
        SubRecord(String sn, int sv){
          this.fieldSubRecordName = new SimpleStringProperty(sn);
          this.fieldSubRecordValue = new SimpleIntegerProperty(sv);
      }
      
      public String getFieldSubRecordName() {
          return fieldSubRecordName.get();
      }
      
      public int getFieldSubRecordValue() {
          return fieldSubRecordValue.get();
      }
      
  }
    public class SubRecord1{
        private final SimpleStringProperty fieldSubRecordName;
        private final SimpleIntegerProperty fieldSubRecordValue;
         
        SubRecord1(String sn, int sv){
          this.fieldSubRecordName = new SimpleStringProperty(sn);
          this.fieldSubRecordValue = new SimpleIntegerProperty(sv);
      }
      
      public String getFieldSubRecordName() {
          return fieldSubRecordName.get();
      }
      
      public int getFieldSubRecordValue() {
          return fieldSubRecordValue.get();
      }
      
  }
    
    public class PatientDetails {
    private final StringProperty category;
    private final StringProperty diagnosis;
    private final StringProperty symptoms;
    private final StringProperty treatment;
    private final StringProperty duration;
    private final StringProperty medic;
    private final StringProperty health_facility;
    
    //default constructor
    public PatientDetails(String category, String diagnosis, String symptoms, String treatment, String duration, 
            String medic, String health_facility){
        this.category = new SimpleStringProperty(category);
        this.diagnosis = new SimpleStringProperty(diagnosis);
        this.symptoms = new SimpleStringProperty(symptoms);
        this.treatment = new SimpleStringProperty(treatment);
        this.duration = new SimpleStringProperty(duration);
        this.medic = new SimpleStringProperty(medic);
        this.health_facility = new SimpleStringProperty(health_facility);
    }

        private PatientDetails(String string, String string0, String string1, String string2, String string3) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
    //gets
    public String getCategory(){
        return category.get();
    }
    public String getDiagnosis(){
        return diagnosis.get();
    }
    public String getSymptoms(){
        return symptoms.get();
    }
    public String getTreatment(){
        return treatment.get();
    }
    public String getDuration(){
        return duration.get();
    }
    public String getMedic(){
        return medic.get();
    }
    public String getHealthFacility(){
        return health_facility.get();
    }
    
    //sets
    public void setCategory(String value){
        category.set(value);
    }
    public void setDiagnosis(String value){
        diagnosis.set(value);
    }
    public void setSymptoms(String value){
        symptoms.set(value);
    }
    public void setTreatment(String value){
        treatment.set(value);
    }
    public void setDuration(String value){
        duration.set(value);
    }
    public void setMedic(String value){
        medic.set(value);
    }
    public void setHealthFacility(String value){
        health_facility.set(value);
    }
    
    //Property values
    public StringProperty categoryProperty(){
        return category;
    }
    public StringProperty diagnosisProperty(){
        return diagnosis;
    }
    public StringProperty symptomsProperty(){
        return symptoms;
    }
    public StringProperty treatmentProperty(){
        return treatment;
    }
    public StringProperty durationProperty(){
        return duration;
    }
    public StringProperty medicProperty(){
        return medic;
    }
    public StringProperty health_facilityProperty(){
        return health_facility;
    }
    }
    
    public class Consultations {
    private final StringProperty tc_id;
    private final StringProperty tc_patient_no;
    private final StringProperty tc_nhif_no;
    private final StringProperty tc_symptoms;
    private final StringProperty tc_duration;
    private final StringProperty tc_treatment;
    private final StringProperty tc_medical_advice;
    private final StringProperty tc_medic;
    
    //default constructor
    public Consultations(String tc_id, String tc_patient_no, String tc_nhif_no, String tc_symptoms, String tc_duration, String tc_treatment, 
            String tc_medical_advice, String tc_medic){
        this.tc_id = new SimpleStringProperty(tc_id);
        this.tc_patient_no = new SimpleStringProperty(tc_patient_no);
        this.tc_nhif_no = new SimpleStringProperty(tc_nhif_no);
        this.tc_symptoms = new SimpleStringProperty(tc_symptoms);
        this.tc_duration = new SimpleStringProperty(tc_duration);
        this.tc_treatment = new SimpleStringProperty(tc_treatment);
        this.tc_medical_advice = new SimpleStringProperty(tc_medical_advice);
        this.tc_medic = new SimpleStringProperty(tc_medic);
    }

        private Consultations(String string, String string0, String string1, String string2, String string3) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
    //gets
    public String getTc_id(){
        return tc_id.get();
    }
    public String getTc_patient_no(){
        return tc_patient_no.get();
    }
    public String getTc_nhif_no(){
        return tc_nhif_no.get();
    }
    public String getTc_symptoms(){
        return tc_symptoms.get();
    }
    public String getTc_duration(){
        return tc_duration.get();
    }
    public String getTc_treatment(){
        return tc_treatment.get();
    }
    public String getTc_medical_advice(){
        return tc_medical_advice.get();
    }
    public String getTc_medic(){
        return tc_medic.get();
    }
    
    //sets
    public void setTc_id(String value){
        tc_id.set(value);
    }
    public void setTc_patient_no(String value){
        tc_patient_no.set(value);
    }
    public void setTc_nhif_no(String value){
        tc_nhif_no.set(value);
    }
    public void setTc_symptoms(String value){
        tc_symptoms.set(value);
    }
    public void setTc_duration(String value){
        tc_duration.set(value);
    }
    public void setTc_treatment(String value){
        tc_treatment.set(value);
    }
    public void setTc_medical_advice(String value){
        tc_medical_advice.set(value);
    }
    public void setTc_medic(String value){
        tc_medic.set(value);
    }
    
    //Property values
    public StringProperty tc_idProperty(){
        return tc_id;
    }
    public StringProperty tc_patient_noProperty(){
        return tc_patient_no;
    }
    public StringProperty tc_nhif_noProperty(){
        return tc_nhif_no;
    }
    public StringProperty tc_symptomsProperty(){
        return tc_symptoms;
    }
    public StringProperty tc_durationProperty(){
        return tc_duration;
    }
    public StringProperty tc_treatmentProperty(){
        return tc_treatment;
    }
    public StringProperty tc_medical_adviceProperty(){
        return tc_medical_advice;
    }
    public StringProperty tc_medicProperty(){
        return tc_medic;
    }
    }
    
        @FXML
    void savePatientDetails(ActionEvent event) throws SQLException{

                try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hms_db", "root", "");
        //Connection conn = DriverManager.getConnection("jdbc:mysql://http://192.168.43.58:3306/hms_db", "root", "");
        data = FXCollections.observableArrayList();

        String patient_no = txt_patient_no.getText();
        String name = txt_name.getText();
        String national_id = txt_national_id.getText();
        String birth_entry = txt_birth_entry.getText();
        String password = txt_password.getText();
        
        if(patient_no != null){ 
        PreparedStatement st = conn.prepareStatement("INSERT INTO persons_record_tb (patient_no, full_name, national_id_no, dob, password) VALUES (?,?,?,?,?)");
        
                st.setString(1, patient_no);
                st.setString(2, name);
                st.setString(3, national_id);
                st.setString(4, birth_entry);
                st.setString(5, password);
                st.executeUpdate();
                
          Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("PATIENT ADDED SUCCESSFULLY!");
                            alert.setHeaderText("Patient name: " +name);
                            alert.showAndWait();
                }else{
                    Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("SUCCESS!");
                            alert.setHeaderText("Patient NOT added!");
                            alert.setContentText("Possible patient number missing/duplicate. Try Again!");
                            alert.showAndWait();
                }         
}
    
    
    @FXML
    void saveTransaction(ActionEvent event) throws SQLException{

                try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hms_db", "root", "");
        //Connection conn = DriverManager.getConnection("jdbc:mysql://http://192.168.43.58:3306/hms_db", "root", "");
        //data = FXCollections.observableArrayList();

        String patientNo = txt_patientNo1.getText();
        String full_name = txt_full_name1.getText();
        String diagnosis = txt_diagnosis1.getText();
        String medicine = txt_medicine_amt.getText();
        String health_facility = txt_health_facility1.getText();
        String served_by = txt_served_by.getText();
        String consultation_fee = txt_consultation_amt.getText();
        String others = txt_others_amt.getText();
        String patient_id = txt_patient_id1.getText();
        String symptoms = txt_symptoms1.getText();
        String treatment = txt_treatment_amt.getText();
        String category = txt_category1.getText();
        String balance = txt_balance.getText();
        
        if(patientNo != "" && full_name != "" && patient_id != ""){ 
        PreparedStatement st = conn.prepareStatement("INSERT INTO transactions_tb (patient_no, patient_id, name, category, "
                + "health_facility, diagnosis, symptoms, consultation_fee, treatment, medication, other_charges, served_by, balance) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
                st.setString(1, patientNo);
                st.setString(2, patient_id);
                st.setString(3, full_name);
                st.setString(4, category);
                st.setString(5, health_facility);
                st.setString(6, diagnosis);
                st.setString(7, symptoms);
                st.setString(8, consultation_fee);
                st.setString(9, treatment);
                st.setString(10, medicine);
                st.setString(11, others);
                st.setString(12, served_by);
                st.setString(13, balance);
                st.executeUpdate();
                
          Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("TRANSACTION SAVED SUCCESSFULLY!");
                            alert.setHeaderText("Patient ID. " +patient_id);
                            alert.showAndWait();
                }else{
                    Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("FAILED!");
                            alert.setHeaderText("Transaction Not saved!");
                            alert.setContentText("Try Again!");
                            alert.showAndWait();
                }         
}
    
    @FXML
    void saveDetails(ActionEvent event) throws SQLException{

                try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hms_db", "root", "");
        //Connection conn = DriverManager.getConnection("jdbc:mysql://http://192.168.43.58:3306/hms_db", "root", "");
        data = FXCollections.observableArrayList();

        String id_advice = txt_id_advice.getText();
        String symptoms_advice = txt_symptoms_advice.getText();
        String med_advice = txt_med_advice.getText();
        String medic = txt_medic_advice.getText();
        
        if(med_advice != "" && medic != ""){ 
        PreparedStatement st = conn.prepareStatement("UPDATE consultations_tb SET medical_advice=?,medic=? WHERE id=" +id_advice+ "");
        
                st.setString(1, med_advice);
                st.setString(2, medic);
                st.executeUpdate();
                
          Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("SUCCESSFULLY DONE!");
                            alert.setHeaderText("Id : " +id_advice);
                            alert.showAndWait();
                }else{
                    Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("FAILED!");
                            alert.setHeaderText("NOT saved!");
                            alert.setContentText("Try Again!");
                            alert.showAndWait();
                }         
}
    @FXML
    void saveHealthRecord(ActionEvent event) throws SQLException{

                try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hms_db", "root", "");
        //Connection conn = DriverManager.getConnection("jdbc:mysql://http://192.168.43.58:3306/hms_db", "root", "");
        data = FXCollections.observableArrayList();

        String patientNo = txt_patientNo.getText();
        String full_name = txt_full_name.getText();
        String diagnosis = txt_diagnosis.getText();
        String medic = txt_medic.getText();
        String health_facility = txt_health_facility.getText();
        String admitted = txt_admitted.getText();
        String discharged = txt_discharged.getText();
        String duration = txt_duration.getText();
        String patient_id = txt_patient_id.getText();
        String symptoms = txt_symptoms.getText();
        String treatment = txt_treatment.getText();
        String category = txt_category.getText();
        
        if(patientNo != "" && full_name != ""){ 
        PreparedStatement st = conn.prepareStatement("INSERT INTO patient_tb (patient_no, name, diagnosis, employee_id , health_facility, time_admitted, time_discharged, duration, patient_id, symptoms, treatment, category) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
        
                st.setString(1, patientNo);
                st.setString(2, full_name);
                st.setString(3, diagnosis);
                st.setString(4, medic);
                st.setString(5, health_facility);
                st.setString(6, admitted);
                st.setString(7, discharged);
                st.setString(8, duration);
                st.setString(9, patient_id);
                st.setString(10, symptoms);
                st.setString(11, treatment);
                st.setString(12, category);
                st.executeUpdate();
                
          Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("RECORD SAVED SUCCESSFULLY!");
                            alert.setHeaderText("Patient No. " +patientNo);
                            alert.showAndWait();
                }else{
                    Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("SUCCESS!");
                            alert.setHeaderText("Record NOT added!");
                            alert.setContentText("Possible patient number/name missing. Try Again!");
                            alert.showAndWait();
                }         
}
    @FXML
  void clearHealthRecord(ActionEvent event)
  {
    this.txt_patientNo.clear();
    this.txt_full_name.clear();
    this.txt_diagnosis.clear();
    this.txt_medic.clear();
    this.txt_health_facility.clear();
    this.txt_admitted.clear();
    this.txt_discharged.clear();
    this.txt_duration.clear();
    this.txt_patient_id.clear();
    this.txt_symptoms.clear();
    this.txt_treatment.clear();
    this.txt_category.clear();
  }
     @FXML
  void clearPatient(ActionEvent event)
  {
    this.patientNameField.clear();
  }
    @FXML
  void clearPatientId(ActionEvent event)
  {
    this.patientId.clear();
  }
   
   @FXML
  void clear(ActionEvent event)
  {
    this.txt_id_advice.clear();
    this.Id.clear();
    this.txt_symptoms_advice.clear();
    this.txt_med_advice.clear();
    this.txt_medic_advice.clear();
  }
  @FXML
  void clearFields(ActionEvent event)
  {
    this.txt_category1.clear();
    this.txt_symptoms1.clear();
    this.txt_patient_id1.clear();
    this.txt_patientNo1.clear();
    this.txt_full_name1.clear();
    this.txt_diagnosis1.clear();
    this.txt_health_facility1.clear();
    this.txt_served_by.clear();
    this.txt_treatment_amt.clear();
    this.txt_consultation_amt.clear();
    this.txt_medicine_amt.clear();
    this.txt_others_amt.clear();
    this.txt_balance.clear();
  }
  
    @FXML
  void clearDetails(ActionEvent event)
  {
    this.txt_patient_no.clear();
    this.txt_name.clear();
    this.txt_national_id.clear();
    this.txt_password.clear();
    this.txt_birth_entry.clear();
  }
  
  
  @FXML
    void searchHealthRecord(ActionEvent event) throws SQLException{
        
        String patient_Id = patientId1.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
            }
               Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hms_db", "root", "");
               // conn = DriverManager.getConnection("jdbc:mysql://http://192.168.43.58:3306/hms_db", "root", "");
               if(patient_Id != null){          
               PreparedStatement st = conn.prepareStatement("SELECT * FROM patient_tb WHERE patient_id=?");
                st.setString(1, patient_Id);

                    try (java.sql.ResultSet rs = st.executeQuery()) {
 
                                while(rs.next()){
                               String patient_no = rs.getString(2);
                               txt_patientNo1.setText(patient_no);
                               String name = rs.getString(3);
                               txt_full_name1.setText(name);
                               String patient_id = rs.getString(5);
                               txt_patient_id1.setText(patient_id);                               
                               String category = rs.getString(4);
                               txt_category1.setText(category);
                               String diagnosis = rs.getString(6);
                               txt_diagnosis1.setText(diagnosis);
                               String symptoms = rs.getString(12);
                               txt_symptoms1.setText(symptoms);
                               String health_facility = rs.getString(11);
                               txt_health_facility1.setText(health_facility);
                }

        }catch(SQLException er){
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Connection to Database Failed!");
                            alert.setContentText("Error: " +er);
                            alert.showAndWait();
        }
               }else{
                Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("FAILED!");
                            alert.setHeaderText("Record does not exist!");
                            alert.setContentText("Check Patient ID and try Again!");
                            alert.showAndWait();
                }
        }
    
  @FXML
    void searchPatientDetails(ActionEvent event) throws SQLException{
        
        String patient_Id = patientId.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(AddPatientController.class.getName()).log(Level.SEVERE, null, ex);
            }
               Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hms_db", "root", "");
               // conn = DriverManager.getConnection("jdbc:mysql://http://192.168.43.58:3306/hms_db", "root", "");
               if(patient_Id != null){          
               PreparedStatement st = conn.prepareStatement("SELECT * FROM persons_record_tb WHERE patient_no=?");
                st.setString(1, patient_Id);

                    try (java.sql.ResultSet rs = st.executeQuery()) {
 
                                while(rs.next()){
                               String patient_no = rs.getString(2);
                               txt_patient_no.setText(patient_no);
                               String name = rs.getString(4);
                               txt_name.setText(name);
                               String national_id = rs.getString(5);
                               txt_national_id.setText(national_id);                               
                               String birth_entry = rs.getString(6);
                               txt_birth_entry.setText(birth_entry);
                               String password = rs.getString(3);
                               txt_password.setText(password);

                }

        }catch(SQLException er){
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Connection to Database Failed!");
                            alert.setContentText("" +er);
                            alert.showAndWait();
        }
               }else{
                Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("FAILED!");
                            alert.setHeaderText("Patient NOT added!");
                            alert.setContentText("Possible patient number missing. Try Again!");
                            alert.showAndWait();
                }
        }

        @FXML
    void loadById(ActionEvent event) throws SQLException{
        
        String id = Id.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {}
               Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hms_db", "root", "");
               //Connection conn = DriverManager.getConnection("jdbc:mysql://http://192.168.43.58:3306/hms_db", "root", "");
               if(id != null){          
               PreparedStatement st = conn.prepareStatement("SELECT * FROM consultations_tb WHERE id=?");
                st.setString(1, id);

                    try (java.sql.ResultSet rs = st.executeQuery()) {
 
                                while(rs.next()){
                               String id_advice = rs.getString(1);
                               txt_id_advice.setText(id_advice);
                               String symptoms = rs.getString(4);
                               txt_symptoms_advice.setText(symptoms);
                              
                }

        }catch(SQLException er){
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Connection to Database Failed!");
                            alert.setContentText("" +er);
                            alert.showAndWait();
        }
               }else{
                Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("FAILED!");
                            alert.setHeaderText("Nothing entered in the Search box!");
                            alert.setContentText("Possible patient number missing. Try Again!");
                            alert.showAndWait();
                }
}
    @FXML
    void searchPatientDetailsByName(ActionEvent event) throws SQLException{
        
        String name = patientId.getText();
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(AddPatientController.class.getName()).log(Level.SEVERE, null, ex);
            }
               Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hms_db", "root", "");
               //Connection conn = DriverManager.getConnection("jdbc:mysql://http://192.168.43.58:3306/hms_db", "root", "");
               if(name != null){          
               PreparedStatement st = conn.prepareStatement("SELECT * FROM persons_record_tb WHERE full_name=?");
                st.setString(1, name);

                    try (java.sql.ResultSet rs = st.executeQuery()) {
 
                                while(rs.next()){
                               String patient_no = rs.getString(2);
                               txt_patient_no.setText(patient_no);
                               String full_name = rs.getString(4);
                               txt_name.setText(full_name);
                               String national_id = rs.getString(5);
                               txt_national_id.setText(national_id);                               
                               String birth_entry = rs.getString(6);
                               txt_birth_entry.setText(birth_entry);
                               String password = rs.getString(3);
                               txt_password.setText(password);
                }

        }catch(SQLException er){
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Connection to Database Failed!");
                            alert.setContentText("" +er);
                            alert.showAndWait();
        }
               }else{
                Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("FAILED!");
                            alert.setHeaderText("Nothing entered in the Search box!");
                            alert.setContentText("Possible patient number missing. Try Again!");
                            alert.showAndWait();
                }
        }
    
            public void showReport() throws SQLException, ClassNotFoundException, JRException {
            String patient_id = patientId1.getText();
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hms_db", "root", "");
            JasperDesign jd = JRXmlLoader.load("C:\\Users\\Jorginho\\Documents\\NetBeansProjects\\nhs\\src\\nhs\\gov\\ke\\receipts\\bill.jrxml");
            String sql = "SELECT * FROM transactions_tb WHERE patient_id = '"+patient_id+"'";

            JRDesignQuery newQ = new JRDesignQuery();
            newQ.setText(sql);
            jd.setQuery(newQ);
            
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
            JasperViewer.viewReport(jp, false);
    
        }catch(JRException ex){
            ex.printStackTrace();
}
    }
    
    @FXML
    void print(ActionEvent event) throws IOException, SQLException, ClassNotFoundException, JRException{
     showReport();
    }
}