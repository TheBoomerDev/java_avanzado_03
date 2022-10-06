package patrones.proxyV02.dbProxy.DB;

import patrones.cache.tools.Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DbPool {

    private class DbCon implements Comparable, Comparator {
        public int currentConections = 0;
        public DB db = new DB();

        @Override
        public int compareTo(Object o) {
            int thisCon = this.currentConections;
            int otherCon = ((DbCon)o).currentConections;
            return  (otherCon> thisCon) ? -1 : 1;
        }

        @Override
        public int compare(Object o1, Object o2) {
            return ((DbCon)o1).compareTo(o2);
        }
    }

    private static Utils tools = new Utils();
    public DbPool(){

        for (int i = 0; i < DbPool.limit; i++) {
            DbCon db = new DbCon();
            this.dbs.add(db);
        }

    }

    private List<DbCon> dbs = new ArrayList<DbCon>();
    private static final int limit =  5;

    public DB getConnection(){
        DbCon con = this.dbs.stream().min(DbCon::compareTo).get();
        con.currentConections = con.currentConections + 1;
        return con.db;
    }

    private DB[] getFreeOnes(){
        Object[] filtrados = this.dbs.stream().filter(db -> {
            return (db.currentConections < limit);
        }).map(dbcon->{
            return dbcon.db;
        }).toArray();
        return (DB[]) filtrados;
    }

    public DB getOneFree(){
        DB[] filtrados = getFreeOnes();
        if (filtrados.length <= 0) return null;
        return (DB) filtrados[0];
    }

    public boolean someOneFree(){

        DB[] filtrados = getFreeOnes();

        return filtrados.length > 0;
    }

    public void liberate(DB db){

        Object[] filtrado = this.dbs.stream().filter(dbCon -> {
            return dbCon.db.equals(db);
        }).toArray();

        if (filtrado.length <= 0) return;
        DbCon currentCon = (DbCon) filtrado[0];
        currentCon.currentConections = currentCon.currentConections - 1;
    }

    public void listAll(){

        String format = "DB: %s - Con: %s";

        for (int i = 0; i < this.dbs.size(); i++) {
            DbCon dbCon = this.dbs.get(i);
            String msg = String.format(format, i, dbCon.currentConections);
            System.out.println(msg);
        }

    }



}
