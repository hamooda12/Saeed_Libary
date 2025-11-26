//import java.lang.reflect.Constructor;
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Stream;
//
//import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.Label;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Font;
//import javafx.stage.Stage;
//public class LA<E> extends Application {
//    private static ObservableList<user> UserList;
//    
//    @Override
//    public void start(Stage primaryStage) {
//        // تهيئة قائمة المستخدمين ببعض البيانات المبدئية للإختبار
//        UserList = FXCollections.observableArrayList();
//        UserList.add(new user("admin", "admin123", "admin@library.com", "Admin"));
//        UserList.add(new user("user1", "pass123", "user1@library.com", "Staff"));
//        
//        // واجهة تسجيل الدخول
//        Scene loginScene = createLoginScene(primaryStage);
//        primaryStage.setScene(loginScene);
//        primaryStage.setTitle("Library Management System");
//        primaryStage.show();
//    }
//    
//    private Scene createLoginScene(Stage primaryStage) {
//        Label usernameLabel = new Label("Username:");
//        TextField usernameField = new TextField();
//        usernameField.setPromptText("Enter username");
//
//        Label passwordLabel = new Label("Password:");
//        PasswordField passwordField = new PasswordField();
//        passwordField.setPromptText("Enter password");
//        
//        Label errorMessage = new Label();
//        errorMessage.setStyle("-fx-text-fill: red;");
//        
//        Button infoButton = new Button("Programmer Info");
//        Button loginButton = new Button("Log In");
//        Button signupButton = new Button("Sign Up");
//        
//        signupButton.setOnAction(e -> {
//            Scene signupScene = createSignupScene(primaryStage);
//            primaryStage.setScene(signupScene);
//        });
//
//        infoButton.setOnAction(e -> {
//            Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
//            infoAlert.setTitle("Programmer Info");
//            infoAlert.setHeaderText("Developer Information");
//            infoAlert.setContentText("Developed by: Saeed Awad\nVersion: 1.0\nLanguage: JavaFX");
//            infoAlert.showAndWait();
//        });
//        
//        GridPane grid = new GridPane();
//        grid.setHgap(10);
//        grid.setVgap(10);
//        grid.setAlignment(Pos.CENTER);
//        grid.setPadding(new Insets(20));
//
//        grid.add(usernameLabel, 0, 0);
//        grid.add(usernameField, 1, 0);
//        grid.add(passwordLabel, 0, 1);
//        grid.add(passwordField, 1, 1);
//        grid.add(errorMessage, 0, 2, 2, 1);
//        grid.add(loginButton, 0, 3);
//        grid.add(signupButton, 1, 3);
//
//        BorderPane root = new BorderPane();
//        root.setCenter(grid);
//        BorderPane.setAlignment(infoButton, Pos.BOTTOM_RIGHT);
//        BorderPane.setMargin(infoButton, new Insets(10));
//        root.setBottom(infoButton);
//        
//        loginButton.setOnAction(e -> {
//            String username = usernameField.getText();
//            String password = passwordField.getText();
//            
//            if(username.isEmpty() || password.isEmpty()) {
//                errorMessage.setText("Please fill your username and password!");
//                return;
//            }
//            
//            boolean loginSuccess = false;
//            for (user u : UserList) {
//                if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
//                    loginSuccess = true;
//                    break;
//                }
//            }
//            
//            if(loginSuccess) {
//                // بعد تسجيل الدخول الناجح، انتقل إلى الواجهة الرئيسية
//                Scene mainScene = createMainScene(primaryStage);
//                primaryStage.setScene(mainScene);
//            } else {
//                errorMessage.setText("Invalid username or password!");
//            }
//        });
//        
//        return new Scene(root, 600, 450);
//    }
//    
//    private Scene createMainScene(Stage primaryStage) {
//        // إنشاء واجهة رئيسية بسيطة
//        VBox mainLayout = new VBox(10);
//        mainLayout.setPadding(new Insets(20));
//        mainLayout.setAlignment(Pos.CENTER);
//        
//        Label welcomeLabel = new Label("Welcome to Library Management System");
//        welcomeLabel.setFont(new Font(20));
//        
//        Button backButton = new Button("Logout");
//        backButton.setOnAction(e -> {
//            Scene loginScene = createLoginScene(primaryStage);
//            primaryStage.setScene(loginScene);
//        });
//        
//        mainLayout.getChildren().addAll(welcomeLabel, backButton);
//        return new Scene(mainLayout, 600, 450);
//    }
//    
//    public Scene createSignupScene(Stage primaryStage) {
//        VBox root = new VBox(15);
//        root.setAlignment(Pos.CENTER);
//        root.setPadding(new Insets(20));
//        root.setStyle("-fx-background-color: linear-gradient(to bottom, #4e54c8, #8f94fb);");
//
//        Label title = new Label("Create Account");
//        title.setStyle("-fx-font-size: 26px; -fx-text-fill: white; -fx-font-weight: bold;");
//
//        TextField usernameField = new TextField();
//        usernameField.setPromptText("Username");
//        usernameField.setStyle("-fx-background-radius: 8; -fx-padding: 10;");
//
//        TextField emailField = new TextField();
//        emailField.setPromptText("Email");
//        emailField.setStyle("-fx-background-radius: 8; -fx-padding: 10;");
//
//        PasswordField passwordField = new PasswordField();
//        passwordField.setPromptText("Password");
//        passwordField.setStyle("-fx-background-radius: 8; -fx-padding: 10;");
//
//        PasswordField confirmPasswordField = new PasswordField();
//        confirmPasswordField.setPromptText("Confirm Password");
//        confirmPasswordField.setStyle("-fx-background-radius: 8; -fx-padding: 10;");
//
//        ComboBox<String> roleBox = new ComboBox<>();
//        roleBox.getItems().addAll("Admin", "Staff", "Student");
//        roleBox.setPromptText("Select Role");
//        roleBox.setStyle("-fx-background-radius: 8; -fx-padding: 8;");
//
//        Label msgLabel = new Label("");
//        msgLabel.setStyle("-fx-text-fill: yellow; -fx-font-size: 14px;");
//
//        Button signupBtn = new Button("Sign Up");
//        signupBtn.setStyle(
//            "-fx-background-color: #ffffff; " +
//            "-fx-text-fill: #4e54c8; " +
//            "-fx-font-weight: bold; " +
//            "-fx-background-radius: 8; " +
//            "-fx-padding: 10 20;"
//        );
//
//        Button backButton = new Button("Back to Login");
//        backButton.setOnAction(e -> {
//            Scene loginScene = createLoginScene(primaryStage);
//            primaryStage.setScene(loginScene);
//        });
//
//        signupBtn.setOnAction(e -> {
//            String name = usernameField.getText().trim();
//            String email = emailField.getText().trim();
//            String pass = passwordField.getText().trim();
//            String confirmPass = confirmPasswordField.getText().trim();
//            String role = roleBox.getValue();
//
//            if (name.isEmpty() || email.isEmpty() || pass.isEmpty() || confirmPass.isEmpty() || role == null) {
//                msgLabel.setText("Please fill all fields!");
//                msgLabel.setStyle("-fx-text-fill: #ffb3b3; -fx-font-size: 14px;");
//                return;
//            }
//            
//            // التحقق من وجود المستخدم
//            boolean userExists = false;
//            for (user u : UserList) {
//                if (u.getUsername().equals(name)) {
//                    userExists = true;
//                    break;
//                }
//            }
//            
//            if (userExists) {
//                msgLabel.setText("User already exists!");
//                msgLabel.setStyle("-fx-text-fill: #ffb3b3; -fx-font-size: 14px;");
//                return;
//            }
//
//            if (!pass.equals(confirmPass)) {
//                msgLabel.setText("Passwords do not match!");
//                msgLabel.setStyle("-fx-text-fill: #ffb3b3; -fx-font-size: 14px;");
//                return;
//            }
//
//            // إضافة المستخدم الجديد
//            UserList.add(new user(name, pass, email, role));
//            
//            msgLabel.setText("Account Created Successfully!");
//            msgLabel.setStyle("-fx-text-fill: #b2ffb2; -fx-font-size: 14px;");
//            
//            // مسح الحقول بعد التسجيل الناجح
//            usernameField.clear();
//            emailField.clear();
//            passwordField.clear();
//            confirmPasswordField.clear();
//            roleBox.setValue(null);
//        });
//
//        root.getChildren().addAll(
//            title,
//            usernameField,
//            emailField,
//            passwordField,
//            confirmPasswordField,
//            roleBox,
//            signupBtn,
//            backButton,
//            msgLabel
//        );
//
//        return new Scene(root, 400, 550);
//    }
//    
//    public static void main(String[] args) {
//        launch(args);
//    }
//}