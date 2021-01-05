package com.weighBridge.serialData;


import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;

import purejavacomm.CommPortIdentifier;
import purejavacomm.NoSuchPortException;
import purejavacomm.PortInUseException;
import purejavacomm.SerialPort;

@Service
public class PortOneData {
	private Integer weight;
	public static volatile SerialPort m_Port;
	public static volatile InputStream m_In;
	public static volatile long m_T0;
	public static int m_Tab;
	public static int m_Progress;
	CommPortIdentifier portId;
	
//	@Autowired
//	private WebSocketStompClient stompClient;
	private static PortOneData single_instance=null; 
	  private PortOneData() {
	  }
	  public static PortOneData getInstance() 
	    { 
	        if (single_instance == null) 
	        { 
	            single_instance = new PortOneData(); 
	        } 
	        return single_instance; 
	    } 

	  public Integer getWeight(){
//		  StompSessionHandler sessionHandler = new CustmStompSessionHandler();
//
//		  StompSession stompSession = stompClient.connect("/send/weight", 
//		  sessionHandler).get();
//
//			stompSession.send("/send/weight", weight);
		try {
			portId = CommPortIdentifier.getPortIdentifier("cu.Bluetooth-Incoming-Port");
			if(portId.isCurrentlyOwned()==false)
				m_Port = (SerialPort) portId.open("MyApp", 1000);
//			m_Port.enableReceiveTimeout(10000);
			m_Port.disableReceiveTimeout();
			m_In = m_Port.getInputStream();
		} catch (NoSuchPortException | PortInUseException | IOException e1) {
			e1.printStackTrace();
		}
		m_T0 = System.currentTimeMillis();
//		int m = 1000;
//		int t = 100;
//		
		int n=100;
		try {
//			while ((n = m_In.available()) > 0) {
//				for (int i = 0; i < n; ++i) {
//					if(m_In.read()==2) {
//						if(m_In.read()==48) {
//							m_In.read();
//							weight=m_In.read()-48;
//							IntStream.range(1, 5).forEach(weight ->{
//								try {
//									weight= weight*10 + m_In.read()-48;
//								} catch (IOException e) {
//									e.printStackTrace();
//								}
//							});
//						}
//					}
////				
//					System.out.print(m_In.read()+" ");
//				}
////			Thread.sleep(100, 0);
//			}
			weight = m_In.read();
			return weight;
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (m_Port != null) {
				try {
					m_Port.close();
				} finally {
					m_Port = null;
				}
			}
		}

		return 0;
	  }

	  public void setWeight(Integer weight) {
	    this.weight = weight;
	  }
	  
}
