package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class ElectronicStoreApp extends Application {
    ElectronicStore store;
    ElectronicStoreView esv;


    public void start(Stage primaryStage) {
        store = ElectronicStore.createStore();
        esv = new ElectronicStoreView(store);

        esv.getAddButton().setOnAction(event -> handleAdd());
        esv.getRemoveButton().setOnAction(event -> handleRemove());

        primaryStage.setTitle("Max' Electronic Store"); // Set title of window
        primaryStage.setScene(new Scene(esv, 800,400)); // Set size of window
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void handleAdd(){
        Object[] Products = new Object[store.stock.length];
        for (int i = 0; i < store.stock.length; i++)
        {
            Products[i] = esv.getStocklist().getItems().get(i);
            esv.getCartlist().setItems(FXCollections.observableArrayList(Products[i]));

        }
        //esv.getCartlist().setItems(FXCollections.observableArrayList(Products));
    }

    public void handleRemove(){
        System.out.println("No");
    }
            }

