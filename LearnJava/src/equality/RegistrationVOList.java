package equality;

import java.util.List;

public class RegistrationVOList {
	
	private List<RegistrationVO> registrations;

	public List<RegistrationVO> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<RegistrationVO> registrations) {
		this.registrations = registrations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((registrations == null) ? 0 : registrations.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		System.out.println();
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrationVOList other = (RegistrationVOList) obj;
		if (registrations == null) {
			if (other.registrations != null)
				return false;
		} else 
			System.out.println("Test non null objects");
			
			//if (!registrations.equals(other.registrations))
			return true;
		
	}
	
	

}
