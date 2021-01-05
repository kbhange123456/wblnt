package com.weighBridge.consumer.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.weighBridge.consumer.domain.WeighBridgeObj;

public class VehicleWisePDF {

	public static ByteArrayInputStream getVehicleWise(List<WeighBridgeObj> wboList,String vtype, LocalDate startDateLD, LocalDate endDateLD) {
		Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
        BigDecimal netWeightTotal = BigDecimal.ZERO;
//        BigDecimal pWeightTotal = BigDecimal.ZERO;
//        BigDecimal lWeightTotal = BigDecimal.ZERO;
        BigDecimal weightChargesTotal = BigDecimal.ZERO;
//        BigDecimal amounTotal = BigDecimal.ZERO;
        try {
            String companyName = "L&T";
            Paragraph title = new Paragraph(companyName,
                    FontFactory.getFont(FontFactory.TIMES, 15, Font.BOLD));
            title.setAlignment(Element.ALIGN_CENTER);
            
            String place = "MANSAR";
            Paragraph location = new Paragraph(place,
                    FontFactory.getFont(FontFactory.HELVETICA, 10));
            location.setAlignment(Element.ALIGN_CENTER);
            
            String road = "MAHULI ROAD";
            Paragraph location2 = new Paragraph(road,
                    FontFactory.getFont(FontFactory.HELVETICA, 10));
            location2.setAlignment(Element.ALIGN_CENTER);
            
            String ws = "Vehicle Type wise Report";
            Paragraph wsp = new Paragraph(ws,
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11));
            wsp.setAlignment(Element.ALIGN_CENTER);
            
            String reportName = "Tickets Date Between " + startDateLD.format(formatters) +" and "+ endDateLD.format(formatters);
            Paragraph address = new Paragraph(reportName,
            		FontFactory.getFont(FontFactory.HELVETICA, 9));
            address.setAlignment(Element.ALIGN_CENTER);
            
            String reportType = "Vehicle Type : " + vtype;
            Paragraph rt = new Paragraph(reportType,
            		FontFactory.getFont(FontFactory.HELVETICA, 9));
            rt.setAlignment(Element.ALIGN_CENTER);
            
            PdfPTable table = new PdfPTable(9);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{10, 10, 10, 20, 10, 10, 10, 10, 10});
            
			
			Font headFontBold = FontFactory.getFont(FontFactory.TIMES_BOLD, 7);
			float leadingVar = 100;
			
			PdfPCell hcell;
			
			hcell = new PdfPCell(new Phrase(leadingVar, "Date", headFontBold));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcell.setBorder(2);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase(leadingVar, "Ticket No", headFontBold));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcell.setBorder(2);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase(leadingVar, "Vehicle No", headFontBold));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcell.setBorder(2);
			table.addCell(hcell);

//			hcell = new PdfPCell(new Phrase(leadingVar, "Vehicle Type", headFontBold));
//			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
//			hcell.setBorder(2);
//			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase(leadingVar, "Name of Party", headFontBold));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcell.setBorder(2);
			table.addCell(hcell);

//			hcell = new PdfPCell(new Phrase(leadingVar, "Type", headFontBold));
//			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
//			hcell.setBorder(2);
//			table.addCell(hcell);

//			hcell = new PdfPCell(new Phrase(leadingVar, "Address", headFontBold));
//			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
//			hcell.setBorder(2);
//			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase(leadingVar, "Item", headFontBold));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
			hcell.setBorder(2);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase(leadingVar, "Gross Wt.", headFontBold));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			hcell.setBorder(2);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase(leadingVar, "Tare Wt.", headFontBold));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			hcell.setBorder(2);
			table.addCell(hcell);

//			hcell = new PdfPCell(new Phrase(leadingVar, "Packing Wt.", headFontBold));
//			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
//			hcell.setBorder(2);
//			table.addCell(hcell);
//
//			hcell = new PdfPCell(new Phrase(leadingVar, "Less Wt.", headFontBold));
//			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
//			hcell.setBorder(2);
//			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase(leadingVar, "Net Wt.", headFontBold));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			hcell.setBorder(2);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase(leadingVar, "W. Charges", headFontBold));
			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			hcell.setBorder(2);
			table.addCell(hcell);

//			hcell = new PdfPCell(new Phrase(leadingVar, "Rate", headFontBold));
//			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//			hcell.setBorder(2);
//			table.addCell(hcell);
//
//			hcell = new PdfPCell(new Phrase(leadingVar, "Amount", headFontBold));
//			hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//			hcell.setBorder(2);
//			table.addCell(hcell);
            
            for(WeighBridgeObj wbo : wboList) {
            	netWeightTotal=netWeightTotal.add(wbo.getNweight());
//            	pWeightTotal=pWeightTotal.add(wbo.getPweight());
//            	lWeightTotal=lWeightTotal.add(wbo.getLweight());
            	weightChargesTotal=weightChargesTotal.add(wbo.getChgs());
//            	wChargeTotal=wChargeTotal.add(wbo.getAmt());
            	rowBuilder(table,wbo.getEntryTime().toLocalDate().format(formatters),wbo.getId(),wbo.getVnum(),wbo.getPname(),wbo.getMat(),wbo.getGweight(),wbo.getTweight(),wbo.getNweight(),wbo.getChgs());
            }
//            rowBuilder(table,"VEHICLE NO",wbo.get().getVnum(),"TICKET NO",wbo.get().getId().toString(),true,true,true,true);
//            rowBuilder(table,"GROSS WEIGHT",wbo.get().getGweight()+" KG","DATE TIME","in time",false,false,false,false);
//            rowBuilder(table,"TARE WEIGHT",wbo.get().getTweight()+" KG","DATE TIME","in time",false,false,false,false);
//            rowBuilder(table,"NET WEIGHT",wbo.get().getNweight()+" KG","MATERIAL","KAPAS",false,false,false,false);
//            rowBuilder(table,"PACKING WEIGHT",wbo.get().getPweight()+" KG","RATE","0.00",false,false,false,false);
//            rowBuilder(table,"LESS WEIGHT",wbo.get().getLweight()+" KG","VEHICLE TYPE","BULKART",false,false,true,false);
//            rowBuilder(table,"ACTUAL NET WT."," KG","","",true,false,true,false);
//            rowBuilder(table,"SUB TOTAL","0.00","PARTY NAME","CASH",false,false,false,false);
//            rowBuilder(table,"VEHICLE CHARGES","100.00","ADDRESS","",false,false,false,false);
//            rowBuilder(table,"LOADING CHARGES","0.00","CITY","",false,false,false,false);
//            rowBuilder(table,"AMOUNT","0.00","MOBILE NO","",true,false,false,false);

            PdfPTable table2 = new PdfPTable(4);
            table2.setWidthPercentage(100);
            table2.setWidths(new int[]{70, 10, 10, 10});
            
            rowBuilder2(table2, "COUNT : "+wboList.size(),"TOTAL",netWeightTotal,weightChargesTotal);
//            rowBuilder2(table2, "COUNT : "+wboList.size(), "L&T");
//            rowBuilder2(table2, "  ", "  ");
//            rowBuilder2(table2, "", "");
//            rowBuilder2(table2, "  ", "  ");
//            rowBuilder2(table2, "", "WEIGHBRIDGE INCHARGE");
          
            
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(title);
//            document.add(location);
//            document.add(location2);
            document.add(wsp);
//            document.add(address);
            document.add(rt);
            LineSeparator ls = new LineSeparator();
            document.add(new Chunk(ls));
            document.addTitle(ws);
            table.setSpacingBefore(30);
            document.add(table);
            ls = new LineSeparator();
            document.add(new Chunk(ls));
            document.add(table2);
            document.close();

        } catch (DocumentException ex) {

            System.out.println(ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
	}

	private static void rowBuilder2(PdfPTable table, String string1, String string2, BigDecimal netWeightTotal, BigDecimal weightChargesTotal) {
		Font headFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8, Font.BOLD);
		float leadingVar = 100;
		PdfPCell hcell;
		hcell = new PdfPCell(new Phrase(leadingVar,string1, headFont));
		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
		hcell.setBorder(Rectangle.NO_BORDER);
		table.addCell(hcell);
		
		hcell = new PdfPCell(new Phrase(leadingVar,string2, headFont));
		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		hcell.setBorder(Rectangle.NO_BORDER);
		table.addCell(hcell);
		
//		hcell = new PdfPCell(new Phrase(leadingVar,gap, headFont));
//		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//		hcell.setBorder(Rectangle.NO_BORDER);
//		table.addCell(hcell);
//		
//		hcell = new PdfPCell(new Phrase(leadingVar,gap1, headFont));
//		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//		hcell.setBorder(Rectangle.NO_BORDER);
//		table.addCell(hcell);
		
//		hcell = new PdfPCell(new Phrase(leadingVar,pWeightTotal.toString(), headFont));
//		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//		hcell.setBorder(Rectangle.NO_BORDER);
//		table.addCell(hcell);
//		
//		hcell = new PdfPCell(new Phrase(leadingVar,lWeightTotal.toString(), headFont));
//		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//		hcell.setBorder(Rectangle.NO_BORDER);
//		table.addCell(hcell);
		
		hcell = new PdfPCell(new Phrase(leadingVar,netWeightTotal.toString(), headFont));
		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		hcell.setBorder(Rectangle.NO_BORDER);
		table.addCell(hcell);
		
		hcell = new PdfPCell(new Phrase(leadingVar,weightChargesTotal.toString(), headFont));
		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		hcell.setBorder(Rectangle.NO_BORDER);
		table.addCell(hcell);
		
//		hcell = new PdfPCell(new Phrase(leadingVar,string, headFont));
//		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//		hcell.setBorder(Rectangle.NO_BORDER);
//		table.addCell(hcell);
//		
//		hcell = new PdfPCell(new Phrase(leadingVar,amounTotal.toString(), headFont));
//		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//		hcell.setBorder(Rectangle.NO_BORDER);
//		table.addCell(hcell);
	}
//	rowBuilder(table,wbo.getEntryTime().toLocalDate().format(formatters),wbo.getId(),wbo.getVnum(),wbo.getPname(),wbo.getMat(),
//			wbo.getGweight(),wbo.getTweight(),wbo.getNweight(),wbo.getChgs());
    	private static void rowBuilder(PdfPTable table, String localDate, Long id, String vnum, String pname,
			String mat, BigDecimal gweight, BigDecimal tweight, BigDecimal nweight, BigDecimal chgs) {
		Font headFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 7);
		float leadingVar = 100;
		PdfPCell hcell;
		
		hcell = new PdfPCell(new Phrase(leadingVar, localDate.toString(), headFont));
		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
		hcell.setBorder(2);
		table.addCell(hcell);

		hcell = new PdfPCell(new Phrase(leadingVar, id.toString(), headFont));
		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
		hcell.setBorder(2);
		table.addCell(hcell);

		hcell = new PdfPCell(new Phrase(leadingVar, vnum, headFont));
		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
		hcell.setBorder(2);
		table.addCell(hcell);
		
//		hcell = new PdfPCell(new Phrase(leadingVar, ma, headFont));
//		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
//		hcell.setBorder(2);
//		table.addCell(hcell);

		hcell = new PdfPCell(new Phrase(leadingVar, pname, headFont));
		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
		hcell.setBorder(2);
		table.addCell(hcell);

		hcell = new PdfPCell(new Phrase(leadingVar,mat, headFont));
		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
		hcell.setBorder(2);
		table.addCell(hcell);

//		hcell = new PdfPCell(new Phrase(leadingVar, addr, headFont));
//		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
//		hcell.setBorder(2);
//		table.addCell(hcell);
//		
//		hcell = new PdfPCell(new Phrase(leadingVar, city, headFont));
//		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
//		hcell.setBorder(2);
//		table.addCell(hcell);


		hcell = new PdfPCell(new Phrase(leadingVar, gweight.toString(), headFont));
		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		hcell.setBorder(2);
		table.addCell(hcell);
		
		hcell = new PdfPCell(new Phrase(leadingVar, tweight.toString(), headFont));
		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		hcell.setBorder(2);
		table.addCell(hcell);
		
//		hcell = new PdfPCell(new Phrase(leadingVar, pweight.toString(), headFont));
//		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//		hcell.setBorder(2);
//		table.addCell(hcell);

		hcell = new PdfPCell(new Phrase(leadingVar, nweight.toString(), headFont));
		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		hcell.setBorder(2);
		table.addCell(hcell);

		hcell = new PdfPCell(new Phrase(leadingVar, chgs.toString(), headFont));
		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		hcell.setBorder(2);
		table.addCell(hcell);

//		hcell = new PdfPCell(new Phrase(leadingVar, amt.toString(), headFont));
//		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//		hcell.setBorder(2);
//		table.addCell(hcell);

//		hcell = new PdfPCell(new Phrase(leadingVar, chgs.toString(), headFont));
//		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//		hcell.setBorder(2);
//		table.addCell(hcell);
//
//		hcell = new PdfPCell(new Phrase(leadingVar, rate.toString(), headFont));
//		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//		hcell.setBorder(2);
//		table.addCell(hcell);
//
//		hcell = new PdfPCell(new Phrase(leadingVar,amt.toString(), headFont));
//		hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//		hcell.setBorder(2);
//		table.addCell(hcell);
		
	}
}