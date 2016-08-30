package model.name;

import model.productivity.ProductivityFile;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.*;
import java.util.Scanner;

/**
 * Created by siddgupta on 8/11/16.
 */
public class NameFile {


    private Scanner input;
    private static XWPFDocument docx;
    private static File file;
    private String nameFile;

   public NameFile()
    {
        input=new Scanner(System.in);
       file= createNewFile();
        try {

            setHeaderWithName();
        }
        catch (IOException e)
        {
            System.out.println("An IOException occured on the file ");
        }
        System.out.println("File has been created successfully");
    }

    private File createNewFile()
    {
        System.out.println("Please enter Name Of File");
        nameFile=input.next();
        File file=new File(nameFile+".doc");
        docx = new XWPFDocument();
        return file;
    }


    public static void finished()
    {
        try {
            FileOutputStream out = new FileOutputStream(file);
            docx.write(out);
            out.close();
        }
        catch (IOException e)
        {
            System.out.println("Exception occurred");
        }
      //  ProductivityFile.finished();
        System.out.println("Done");
    }


    private void setHeaderWithName() throws IOException
    {

        try {
            CTSectPr sectPr = docx.getDocument().getBody().addNewSectPr();
            XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(docx, sectPr);

           String header= writeHeader(policy);
            String topic=writeTopic();
            ProductivityFile productivityFile=new ProductivityFile(header,topic);


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private String writeHeader(XWPFHeaderFooterPolicy policy) throws IOException
    {
        CTP ctpHeader = CTP.Factory.newInstance();
        CTR ctrHeader = ctpHeader.addNewR();
        CTText ctHeader = ctrHeader.addNewT();
        Name name=new Name();
        String headerText = name.getName();
        ctHeader.setStringValue(headerText);
        XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, docx);
        XWPFParagraph[] parsHeader = new XWPFParagraph[1];
        parsHeader[0] = headerParagraph;
        policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);
        return headerText;

    }

    /*
    private void writeFooter(XWPFHeaderFooterPolicy policy) throws  IOException
    {
        CTP ctpFooter = CTP.Factory.newInstance();
        CTR ctrFooter = ctpFooter.addNewR();
        CTText ctFooter = ctrFooter.addNewT();
        String footerText = "Hello";
        ctFooter.setStringValue(footerText);
        XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooter, docx);
        XWPFParagraph[] parsFooter = new XWPFParagraph[1];
        parsFooter[0] = footerParagraph;
        policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);
    }
    */

    private String writeTopic()
    {
        XWPFParagraph bodyParagraph = docx.createParagraph();
        bodyParagraph.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun r = bodyParagraph.createRun();

        r.setBold(true);
        r.setColor("3297e9");
        r.setFontSize(18);
        r.setEmbossed(true);
        System.out.println("Please enter a topic");

        Scanner input=new Scanner(System.in);
        String topic=input.nextLine();
        System.out.println("topic = " + topic);
        r.setText(topic);
        r.addBreak();

        return topic;

    }

    public static void writeContent(String string)
    {
        XWPFParagraph bodyParaph =docx.createParagraph();
        bodyParaph.setAlignment(ParagraphAlignment.LEFT);

        XWPFRun r=bodyParaph.createRun();
        r.setBold(true);
        r.setColor("BA55D3");
        r.setFontSize(14);
        r.setEmbossed(false);
        r.setText(string);

    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }
}
