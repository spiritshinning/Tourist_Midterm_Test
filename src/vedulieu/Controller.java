package vedulieu;

import ShowData.TouristDescription;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends TouristDescription implements Initializable {

    @FXML
    private ImageView imageView;
    private final URL url = new URL("http://commons.wikimedia.org/wiki/Special:FilePath/Trung_tâm_thương_mại_Bà_Rịa.jpg?width=300");

    BufferedImage image = ImageIO.read(url);
    // Image image= SwingFXUtils.toFXImage(imagea, null);
    private final Image image0 = new Image(getClass().getResourceAsStream("vedulieu/quetoi.jpg"));
    private final Image image1 = new Image(getClass().getResourceAsStream("vedulieu/food.jpg"));
    private final Image image2 = new Image(getClass().getResourceAsStream("vedulieu/festival.jpg"));
    private final Image image3 = new Image(getClass().getResourceAsStream("vedulieu/city.jpg"));
    @FXML
    private ComboBox<String> comBoBox;
    @FXML
    private TableView<DuLieuDuLich> table;
    @FXML
    private TableColumn<DuLieuDuLich, Hyperlink> linkClolumn;
    @FXML
    private TableColumn<DuLieuDuLich, String> abtractClolumn;
    @FXML
    private TableColumn<DuLieuDuLich, String> thumbClolumn;

    private ObservableList<DuLieuDuLich> touristList;
    @FXML
    public Label label;
    DuLieuDuLich Data = new DuLieuDuLich();
    ObservableList<String> list = FXCollections.observableArrayList("TouristPlace", "TouristFood", "TouristFestival", "City");

    public Controller() throws IOException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comBoBox.setItems(list);
        try {
            this.imageView.setImage(this.image0);
            putData("a");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void comBoBoxChanged(ActionEvent actionEvent) throws IOException {
        label.setText(comBoBox.getValue());
        if (comBoBox.getValue() == "TouristPlace") {
            this.imageView.setImage(this.image0);

            putData(0);
        }
        if (comBoBox.getValue() == "TouristFood") {
            this.imageView.setImage(this.image1);
            putData(1);
        }
        if (comBoBox.getValue() == "TouristFestival") {
            this.imageView.setImage(this.image2);
            putData(2);
        }
        if (comBoBox.getValue() == "City") {
            this.imageView.setImage(this.image3);
            putData(3);
        }
    }

    private void putData(int qu) throws IOException {
        touristList = FXCollections.observableArrayList();
        for (int i = 0; i < Data.getDem(); i++) {
            touristList.add(new DuLieuDuLich(i, qu));
        }
        linkClolumn.setCellValueFactory(new PropertyValueFactory<DuLieuDuLich, Hyperlink>("linkDulieu"));
        abtractClolumn.setCellValueFactory(new PropertyValueFactory<DuLieuDuLich, String>("abtractDulieu"));
        thumbClolumn.setCellValueFactory(new PropertyValueFactory<DuLieuDuLich, String>("thumnailDulieu"));
        table.setItems(touristList);
    }

    private void putData(String a) throws IOException {
        touristList = FXCollections.observableArrayList();
        touristList.add(new DuLieuDuLich("Welcome", "This is a javaFX function", "To see information"));
        touristList.add(new DuLieuDuLich("Choose", "The ComboBox to see more", "Thank You"));

        linkClolumn.setCellValueFactory(new PropertyValueFactory<DuLieuDuLich, Hyperlink>("linkDulieu"));
        abtractClolumn.setCellValueFactory(new PropertyValueFactory<DuLieuDuLich, String>("abtractDulieu"));
        thumbClolumn.setCellValueFactory(new PropertyValueFactory<DuLieuDuLich, String>("thumnailDulieu"));
        table.setItems(touristList);
    }

}

