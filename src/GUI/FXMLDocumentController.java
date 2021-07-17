/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Caeser.caeserDecrypt;
import Caeser.caeserEncrypt;
import HillCipher.HillDecrypt;
import HillCipher.HillEncrypt;
import PlayFair.PlayFairDecrypt;
import PlayFair.PlayFairEncrypt;
import Procedures.Decryption;
import Procedures.Encryption;
import VingereCipher.AutoKeyEncrypt;
import VingereCipher.AutokeyDecrypt;
import VingereCipher.RepeatedKeyDecrypt;
import VingereCipher.RepeatedKeyEncrypt;
import railFence.railFenceDecrypt;
import railFence.railFenceEncrypt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import javafx.application.Application;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author voider
 */
public class FXMLDocumentController implements Initializable {

//    @FXML
//    private Button encryptButton;
//    @FXML
//    private Button decryptButton;
//    @FXML
//    private Button historyButton;
    
    //File chooser
    List<String> istFile;
    String path;
    String tempRead;
    String outputFile;
    Tab tab1;
    TabPane tp;
    //result Lables
    @FXML
    private Label vingereResult;
    @FXML
    private Label caeserResult;
    @FXML
    private Label playFairResult;
    @FXML
    private Label RailFenceResult;
    @FXML
    private Label HillResult;
    
    //Error Labels
    @FXML
    private Label vingereError;
    @FXML
    private Label caeserError;
    @FXML
    private Label playFairError;
    @FXML
    private Label hillError;
    @FXML
    private Label railFenceError;
    //Input TextFields
    @FXML
    private TextField vingereMsgText;
    @FXML
    private TextField vingereKeyText;
    @FXML
    private RadioButton autoButton;
    @FXML
    private RadioButton repButton;
    
    @FXML
    private TextField caeserMsgText;
    @FXML
    private TextField caeserKeyText;
    
    @FXML
    private TextField hillMsgText;
    @FXML
    private TextField hillKeyText;

    @FXML
    private TextField playFairMsgText;
    @FXML
    private TextField playFairKeyText;
    
    @FXML
    private TextField railFenceMsgText;
    @FXML
    private TextField railFenceKeyText;
    private Boolean ceaserFlag=false;
    private Boolean vingereFlag=false;
    private Boolean playFairFlag=false;
    private Boolean railFenceFlag=false;
    private Boolean hillFlag=false;
    //polymorphism
    private Encryption enc;
    private Decryption dec;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        istFile = new ArrayList<>();  
        istFile.add("*.txt");
        
    }    
    
    @FXML
    private void caeserDragOver(DragEvent event) throws IOException
    {
       if(event.getDragboard().hasFiles())
       {event.acceptTransferModes(TransferMode.ANY);}
    }
    
       @FXML
    private void messageFileDragDrop(DragEvent event) throws FileNotFoundException, IOException 
    {
        Dragboard db = event.getDragboard();
        event.getDragboard().getFiles();
        File f = db.getFiles().get(0);
        
        if(f != null)
        {
            path = f.getAbsolutePath();
            BufferedReader br = new BufferedReader(new FileReader(f));
            
            while ((tempRead = br.readLine()) != null)
            {
                outputFile+=br.readLine();
                System.out.println(tempRead);
                System.out.println(1);
                caeserMsgText.setText(tempRead);
            }
            System.out.println(tempRead);
            System.out.println(outputFile);
            br.close();
            
            
            
        }
        
        
    }
    @FXML
    private void caeserKeyDragOver(DragEvent event) throws IOException
    {
       if(event.getDragboard().hasFiles())
       {event.acceptTransferModes(TransferMode.ANY);}
    }
    
       @FXML
    private void keyFileDragDrop(DragEvent event) throws FileNotFoundException, IOException 
    {
        Dragboard db = event.getDragboard();
        event.getDragboard().getFiles();
        File f = db.getFiles().get(0);
        
        if(f != null)
        {
            path = f.getAbsolutePath();
            BufferedReader br = new BufferedReader(new FileReader(f));
            
            while ((tempRead = br.readLine()) != null)
            {
                outputFile+=br.readLine();
                System.out.println(tempRead);
                System.out.println(1);
                caeserKeyText.setText(tempRead);
            }
            System.out.println(tempRead);
            System.out.println(outputFile);
            br.close();
            
            
            
        }
        
        
    }
    
     @FXML
    private void caeserDragShow(ActionEvent event) throws IOException
    {
        
    }
    
    @FXML
    public void historyButtonMenu(ActionEvent event) throws IOException
    {
        Parent historyParent = FXMLLoader.load(getClass().getResource("History.fxml"));
        Scene historyView = new Scene(historyParent);
        
        //Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setScene(historyView);
       // stage.setScene(historyView);
        stage.show();
    }
    
    
    
   
    
//public void historyButtonMenu(ActionEvent event)
//{
//
//    try {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
//        Stage stage = (Stage) historyButton.getScene().getWindow();
//        Scene scene = new Scene(loader.load());
//        stage.setScene(scene);
//    }catch (IOException io){
//        io.printStackTrace();
//    }
//    
//}
   @FXML
    private void caeserDecryptButton(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        if(caeserMsgText.getText().isEmpty() || caeserKeyText.getText().isEmpty())
            {
                caeserError.setVisible(true);
            }
        else
        {
        	//polymorphism
            dec = new caeserDecrypt();
            caeserResult.setText(dec.Decrypt(caeserMsgText.getText(), caeserKeyText.getText()));
            if(ceaserFlag)
            {
                PrintWriter writer = new PrintWriter("ceaserNew.txt", "UTF-8");
                writer.println(caeserResult.getText());
                writer.close();
            }
        
        }
    }
    
    @FXML
    private void caeserEncryptButton(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        if(caeserMsgText.getText().isEmpty() || caeserKeyText.getText().isEmpty())
            {
                caeserError.setVisible(true);
            }
        else
        {
            //polymorphism
           enc = new caeserEncrypt();
            caeserResult.setText(enc.Encrypt(caeserMsgText.getText(), caeserKeyText.getText()));
            if(ceaserFlag)
            {
                PrintWriter writer = new PrintWriter("ceaserNew.txt", "UTF-8");
                writer.println(caeserResult.getText());
                writer.close();
//                 File myObj = new File("ceaserNew.txt");
//                 FileWriter ceaserWriter = new FileWriter("ceaserNew.txt");
//                 ceaserWriter.write(caeserResult.getText());
//                 ceaserWriter.close();
                 
//                PrintWriter writer = new PrintWriter("ceaserNew.txt", "UTF-8");
//                writer.println("The first line");
//                writer.close();
            }
        
        }
    }
    @FXML
    private void vingereDecryptButton(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException, UnsupportedEncodingException, UnsupportedEncodingException, UnsupportedEncodingException {
         if(vingereMsgText.getText().isEmpty() || vingereKeyText.getText().isEmpty())
            {
                vingereError.setVisible(true);
            }
        else
        {
        if(autoButton.isSelected())
        {
           dec = new AutokeyDecrypt();
            vingereResult.setText(dec.Decrypt(vingereMsgText.getText(), vingereKeyText.getText()));
            if(vingereFlag)
            {
                PrintWriter writer = null;
                try {
                    writer = new PrintWriter("vingereNew.txt", "UTF-8");
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                writer.println(vingereResult.getText());
                writer.close();
            }
        }
        else
        {
           dec = new RepeatedKeyDecrypt();   
            vingereResult.setText(dec.Decrypt(vingereMsgText.getText(), vingereKeyText.getText()));
            PrintWriter writer = new PrintWriter("vingereNew.txt", "UTF-8");
                writer.println(vingereResult.getText());
                writer.close();
            
        }
    }
    }
    
    @FXML
    private void vingereEncryptButton(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        if(vingereMsgText.getText().isEmpty() || vingereKeyText.getText().isEmpty())
            {
                vingereError.setVisible(true);
            }
        else
        {
        if(autoButton.isSelected())
        {
            enc = new AutoKeyEncrypt();
            
            vingereResult.setText(enc.Encrypt(vingereMsgText.getText(), vingereKeyText.getText()));
            PrintWriter writer = new PrintWriter("vingereNew.txt", "UTF-8");
                writer.println(vingereResult.getText());
                writer.close();
        }
        else
            {
           enc = new RepeatedKeyEncrypt();
            vingereResult.setText(enc.Encrypt(vingereMsgText.getText(), vingereKeyText.getText()));
            PrintWriter writer = new PrintWriter("vingereNew.txt", "UTF-8");
                writer.println(vingereResult.getText());
                writer.close();
            }
        }
    }
    
    @FXML
    private void hillDecryptButton(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
          if(hillMsgText.getText().isEmpty() || hillKeyText.getText().isEmpty())
            {
                hillError.setVisible(true);
            }
            else
            {
            dec = new HillDecrypt();
            dec.Decrypt(hillMsgText.getText(), hillKeyText.getText());
            HillResult.setText(dec.getdecryptedText());      
            if(hillFlag)
                {
                    PrintWriter writer = new PrintWriter("hillNew.txt", "UTF-8");
                    writer.println(HillResult.getText());
                    writer.close();
                }
            }
        
    }
    
    @FXML
    private void hillEncryptButton(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException, UnsupportedEncodingException, UnsupportedEncodingException {
            if(hillMsgText.getText().isEmpty() || hillKeyText.getText().isEmpty())
            {
                hillError.setVisible(true);
            }
            else
            {
          enc  = new HillEncrypt();
            enc.Encrypt(hillMsgText.getText(), hillKeyText.getText());
                System.out.println(enc);
            HillResult.setText(enc.getencryptedText()); 
            if(hillFlag)
                {
                    PrintWriter writer = null;
                try {
                    writer = new PrintWriter("hillNew.txt", "UTF-8");
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    writer.println(HillResult.getText());
                    writer.close();
                }
            }
        
    }
    @FXML
    private void playFairEncryptButton(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException
    {
        if(playFairMsgText.getText().isEmpty() || playFairKeyText.getText().isEmpty())
            {
                playFairError.setVisible(true);
            }
            else
            {
            enc = new PlayFairEncrypt();
            enc.Encrypt(playFairMsgText.getText(), playFairKeyText.getText());
            playFairResult.setText(enc.getencryptedText()); 
            
            if(playFairFlag)
                {
                    PrintWriter writer = null;
                try {
                    writer = new PrintWriter("playFairNew.txt", "UTF-8");
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    writer.println(playFairResult.getText());
                    writer.close();
                }
            }
        
    }
    
     @FXML
    private void playFairDecryptButton(ActionEvent event) throws FileNotFoundException
    {
        if(playFairMsgText.getText().isEmpty() || playFairKeyText.getText().isEmpty())
            {
                playFairError.setVisible(true);
            }
            else
            {
            dec = new PlayFairDecrypt();
            dec.Decrypt(playFairMsgText.getText(), playFairKeyText.getText());
            playFairResult.setText(dec.getdecryptedText()); 
            
            if(playFairFlag)
                {
                    PrintWriter writer = null;
                try {
                    writer = new PrintWriter("playFairNew.txt", "UTF-8");
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    writer.println(playFairResult.getText());
                    writer.close();
                }
                
            }
        
    }
    
    
    
    @FXML
    private void railFenceEncryptButton(ActionEvent event) throws FileNotFoundException
    {
        if(railFenceMsgText.getText().isEmpty() || railFenceKeyText.getText().isEmpty())
            {
                railFenceError.setVisible(true);
            }
            else
            {
            enc = new railFenceEncrypt();
            RailFenceResult.setText(enc.Encrypt(railFenceMsgText.getText(), railFenceKeyText.getText())); 
            
            if(railFenceFlag)
                {
                    PrintWriter writer = null;
                try {
                    writer = new PrintWriter("railFenceNew.txt", "UTF-8");
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    writer.println(RailFenceResult.getText());
                    writer.close();
                }
            }
        
    }
    
    @FXML
    private void railFenceDecryptButton(ActionEvent event) throws FileNotFoundException
    {
        if(railFenceMsgText.getText().isEmpty() || railFenceKeyText.getText().isEmpty())
            {
                railFenceError.setVisible(true);
            }
            else
            {
            dec = new railFenceDecrypt();
            RailFenceResult.setText(dec.Decrypt(railFenceMsgText.getText(), railFenceKeyText.getText())); 
            
            if(railFenceFlag)
                {
                    PrintWriter writer = null;
                try {
                    writer = new PrintWriter("railFenceNew.txt", "UTF-8");
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    writer.println(RailFenceResult.getText());
                    writer.close();
                }
                
            }
        
    }
    
    @FXML
    private void messageFileChooserButtonCaeser(ActionEvent event) throws FileNotFoundException, IOException
    {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Text Files", istFile));
        File f = fc.showOpenDialog(null);
        
        if(f != null)
        {
            ceaserFlag = true;
            path = f.getAbsolutePath();
           // BufferedReader br = new BufferedReader(new FileReader(f));
                Scanner sc = new Scanner(f); 
                sc.useDelimiter("\\Z"); 
                outputFile = sc.next();
//            while ((tempRead = br.readLine()) != null)
//            {
//                System.out.println(br.readLine());
//                outputFile=br.readLine();
//            }
            caeserMsgText.setText(outputFile);
            
            System.out.println(outputFile);
        }
    }
    
     @FXML
    private void keyFileChooserButtonCaeser(ActionEvent event) throws FileNotFoundException, IOException
    {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Text Files", istFile));
        File f = fc.showOpenDialog(null);
        
        if(f != null)
        {
            ceaserFlag = true;
            path = f.getAbsolutePath();
           // BufferedReader br = new BufferedReader(new FileReader(f));
                Scanner sc = new Scanner(f); 
                sc.useDelimiter("\\Z"); 
                outputFile = sc.next();
//            while ((tempRead = br.readLine()) != null)
//            {
//                System.out.println(br.readLine());
//                outputFile=br.readLine();
//            }
            
            caeserKeyText.setText(outputFile);
            System.out.println(outputFile);
        }
        
        
            
    }

    
    @FXML
    private void fileChooserButtonVingere(ActionEvent event) throws FileNotFoundException, IOException
    {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Text Files", istFile));
        File f = fc.showOpenDialog(null);
        
        if(f != null)
        {
           vingereFlag = true;
            path = f.getAbsolutePath();
           // BufferedReader br = new BufferedReader(new FileReader(f));
                Scanner sc = new Scanner(f); 
                sc.useDelimiter("\\Z"); 
                outputFile = sc.next();
//            while ((tempRead = br.readLine()) != null)
//            {
//                System.out.println(br.readLine());
//                outputFile=br.readLine();
//            }
            
            vingereMsgText.setText(outputFile);
            System.out.println(outputFile);
        }
        
        
            
    }
      @FXML
    private void keyFileChooserButtonVingere(ActionEvent event) throws FileNotFoundException, IOException
    {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Text Files", istFile));
        File f = fc.showOpenDialog(null);
        
        if(f != null)
        {
            vingereFlag = true;
            path = f.getAbsolutePath();
           // BufferedReader br = new BufferedReader(new FileReader(f));
                Scanner sc = new Scanner(f); 
                sc.useDelimiter("\\Z"); 
                outputFile = sc.next();
//            while ((tempRead = br.readLine()) != null)
//            {
//                System.out.println(br.readLine());
//                outputFile=br.readLine();
//            }
            
            vingereKeyText.setText(outputFile);
            System.out.println(outputFile);
        }
        
        
            
    }
    
    
    @FXML
    private void fileChooserButtonPlayFair(ActionEvent event) throws FileNotFoundException, IOException
    {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Text Files", istFile));
        File f = fc.showOpenDialog(null);
        
        if(f != null)
        {
             playFairFlag = true;
            path = f.getAbsolutePath();
           // BufferedReader br = new BufferedReader(new FileReader(f));
                Scanner sc = new Scanner(f); 
                sc.useDelimiter("\\Z"); 
                outputFile = sc.next();
//            while ((tempRead = br.readLine()) != null)
//            {
//                System.out.println(br.readLine());
//                outputFile=br.readLine();
//            }
            
            playFairMsgText.setText(outputFile);
            System.out.println(outputFile);
        }
        
        
            
    }
    
     @FXML
    private void keyFileChooserButtonPlayFair(ActionEvent event) throws FileNotFoundException, IOException
    {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Text Files", istFile));
        File f = fc.showOpenDialog(null);
        
        if(f != null)
        {
            playFairFlag = true;
            path = f.getAbsolutePath();
           // BufferedReader br = new BufferedReader(new FileReader(f));
                Scanner sc = new Scanner(f); 
                sc.useDelimiter("\\Z"); 
                outputFile = sc.next();
//            while ((tempRead = br.readLine()) != null)
//            {
//                System.out.println(br.readLine());
//                outputFile=br.readLine();
//            }
            
            playFairKeyText.setText(outputFile);
            System.out.println(outputFile);
        }
    }
    
    
    
    
    @FXML
    private void fileChooserButtonRailFence(ActionEvent event) throws FileNotFoundException, IOException
    {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Text Files", istFile));
        File f = fc.showOpenDialog(null);
        
        if(f != null)
        {
             playFairFlag = true;
            path = f.getAbsolutePath();
           // BufferedReader br = new BufferedReader(new FileReader(f));
                Scanner sc = new Scanner(f); 
                sc.useDelimiter("\\Z"); 
                outputFile = sc.next();
//            while ((tempRead = br.readLine()) != null)
//            {
//                System.out.println(br.readLine());
//                outputFile=br.readLine();
//            }
            
            railFenceMsgText.setText(outputFile);
            System.out.println(outputFile);
        }
        
        
            
    }
    
     @FXML
    private void keyFileChooserButtonRailFence(ActionEvent event) throws FileNotFoundException, IOException
    {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Text Files", istFile));
        File f = fc.showOpenDialog(null);
        
        if(f != null)
        {
            playFairFlag = true;
            path = f.getAbsolutePath();
           // BufferedReader br = new BufferedReader(new FileReader(f));
                Scanner sc = new Scanner(f); 
                sc.useDelimiter("\\Z"); 
                outputFile = sc.next();
//            while ((tempRead = br.readLine()) != null)
//            {
//                System.out.println(br.readLine());
//                outputFile=br.readLine();
//            }
            
            railFenceKeyText.setText(outputFile);
            System.out.println(outputFile);
        }
    }
    
    
    
    
    @FXML
    private void fileChooserButtonHill(ActionEvent event) throws FileNotFoundException, IOException
    {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Text Files", istFile));
        File f = fc.showOpenDialog(null);
        
        if(f != null)
        {
           playFairFlag = true;
            path = f.getAbsolutePath();
           // BufferedReader br = new BufferedReader(new FileReader(f));
                Scanner sc = new Scanner(f); 
                sc.useDelimiter("\\Z"); 
                outputFile = sc.next();
//            while ((tempRead = br.readLine()) != null)
//            {
//                System.out.println(br.readLine());
//                outputFile=br.readLine();
//            }
            
            hillMsgText.setText(outputFile);
            System.out.println(outputFile);
        }
        
        
            
    }
    @FXML
     private void keyFileChooserButtonHill(ActionEvent event) throws FileNotFoundException, IOException
    {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Text Files", istFile));
        File f = fc.showOpenDialog(null);
        
        if(f != null)
        {
            playFairFlag = true;
            path = f.getAbsolutePath();
           // BufferedReader br = new BufferedReader(new FileReader(f));
                Scanner sc = new Scanner(f); 
                sc.useDelimiter("\\Z"); 
                outputFile = sc.next();
//            while ((tempRead = br.readLine()) != null)
//            {
//                System.out.println(br.readLine());
//                outputFile=br.readLine();
//            }
            
            hillKeyText.setText(outputFile);
            System.out.println(outputFile);
        }
    }
    
}
