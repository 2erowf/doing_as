package cc.doing.as.ds;

import org.apache.commons.dbcp.BasicDataSource;

public class ActivityDS {
    private static final BasicDataSource dataSource;
    static{ //use static block to avoid using singletons and worry free about thread-safe
        //TODO: move these to a resource based approach instead of plain text in code
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setMaxActive(5);
        dataSource.setMaxIdle(5);
        dataSource.setUsername("root");
        dataSource.setPassword("****");
        dataSource.setUrl("jdbc:mysql://localhost:3306/doing?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT");
    }
    public static BasicDataSource getDataSource(){
        return dataSource;
    }

}
