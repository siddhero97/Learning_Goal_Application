package model.productivity;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.*;

/**
 * Created by siddgupta on 8/21/16.
 */
public class ProductivityFile {

    private static XWPFDocument docx;
    private static File file;

    public ProductivityFile(String header,String topic)
    {
        file= createNewFile(topic);
        try {
            setHeaderWithName(header,topic);

        }
        catch (IOException e)
        {
            System.out.println("An IOException occured on the file ");
        }
        System.out.println("File has been created successfully");
    }
    private File createNewFile(String topic)
    {
        String productivity=topic+"productivity";
        File file=new File(productivity+".doc");
        docx = new XWPFDocument();
        return file;
    }

    private void setHeaderWithName(String header,String topic) throws IOException  {



            CTSectPr sectPr = docx.getDocument().getBody().addNewSectPr();
            XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(docx, sectPr);

            writeHeader(header,policy);
            writeTopic(topic);


        }

    private void writeTopic(String topic) {

        XWPFParagraph bodyParagraph = docx.createParagraph();
        bodyParagraph.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun r = bodyParagraph.createRun();

        r.setBold(true);
        r.setColor("3297e9");
        r.setFontSize(18);
        r.setEmbossed(true);


        r.setText(topic);
        r.addBreak();

    }

    private void writeHeader(String header, XWPFHeaderFooterPolicy policy) throws IOException {

        CTP ctpHeader = CTP.Factory.newInstance();
        CTR ctrHeader = ctpHeader.addNewR();
        CTText ctHeader = ctrHeader.addNewT();
        ctHeader.setStringValue(header);
        XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, docx);
        XWPFParagraph[] parsHeader = new XWPFParagraph[1];
        parsHeader[0] = headerParagraph;
        policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);
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
        System.out.println("Done");
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



}

