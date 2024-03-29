package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"file:environment/${evn}.properties"})
public interface EnvironmentConfig extends Config{
	@Key("App.URL")
	String getWebURL();
	
	@Key("App.Email")
	String getEmail();
	
	@Key("App.Password")
	String getPassword();
}
