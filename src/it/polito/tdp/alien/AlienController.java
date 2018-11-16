/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {

	private Model model;
	
	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtWord"
    private TextField txtWord; // Value injected by FXMLLoader

    @FXML // fx:id="btnTranslate"
    private Button btnTranslate; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doReset(ActionEvent event) {

    	txtResult.clear();
    	model.reset();
    	
    }

    @FXML
    void doTranslate(ActionEvent event) {

    	   	
    	if (txtWord.getText().length()==0)
    	{
    		txtResult.setText("ERRORE: Inserire una parola");
    		return;
    	}
    	
    	if (!txtWord.getText().matches("[a-zA-Z ]+"))
    	{
    		txtResult.setText("ERRORE: caratteri non ammessi");
    		return;
    	}
    		
    	String input = txtWord.getText().toLowerCase();
    	
    	if(input.contains(" "))
    	{
    		String alien = input.substring(0, input.indexOf(" "));
    		
    		String word = input.substring(input.indexOf(" ")+1);
    		
    		int add = model.addWord(alien, word);
    		if (add == 1)
    			txtResult.appendText(String.format("Traduzione aggiunta: <%s> <%s>\n", alien, word));
    		else
    			txtResult.appendText(String.format("Aggiunta la %da traduzione per <%s>: <%s>\n", add, alien, word));
     	}
    	else
    	{
    		ArrayList<String> res = model.searchWord(input) ;
    		if (res != null)
    		{
    			txtResult.appendText(String.format("Traduzione:\n--> %s = %s\n", input, res));
    		}
    		else
    			txtResult.appendText(String.format("Traduzione di <%s> non trovata.", input));
    		    		
       	}
    	
    	txtWord.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

    }

	public void setModel(Model m) {
		
		this.model = m;
		
	}
}
