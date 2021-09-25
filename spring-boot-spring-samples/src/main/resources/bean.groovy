

beans{
    /*dataSource(BasicDataSource) {
        driverClassName = "org.hsqldb.jdbcDriver"
        url = "jdbc:hsqldb:mem:grailsDB"
        username = "sa"
        password = ""
        settings = [mynew:"setting"]
    }
    sessionFactory(SessionFactory){
        dataSource = dataSource
    }
    myService(MyService) {
//        nestedBean = { AnotherBean com.demo.ioc.service.bean ->
//            dataSource = dataSource
//        }
    }*/
    user(User){
        name="zs"
        age=18
    }
}