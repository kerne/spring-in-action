package cl.caraya.action.beans;

import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
@Component
public class OneManBand {

    private Map<String, Instrumental> instrumentalList;
    private Properties properties;


    public void start() {
        for (String inst : instrumentalList.keySet()) {
            Instrumental instrumental = instrumentalList.get(inst);
            instrumental.play();
        }

        for (Iterator<Object> it = properties.keySet().iterator(); it.hasNext(); ) {
            String key = (String)it.next();
            System.out.println(properties.getProperty(key));
        }

    }

    public void setInstrumentalList(Map<String, Instrumental> instrumentalList) {
        this.instrumentalList = instrumentalList;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
