package patrones.cache.dataSource;

import patrones.cache.dataSource.models.User;

import java.util.*;

public class DbCache {

    private class DbInfo{
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

}
