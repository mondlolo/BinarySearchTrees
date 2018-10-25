import java.util.*;
import java.io.*;

public class DamBSTApp{

     public static void main(String[] args){
         //Collecting the input from the args array
          String userInput = "";
          for(String x : args){
              userInput += x;
          }
          //userInput +=" ";
          // Create an object of type BinarySearchTree
           BinarySearchTree<String> DamData = new BinarySearchTree<String>();

           int indexVariable = -1;
           String inputFile = "DamLevel.csv";
           File file =  new File(inputFile);
           //create new file

           //open file and populate the BinarySearchTree
           //catch any possible errors and report them
           try{
               Scanner dataFile = new Scanner(file);
               String[] dataStorage;
               while(dataFile.hasNextLine()){
                    String dataLine = dataFile.nextLine();
                    dataStorage = dataLine.split(",");

                    if(indexVariable== -1){

                    }else{
                        String data= String.format("Dam Name: %s\nFSC: %s\nDam Level: %s\n\n\n",dataStorage[2],dataStorage[10],dataStorage[27]);
                        String key = dataStorage[2];
                        DamData.insert(key,data);

                    }
                    indexVariable++;
               }
           }catch(FileNotFoundException e){
              System.out.println("An error occured");
           }
        //If the userInputis an empty string, the whole BST is printed out
        //otherwise the searched name and comparisonsdone are printed out.
        if(userInput.equals("")){
          DamData.preOrder();
        }else{
          userInput += " ";

          try{

              DamData.visit(DamData.find(userInput));
              System.out.printf("Number of comparisons: %s\n",DamData.getCounter(),DamData.getHeight());
          }catch(NullPointerException e){
            System.out.printf("%sis not found.\n",userInput);
          }
        }

     }


}
