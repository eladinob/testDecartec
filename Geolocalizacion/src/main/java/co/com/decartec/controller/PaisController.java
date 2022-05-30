package co.com.decartec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import co.com.decartec.entity.DataApiModel;
import co.com.decartec.entity.IpModel;
import co.com.decartec.entity.Pais;
import co.com.decartec.model.ResponseModel;
import co.com.decartec.service.PaisServices;
import lombok.extern.slf4j.Slf4j;
import static org.springframework.http.HttpStatus.*;


@Controller
public class PaisController {

	@Autowired
	private PaisServices paisServives;
	
	private ResponseModel response = new ResponseModel();
	
	@PostMapping("/registro/ip/")
	public ResponseEntity<ResponseModel> create(@RequestBody IpModel ip) { 
		
		DataApiModel dataApiModel = getDataModel(ip.getIp());
		if (dataApiModel != null) {
			
			Pais pais = new Pais();
			pais.setNombrePais(dataApiModel.getCountry_name());
			pais.setCodigoIso(dataApiModel.getCountry_code());
			pais.setDireccionIp(ip.getIp());
			
			response.setStatusCode(200);
			response.setData(paisServives.save(pais));
			response.setMensaje("Se consumido el servicio correctamente");
		    return new ResponseEntity<>(response, OK);
		}else {
			response.setStatusCode(300);
			response.setData(null);
			response.setMensaje("No es posible consumir el servicio");
		    return new ResponseEntity<>(response, OK);
		}
		
	}
	
	public DataApiModel getDataModel(String ip){
		try {
			String url = "http://api.ipapi.com/" + ip + "?access_key=5ef8614877f0fc16ed20e2fc33f07ac4";
			RestTemplate restTemplate = new RestTemplate();
			DataApiModel dataApiModel = restTemplate.getForObject(url, DataApiModel.class);
			return dataApiModel;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}	
	}
}
