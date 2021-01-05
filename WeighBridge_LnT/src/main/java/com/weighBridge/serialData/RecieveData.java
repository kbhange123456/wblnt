package com.weighBridge.serialData;

import java.io.IOException;
import java.io.InputStream;

import purejavacomm.CommPortIdentifier;
import purejavacomm.SerialPort;
import purejavacomm.UnsupportedCommOperationException;

public class RecieveData {
	public static volatile SerialPort m_Port;
	public static volatile InputStream m_In;
	public static volatile long m_T0;
	public static int m_Tab;
	public static int m_Progress;

	public static void sleep(int t) throws InterruptedException {
		int m = 1000;
		while (t > 0) {
			Thread.sleep(t > m ? m : t);
			t -= m;
			while ((System.currentTimeMillis() - m_T0) / m > m_Progress) {
				System.out.print(".");
				m_Tab--;
				m_Progress++;
			}
		}
	}

	public static void main(String[] args) {

		try {
			CommPortIdentifier portid = CommPortIdentifier.getPortIdentifier("cu.Bluetooth-Incoming-Port");
			m_Port = (SerialPort) portid.open("MyApp", 100000);
			m_In = m_Port.getInputStream();

			m_T0 = System.currentTimeMillis();
			int m = 1000;
			int t = 100;
			m_Tab = 46;
			m_Progress = 0;
			while (t > 0) {
				Thread.sleep(t > m ? m : t);
				t -= m;
				while ((System.currentTimeMillis() - m_T0) / m > m_Progress) {
					System.out.print(".");
					m_Tab--;
					m_Progress++;
				}
			}
			int n;
			while ((n = m_In.available()) > 0) {
				for (int i = 0; i < n; ++i) {
					
					
					System.out.print(m_In.read()+" ");
				}
				sleep(100);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		int mode = m_Port.getFlowControlMode();
		mode &= ~(SerialPort.FLOWCONTROL_XONXOFF_IN | SerialPort.FLOWCONTROL_XONXOFF_OUT);
		try {
			m_Port.setFlowControlMode(mode);
		} catch (UnsupportedCommOperationException e) {
			e.printStackTrace();
		}

		byte[] rcvd = new byte[256];

		try {
			m_Port.enableReceiveTimeout(10000);
			m_In = m_Port.getInputStream();
			int n = m_In.read(rcvd);

			System.out.println(n);
			System.out.println(rcvd.toString());
			int i;
			char c;
			while((i = m_In.read())!=-1) {
		         
	            // converts integer to character
	            c = (char)i;
	            
	            // prints character
	            System.out.print(c);
	         }
		} catch (UnsupportedCommOperationException | IOException e) {
			e.printStackTrace();
		} finally {
			if (m_Port != null) {
				try {
					m_Port.close();
				} finally {
					m_Port = null;
				}
			}
		}

	}

}
