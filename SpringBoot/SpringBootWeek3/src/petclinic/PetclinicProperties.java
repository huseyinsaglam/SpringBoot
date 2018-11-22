package petclinic;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="petclinic")
public class PetclinicProperties {
	
	private boolean dogru=true;

	public boolean isDogru() {
		return dogru;
	}

	public void setDogru(boolean dogru) {
		this.dogru = dogru;
	}
	
	

}
