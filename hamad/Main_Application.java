package hamad;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.effect.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Main_Application extends Application {
    
    private Stage primaryStage;
    private Scene loginScene, signupScene, programmerScene;
    
    // Modern color palette with gradients
    private final LinearGradient PRIMARY_GRADIENT = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
        new Stop(0, Color.web("#667eea")),
        new Stop(1, Color.web("#764ba2")));
    
    private final LinearGradient SECONDARY_GRADIENT = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
        new Stop(0, Color.web("#f093fb")),
        new Stop(1, Color.web("#f5576c")));
    
    private final LinearGradient SUCCESS_GRADIENT = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
        new Stop(0, Color.web("#4facfe")),
        new Stop(1, Color.web("#00f2fe")));
    
    private final LinearGradient DARK_GRADIENT = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
        new Stop(0, Color.web("#2c3e50")),
        new Stop(1, Color.web("#3498db")));
    
    private final RadialGradient GLOW_GRADIENT = new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE,
        new Stop(0, Color.web("#ffffff")),
        new Stop(1, Color.web("#f8f9fa")));

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        
        // Create scenes
        loginScene = createLoginScene();
        signupScene = createSignupScene();
        programmerScene = createProgrammerScene();
        
        primaryStage.setTitle("🏛️ BU Digital Library • Next Generation Learning Hub");
        primaryStage.setScene(loginScene);
        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(800);
        primaryStage.show();
    }
    
    private Scene createLoginScene() {
        // Main container with animated gradient background
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: linear-gradient(135deg, #667eea 0%, #764ba2 100%);");
        
        // Animated floating elements
        Pane floatingElements = createFloatingAnimation();
        root.getChildren().add(floatingElements);
        
        // Glass morphism main container
        VBox glassContainer = new VBox(40);
        glassContainer.setAlignment(Pos.CENTER);
        glassContainer.setPadding(new Insets(60, 80, 60, 80));
        glassContainer.setMaxWidth(500);
        glassContainer.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.12); " +
            "-fx-background-radius: 30; " +
            "-fx-border-color: rgba(255, 255, 255, 0.18); " +
            "-fx-border-width: 1.5; " +
            "-fx-border-radius: 30; " +
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.25), 35, 0, 0, 15);"
        );
        
        // Header section with animated icon
        VBox headerBox = new VBox(20);
        headerBox.setAlignment(Pos.CENTER);
        
        // Animated book icon container
        StackPane iconContainer = new StackPane();
        iconContainer.setPrefSize(120, 120);
        iconContainer.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.15); " +
            "-fx-background-radius: 30; " +
            "-fx-border-color: rgba(255, 255, 255, 0.25); " +
            "-fx-border-width: 2; " +
            "-fx-border-radius: 30;"
        );
        
        Label iconLabel = new Label("📚");
        iconLabel.setStyle("-fx-font-size: 48px;");
        iconLabel.setEffect(new DropShadow(15, Color.WHITE));
        
        // Pulsing animation for icon
        ScaleTransition pulse = new ScaleTransition(Duration.seconds(2), iconContainer);
        pulse.setFromX(1);
        pulse.setFromY(1);
        pulse.setToX(1.08);
        pulse.setToY(1.08);
        pulse.setCycleCount(Animation.INDEFINITE);
        pulse.setAutoReverse(true);
        pulse.play();
        
        iconContainer.getChildren().add(iconLabel);
        
        Label mainTitle = new Label("BU DIGITAL LIBRARY");
        mainTitle.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: white; " +
                          "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 12, 0, 2, 2);");
        
        Label subTitle = new Label("Where Knowledge Meets Innovation");
        subTitle.setStyle("-fx-font-size: 16px; -fx-text-fill: rgba(255,255,255,0.85); -fx-font-weight: 500;");
        
        headerBox.getChildren().addAll(iconContainer, mainTitle, subTitle);
        
        // Login form section
        VBox formContainer = new VBox(30);
        formContainer.setAlignment(Pos.CENTER);
        
        Label formTitle = new Label("Welcome Back, Scholar");
        formTitle.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: white;");
        
        VBox fieldsContainer = new VBox(25);
        fieldsContainer.setAlignment(Pos.CENTER);
        
        // Modern input fields with icons
        StackPane userField = createModernInputField("👤", "Username or Email", false);
        StackPane passField = createModernInputField("🔒", "Password", true);
        
        // Options container
        HBox optionsContainer = new HBox();
        optionsContainer.setAlignment(Pos.CENTER_LEFT);
        optionsContainer.setSpacing(25);
        
        CheckBox rememberMe = createModernCheckbox("Remember my access");
        Hyperlink forgotPassword = createModernHyperlink("Forgot your password?");
        
        optionsContainer.getChildren().addAll(rememberMe, forgotPassword);
        
        // Login button with stunning effect
        StackPane loginBtn = createModernButton("🚀 ACCESS DIGITAL COLLECTION", SECONDARY_GRADIENT, 55);
        
        // Separator with elegant design
        HBox separator = createModernSeparator("New to our community?");
        
        // Action buttons
        HBox actionButtons = new HBox(20);
        actionButtons.setAlignment(Pos.CENTER);
        
        StackPane signupBtn = createModernButton("🌟 BECOME A MEMBER", SUCCESS_GRADIENT, 50);
        signupBtn.setOnMouseClicked(e -> primaryStage.setScene(signupScene));
        
        StackPane infoBtn = createModernOutlineButton("💻 MEET THE VISIONARY");
        infoBtn.setOnMouseClicked(e -> primaryStage.setScene(programmerScene));
        
        actionButtons.getChildren().addAll(signupBtn, infoBtn);
        
        // Build form
        fieldsContainer.getChildren().addAll(userField, passField, optionsContainer, loginBtn);
        formContainer.getChildren().addAll(formTitle, fieldsContainer, separator, actionButtons);
        
        // Assemble glass container
        glassContainer.getChildren().addAll(headerBox, formContainer);
        
        // Add everything to root
        root.getChildren().add(glassContainer);
        
        // Button actions
        loginBtn.setOnMouseClicked(e -> {
            showModernAlert("🎉 Access Granted", 
                "Welcome back to BU Digital Library!\n\n" +
                "📚 Full access to digital collections\n" +
                "🔍 Advanced research tools activated\n" +
                "💫 Personalized learning experience ready");
        });
        
        forgotPassword.setOnMouseClicked(e -> {
            showModernAlert("🔐 Account Recovery", 
                "Digital Support Team Contact:\n\n" +
                "📧 library-support@bethlehem.edu\n" +
                "📞 +970 2 274 1241\n" +
                "🕒 Available 24/7");
        });
        
        return new Scene(root, 1200, 800);
    }
    
    private Scene createSignupScene() {
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%);");
        
        // Animated background
        Pane floatingElements = createFloatingAnimation();
        root.getChildren().add(floatingElements);
        
        // Main scrollable content
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent; " +
                           "-fx-border-color: transparent; -fx-padding: 0;");
        
        VBox mainContainer = new VBox(30);
        mainContainer.setAlignment(Pos.TOP_CENTER);
        mainContainer.setPadding(new Insets(50));
        
        // Glass header
        VBox headerBox = new VBox(15);
        headerBox.setAlignment(Pos.CENTER);
        headerBox.setPadding(new Insets(30, 50, 30, 50));
        headerBox.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.15); " +
            "-fx-background-radius: 25; " +
            "-fx-border-color: rgba(255, 255, 255, 0.2); " +
            "-fx-border-width: 1.5; " +
            "-fx-border-radius: 25; " +
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 25, 0, 0, 10);"
        );
        headerBox.setMaxWidth(700);
        
        Label mainTitle = new Label("JOIN OUR ACADEMIC COMMUNITY");
        mainTitle.setStyle("-fx-font-size: 38px; -fx-font-weight: bold; -fx-text-fill: white;");
        
        Label subTitle = new Label("Begin your journey of knowledge and discovery");
        subTitle.setStyle("-fx-font-size: 18px; -fx-text-fill: rgba(255,255,255,0.9);");
        
        headerBox.getChildren().addAll(mainTitle, subTitle);
        
        // Glass form container
        VBox formContainer = new VBox(30);
        formContainer.setPadding(new Insets(50));
        formContainer.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.12); " +
            "-fx-background-radius: 30; " +
            "-fx-border-color: rgba(255, 255, 255, 0.18); " +
            "-fx-border-width: 1.5; " +
            "-fx-border-radius: 30; " +
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 30, 0, 0, 15);"
        );
        formContainer.setMaxWidth(800);
        
        // Form grid with modern layout
        GridPane formGrid = new GridPane();
        formGrid.setHgap(30);
        formGrid.setVgap(25);
        formGrid.setPadding(new Insets(20, 0, 0, 0));
        
        // Create form fields
        StackPane userField = createModernInputField("👤", "Choose your username", false);
        StackPane emailField = createModernInputField("📧", "University email address", false);
        StackPane passField = createModernInputField("🔑", "Create secure password", true);
        StackPane confirmPassField = createModernInputField("✅", "Confirm your password", true);
        
        // Role selection
        VBox roleBox = new VBox(10);
        Label roleLabel = new Label("🎓 ACADEMIC ROLE");
        roleLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: white;");
        
        ComboBox<String> roleCombo = new ComboBox<>(
            FXCollections.observableArrayList(
                "🎒 Undergraduate Student", 
                "🎓 Graduate Student", 
                "👨‍🏫 Faculty Member", 
                "🔬 Research Scholar", 
                "⚡ Administrator"
            )
        );
        roleCombo.setValue("🎒 Undergraduate Student");
        roleCombo.setStyle(
            "-fx-background-color: rgba(255,255,255,0.1); " +
            "-fx-background-radius: 15; " +
            "-fx-border-color: rgba(255,255,255,0.3); " +
            "-fx-border-radius: 15; " +
            "-fx-text-fill: white; " +
            "-fx-padding: 18; " +
            "-fx-font-size: 14px; " +
            "-fx-cursor: hand;"
        );
        roleCombo.setPrefHeight(55);
        roleCombo.setMaxWidth(Double.MAX_VALUE);
        
        roleBox.getChildren().addAll(roleLabel, roleCombo);
        
        // Agreement
        CheckBox agreeCheckbox = createModernCheckbox("I agree to the Digital Library Terms of Service and Privacy Policy");
        
        // Layout form grid
        formGrid.add(userField, 0, 0);
        formGrid.add(emailField, 1, 0);
        formGrid.add(passField, 0, 1);
        formGrid.add(confirmPassField, 1, 1);
        formGrid.add(roleBox, 0, 2, 2, 1);
        formGrid.add(agreeCheckbox, 0, 3, 2, 1);
        
        // Action buttons
        HBox buttonContainer = new HBox(25);
        buttonContainer.setAlignment(Pos.CENTER);
        
        StackPane signupBtn = createModernButton("🚀 CREATE MY ACCOUNT", SUCCESS_GRADIENT, 55);
        signupBtn.setPrefWidth(300);
        
        StackPane backBtn = createModernOutlineButton("↶ BACK TO LOGIN");
        backBtn.setPrefWidth(200);
        backBtn.setOnMouseClicked(e -> primaryStage.setScene(loginScene));
        
        buttonContainer.getChildren().addAll(signupBtn, backBtn);
        
        // Add all to form
        formContainer.getChildren().addAll(formGrid, buttonContainer);
        
        // Build main container
        mainContainer.getChildren().addAll(headerBox, formContainer);
        
        scrollPane.setContent(mainContainer);
        root.getChildren().add(scrollPane);
        
        // Sign up logic
        signupBtn.setOnMouseClicked(e -> {
            showModernAlert("🎉 Welcome to BU Library!", 
                "Your digital library account has been created!\n\n" +
                "✨ Full access to 100,000+ digital resources\n" +
                "🔍 Advanced research tools unlocked\n" +
                "📚 Personalized reading recommendations\n" +
                "💫 Join our community of 10,000+ scholars\n\n" +
                "Start your journey today!");
            primaryStage.setScene(loginScene);
        });
        
        return new Scene(root, 1200, 800);
    }
    
    private Scene createProgrammerScene() {
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: linear-gradient(135deg, #2c3e50 0%, #3498db 100%);");
        
        // Animated background
        Pane floatingElements = createFloatingAnimation();
        root.getChildren().add(floatingElements);
        
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        
        VBox mainContainer = new VBox(40);
        mainContainer.setAlignment(Pos.TOP_CENTER);
        mainContainer.setPadding(new Insets(50));
        
        // Header
        VBox headerBox = new VBox(15);
        headerBox.setAlignment(Pos.CENTER);
        headerBox.setPadding(new Insets(40, 60, 40, 60));
        headerBox.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.15); " +
            "-fx-background-radius: 25; " +
            "-fx-border-color: rgba(255, 255, 255, 0.2); " +
            "-fx-border-width: 1.5; " +
            "-fx-border-radius: 25; " +
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 25, 0, 0, 10);"
        );
        headerBox.setMaxWidth(900);
        
        Label mainTitle = new Label("THE VISIONARY BEHIND THE DIGITAL EXPERIENCE");
        mainTitle.setStyle("-fx-font-size: 42px; -fx-font-weight: bold; -fx-text-fill: white;");
        
        Label subTitle = new Label("Crafting the future of digital learning and knowledge access");
        subTitle.setStyle("-fx-font-size: 20px; -fx-text-fill: rgba(255,255,255,0.9);");
        
        headerBox.getChildren().addAll(mainTitle, subTitle);
        
        // Profile card
        VBox profileCard = createGlassCard();
        
        // Profile header with animated avatar
        HBox profileHeader = new HBox(40);
        profileHeader.setAlignment(Pos.CENTER_LEFT);
        
        // Animated profile avatar
        StackPane profileAvatar = new StackPane();
        profileAvatar.setPrefSize(180, 180);
        profileAvatar.setStyle(
            "-fx-background-color: linear-gradient(135deg, #667eea 0%, #764ba2 100%); " +
            "-fx-background-radius: 90; " +
            "-fx-border-color: rgba(255,255,255,0.3); " +
            "-fx-border-radius: 90; " +
            "-fx-border-width: 4; " +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.3), 20, 0, 0, 10);"
        );
        
        // Pulsing animation for avatar
        ScaleTransition avatarPulse = new ScaleTransition(Duration.seconds(3), profileAvatar);
        avatarPulse.setFromX(1);
        avatarPulse.setFromY(1);
        avatarPulse.setToX(1.05);
        avatarPulse.setToY(1.05);
        avatarPulse.setCycleCount(Animation.INDEFINITE);
        avatarPulse.setAutoReverse(true);
        avatarPulse.play();
        
        Label avatarText = new Label("HT");
        avatarText.setStyle("-fx-font-size: 52px; -fx-font-weight: bold; -fx-text-fill: white;");
        profileAvatar.getChildren().add(avatarText);
        
        // Profile info
        VBox profileInfo = new VBox(15);
        
        Label nameLabel = new Label("Hamad Tarawa");
        nameLabel.setStyle("-fx-font-size: 42px; -fx-font-weight: bold; -fx-text-fill: white;");
        
        Label titleLabel = new Label("💻 Full-Stack Architect • 🎯 Software Engineering Visionary");
        titleLabel.setStyle("-fx-font-size: 22px; -fx-text-fill: rgba(255,255,255,0.9); -fx-font-weight: 500;");
        
        Label universityLabel = new Label("🏛️ Bethlehem University • B.Sc. Software Engineering '2024");
        universityLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: rgba(255,255,255,0.8);");
        
        profileInfo.getChildren().addAll(nameLabel, titleLabel, universityLabel);
        profileHeader.getChildren().addAll(profileAvatar, profileInfo);
        
        // Bio section
        VBox bioSection = new VBox(20);
        Label bioTitle = new Label("🌟 DIGITAL VISIONARY");
        bioTitle.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");
        
        TextArea bioText = new TextArea();
        bioText.setEditable(false);
        bioText.setWrapText(true);
        bioText.setPrefHeight(140);
        bioText.setStyle(
            "-fx-background-color: rgba(255,255,255,0.08); " +
            "-fx-background-radius: 20; " +
            "-fx-border-color: rgba(255,255,255,0.15); " +
            "-fx-border-radius: 20; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 16px; " +
            "-fx-padding: 25; " +
            "-fx-control-inner-background: transparent;"
        );
        bioText.setText("A passionate software engineering scholar dedicated to transforming digital education through innovative technology solutions. With expertise in full-stack development, cloud architecture, and user experience design, I create systems that bridge the gap between technology and human learning. Currently advancing the future of digital libraries while pursuing excellence in software engineering principles and modern development practices.");
        
        bioSection.getChildren().addAll(bioTitle, bioText);
        
        // Skills section with modern grid
        VBox skillsCard = createGlassCard();
        Label skillsTitle = new Label("🛠️ TECHNICAL MASTERY");
        skillsTitle.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");
        
        GridPane skillsGrid = new GridPane();
        skillsGrid.setHgap(40);
        skillsGrid.setVgap(25);
        skillsGrid.setPadding(new Insets(25, 0, 0, 0));
        
        String[] skillCategories = {
            "💎 Frontend Architecture", "⚡ Backend Systems", "🗄️ Data Engineering", "☁️ DevOps & Cloud"
        };
        
        String[][] skills = {
            {"React.js & Vue.js", "TypeScript Ecosystem", "Modern CSS/SASS", "JavaFX & Desktop", "Responsive Design"},
            {"Java/Spring Boot", "Python/Django", "Node.js/Express", "REST/GraphQL APIs", "Microservices"},
            {"PostgreSQL", "MongoDB", "Redis Cache", "Data Modeling", "SQL Optimization"},
            {"Docker & Kubernetes", "AWS/Azure Cloud", "CI/CD Pipelines", "Linux Systems", "System Architecture"}
        };
        
        for (int i = 0; i < skillCategories.length; i++) {
            VBox skillColumn = new VBox(15);
            
            Label categoryLabel = new Label(skillCategories[i]);
            categoryLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #00f2fe;");
            
            for (String skill : skills[i]) {
                HBox skillItem = new HBox(10);
                skillItem.setAlignment(Pos.CENTER_LEFT);
                
                // Animated dot
                Circle dot = new Circle(4);
                dot.setFill(Color.web("#4facfe"));
                
                Label skillLabel = new Label(skill);
                skillLabel.setStyle("-fx-text-fill: rgba(255,255,255,0.9); -fx-font-size: 15px;");
                
                skillItem.getChildren().addAll(dot, skillLabel);
                skillColumn.getChildren().add(skillItem);
            }
            
            skillsGrid.add(skillColumn, i % 2, i / 2);
        }
        
        skillsCard.getChildren().addAll(skillsTitle, skillsGrid);
        
        // Features section
        VBox featuresCard = createGlassCard();
        Label featuresTitle = new Label("🚀 NEXT-GEN LIBRARY INNOVATIONS");
        featuresTitle.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");
        
        TextArea featuresText = new TextArea();
        featuresText.setEditable(false);
        featuresText.setWrapText(true);
        featuresText.setPrefHeight(200);
        featuresText.setStyle(
            "-fx-background-color: rgba(255,255,255,0.08); " +
            "-fx-background-radius: 20; " +
            "-fx-border-color: rgba(255,255,255,0.15); " +
            "-fx-border-radius: 20; " +
            "-fx-text-fill: white; " +
            "-fx-font-size: 15px; " +
            "-fx-padding: 25; " +
            "-fx-control-inner-background: transparent;"
        );
        featuresText.setText("🤖 AI-Powered Research Assistant\n" +
                            "🔮 Smart Book Recommendations\n" +
                            "📱 Progressive Web App Technology\n" +
                            "⚡ Real-time Collaboration Tools\n" +
                            "🔐 Blockchain Digital Rights Management\n" +
                            "☁️ Cloud-Native Microservices\n" +
                            "📊 Advanced Analytics Dashboard\n" +
                            "🔍 Semantic Search Engine\n" +
                            "💫 Personalized Learning Paths\n" +
                            "🎯 Adaptive User Interfaces\n" +
                            "🔔 Smart Notification System\n" +
                            "🛡️ Enterprise-grade Security\n" +
                            "🌐 Multi-platform Accessibility\n" +
                            "📚 Digital Preservation System");
        
        featuresCard.getChildren().addAll(featuresTitle, featuresText);
        
        // Contact section
        VBox contactCard = createGlassCard();
        Label contactTitle = new Label("📡 CONNECT & COLLABORATE");
        contactTitle.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: white;");
        
        GridPane contactGrid = new GridPane();
        contactGrid.setHgap(35);
        contactGrid.setVgap(25);
        contactGrid.setPadding(new Insets(25, 0, 0, 0));
        
        String[][] contacts = {
            {"💼", "Professional Profile", "linkedin.com/in/hamad-tarawa"},
            {"🐙", "Code Repository", "github.com/hamad-tarawa"},
            {"📧", "Academic Email", "h.tarawa@student.bethlehem.edu"},
            {"🌐", "Digital Portfolio", "hamad.dev.bu.edu"},
            {"🏢", "Academic Department", "Software Engineering"},
            {"📍", "University Campus", "Bethlehem University"}
        };
        
        for (int i = 0; i < contacts.length; i++) {
            HBox contactItem = new HBox(20);
            contactItem.setAlignment(Pos.CENTER_LEFT);
            
            Label iconLabel = new Label(contacts[i][0]);
            iconLabel.setStyle("-fx-font-size: 28px;");
            
            VBox contactInfo = new VBox(5);
            Label typeLabel = new Label(contacts[i][1]);
            typeLabel.setStyle("-fx-font-size: 13px; -fx-text-fill: rgba(255,255,255,0.7);");
            
            Label valueLabel = new Label(contacts[i][2]);
            valueLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: 600; -fx-text-fill: white;");
            
            contactInfo.getChildren().addAll(typeLabel, valueLabel);
            contactItem.getChildren().addAll(iconLabel, contactInfo);
            
            contactGrid.add(contactItem, i % 3, i / 3);
        }
        
        contactCard.getChildren().addAll(contactTitle, contactGrid);
        
        // Back button
        StackPane backBtn = createModernButton("🏠 RETURN TO DIGITAL LIBRARY", SECONDARY_GRADIENT, 55);
        backBtn.setMaxWidth(400);
        backBtn.setOnMouseClicked(e -> primaryStage.setScene(loginScene));
        
        // Add all to profile card
        profileCard.getChildren().addAll(profileHeader, bioSection, skillsCard, featuresCard, contactCard, backBtn);
        
        // Build main container
        mainContainer.getChildren().addAll(headerBox, profileCard);
        
        scrollPane.setContent(mainContainer);
        root.getChildren().add(scrollPane);
        
        return new Scene(root, 1200, 800);
    }
    
    // Helper methods for modern UI components
    private StackPane createModernInputField(String emoji, String prompt, boolean isPassword) {
        StackPane container = new StackPane();
        container.setMaxWidth(Double.MAX_VALUE);
        container.setPrefHeight(60);
        
        // Background shape
        Rectangle bg = new Rectangle(400, 60);
        bg.setArcWidth(20);
        bg.setArcHeight(20);
        bg.setFill(Color.rgb(255, 255, 255, 0.1));
        bg.setStroke(Color.rgb(255, 255, 255, 0.2));
        bg.setStrokeWidth(1.5);
        
        // Input field
        TextInputField field = isPassword ? new PasswordField() : new TextField();
        field.setPromptText(prompt);
        field.setStyle(
            "-fx-background-color: transparent; " +
            "-fx-border-color: transparent; " +
            "-fx-text-fill: white; " +
            "-fx-prompt-text-fill: rgba(255,255,255,0.5); " +
            "-fx-font-size: 15px; " +
            "-fx-padding: 0 20 0 60;"
        );
        field.setPrefHeight(60);
        
        // Emoji icon
        Label icon = new Label(emoji);
        icon.setStyle("-fx-text-fill: rgba(255,255,255,0.7); -fx-font-size: 18px;");
        StackPane.setAlignment(icon, Pos.CENTER_LEFT);
        StackPane.setMargin(icon, new Insets(0, 0, 0, 25));
        
        container.getChildren().addAll(bg, field, icon);
        
        // Hover effects
        container.setOnMouseEntered(e -> {
            bg.setStroke(Color.rgb(255, 255, 255, 0.4));
        });
        
        container.setOnMouseExited(e -> {
            bg.setStroke(Color.rgb(255, 255, 255, 0.2));
        });
        
        return container;
    }
    
    private StackPane createModernButton(String text, LinearGradient gradient, double height) {
        StackPane container = new StackPane();
        container.setPrefHeight(height);
        container.setMaxWidth(Double.MAX_VALUE);
        container.setCursor(Cursor.HAND);
        
        // Background with gradient
        Rectangle bg = new Rectangle(400, height);
        bg.setArcWidth(20);
        bg.setArcHeight(20);
        bg.setFill(gradient);
        bg.setEffect(new DropShadow(15, Color.gray(0, 0.4)));
        
        // Button text
        Label buttonText = new Label(text);
        buttonText.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 16px;");
        
        container.getChildren().addAll(bg, buttonText);
        
        // Hover animation
        container.setOnMouseEntered(e -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(200), container);
            st.setToX(1.03);
            st.setToY(1.03);
            st.play();
            
            bg.setEffect(new DropShadow(25, Color.gray(0, 0.6)));
        });
        
        container.setOnMouseExited(e -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(200), container);
            st.setToX(1.0);
            st.setToY(1.0);
            st.play();
            
            bg.setEffect(new DropShadow(15, Color.gray(0, 0.4)));
        });
        
        return container;
    }
    
    private StackPane createModernOutlineButton(String text) {
        StackPane container = new StackPane();
        container.setPrefHeight(50);
        container.setMaxWidth(Double.MAX_VALUE);
        container.setCursor(Cursor.HAND);
        
        // Background
        Rectangle bg = new Rectangle(400, 50);
        bg.setArcWidth(15);
        bg.setArcHeight(15);
        bg.setFill(Color.TRANSPARENT);
        bg.setStroke(Color.rgb(255, 255, 255, 0.5));
        bg.setStrokeWidth(2);
        
        // Button text
        Label buttonText = new Label(text);
        buttonText.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14px;");
        
        container.getChildren().addAll(bg, buttonText);
        
        // Hover effects
        container.setOnMouseEntered(e -> {
            bg.setFill(Color.rgb(255, 255, 255, 0.1));
            bg.setStroke(Color.rgb(255, 255, 255, 0.8));
        });
        
        container.setOnMouseExited(e -> {
            bg.setFill(Color.TRANSPARENT);
            bg.setStroke(Color.rgb(255, 255, 255, 0.5));
        });
        
        return container;
    }
    
    private CheckBox createModernCheckbox(String text) {
        CheckBox checkbox = new CheckBox(text);
        checkbox.setStyle(
            "-fx-text-fill: white; " +
            "-fx-font-size: 14px; " +
            "-fx-cursor: hand; " +
            "-fx-font-weight: 500;"
        );
        return checkbox;
    }
    
    private Hyperlink createModernHyperlink(String text) {
        Hyperlink link = new Hyperlink(text);
        link.setStyle(
            "-fx-text-fill: rgba(255,255,255,0.9); " +
            "-fx-font-size: 14px; " +
            "-fx-border-color: transparent; " +
            "-fx-underline: true; " +
            "-fx-cursor: hand; " +
            "-fx-font-weight: 500;"
        );
        return link;
    }
    
    private HBox createModernSeparator(String text) {
        HBox separator = new HBox(15);
        separator.setAlignment(Pos.CENTER);
        separator.setPrefHeight(30);
        
        Line line1 = new Line(0, 0, 80, 0);
        line1.setStroke(Color.rgb(255, 255, 255, 0.3));
        line1.setStrokeWidth(1.5);
        
        Line line2 = new Line(0, 0, 80, 0);
        line2.setStroke(Color.rgb(255, 255, 255, 0.3));
        line2.setStrokeWidth(1.5);
        
        Label separatorText = new Label(text);
        separatorText.setStyle("-fx-text-fill: rgba(255,255,255,0.7); -fx-font-size: 14px; -fx-font-weight: 500;");
        
        separator.getChildren().addAll(line1, separatorText, line2);
        return separator;
    }
    
    private VBox createGlassCard() {
        VBox card = new VBox(25);
        card.setPadding(new Insets(40));
        card.setStyle(
            "-fx-background-color: rgba(255, 255, 255, 0.1); " +
            "-fx-background-radius: 25; " +
            "-fx-border-color: rgba(255, 255, 255, 0.15); " +
            "-fx-border-width: 1.5; " +
            "-fx-border-radius: 25; " +
            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.2), 25, 0, 0, 10);"
        );
        card.setMaxWidth(900);
        return card;
    }
    
    private Pane createFloatingAnimation() {
        Pane floatingPane = new Pane();
        floatingPane.setStyle("-fx-background-color: transparent;");
        
        // Create multiple floating shapes
        for (int i = 0; i < 12; i++) {
            Circle shape = new Circle(20 + Math.random() * 60);
            shape.setCenterX(Math.random() * 1200);
            shape.setCenterY(Math.random() * 800);
            shape.setFill(Color.rgb(255, 255, 255, 0.03));
            shape.setEffect(new BoxBlur(25, 25, 3));
            
            // Floating animation
            TranslateTransition tt = new TranslateTransition(Duration.seconds(15 + Math.random() * 20), shape);
            tt.setFromX(Math.random() * 200 - 100);
            tt.setFromY(Math.random() * 200 - 100);
            tt.setToX(Math.random() * 200 - 100);
            tt.setToY(Math.random() * 200 - 100);
            tt.setCycleCount(Animation.INDEFINITE);
            tt.setAutoReverse(true);
            tt.play();
            
            floatingPane.getChildren().add(shape);
        }
        
        return floatingPane;
    }
    
    private void showModernAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle(
            "-fx-background-color: rgba(45, 45, 45, 0.95); " +
            "-fx-border-color: rgba(255,255,255,0.2); " +
            "-fx-border-width: 1.5; " +
            "-fx-border-radius: 20; " +
            "-fx-background-radius: 20; " +
            "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.4), 30, 0, 0, 10);"
        );
        
        alert.showAndWait();
    }
    
    private boolean isValidEmail(String email) {
        return email.contains("@") && (email.contains("bethlehem.edu") || email.contains("student.bethlehem.edu"));
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}