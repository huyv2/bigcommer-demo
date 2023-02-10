package bigcommer.apidemo.application.port.out.tax;

import bigcommer.apidemo.application.port.out.command.request.TaxCreatingPropertiesRequestCommand;
import bigcommer.apidemo.application.port.out.command.response.TaxCreatingPropertiesResponseCommand;

public interface TaxCreatingPropertiesPort {
	TaxCreatingPropertiesResponseCommand createTaxProperty(TaxCreatingPropertiesRequestCommand taxCreatingPropertiesRequestCommand);
}
