package petclinic;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetClinicConfiguartion {
	
	@Autowired
	private PetclinicProperties petclinicProperties;
	
	@PostConstruct
	public void hs()
	{
		
		System.out.println("dmojs :"+petclinicProperties.isDogru());
		
	}

}
