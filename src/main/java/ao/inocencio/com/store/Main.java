package ao.inocencio.com.store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("C:\\SOA\\workspace\\reading_data_from_xml_with_Java\\vendas.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Vendas.class);

            Unmarshaller jaxbUnmarshaler = jaxbContext.createUnmarshaller();
            Vendas vendas = (Vendas) jaxbUnmarshaler.unmarshal(xmlFile);

            List<Venda> todasAsVendas = vendas.getVenda();
            BigDecimal Grosstotal = BigDecimal.ZERO;
            BigDecimal TotalDiscount = BigDecimal.ZERO;

            for (Venda v : todasAsVendas) {
                for (Item i : v.getItens()) {
                 BigDecimal itemValue =  i.getPrice().multiply(new BigDecimal(i.getQuantity()));
                    Grosstotal = Grosstotal.add(itemValue);
                    TotalDiscount = TotalDiscount.add(i.getDiscount());
                }
            }
            System.out.println("TOTAL GROSS SALE " + Grosstotal);
            System.out.println("TOTAL  DISCOUNT " + TotalDiscount);
            System.out.println("TOTAL NET SALE " + Grosstotal.subtract(TotalDiscount));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}