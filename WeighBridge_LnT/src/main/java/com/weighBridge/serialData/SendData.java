package com.weighBridge.serialData;

import java.io.IOException;
import java.io.OutputStream;

import purejavacomm.CommPortIdentifier;
import purejavacomm.SerialPort;
import purejavacomm.UnsupportedCommOperationException;

public class SendData {
	public static volatile SerialPort m_Port;
	public static volatile OutputStream m_Out;
	public static void main(String[] args) {
		try {
			CommPortIdentifier portid = CommPortIdentifier.getPortIdentifier("cu.Bluetooth-Incoming-Port");
			m_Port = (SerialPort) portid.open("MyApp", 10000);
			m_Port.setOutputBufferSize(100);
			m_Out = m_Port.getOutputStream();

		} catch (Exception e) {
			e.printStackTrace();
		}
//		int mode = m_Port.getFlowControlMode();
//		mode &= ~(SerialPort.FLOWCONTROL_XONXOFF_IN | SerialPort.FLOWCONTROL_XONXOFF_OUT);
//		try {
//			m_Port.setFlowControlMode(mode);
//		} catch (UnsupportedCommOperationException e) {
//			e.printStackTrace();
//		}
		
		byte[] sent = new byte[256];
		sent[0]='k';
		sent[1]='a';
		sent[2]='r';
		sent[3]='a';
		sent[4]='n';
		
		try {
			m_Out.write(sent);
			m_Out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (m_Port != null) {
				try {
					m_Out.flush();
					m_Port.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				finally {
					m_Port = null;
				}
			}
		}
		
	}

}
