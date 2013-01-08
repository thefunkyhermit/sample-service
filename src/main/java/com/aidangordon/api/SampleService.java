package com.aidangordon.api;


import com.aidangordon.api.config.SampleServiceConfiguration;
import com.aidangordon.api.dao.TestDAO;
import com.aidangordon.api.resources.DBSampleResource;
import com.aidangordon.api.resources.GroovyResource;
import com.aidangordon.api.resources.SampleResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.jdbi.DBIFactory;
import org.skife.jdbi.v2.DBI;

public class SampleService extends Service<SampleServiceConfiguration> {
    public static void main(String[] args) throws Exception {
//        new SampleService().run();
        new SampleService().run(args);
    }


    @Override
    public void initialize(Bootstrap<SampleServiceConfiguration> sampleServiceConfigurationBootstrap) {
        sampleServiceConfigurationBootstrap.setName("sample-service");
    }

    @Override
    public void run(SampleServiceConfiguration sampleServiceConfiguration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, sampleServiceConfiguration.getDatabaseConfiguration(), "mysql");
        final TestDAO dao = jdbi.onDemand(TestDAO.class);
        environment.addResource(new SampleResource());
        environment.addResource(new DBSampleResource(dao));
        environment.addResource(new GroovyResource());
    }
}
