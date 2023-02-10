package bigcommer.apidemo.adapter.out.tax;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import bigcommer.apidemo.adapter.out.dto.request.TaxCreatingPropertiesRequestDto;
import bigcommer.apidemo.adapter.out.dto.response.TaxCreatingPropertiesResponseDto;
import bigcommer.apidemo.application.port.out.command.request.TaxCreatingPropertiesRequestCommand;
import bigcommer.apidemo.application.port.out.command.request.data.TaxCreatingPropertiesRequestData;
import bigcommer.apidemo.application.port.out.command.response.TaxCreatingPropertiesResponseCommand;
import bigcommer.apidemo.application.port.out.command.response.data.TaxCreatingPropertiesResponseData;
import bigcommer.apidemo.application.port.out.tax.TaxCreatingPropertiesPort;

@Service("adapter.out.TaxCreatingProperties")
public class TaxCreatingProperties implements TaxCreatingPropertiesPort {
	
	@Value("${provider.bigcommerce.url}")
	private String url;
	@Value("${provider.bigcommerce.token}")
	private String token;
	
	@Override
	public TaxCreatingPropertiesResponseCommand createTaxProperty(
			TaxCreatingPropertiesRequestCommand taxCreatingPropertiesRequestCommand) {
		
		TaxCreatingPropertiesRequestDto taxCreatingPropertiesRequestDto = new TaxCreatingPropertiesRequestDto();
		for(TaxCreatingPropertiesRequestData taxCreatingPropertiesRequestData : taxCreatingPropertiesRequestCommand.getTaxCreatingPropertiesCommandList()) {
			bigcommer.apidemo.adapter.out.dto.request.data.TaxCreatingPropertiesRequestData taxCreatingPropertiesRequestDataDto
				= new bigcommer.apidemo.adapter.out.dto.request.data.TaxCreatingPropertiesRequestData();
			taxCreatingPropertiesRequestDataDto.setCode(taxCreatingPropertiesRequestData.getCode());
			taxCreatingPropertiesRequestDataDto.setDisplayName(taxCreatingPropertiesRequestData.getDisplayName());
			taxCreatingPropertiesRequestDataDto.setDescription(taxCreatingPropertiesRequestData.getDescription());
			
			taxCreatingPropertiesRequestDto.getTaxCreatingPropertiesRequestDtos().add(taxCreatingPropertiesRequestDataDto);
		}
		
		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("X-Auth-Token", token);
		
		List<bigcommer.apidemo.adapter.out.dto.request.data.TaxCreatingPropertiesRequestData> taxCreatingPropertiesRequestDtos
			= taxCreatingPropertiesRequestDto.getTaxCreatingPropertiesRequestDtos();
		
		HttpEntity<List<bigcommer.apidemo.adapter.out.dto.request.data.TaxCreatingPropertiesRequestData>> requestBody
			= new HttpEntity<>(taxCreatingPropertiesRequestDtos, headers);

		RestTemplate restTemplate = new RestTemplate();

		TaxCreatingPropertiesResponseDto taxCreatingPropertiesResponseDto = null;
		try {
			taxCreatingPropertiesResponseDto
			= restTemplate.postForObject(url, requestBody, TaxCreatingPropertiesResponseDto.class);
		} catch(Exception e) {
			
		}
		TaxCreatingPropertiesResponseCommand taxCreatingPropertiesResponseCommand = new TaxCreatingPropertiesResponseCommand();
		for(bigcommer.apidemo.adapter.out.dto.response.data.TaxCreatingPropertiesResponseData taxCreatingPropertiesResponseDataDto
				: taxCreatingPropertiesResponseDto.getTaxCreatingPropertiesResponseDtos()) {
			TaxCreatingPropertiesResponseData taxCreatingPropertiesResponseData = new TaxCreatingPropertiesResponseData();
			taxCreatingPropertiesResponseData.setId(taxCreatingPropertiesResponseDataDto.getId());
			taxCreatingPropertiesResponseData.setCode(taxCreatingPropertiesResponseDataDto.getCode());
			taxCreatingPropertiesResponseData.setDisplayName(taxCreatingPropertiesResponseDataDto.getDisplayName());
			taxCreatingPropertiesResponseData.setDescription(taxCreatingPropertiesResponseDataDto.getDescription());
			taxCreatingPropertiesResponseData.setCreatedAt(taxCreatingPropertiesResponseDataDto.getCreatedAt());
			taxCreatingPropertiesResponseData.setUpdatedAt(taxCreatingPropertiesResponseDataDto.getUpdatedAt());
			
			taxCreatingPropertiesResponseCommand.getTaxCreatingPropertiesResponseCommandList().add(taxCreatingPropertiesResponseData);
		}
		
		return taxCreatingPropertiesResponseCommand;
	}

}
