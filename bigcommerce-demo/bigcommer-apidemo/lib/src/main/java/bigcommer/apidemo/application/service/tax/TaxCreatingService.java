package bigcommer.apidemo.application.service.tax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bigcommer.apidemo.application.port.in.command.request.tax.TaxCreatingRequestCommand;
import bigcommer.apidemo.application.port.in.command.request.tax.data.TaxCreatingRequestData;
import bigcommer.apidemo.application.port.in.command.response.tax.TaxCreatingResponseCommand;
import bigcommer.apidemo.application.port.in.command.response.tax.data.TaxCreatingResponseData;
import bigcommer.apidemo.application.port.in.tax.TaxCreatingUseCase;
import bigcommer.apidemo.application.port.out.command.request.TaxCreatingPropertiesRequestCommand;
import bigcommer.apidemo.application.port.out.command.request.data.TaxCreatingPropertiesRequestData;
import bigcommer.apidemo.application.port.out.command.response.TaxCreatingPropertiesResponseCommand;
import bigcommer.apidemo.application.port.out.command.response.data.TaxCreatingPropertiesResponseData;
import bigcommer.apidemo.application.port.out.tax.TaxCreatingPropertiesPort;
import bigcommer.apidemo.common.util.RandomStringGenerationUtil;

@Service("app.TaxCreatingService")
public class TaxCreatingService implements TaxCreatingUseCase {
	
	@Autowired
	private TaxCreatingPropertiesPort taxCreatingPropertiesPort;
	@Override
	public TaxCreatingResponseCommand createTaxProperty(TaxCreatingRequestCommand taxCreatingRequestCommand) {
		TaxCreatingResponseCommand taxCreatingResponseCommand = new TaxCreatingResponseCommand();
		
		TaxCreatingPropertiesRequestCommand taxCreatingPropertiesRequestCommand = new TaxCreatingPropertiesRequestCommand();
		String generationContentCode = RandomStringGenerationUtil.generateASCIIString(19);
		for(TaxCreatingRequestData taxCreatingRequestData : taxCreatingRequestCommand.getTaxCreatingRequestCommandList()) {
			TaxCreatingPropertiesRequestData taxCreatingPropertiesRequestData = new TaxCreatingPropertiesRequestData();
			taxCreatingPropertiesRequestData.setCode(taxCreatingRequestData.getPrefixCode() + generationContentCode);
			taxCreatingPropertiesRequestData.setDisplayName(taxCreatingRequestData.getDisplayName());
			taxCreatingPropertiesRequestData.setDescription(taxCreatingRequestData.getDescription());
			
			taxCreatingPropertiesRequestCommand.getTaxCreatingPropertiesCommandList().add(taxCreatingPropertiesRequestData);
		}
		
		TaxCreatingPropertiesResponseCommand taxCreatingPropertiesResponseCommand
			= taxCreatingPropertiesPort.createTaxProperty(taxCreatingPropertiesRequestCommand);
		
		for(TaxCreatingPropertiesResponseData taxCreatingPropertiesResponseData
				: taxCreatingPropertiesResponseCommand.getTaxCreatingPropertiesResponseCommandList()) {
			TaxCreatingResponseData taxCreatingResponseData = new TaxCreatingResponseData();
			taxCreatingResponseData.setId(taxCreatingPropertiesResponseData.getId());
			taxCreatingResponseData.setCode(taxCreatingPropertiesResponseData.getCode());
			taxCreatingResponseData.setDisplayName(taxCreatingPropertiesResponseData.getDisplayName());
			taxCreatingResponseData.setDescription(taxCreatingPropertiesResponseData.getDescription());
			taxCreatingResponseData.setCreatedAt(taxCreatingPropertiesResponseData.getCreatedAt());
			taxCreatingResponseData.setUpdatedAt(taxCreatingPropertiesResponseData.getUpdatedAt());
			
			taxCreatingResponseCommand.getTaxCreatingResponseCommandList().add(taxCreatingResponseData);
		}
		
		return taxCreatingResponseCommand;
	}
}
