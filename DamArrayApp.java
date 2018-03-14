import java.util.*;
import java.io.*;

public class DamArrayApp{

        String[] damInfo = new String[211];

        public static void main(String[] args){

              DamArrayApp x = new DamArrayApp();
              x.readFile();

              String userInput = "";
              for(String k : args){
                userInput+=k;
              }

              if(userInput.equals("")){
                  x.printAllDams();
              }else{
                  x.printDam(userInput);
              }
        }



        public void printDam(String damName){

           int count =0;
           String variable = "";
           for(String x : damInfo){
             count+=1;
             variable = x;
             if(x.contains(damName)){
               System.out.println(x);
               System.out.printf("There are %s comparisons done.\n",count);
               break;

             }if(!(variable.contains(damName))&& count==211){
               System.out.printf("%s is not found.There are %s comparisons done.\n",damName,count);
	       int k =0;
             }
           }
          }


        public void printAllDams(){
           // int counter = 0;
            for(String x: damInfo){
	     // counter++;
              System.out.println(x);
	     // System.out.printf("Dams compared: %s \n\n",counter);
            }
        }


        public void readFile(){
	       
               int indexVariable = -1;
               String inputFile = "DamLevel.csv";
               File file =  new File(inputFile);

               try{
                   Scanner data = new Scanner(file);
                   String[] dataStorage;
                   while(data.hasNextLine()){
                        String dataLine = data.nextLine();
                        dataStorage = dataLine.split(",");

                        if(indexVariable== -1){

                        }else{
                            damInfo[indexVariable]= String.format("Dam Name: %s\nFSC: %s\nDam Level: %s\n\n\n",dataStorage[2],dataStorage[10],dataStorage[27]);

                        }
                        indexVariable++;
                   }
               }catch(FileNotFoundException e){
                  System.out.println("An error occured");
               }

        }
}
