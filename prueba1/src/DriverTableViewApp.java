import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DriverTableViewApp extends Application {

    public static class Driver {
        private final String name;
        private final String team;
        private final int wins;
        private final int totalPoints;
        private final int rank;

        public Driver(String name, String team, int wins, int totalPoints, int rank) {
            this.name = name;
            this.team = team;
            this.wins = wins;
            this.totalPoints = totalPoints;
            this.rank = rank;
        }

        public String getName() {
            return name;
        }

        public String getTeam() {
            return team;
        }

        public int getWins() {
            return wins;
        }

        public int getTotalPoints() {
            return totalPoints;
        }

        public int getRank() {
            return rank;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage primaryStage) {
        ComboBox<Integer> yearComboBox = new ComboBox<>();
        yearComboBox.getItems().addAll(2016, 2017, 2018, 2019, 2020);

        TableView<Driver> tableView = new TableView<>();
        TableColumn<Driver, String> nameColumn = new TableColumn<>("Driver Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Driver, String> teamColumn = new TableColumn<>("Team");
        teamColumn.setCellValueFactory(new PropertyValueFactory<>("team"));

        TableColumn<Driver, Integer> winsColumn = new TableColumn<>("Wins");
        winsColumn.setCellValueFactory(new PropertyValueFactory<>("wins"));

        TableColumn<Driver, Integer> totalPointsColumn = new TableColumn<>("Total Points");
        totalPointsColumn.setCellValueFactory(new PropertyValueFactory<>("totalPoints"));

        TableColumn<Driver, Integer> rankColumn = new TableColumn<>("Rank");
        rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));

        tableView.getColumns().addAll(nameColumn, teamColumn, winsColumn, totalPointsColumn, rankColumn);

        // Datos para 2016
        ObservableList<Driver> drivers2016 = FXCollections.observableArrayList(
                new Driver("John Smith", "Mercedes", 10, 250, 1),
                new Driver("Emma Johnson", "Mercedes", 5, 180, 2),
                new Driver("Michael Brown", "Red Bull", 3, 150, 3),
                new Driver("Sophia Davis", "Ferrari", 2, 120, 4),
                new Driver("James Wilson", "Ferrari", 1, 100, 5)
        );

        // Datos para 2017
        ObservableList<Driver> drivers2017 = FXCollections.observableArrayList(
                new Driver("Liam Walker", "Ferrari", 9, 240, 1),
                new Driver("Olivia Martinez", "Mercedes", 8, 230, 2),
                new Driver("Noah Anderson", "Red Bull", 4, 170, 3),
                new Driver("Isabella Lee", "Ferrari", 3, 130, 4),
                new Driver("Ethan Harris", "Red Bull", 2, 110, 5)
        );

        // Datos para 2018
        ObservableList<Driver> drivers2018 = FXCollections.observableArrayList(
                new Driver("Ava Thompson", "Mercedes", 11, 260, 1),
                new Driver("Lucas Taylor", "Ferrari", 6, 200, 2),
                new Driver("Mia White", "Mercedes", 4, 160, 3),
                new Driver("Benjamin Moore", "Red Bull", 3, 140, 4),
                new Driver("Charlotte King", "Red Bull", 2, 120, 5)
        );

        // Datos para 2019
        ObservableList<Driver> drivers2019 = FXCollections.observableArrayList(
                new Driver("Alexander Scott", "Mercedes", 12, 270, 1),
                new Driver("Emily Clark", "Mercedes", 7, 220, 2),
                new Driver("Daniel Lewis", "Ferrari", 5, 180, 3),
                new Driver("Matthew Hall", "Red Bull", 4, 150, 4),
                new Driver("Grace Walker", "Ferrari", 3, 130, 5)
        );

        // Datos para 2020
        ObservableList<Driver> drivers2020 = FXCollections.observableArrayList(
                new Driver("Lily Allen", "Mercedes", 13, 280, 1),
                new Driver("Jackson Young", "Mercedes", 8, 230, 2),
                new Driver("Sophie Green", "Red Bull", 6, 190, 3),
                new Driver("Henry Adams", "Racing Point", 2, 140, 4),
                new Driver("Ella Hill", "Ferrari", 1, 120, 5)
        );

        yearComboBox.setOnAction(e -> {
            int selectedYear = yearComboBox.getValue();
            switch (selectedYear) {
                case 2016:
                    tableView.setItems(drivers2016);
                    break;
                case 2017:
                    tableView.setItems(drivers2017);
                    break;
                case 2018:
                    tableView.setItems(drivers2018);
                    break;
                case 2019:
                    tableView.setItems(drivers2019);
                    break;
                case 2020:
                    tableView.setItems(drivers2020);
                    break;
            }
        });

        VBox vbox = new VBox(yearComboBox, tableView);
        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Tabla de lso resultados de los conductores");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
