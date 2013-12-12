package data;

import java.io.FileWriter;  
import java.io.IOException;  
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
  
public class CSV {
	static Set<String> data=new HashSet<String>();
	static List<String> country=new ArrayList<String>();
	static List<String> items=new ArrayList<String>();
	
	
    public static void main(String[] args) { 
    	for(int i=1;i<=1000;i++){

    	String name=getString(10);
		System.out.println("Ëæ¼´"+i+"¸ö"+name);
    	data.add(name);
    	}

        try {  
            FileWriter fw = new FileWriter("d:\\helloworld.csv");
            FileWriter or=new FileWriter("d:\\order.csv");
            Iterator<String> ite=data.iterator();
           while(ite.hasNext()){
        	  
        	   String mmm=ite.next();
        	   System.out.println(mmm);
        	   String cont=RandomCountry();
        	   fw.write(mmm.toString()+","+cont +","+mmm.toString()+","+mmm.toString()+"@163.com"+"\r\n");
        	   for(int a=1;a<=1000;a++){
        	   or.write(mmm.toString()+"@163.com"+","+mmm.toString()+","+getItem()+","+mmm.toString()+getString(5)+"\r\n");
        	   }
            }
            fw.close();  
            or.close();
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    } 
    
    public static String getItem(){
    	items.add("item1");
    	items.add("item2");
    	items.add("item3");
    	items.add("item4");
    	items.add("item5");
    	items.add("item6");
    	items.add("item7");
    	items.add("item8");
    	items.add("item9");
    	Random cou=new Random();
		int index=cou.nextInt(9);
		return items.get(index);
    	
    }
    
	private static String RandomCountry() {
    	country.add("Bangladesh");
    	country.add("Cambodia");
    	country.add("Malaysia");
    	country.add("Japan");
    	country.add("The USA");
    	country.add("The UK");
    	country.add("Thailand");
    	country.add("France");
    	country.add("Belgium");
    	country.add("Germany");
    	country.add("China");
		Random cou=new Random();
		int index=cou.nextInt(15);
		return country.get(index);
		
	}

	public static String getString(int length){
    	String z="abcdefghijklmnopqrstuvwsyzABCDEFGHIGKLMNOPQRSTUVWSYZ";
    	StringBuffer len =new StringBuffer();
    	Random mun=new Random();
    	for(int i=1;i<=length;i++){    		
    		len.append(z.charAt(mun.nextInt(48)));    		
    	}
    	return len.toString();
    }
}  
