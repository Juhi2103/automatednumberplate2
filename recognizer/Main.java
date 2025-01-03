package numberPlate;

/*
 * 
 * Author : Tushar Singhal
 * Email : tushar8194@gmail.com
 * Date : 29 Jan 2017
 * Code is derived from Java ANPR library and enhanced to make it more power full.
 * */

import java.io.File;
import java.io.IOException;

import numberPlate.imageanalysis.CarSnapshot;
import numberPlate.intelligence.Intelligence;


public class Main {
	
	public static CarSnapshot car;
    public static Intelligence systemLogic;
    static String ImageName ;
   // static int count=0;
 
    public static void main(String[] args) throws Exception {        	  
           Main.systemLogic = new Intelligence(false);
           String InputPath=args[0];
           File file = new File(InputPath);	
   		while(file.isDirectory())
   		{
   			if(file.list().length>0)
   			{	
   				System.out.println("Directory is not empty!");
   				for(String filename : file.list())
				{
   	//			count++;	
   		//		if(count<2){ImageName=filename;}
   			//	else {System.out.println("More than one Image"); System.exit(0);}
				//System.out.println(filename);
   					ImageName=filename;
				}
   				break;
   			}
   			else
   			{		
   				System.out.println("Directory is empty!");
   				continue;
   			}				
   		}
           try {
               car = new CarSnapshot(InputPath+"/"+ImageName);
               String recognizedText = Main.systemLogic.recognize(car);
               System.out.println("Car Number :"+recognizedText);
               if(recognizedText!=null)
               {
               	System.exit(0);
               }
           } catch (IOException ex) {
               ex.printStackTrace();
           } catch (Exception e) {
   			e.printStackTrace();
   		}
    }
}
