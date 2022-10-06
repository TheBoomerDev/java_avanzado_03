package patrones.cache.dataSource;

import patrones.cache.dataSource.models.User;

import java.util.*;

public class DbCache {

    private DbCache(){}
    public static final DbCache instance = new DbCache();

    private class DbInfo{

        private int tiempoVida = 5; // Segundos

        public DbInfo( List<User> info){
            this.info = info;

            // Ponemos el tiempo de Vida
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.SECOND, cal.get(Calendar.SECOND)+this.tiempoVida);
            this.limit = cal.getTime();
        }
        private Date limit = new Date();
        private List<User> info = new ArrayList<User>();
    }

    private Map<String, DbInfo> cache = new HashMap<String, DbInfo>();

    public boolean exists(String label){
        return this.cache.get(label) != null;
    }

    public boolean caducado(String label){
        if (!exists(label)) return false;
        DbInfo info = this.cache.get(label);

        Date now = new Date();
        return now.after(info.limit);
    }

    public List<User> getInfo(String label){
        DbInfo info = this.cache.get(label);
        return info.info;
    }

    public void setInfo(String label, List<User> info){
        DbInfo data = new DbInfo(info);
        this.cache.put(label, data);
    }

}
