package com.kixeye.api;


import com.kixeye.api.config.SampleServiceConfiguration;
import com.kixeye.api.dao.TestDAO;
import com.kixeye.api.resources.DBSampleResource;
import com.kixeye.api.resources.GroovyResource;
import com.kixeye.api.resources.SampleResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.jdbi.DBIFactory;
import net.sourceforge.argparse4j.impl.type.StringArgumentType;
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
