package cc.doing.as.ds;

import org.apache.commons.dbcp.BasicDataSource;

public class ActivityDS {
    private static final BasicDataSource dataSource;
    static{ //use static block to avoid using singletons and worry free about thread-safe
        //TODO: move these to a resource based approach instead of plain text in code
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("1whzydxfsh");
        dataSource.setUrl("jdbc:mysql://localhost/test");
    }
    public BasicDataSource getDataSource(){
        return dataSource;
    }

}
