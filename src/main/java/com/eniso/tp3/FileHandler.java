
package com.eniso.tp3;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class FileHandler {
  private String filePath;
  private int fileSizeInKb ;
  private int numberOfLines;
  private ArrayList<String> fileContent;
  public FileHandler (String filePath){
      File file = new File(filePath);
      if(file.exists()){
         
          this.fileSizeInKb = 0;
          this.numberOfLines = 0;
          this.fileContent =new ArrayList<String>();
          }
      else 
          System.out.println("Le fichier n'existe pas");
      
  }
  private void readFile() throws FileNotFoundException{
      File myObj = new File(filePath);
      Scanner myReader = new Scanner(myObj);
      while(myReader.hasNextLine()){
          String data = myReader.nextLine();
           this.numberOfLines += 1 ;
           this.fileContent.add(data);
      }
      this.fileSizeInKb = (int) myObj.length()/1024;
       
  }
public ArrayList<String> findLinesWithPattern(String Pattern) throws FileNotFoundException{
      ArrayList<String> listPattern = new ArrayList<String>();
     for(String l : fileContent){
          if(l.contains(Pattern))
              listPattern.add(l);
          
              
      }
     return listPattern;
 }
 public boolean compareString1(String str1,String str2){
     return str1.equals(str2);
 }
  public boolean compareString2(String str1,String str2){
      return str1.equalsIgnoreCase(str2);
  }
  public boolean compareString3(String str1,String str2){
      return str1 == str2;
  }
  public String reverseString(int lineIndex){
        String Line = fileContent.get(lineIndex);
        String LineRev = null;
        for (int i = Line.length();i>0;i--){
            LineRev += Line.charAt(i);
        }
        return LineRev;
    
  }
  public String removeDuplicates(int lineIndex){
      String Line = fileContent.get(lineIndex);
      String LineDeleteDup = null;
      for (int i = 0 ; i<Line.length();i++){
          for (int j = Line.length(); j>0 ; j--){
          if(Line.charAt(i)!=Line.charAt(j)){
               LineDeleteDup += Line.charAt(i);
          }
              
          }
          
      }
      return LineDeleteDup;
  }
 
  
}
