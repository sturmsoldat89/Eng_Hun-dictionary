package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {
    addWordEng awe = new addWordEng();
    DB db = new DB();
    SearchEngWord sew = new SearchEngWord();
    CreateArraylistFromDatabase calfd = new CreateArraylistFromDatabase();

    //Search box one
    @FXML
    TextField EngSearchTbox;
    //Search box two
    @FXML
    TextField HunSearchTbox;
    //Returned hun word
    @FXML
    Label HunWordLabel;
    //Returned eng word
    @FXML
    Label EngWordLabel;
    //Search button for searching english word
    @FXML
    Button EngSearchButton;
    //Search button for searching hungarian word
    @FXML
    Button HunSearchButton;
    //Add new english word here
    @FXML
    TextField EngWordAddTbox;
    //Add new hungarian word here
    @FXML
    TextField HunWordAddTbox;
    //The word is successfully added to the database
    @FXML
    Label AddedLabel;

    @FXML
    public void addWordEng(ActionEvent e){
        String eng = EngWordAddTbox.getText();
        String hun = HunWordAddTbox.getText();
        if(eng != null && hun != null){
            awe.addUserP(eng,hun);
            System.out.println("Sikeres adatküldés!");
        }else{
            System.out.println("A mezők értéke nem lehet null!");
        }
    }
    @FXML
    public void getDatabaseArrayList(ActionEvent e){
        String eng = EngSearchTbox.getText();
        ArrayList<Word> words = calfd.getAllWord();
        for(Word w : words){
            if(w.getEng().equals(eng)){
                HunWordLabel.setText(w.getHun());
            }else{
                System.out.println("Nincs ilyen szó az adatbázisban!");
            }
        }
    }
}