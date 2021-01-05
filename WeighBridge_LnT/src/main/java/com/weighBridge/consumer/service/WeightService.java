package com.weighBridge.consumer.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.stream.IntStream;

import org.springframework.messaging.MessagingException;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.weighBridge.consumer.dao.WeighBridgeDAO;
import com.weighBridge.consumer.domain.WeighBridgeObj;
import com.weighBridge.consumer.repository.WBORepository;

import purejavacomm.CommPortIdentifier;
import purejavacomm.NoSuchPortException;
import purejavacomm.PortInUseException;
import purejavacomm.SerialPort;

@Service
public class WeightService {
	
	private Integer weight=0;
	private Integer newWeight=0;
	private Integer weight1=0;
	private Integer newWeight1=0;
	private String range="";
	private String range1="";
	public static volatile SerialPort m_Port;
	public static volatile InputStream m_In;
	public static volatile OutputStream m_Out;
	public static volatile SerialPort m_Port1;
	public static volatile InputStream m_In1;
	public static volatile OutputStream m_Out1;
	public static volatile long m_T0;
	public static int m_Tab;
	public static int m_Progress;
	CommPortIdentifier portId;
	CommPortIdentifier portId1;
	
	
	  private final SimpMessagingTemplate simpMessagingTemplate;
	    private static final String WS_MESSAGE_TRANSFER_DESTINATION = "/topic/greetings";

	    WeightService(SimpMessagingTemplate simpMessagingTemplate) {
	        this.simpMessagingTemplate = simpMessagingTemplate;
	    }
	    
	    public String getWeight() {
	    	try {
				portId = CommPortIdentifier.getPortIdentifier("COM5");
//				System.out.println(portId.getName());
				if(portId.isCurrentlyOwned()==false)
					m_Port = (SerialPort) portId.open("MyApp", 10000);
				m_Port.disableReceiveTimeout();
				m_Port.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
				m_Port.setSerialPortParams(4800, 8, 1, 0);
				m_In = m_Port.getInputStream();
				m_Out = m_Port.getOutputStream();
//				System.out.println("Baud Rate "+m_Port.getBaudRate());
//				System.out.println("Parity "+m_Port.getParity());
//				System.out.println("Stop bits "+m_Port.getStopBits());
			

				int[] frame = new int[10];
//				System.out.print("m_In : "+m_In.read());
//				System.out.print(m_In.read());
//				System.out.print(m_In.read());
//				System.out.print(m_In.read());
//				System.out.print(m_In.read());
//				System.out.print(m_In.read());
//				System.out.print(m_In.read());
//				System.out.print(m_In.read());
//				System.out.print(m_In.read());
//				System.out.print(m_In.read());
//				System.out.println();

//				portId1 = CommPortIdentifier.getPortIdentifier("COM6");
////				System.out.println(portId1.getName());
//				if(portId1.isCurrentlyOwned()==false)
//					m_Port1 = (SerialPort) portId1.open("MyApp1", 10001);
//				m_Port1.disableReceiveTimeout();
//				m_Port1.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
//				m_Port1.setSerialPortParams(4800, 8, 1, 0);
//				m_In1 = m_Port1.getInputStream();
//				m_Out1 = m_Port1.getOutputStream();
				int[] frame1 = new int[10];
//				System.out.print("m_In1 : "+m_In1.read());
//				System.out.print(m_In1.read());
//				System.out.print(m_In1.read());
//				System.out.print(m_In1.read());
//				System.out.print(m_In1.read());
//				System.out.print(m_In1.read());
//				System.out.print(m_In1.read());
//				System.out.print(m_In1.read());
//				System.out.print(m_In1.read());
//				System.out.print(m_In1.read());
//				System.out.println();
				if (m_In.available() > 0 && m_In.read() == 2) {
					if (m_In.read() == 48) {
						if (m_In.read() == 49) {
							for (int i = 0; i < 10; i++)
								frame[i] = m_In.read();
							for (int j = 0; j < 6; j++) {
								weight = (frame[j] - 48) + weight * 10;
							}
							if (frame[7] == 45) {
								weight *= -1;
							}
//							System.out.print("Frame : "+frame[0]+""+frame[1]+""+frame[2]+""+frame[3]+""+frame[4]+""+frame[5]+""+frame[6]+""+frame[7]+""+frame[8]+""+frame[9]);
//							System.out.println();
							System.out.println("weight "+weight);
								newWeight = weight;
								range=""+frame[6]+frame[8];
//								return "w0,"+weight;								
						}
					}
					
				}
//				
//				if (m_In1.available() > 0 && m_In1.read() == 2) {
//					if (m_In1.read() == 48) {
//						if (m_In1.read() == 49) {
//							for (int i = 0; i < 10; i++)
//								frame1[i] = m_In1.read();
//							for (int j = 0; j < 6; j++) {
//								weight1 = (frame1[j] - 48) + weight1 * 10;
//							}
//							if (frame1[7] == 45) {
//								weight1 *= -1;
//							}
////							System.out.print("Frame : "+frame1[0]+""+frame1[1]+""+frame1[2]+""+frame1[3]+""+frame1[4]+""+frame1[5]+""+frame1[6]+""+frame1[7]+""+frame1[8]+""+frame1[9]);
////							System.out.println();
//							System.out.println("weight1 "+weight1);
//								newWeight1 = weight1;
//								range1=""+frame1[6]+frame1[8];
////								return "w1,"+weight1;								
//						}
//					}
//					
//				}
//				if (m_In.read() == 2) {
//					System.out.println("Frame : 2"+m_In.read()+""+m_In.read()+""+m_In.read()+""+m_In.read()+""+m_In.read()+""+m_In.read()+""+m_In.read()+""+m_In.read()+""+m_In.read());
//				}
		
//				System.out.println("sign "+frame[7]);
					
					Thread.sleep(5);
					
					m_Out.write(49);
					m_Out.flush();
//					m_Out1.write(49);
//					m_Out1.flush();
					if(weight!=0) {
						newWeight = weight;
						newWeight1 = weight1;
						return "w0,"+weight+",w1,"+weight1+",r0,"+range+",r1,"+range1;								
					}else {
						return "w0,"+newWeight+",w1,"+newWeight1+",r0,"+range+",r1,"+range1;	
					}
	    }catch(Exception e){
	    	System.out.println("Weight exception "+e);
	    }finally {
	    	weight=0;
	    	weight1=0;
			if (m_Port != null) {
				try {
					m_Port.close();
				} finally {
					m_Port = null;
				}
			}
			if (m_Port1 != null) {
				try {
					m_Port1.close();
				} finally {
					m_Port1 = null;
				}
			}
		}
	    	if(weight!=0 && weight1!=0) {
				newWeight = weight;
//				newWeight1 = weight1;
				return "w0,"+weight+",w1,"+weight1;								
			}else {
				return "w0,"+newWeight+",w1,"+newWeight1;	
			}
//	    	if(weight1!=0) {
//				newWeight1 = weight1;
//				return "w1,"+weight1;								
//			}else {
//				return "w1,"+newWeight1;	
//			}
	    }
	    public void sendMessages() {
	    	System.out.println("in sendMessage");
	        simpMessagingTemplate.convertAndSend(WS_MESSAGE_TRANSFER_DESTINATION,
	            getWeight());
	    }

}
