import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class DB_FUNCTIONS {


    // show all the males
    

    // show all the females
    

    // show all the visitors
    
    // show all the full Members
    
    // show all the male visitors
    
    // show all the female visitos
    
    // show all the full member males
    
    // show all the full member females
    
    
    
    
    // 1. show all the males
    // the TABLE_NAME is Members
    
    
    @FXML
    TableView<Members> table;
    
    Connection connection = MyAppDatabaseConnection.LoginConnector();
    ObservableList<User> data=FXCollections.observableArrayList();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    public void AllMalesOrAllFemales(String gender){
        
        
    //  String sqlQuery = "SELECT * FROM MEMEBERS WHERE gender = ?";
        String sqlQuery = "select * FROM Members  where gender = gender";
        
        try{
        
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet.preparedStatement.executeQuery();
            
            //displaying the results of the database query
            //assumption here is that the results will be in a tabular format
            
            while(resultSet.next()){
            
                //each entry in the database is assaigned to its own Member object
                data.add(new Members(
                                     
                 resultSet.getString("members_id"),
                 resultSet.getString("name"),
                 resultSet.getString("surname"),
                 resultSet.getString("age"),
                 resultSet.getString("cell"),
                 resultSet.getString("gender"),
                 resultSet.getString("address"),
                 resultSet.getString("city"),
                 resultSet.getString("postal"),
                 resultSet.getString("membership"),
                 resultSet.getString("email")));
                                     
                table.setItems(data);
            
            }
                                     preparedStatement.close();
                                     resultSet.close();
      
            
        }
        catch(SQLException e){
                                     
            // error handling
        }
        
    }
    
//    //2. show all females
//                                     
//    public void AllMales(String male){
//                    
//                    
//                    //  String sqlQuery = "SELECT * FROM MEMEBERS WHERE gender = ?";
//                    String sqlQuery = "select * FROM Members  where gender = male";
//                    
//                    try{
//                        
//                        preparedStatement = connection.preparedStatement(sqlQuery);
//                        resultSet.preparedStatement.executeQuery();
//                        
//                        //displaying the results of the database query
//                        //assumption here is that the results will be in a tabular format
//                        
//                        while(resultSet.next()){
//                            
//                            //each entry in the database is assaigned to its own Member object
//                            data.add(new Members(
//                                                 
//                                                 resultSet.getString("members_id"),
//                                                 resultSet.getString("name"),
//                                                 resultSet.getString("surname"),
//                                                 resultSet.getString("age"),
//                                                 resultSet.getString("cell"),
//                                                 resultSet.getString("gender"),
//                                                 resultSet.getString("address"),
//                                                 resultSet.getString("city"),
//                                                 resultSet.getString("postal"),
//                                                 resultSet.getString("membership"),
//                                                 resultSet.getString("email")));
//                                                 
//                                                 table.setItems(data);
//                                                 
//                                                 }
//                                                 preparedStatement.close();
//                                                 resultSet.close();
//                                                 
//                                                 
//                                                 }
//                                                 
//                                                 
//                                                 
//                                                 catch(SQLException e){
//                                                     
//                                                     // error handling
//                                                 }
//                                                 
//                                                 }
//                                                 
//        public void AllMaleVisitors(String gender, String membership){
//                                
//                                
//                //  String sqlQuery = "SELECT * FROM MEMEBERS WHERE gender = ?" AND membership = ?;
//                String sqlQuery = "select * FROM Members  where gender = male AND membership = visitor ";
//                                
//                try{
//                                    
//                    preparedStatement = connection.preparedStatement(sqlQuery);
//                    resultSet.preparedStatement.executeQuery();
//                                    
//                    //displaying the results of the database query
//                    //assumption here is that the results will be in a tabular format
//                                    
//                    while(resultSet.next()){
//                                        
//                        //each entry in the database is assaigned to its own Member object
//                        data.add(new Members(
//                                                             
//                            resultSet.getString("members_id"),
//                            resultSet.getString("name"),
//                            resultSet.getString("surname"),
//                            resultSet.getString("age"),
//                            resultSet.getString("cell"),
//                            resultSet.getString("gender"),
//                            resultSet.getString("address"),
//                            resultSet.getString("city"),
//                            resultSet.getString("postal"),
//                            resultSet.getString("membership"),
//                            resultSet.getString("email")));
//                        table.setItems(data);
//                                                             
//                        }
//                        preparedStatement.close();
//                        resultSet.close();
//                                                             
//                                                             
//                    }
//                    catch(SQLException e){
//                        // error handling
//                    }
//                                                             
//        }
//                                     
//                                     
//                            
//        // Famale visitors
//        public void AllFemaleVisitors(String gender, String membership){
//                    
//                    
//                    //  String sqlQuery = "SELECT * FROM MEMEBERS WHERE gender = ?" AND membership = ?;
//                    String sqlQuery = "select * FROM Members  where gender = female AND membership = visitor ";
//                    
//                    try{
//                        
//                        preparedStatement = connection.preparedStatement(sqlQuery);
//                        resultSet.preparedStatement.executeQuery();
//                        
//                        //displaying the results of the database query
//                        //assumption here is that the results will be in a tabular format
//                        
//                        while(resultSet.next()){
//                            
//                            //each entry in the database is assaigned to its own Member object
//                            data.add(new Members(
//                                                 
//                                                 resultSet.getString("members_id"),
//                                                 resultSet.getString("name"),
//                                                 resultSet.getString("surname"),
//                                                 resultSet.getString("age"),
//                                                 resultSet.getString("cell"),
//                                                 resultSet.getString("gender"),
//                                                 resultSet.getString("address"),
//                                                 resultSet.getString("city"),
//                                                 resultSet.getString("postal"),
//                                                 resultSet.getString("membership"),
//                                                 resultSet.getString("email")));
//                            table.setItems(data);
//                            
//                        }
//                        preparedStatement.close();
//                        resultSet.close();
//                        
//                        
//                    }
//                    catch(SQLException e){
//                        // error handling
//                    }
//                    
//                }
//                                     
//                                     
//            
//                                     
//        public void AllMaleMembers(String gender, String membership){
//                    
//                    
//                    //  String sqlQuery = "SELECT * FROM MEMEBERS WHERE gender = ?" AND membership = ?;
//                    String sqlQuery = "select * FROM Members  where gender = male AND membership = fullmember ";
//                    
//                    try{
//                        
//                        preparedStatement = connection.preparedStatement(sqlQuery);
//                        resultSet.preparedStatement.executeQuery();
//                        
//                        //displaying the results of the database query
//                        //assumption here is that the results will be in a tabular format
//                        
//                        while(resultSet.next()){
//                            
//                            //each entry in the database is assaigned to its own Member object
//                            data.add(new Members(
//                                                 
//                                                 resultSet.getString("members_id"),
//                                                 resultSet.getString("name"),
//                                                 resultSet.getString("surname"),
//                                                 resultSet.getString("age"),
//                                                 resultSet.getString("cell"),
//                                                 resultSet.getString("gender"),
//                                                 resultSet.getString("address"),
//                                                 resultSet.getString("city"),
//                                                 resultSet.getString("postal"),
//                                                 resultSet.getString("membership"),
//                                                 resultSet.getString("email")));
//                            table.setItems(data);
//                            
//                        }
//                        preparedStatement.close();
//                        resultSet.close();
//                        
//                        
//                    }
//                    catch(SQLException e){
//                        // error handling
//                    }
//                    
//                }
//                                     
//        
//                                     
//                                    
//        public void AllFemaleVisitors(String gender, String membership){
//                    
//                    
//                    //  String sqlQuery = "SELECT * FROM MEMEBERS WHERE gender = ?" AND membership = ?;
//                    String sqlQuery = "select * FROM Members  where gender = female AND membership = fullmember ";
//                    
//                    try{
//                        
//                        preparedStatement = connection.preparedStatement(sqlQuery);
//                        resultSet.preparedStatement.executeQuery();
//                        
//                        //displaying the results of the database query
//                        //assumption here is that the results will be in a tabular format
//                        
//                        while(resultSet.next()){
//                            
//                            //each entry in the database is assaigned to its own Member object
//                            data.add(new Members(
//                                                 
//                                                 resultSet.getString("members_id"),
//                                                 resultSet.getString("name"),
//                                                 resultSet.getString("surname"),
//                                                 resultSet.getString("age"),
//                                                 resultSet.getString("cell"),
//                                                 resultSet.getString("gender"),
//                                                 resultSet.getString("address"),
//                                                 resultSet.getString("city"),
//                                                 resultSet.getString("postal"),
//                                                 resultSet.getString("membership"),
//                                                 resultSet.getString("email")));
//                            table.setItems(data);
//                            
//                        }
//                        preparedStatement.close();
//                        resultSet.close();
//                        
//                        
//                    }
//                    catch(SQLException e){
//                        // error handling
//                    }
//                    
//                }
//
//                                    
//
//                                                             
//        //3. Show all Visitors
//        public void AllVisitors(String visitor){
//                                            
//                                            
//                //  String sqlQuery = "SELECT * FROM MEMEBERS WHERE membership = ?";
//                String sqlQuery = "select * FROM Members  where membership = visitor";
//                                            
//                try{
//                                                
//                        preparedStatement = connection.preparedStatement(sqlQuery);
//                        resultSet.preparedStatement.executeQuery();
//                                                
//                        //displaying the results of the database query
//                        //assumption here is that the results will be in a tabular format
//                                                
//                        while(resultSet.next()){
//                                                    
//                                //each entry in the database is assaigned to its own Member object
//                                data.add(new Members(
//                                                                         
//                                    resultSet.getString("members_id"),
//                                    resultSet.getString("name"),
//                                    resultSet.getString("surname"),
//                                    resultSet.getString("age"),
//                                    resultSet.getString("cell"),
//                                    resultSet.getString("gender"),
//                                    resultSet.getString("address"),
//                                    resultSet.getString("city"),
//                                    resultSet.getString("postal"),
//                                    resultSet.getString("membership"),
//                                    resultSet.getString("email")));
//                                                                         
//                                    table.setItems(data);
//                                                                         
//                         }
//                         preparedStatement.close();
//                         resultSet.close();
//                                                                         
//                                                                         
//                    }
//                                                                         
//                                                                         
//                                                                         
//                    catch(SQLException e){
//                                                                             
//                        // error handling
//                    }
//                                                                         
//        }
//                                                                         
//                                                                         
// 
//        //4. Show all FullMembers
//        public void AllFullMembers(String fullmember){
//                                                        
//                                                        
//                //  String sqlQuery = "SELECT * FROM MEMEBERS WHERE membership = ?";
//                String sqlQuery = "select * FROM Members  where membership = fullmember";
//                                                        
//                try{
//                                                            
//                        preparedStatement = connection.preparedStatement(sqlQuery);
//                        resultSet.preparedStatement.executeQuery();
//                                                            
//                        //displaying the results of the database query
//                        //assumption here is that the results will be in a tabular format
//                                                            
//                        while(resultSet.next()){
//                                                                
//                            //each entry in the database is assaigned to its own Member object
//                            data.add(new Members(
//                                                                                     
//                                resultSet.getString("members_id"),
//                                resultSet.getString("name"),
//                                resultSet.getString("surname"),
//                                resultSet.getString("age"),
//                                resultSet.getString("cell"),
//                                resultSet.getString("gender"),
//                                resultSet.getString("address"),
//                                resultSet.getString("city"),
//                                resultSet.getString("postal"),
//                                resultSet.getString("membership"),
//                                resultSet.getString("email")));
//                                                                                     
//                            table.setItems(data);
//                                                                                     
//                        }
//                        preparedStatement.close();
//                        resultSet.close();
//                                                                                     
//                                                                                     
//                    }
//                                                                                     
//                                                                                     
//                                                                                     
//                    catch(SQLException e){
//                                                                                         
//                        // error handling
//                    }
//                                                                                     
//        }
//                                                                         
//
//
//
//
//                                     
//
//    
//        
}
 
