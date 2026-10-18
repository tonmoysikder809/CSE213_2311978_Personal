package cse213._starhotel_2311978;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class AddNewRoomViewController
{
    @javafx.fxml.FXML
    private TableView<Room> outputTableView;
    @javafx.fxml.FXML
    private ComboBox<Integer> capacityComboBox;
    @javafx.fxml.FXML
    private TableColumn<Room, Boolean> isSeaViewTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Room, String> roomTypeTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Room, LocalDate> dorTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Room, Integer> roomIdTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> roomTypeFilterComboBox;
    @javafx.fxml.FXML
    private CheckBox isSeaViewCheckBox;
    @javafx.fxml.FXML
    private ComboBox<String> roomTypeComboBox;
    @javafx.fxml.FXML
    private TextField rateTextField;
    @javafx.fxml.FXML
    private CheckBox seaViewFilterCheckBox;
    @javafx.fxml.FXML
    private TableColumn<Room, Integer> capacityTableColumn;
    @javafx.fxml.FXML
    private ComboBox<Integer> minCapacityFilterComboBox;
    @javafx.fxml.FXML
    private TextField roomNoTextField;
    @javafx.fxml.FXML
    private DatePicker renovationDatePicker;

    private ArrayList<Room> roomList;

    @javafx.fxml.FXML
    public void initialize() {

        roomList = new ArrayList<Room>();

        capacityComboBox.getItems().addAll(1, 2, 3, 4);

        roomTypeComboBox.getItems().addAll("Single", "Double", "Deluxe", "Executive", "Suite");

        minCapacityFilterComboBox.getItems().addAll(1, 2, 3, 4);

        roomTypeFilterComboBox.getItems().addAll("Single", "Double", "Deluxe", "Executive", "Suite");

        roomIdTableColumn.setCellValueFactory(
                new PropertyValueFactory<Room, Integer>("roomNo")
        );

        capacityTableColumn.setCellValueFactory(
                new PropertyValueFactory<Room, Integer>("capacity")
        );

        roomTypeTableColumn.setCellValueFactory(
                new PropertyValueFactory<Room, String>("roomType")
        );

        isSeaViewTableColumn.setCellValueFactory(
                new PropertyValueFactory<Room, Boolean>("isSeaViewCheckBox")
        );

        dorTableColumn.setCellValueFactory(
                new PropertyValueFactory<Room, LocalDate>("renovationDatePicker")
        );
    }

    private boolean isValid(){

        if(roomNoTextField.getText().isEmpty()
        || rateTextField.getText().isEmpty()
        || capacityComboBox.getValue() == null
        || roomTypeComboBox.getValue() == null
        || renovationDatePicker.getValue() == null) {

            return false;
        }

        try {
            int roomNo = Integer.parseInt(roomNoTextField.getText());
            int rate = Integer.parseInt(rateTextField.getText());
            if (roomNo <= 0 || rate <= 0) {
                return false;
            }

            for (Room r : roomList) {
                if(r.getRoomNo() == roomNo) {
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    @javafx.fxml.FXML
    public void validateAndAddNewRoomButtonOnAction(ActionEvent actionEvent) {

        if(isValid()){

            Room r = new Room(
                    Integer.parseInt(roomNoTextField.getText()),
                    capacityComboBox.getValue(),
                    Integer.parseInt(rateTextField.getText()),
                    roomTypeComboBox.getValue(),
                    isSeaViewCheckBox.isSelected(),
                    renovationDatePicker.getValue()
            );

            roomList.add(r);
            outputTableView.getItems().setAll(roomList);

        }
        else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Invalid Input! Please check your information.");
            a.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void filterAndLoadTableButtonOnAction(ActionEvent actionEvent) {

        ArrayList<Room> filteredList = new ArrayList<Room>();

        for (Room r : roomList){
            if(minCapacityFilterComboBox.getValue() != null
            && r.getCapacity() < minCapacityFilterComboBox.getValue()){
                continue;
            }

            if(roomTypeFilterComboBox.getValue() != null
                && !r.getRoomType().equals(roomTypeFilterComboBox.getValue())){
                continue;
            }

            if(seaViewFilterCheckBox.isSelected()
            && !r.isSeaViewRoom()){
                continue;
            }

            filteredList.add(r);
        }
        outputTableView.getItems().setAll(filteredList);
    }
}