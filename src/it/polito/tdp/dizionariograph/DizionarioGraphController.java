/**
 * Sample Skeleton for 'DizionarioGraph.fxml' Controller Class
 */

package it.polito.tdp.dizionariograph;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.dizionariograph.model.Model;
import it.polito.tdp.dizionariograph.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DizionarioGraphController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtNum"
    private TextField txtNum; // Value injected by FXMLLoader

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader
    
    private Model model;

    @FXML
    void doGeneraGrafo(ActionEvent event) {
    	
    	model.createGraph(Integer.parseInt(txtNum.getText()));
    	txtRisultato.appendText("Grafo creato!\n");
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	txtRisultato.clear();
    }

    @FXML
    void doTrovaGradoMax(ActionEvent event) {
    	
    	Parola gradoMax = model.findMaxDegree();
    	txtRisultato.appendText("Grado: " + gradoMax.getDegree() + 
    							"\n Vertice: " + gradoMax.getNome() + 
    							"\n Vicini: " + model.displayNeighbours(gradoMax.getNome()));
    	
    }

    @FXML
    void doTrovaVicini(ActionEvent event) {
    	
    	String parolaDaCercare = txtParola.getText();
    	
    	if (!model.contieneParola(parolaDaCercare)) {
    		txtRisultato.appendText("Questa parola non è presente nel dizionario!\n");
    		return;
    	}
    		
    	List<Parola> vicini = model.displayNeighbours(parolaDaCercare);
    	
    	txtRisultato.appendText(vicini.toString());

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtNum != null : "fx:id=\"txtNum\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
    
}
