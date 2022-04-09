package ReBack.core;


import ReBack.core.pdf.PDFGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"ReBack.core.pdf"})
public class SpringBootPdfGenerationApplication {

    public static void main(String[] args) {

        ApplicationContext ac = SpringApplication.run(SpringBootPdfGenerationApplication.class, args);

        PDFGenerator pDFGenerator = ac.getBean("pdfGenerator",PDFGenerator.class);

        pDFGenerator.generatePdfReport();
    }

}