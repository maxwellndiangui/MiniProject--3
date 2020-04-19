package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class ElectronicStoreView extends Pane {
   private Button addButton, removeButton, completeSale, resetButton;
   private Label label, label1, label2, label3, label4, label5, label6;
   private TextField newItemField, newItemField1, newItemField2, newItemField3, newItemField4, newItemField5;
   private ListView stocklist, intlist, revlist, salelist, cartlist, sumlist, poplist;
   String[] products, salesper, cart;
   Integer[] sales;
   Double[] revenue;
   ElectronicStore store;



    ElectronicStoreView(ElectronicStore store) {
        this.store = store;

        label = new Label("Store Summary:");
        label.relocate(70, 10);
        label.setPrefSize(150, 25);

        label4 = new Label("Most Popular Items:");
        label4.relocate(55, 135);
        label4.setPrefSize(150, 25);

        label1 = new Label("# Sales: ");
        label1.relocate(55, 35);
        label1.setPrefSize(150, 25);

        label2 = new Label("Revenue: ");
        label2.relocate(47, 65);
        label2.setPrefSize(150, 25);

        label3 = new Label("$ / Sale: ");
        label3.relocate(52, 95);
        label3.setPrefSize(150, 25);

        label5 = new Label("Store Stock:");
        label5.relocate(330, 20);
        label5.setPrefSize(150, 25);

        addButton = new Button("Add To Cart");
        addButton.relocate(300, 350);
        addButton.setPrefSize(130, 25);

        label6 = new Label("Current Cart:");
        label6.relocate(630, 20);
        label6.setPrefSize(150, 25);

        removeButton = new Button("Remove From Cart");
        removeButton.relocate(560, 350);
        removeButton.setPrefSize(100, 20);

        completeSale = new Button("Complete Sale");
        completeSale.relocate(660, 350);
        completeSale.setPrefSize(100, 20);

        resetButton = new Button("Reset Store");
        resetButton.relocate(50, 350);
        resetButton.setPrefSize(130, 25);

        products = new String[store.getCurProducts()];
        salesper = new String[store.getCurProducts()];
        sales = new Integer[store.getCurProducts()];
        revenue = new Double[store.getCurProducts()];
        cart = new String[store.getCurProducts()];

        for (int i = 0; i < store.getCurProducts(); i++) {
            products[i] = store.stock[i].toString();
        }

        for (int j = 0; j < store.getCurProducts(); j++) {
            sales[j] = store.stock[j].getSoldQuantity();
        }

        for (int k = 0; k < store.getCurProducts(); k++) {
            revenue[k] = (double) store.stock[k].getSoldQuantity();
        }

        sumlist = new ListView();
        sumlist.relocate(100, 95);
        sumlist.setPrefSize(100, 25);

        poplist = new ListView();
        poplist.relocate(30, 170);
        poplist.setPrefSize(170, 160);

        stocklist = new ListView<String>();
        stocklist.setItems(FXCollections.observableArrayList(products));
        stocklist.relocate(260, 45);
        stocklist.setPrefSize(270, 290);

        intlist = new ListView<Integer>();
        intlist.setItems(FXCollections.observableArrayList(sales));
        intlist.relocate(100, 35);
        intlist.setPrefSize(100, 25);

        revlist = new ListView<Double>();
        revlist.setItems(FXCollections.observableArrayList(revenue));
        revlist.relocate(100, 65);
        revlist.setPrefSize(100, 25);

        salelist = new ListView<String>();
        salelist.setItems(FXCollections.observableArrayList(salesper));
        salelist.relocate(100, 95);
        salelist.setPrefSize(100, 35);

        cartlist = new ListView<String>();
        cartlist.relocate(560, 40);
        cartlist.setPrefSize(200, 300);

        addButton.disableProperty().bind(stocklist.getSelectionModel().selectedItemProperty().isNull());
        removeButton.disableProperty().bind(cartlist.getSelectionModel().selectedItemProperty().isNull());
        completeSale.disableProperty().bind(cartlist.getSelectionModel().selectedItemProperty().isNull());

        getChildren().addAll(label, label1, label2, label3, label4, label5, label6, addButton, removeButton, resetButton, completeSale, intlist, stocklist, revlist, cartlist, poplist, sumlist);
    }

    public void update() {
        //stocklist.setItems(FXCollections.observableArrayList(s));
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getRemoveButton() {
        return removeButton;
    }

    public Button getCompleteSale() {
        return completeSale;
    }

    public Button getResetButton() {
        return resetButton;
    }

    public Label getLabel() {
        return label;
    }

    public Label getLabel1() {
        return label1;
    }

    public Label getLabel2() {
        return label2;
    }

    public Label getLabel3() {
        return label3;
    }

    public Label getLabel4() {
        return label4;
    }

    public Label getLabel5() {
        return label5;
    }

    public Label getLabel6() {
        return label6;
    }

    public TextField getNewItemField() {
        return newItemField;
    }

    public TextField getNewItemField1() {
        return newItemField1;
    }

    public TextField getNewItemField2() {
        return newItemField2;
    }

    public TextField getNewItemField3() {
        return newItemField3;
    }

    public TextField getNewItemField4() {
        return newItemField4;
    }

    public TextField getNewItemField5() {
        return newItemField5;
    }

    public ListView getStocklist(){
        return stocklist;
    }

    public ListView getIntlist(){
        return intlist;
    }

    public ListView getRevlist(){
        return revlist;
    }

    public ListView getCartlist() {
        return cartlist;
    }

    public ListView getSalelist() {
        return salelist;
    }

    public void setAddButton(Button addButton) {
        this.addButton = addButton;
    }

    public void setCompleteSale(Button completeSale) {
        this.completeSale = completeSale;
    }

    public void setRemoveButton(Button removeButton) {
        this.removeButton = removeButton;
    }

    public void setResetButton(Button resetButton) {
        this.resetButton = resetButton;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public void setLabel1(Label label1) {
        this.label1 = label1;
    }

    public void setLabel2(Label label2) {
        this.label2 = label2;
    }

    public void setLabel3(Label label3) {
        this.label3 = label3;
    }

    public void setLabel4(Label label4) {
        this.label4 = label4;
    }

    public void setLabel5(Label label5) {
        this.label5 = label5;
    }

    public void setLabel6(Label label6) {
        this.label6 = label6;
    }

    public void setNewItemField(TextField newItemField) {
        this.newItemField = newItemField;
    }

    public void setNewItemField1(TextField newItemField1) {
        this.newItemField1 = newItemField1;
    }

    public void setNewItemField2(TextField newItemField2) {
        this.newItemField2 = newItemField2;
    }

    public void setNewItemField3(TextField newItemField3) {
        this.newItemField3 = newItemField3;
    }

    public void setNewItemField4(TextField newItemField4) {
        this.newItemField4 = newItemField4;
    }

    public void setNewItemField5(TextField newItemField5) {
        this.newItemField5 = newItemField5;
    }

    public void setStocklist(ListView stocklist) {
        this.stocklist = stocklist;
    }

    public void setIntlist(ListView intlist) {
        this.intlist = intlist;
    }

    public void setRevlist(ListView revlist) {
        this.revlist = revlist;
    }

    public void setCartlist(ListView cartlist) {
        this.cartlist = cartlist;
    }

    public void setSalelist(ListView salelist) {
        this.salelist = salelist;
    }
}