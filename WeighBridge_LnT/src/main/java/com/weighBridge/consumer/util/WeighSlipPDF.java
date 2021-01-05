package com.weighBridge.consumer.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Optional;

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

public class WeighSlipPDF {

	public static ByteArrayInputStream getWeighSlip(Optional<WeighBridgeObj> wbo) {
		Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.out.println(wbo.get().getId());
        try {
            String companyName = "L&T";
            Paragraph title = new Paragraph(companyName,
                    FontFactory.getFont(FontFactory.HELVETICA, 15, Font.BOLD));
            title.setAlignment(Element.ALIGN_CENTER);
            
            String place = "MANSAR";
            Paragraph location = new Paragraph(place,
                    FontFactory.getFont(FontFactory.HELVETICA, 10));
            location.setAlignment(Element.ALIGN_CENTER);
            
            String road = "MAHULI ROAD";
            Paragraph location2 = new Paragraph(road,
                    FontFactory.getFont(FontFactory.HELVETICA, 10));
            location2.setAlignment(Element.ALIGN_CENTER);
            
            String add = "MANSAR - 441401, MAHARASHTRA, PhoneNo: 8600000278";
            Paragraph address = new Paragraph(add,
                    FontFactory.getFont(FontFactory.HELVETICA, 9));
            address.setAlignment(Element.ALIGN_CENTER);
            
            String ws = "WEIGH - SLIP";
            Paragraph wsp = new Paragraph(ws,
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11));
            wsp.setAlignment(Element.ALIGN_CENTER);
            
            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{23, 2, 15, 20, 15, 2, 23});
            
            String dateTime=  DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
     		  .format(wbo.get().getEntryTime());
            
            rowBuilder(table,"VEHICLE NO",wbo.get().getVnum(),"TICKET NO",wbo.get().getId().toString(),true,true,true,true);
            rowBuilder(table,"GROSS WEIGHT",wbo.get().getGweight().toString()+" KG","ENTRY TIME",dateTime,false,false,false,false);
            rowBuilder(table,"TARE WEIGHT",wbo.get().getTweight().toString()+" KG","EXIT TIME",dateTime,false,false,false,false);
            rowBuilder(table,"NET WEIGHT",wbo.get().getNweight().toString()+" KG","MATERIAL",wbo.get().getMat(),false,false,false,false);
            rowBuilder(table,"PACKING WEIGHT",wbo.get().getPweight().toString()+" KG","RATE",wbo.get().getRate().toString(),false,false,false,false);
            rowBuilder(table,"LESS WEIGHT",wbo.get().getLweight().toString()+" KG","VEHICLE TYPE",wbo.get().getVtype(),false,false,true,false);
            rowBuilder(table,"ACTUAL NET WT.",wbo.get().getNweight().toString()+" KG","","",true,false,true,false);
            rowBuilder(table,"SUB TOTAL","0.00","PARTY NAME",wbo.get().getPname(),false,false,false,false);
            rowBuilder(table,"VEHICLE CHARGES",wbo.get().getChgs().toString(),"ADDRESS",wbo.get().getAddr(),false,false,false,false);
            rowBuilder(table,"LOADING CHARGES",wbo.get().getUlbchgs().toString(),"CITY",wbo.get().getCity(),false,false,false,false);
            rowBuilder(table,"AMOUNT",wbo.get().getAmt().toString(),"MOBILE NO",wbo.get().getMno().toString(),true,false,false,false);

            PdfPTable table2 = new PdfPTable(2);
            table2.setWidthPercentage(80);
            table2.setWidths(new int[]{50,50});
            
            rowBuilder2(table2, "  ", "  ");
            rowBuilder2(table2, "", "L&T");
            rowBuilder2(table2, "  ", "  ");
            rowBuilder2(table2, "PARTY SIGN", "");
            rowBuilder2(table2, "  ", "  ");
            rowBuilder2(table2, "", "WEIGHBRIDGE INCHARGE");
            
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(title);
//            document.add(location);
//            document.add(location2);
//            document.add(address);
            document.add(wsp);
            LineSeparator ls = new LineSeparator();
            document.add(new Chunk(ls));
            document.addTitle("Weigh Slip");
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

	private static void rowBuilder2(PdfPTable table, String string1, String string2) {
		Font headFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8);
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
	}

	private static void rowBuilder(PdfPTable table,String string, String string2, String string3, String string4, Boolean field1, Boolean field2, Boolean field3, Boolean field4) {
		Font headFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8);
		Font headFontBold = FontFactory.getFont(FontFactory.TIMES_BOLD, 8);
		float leadingVar = 100;
		 PdfPCell hcell;
         hcell = new PdfPCell(new Phrase(leadingVar,string, headFont));
         hcell.setPaddingLeft(1);
         hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
         if(field3)
        	 hcell.setBorder(2);
         else
        	 hcell.setBorder(Rectangle.NO_BORDER);
         table.addCell(hcell);

         hcell = new PdfPCell(new Phrase(leadingVar,":", headFont));
         hcell.setPaddingLeft(3);
         hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
         if(field3)
        	 hcell.setBorder(2);
         else
        	 hcell.setBorder(Rectangle.NO_BORDER);
         table.addCell(hcell);

         if(field1)
        	 hcell = new PdfPCell(new Phrase(leadingVar,string2, headFontBold));
         else
        	 hcell = new PdfPCell(new Phrase(leadingVar,string2, headFont));
         hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         hcell.setHorizontalAlignment(Element.ALIGN_RIGHT);
         if(field3)
        	 hcell.setBorder(2);
         else
        	 hcell.setBorder(Rectangle.NO_BORDER);
         table.addCell(hcell);
         
         hcell = new PdfPCell(new Phrase(leadingVar," ", headFont));
         hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
         if(field3 && field4)
        	 hcell.setBorder(2);
         else
        	 hcell.setBorder(Rectangle.NO_BORDER);
         table.addCell(hcell);

         hcell = new PdfPCell(new Phrase(leadingVar,string3, headFont));
         hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
         if(field4)
        	 hcell.setBorder(2);
         else
        	 hcell.setBorder(Rectangle.NO_BORDER);
         table.addCell(hcell);

         hcell = new PdfPCell(new Phrase(leadingVar,":", headFont));
         hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
         if(field4)
        	 hcell.setBorder(2);
         else
        	 hcell.setBorder(Rectangle.NO_BORDER);
         table.addCell(hcell);
         
         if(field2)
        	 hcell = new PdfPCell(new Phrase(leadingVar,string4, headFontBold));
         else
        	 hcell = new PdfPCell(new Phrase(leadingVar,string4, headFont));
         hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
         hcell.setHorizontalAlignment(Element.ALIGN_LEFT);
         if(field4)
        	 hcell.setBorder(2);
         else
        	 hcell.setBorder(Rectangle.NO_BORDER);
         table.addCell(hcell);
		
	}
}