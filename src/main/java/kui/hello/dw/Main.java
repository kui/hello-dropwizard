package kui.hello.dw;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class Main extends Application<Config>{
	
	public static void main(String[] args) throws Exception {
		new Main().run(args);
	}

	@Override
	public void initialize(Bootstrap<Config> bootstrap) {
		// noop
		// ほぼ最初に呼ばれるフック
	}

	/**
	 * 起動準備ができてサーバとして立ち上がる直前のフック
	 */
	@Override
	public void run(Config conf, Environment env) throws Exception {
		final HellowResource helloResource = new HellowResource(conf.getName());
		env.jersey().register(helloResource);

		final HealthCheck healthCheck = new HealthCheck();
		env.healthChecks().register("default", healthCheck);
	}
}
