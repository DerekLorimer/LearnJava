package equality;

import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.core.net.SyslogOutputStream;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProviderStemVO aphraProvider = new ProviderStemVO();

		List<RegistrationVO> registrations = new ArrayList<RegistrationVO>();

		List<RegistrationVO> pdsRegistration = new ArrayList<RegistrationVO>();

		registrations.add(new RegistrationVO("1", "ACT"));
		registrations.add(new RegistrationVO("2", "ACT"));

		pdsRegistration.add(new RegistrationVO("1", "ACT"));

		ProviderStemVO provider = new ProviderStemVO();

		aphraProvider.setRegistrations(registrations);
		provider.setRegistrations(pdsRegistration);

	
		NRASRegistration r1 = new NRASRegistration("1", "ACT");

		RegistrationVOList profession = new RegistrationVOList();

		profession.setRegistrations((List<RegistrationVO>) aphraProvider.getRegistrations());

		RegistrationVOList base = new RegistrationVOList();

		base.setRegistrations((List<RegistrationVO>) provider.getRegistrations());
		
		if ( base.equals(profession)) {
			System.out.println("EQUALS");
		}

	}

}
