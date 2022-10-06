package patrones.proxy.dbProxy;


import patrones.poolCreation.DB.DB;

import java.util.HashMap;
import java.util.Map;

public class Proxy {

    private Proxy(){
        this.init();
    }
    public static final Proxy instance = new Proxy();

    private Map<Country, DB> mapProxy = new HashMap<Country, DB>();

    private void init(){
        Country[] values = Country.values();
        for (Country country : values) {
            DB db = new DB();
            mapProxy.put(country, db);
        }
    }

    public DB getDB(Country country){
        DB db = mapProxy.get(country);
        return db;
    }

}
