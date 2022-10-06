package patrones.proxyV02.dbProxy;

import patrones.cache.tools.Utils;
import patrones.proxy.dbProxy.Country;
import patrones.proxyV02.dbProxy.DB.DB;
import patrones.proxyV02.dbProxy.DB.DbPool;

import java.util.HashMap;
import java.util.Map;

public class Proxy {

    private Utils tools = new Utils();

    private Proxy(){
        this.init();
    }
    public static final Proxy instance = new Proxy();

    private Map<Country, DbPool> mapProxy = new HashMap<Country, DbPool>();

    private void init(){
        Country[] values = Country.values();
        for (Country country : values) {
            DbPool db = new DbPool();
            mapProxy.put(country, db);
        }
    }

    public DB getDB(Country country){
        DbPool pool = mapProxy.get(country);

        if (pool.someOneFree()){
            return pool.getOneFree();
        }
        // No hay libre

        // Conectamos a un pais aleatorio
        Country[] countries = Country.values();
        int pos = tools.getNumber(countries.length);
        // Coger un pais aleatorio
        Country nCountry = countries[pos];

        // Recursividad -> Se genera un bucle pseudoInfinito hasta que alguna conexión queda libre
        return getDB(nCountry);
    }

}
