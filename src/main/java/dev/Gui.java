 package dev; 
 
 import javafx.application.Application; 
 import javafx.scene.Scene; 
 import javafx.scene.web.WebView; 
 import javafx.stage.Stage; 
 import netscape.javascript.JSObject; 
 
 public class Gui extends Application { 
 
 @Override 
 public void init() throws Exception { 
 WebAPI.start(); 
 SocketServer.start(); 
 } 
 
 @Override 
 public void start(Stage stage) { 
 WebView webView = new WebView(); 
 webView.getEngine().load("http://localhost:8080"); 
 
 JSObject window = (JSObject) webView.getEngine() 
 .executeScript("window"); 
 window.setMember("java", new Bridge()); 
 
 stage.setTitle("Scandor"); 
 stage.setScene(new Scene(webView, 1000, 700)); 
 stage.show(); 
 } 
 } 
