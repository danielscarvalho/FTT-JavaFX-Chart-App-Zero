package br.edu.cefsa.ftt.ec.chart.app;

//TODO: Projeto N1

//TODO: Esta � a estratura b�sica do projeto
//TODO: Abrir um arquivo e ler os dados
//TODO: Mudar parametros do gr�fico pegando dados com usu�rio utilizando dialog
//TODO: Gerar o gr�fico no centro da interface (border layout)
//TODO: Utilizar valor dos sliders para modificar o gr�fico dinamicamente...

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			BorderPane rootBorderPane = new BorderPane();
			Scene scene = new Scene(rootBorderPane, 800, 600);
			
			primaryStage.setTitle("JavaFX - Chart Controll");
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			//Components declaration:
			
			Button buttonFileOpen = new Button("Open");
			
			Button buttonSettings = new Button("Settings");

			Slider slider = new Slider();
			
			slider.setMin(1);
			slider.setMax(100);
			slider.setValue(40);
			slider.setShowTickLabels(true);
			slider.setShowTickMarks(true);
			slider.setMajorTickUnit(50);
			slider.setMinorTickCount(5);
			slider.setBlockIncrement(10);
			
		     Label status = new Label("Status: ");
			
			//Actions to the interactive components:
			
			buttonFileOpen.setOnAction(new EventHandler<ActionEvent>() {
			    @Override 
			    public void handle(ActionEvent e) {
			    	//TODO: Read a file and get data to the graphic, using dialog
			        System.out.println("Open...");
			    }
			});

			buttonSettings.setOnAction(new EventHandler<ActionEvent>() {
			    @Override 
			    public void handle(ActionEvent e) {
			    	//TODO: Change graphic parameters using dialog
			        System.out.println("Settings...");
			    }
			});			
			
			slider.valueProperty().addListener((observable, oldvalue, newvalue) -> {
			            float val = newvalue.floatValue();
			            System.out.println("Slider value: " + val);
			            status.setText("Status: Slider=" + val);
			});
		
			//Form layout...		
			
		    ToolBar toolbar = new ToolBar();
		     
		    toolbar.getItems().add(buttonFileOpen);
		    toolbar.getItems().add(buttonSettings);
		    toolbar.getItems().add(slider);
		     
		     
		    HBox statusbar = new HBox();

		    statusbar.getChildren().add(status);

		    rootBorderPane.setTop(toolbar);
		    //TODO: Criar o gr�fico e carrega-lo no centro...
		    rootBorderPane.setCenter(new Label("O gr�fico vai aqui..."));
		    rootBorderPane.setBottom(statusbar);
		      
			//M�gica...
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
