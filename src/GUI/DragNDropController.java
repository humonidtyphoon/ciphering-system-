/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

/**
 * FXML Controller class
 *
 * @author voider
 */
public class DragNDropController implements Initializable {

   String path = new String();
    String tempRead= "";
    String outputFile= "";
    List<String> istFile;
    
    @FXML
    private Label lbl;
     @FXML
   private void messageFileDragOver(DragEvent event)
   {
       if(event.getDragboard().hasFiles())
       event.acceptTransferModes(TransferMode.ANY);
       
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
            }
            br.close();
            lbl.setText(outputFile);
            
            
        }
        
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        istFile = new ArrayList<>();  
        istFile.add("*.txt");
    }    

}
