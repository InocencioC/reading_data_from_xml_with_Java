package ao.inocencio.com.store;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.List;

@XmlRootElement(name = "venda")
@XmlAccessorType(XmlAccessType.FIELD)
public class Venda {
    @XmlAttribute
    private  Long id;
    @XmlElement(name = "cliente")
    private String client;

    @XmlElement (name = "data")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime date;

    @XmlElementWrapper(name = "itens")
    @XmlElement(name = "item")
    private List<Item> itens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
