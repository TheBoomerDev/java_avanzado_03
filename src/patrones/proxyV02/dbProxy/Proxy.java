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

    private static final int limitSaltos = 5;

    private Map<Country, DbPool> mapProxy = new HashMap<Country, DbPool>();

    private void init(){
        Country[] values = Country.values();
        for (Country country : values) {
            DbPool db = new DbPool();
            mapProxy.put(country, db);
        }
    }

    private DB getPoolSaltando(Country country, int salto){
        if (salto <= 0) return null;

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

        return getPoolSaltando(country, salto--);
    }

    public DB getOneFree(Country country){
        // Evitamos el bucle infinito usando un limite al que podamos llegar o null
        return getPoolSaltando(country, limitSaltos);
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
