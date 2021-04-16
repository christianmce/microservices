@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
public class Microservicio2Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservicio2Application.class, args);
	}
	
	@Bean
	public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
