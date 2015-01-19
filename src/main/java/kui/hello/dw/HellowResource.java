package kui.hello.dw;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

@Path("/")
public class HellowResource {

	private final String defaultName;
	private final AtomicLong counter;
	
	public HellowResource(String name) {
		this.defaultName = name;
		this.counter = new AtomicLong();
	}
	
	@GET
	@Timed
	@Produces(MediaType.TEXT_PLAIN)
	public String doGreet(@QueryParam("name") Optional<String> name) {
	//public String greet() {
		final long c = counter.incrementAndGet();
		String n = name.or(defaultName);
		//final String n = defaultName;
		return String.format("Hello %s. (%d)", n, c);
	}
}
