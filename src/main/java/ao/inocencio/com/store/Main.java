package ao.inocencio.com.store;

import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("C:\\SOA\\workspace\\reading_data_from_xml_with_Java\\vendas.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Vendas.class);

            Unmarshaller jaxbUnmarshaler = jaxbContext.createUnmarshaller();
            Vendas vendas = (Vendas) jaxbUnmarshaler.unmarshal(xmlFile);

            for (Venda venda : vendas.getVenda()) {
                System.out.println("ID da venda: "  + venda.getId());
                System.out.println("Cliente: "  + venda.getClient());
                System.out.println("Data da venda: "  + venda.getDate());

                for (Item item : venda.getItens()) {
                    System.out.println("\tItem: "  + item.getProduct());
                    System.out.println("\tQuantidade: "  + item.getQuantity());
                    System.out.println("\tPreço: "  + item.getPrice());
                    System.out.println("\tDesconto: "  + item.getDiscount());
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}