package com.weighBridge.serialData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class testLocalDateTime {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		
		System.out.println(now);
		
//		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
//         LocalDateTime dateTime = java.time.LocalDateTime.parse(now.toString(), formatter);
         
		  
         System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
       		  .format(now));
	}

}
