package com.weighBridge.serialData;

import java.util.Enumeration;

import purejavacomm.CommPortIdentifier;

public class checkCom {

	public static void main(String[] args) {
		Enumeration<CommPortIdentifier> portIdentifiers = CommPortIdentifier.getPortIdentifiers();
		
		while(portIdentifiers.hasMoreElements()) {
			
			System.out.println(portIdentifiers.nextElement());
		}
	}

}