package com.weighBridge.consumer.controller;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace.Response;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import com.weighBridge.consumer.dao.WeighBridgeDAO;
import com.weighBridge.consumer.domain.WeighBridgeObj;
import com.weighBridge.consumer.service.WeightService;
import com.weighBridge.consumer.util.CashCreditWisePDF;
import com.weighBridge.consumer.util.DateWisePDF;
import com.weighBridge.consumer.util.ItemWisePDF;
import com.weighBridge.consumer.util.LoadingWisePDF;
import com.weighBridge.consumer.util.PartyWisePDF;
import com.weighBridge.consumer.util.PendingPDF;
import com.weighBridge.consumer.util.VehicleWisePDF;
import com.weighBridge.consumer.util.WeighSlipPDF;
import com.weighBridge.serialData.PortOneData;

@Controller
public class WeightController {

	private WeighBridgeDAO wbdao;

	@Autowired
	public void setWeighBridgeDAO(WeighBridgeDAO wbdao) {
		this.wbdao = wbdao;
	}

	@Autowired
    private SimpMessagingTemplate template;
	
	@Autowired
	private WeightService weightService;

	@GetMapping({ "/", "/weighBridge" })
	public String weighBridge(@RequestParam(value = "weight", defaultValue = "0", required = true) String weight,
			Model model) throws Exception {
		Long lastId = wbdao.getLastId();
		List<String> partyNames = wbdao.getPartyNames();
		List<String> vehicleTypes = wbdao.getVehicleTypes();
		Boolean ispending = Boolean.TRUE;
		model.addAttribute("lastId", lastId + 1);
		model.addAttribute("partyNames", partyNames);
		model.addAttribute("vehicleTypes", vehicleTypes);
		model.addAttribute("ispending", ispending);
		return "weighbridgejsp";
	}
	
//	@GetMapping({ "/second/{id}" })
//	public String weighBridgeSecond(@PathVariable Long id, Model model) throws Exception {
//		Optional<WeighBridgeObj> wbo = wbdao.findById(id);
//		model.addAttribute("lastId", id);
//		model.addAttribute("vnum", wbo.get().getVnum());
//		model.addAttribute("ttype", wbo.get().getTtype());
//		model.addAttribute("wgeight", wbo.get().getGweight());
//		model.addAttribute("tweight", wbo.get().getTweight());
//		model.addAttribute("pweightpq", wbo.get().getPweightpq());
//		model.addAttribute("pweight", wbo.get().getPweight());
//		model.addAttribute("lweight", wbo.get().getLweight());
//		model.addAttribute("pname", wbo.get().getPname());
//		model.addAttribute("addr", wbo.get().getAddr());
//		model.addAttribute("city", wbo.get().getCity());
//		model.addAttribute("mno", wbo.get().getMno());
//		model.addAttribute("mat", wbo.get().getMat());
//		model.addAttribute("vtype", wbo.get().getVtype());
//		model.addAttribute("chgs", wbo.get().getChgs());
//		model.addAttribute("ulb", wbo.get().getUlb());
//		model.addAttribute("ulbchgs", wbo.get().getUlbchgs());
//		model.addAttribute("qty", wbo.get().getQty());
//		model.addAttribute("rate", wbo.get().getRate());
//		model.addAttribute("ispending", "true");
//		//return "redirect:/weighBridge"; //does not send value
//		return "weighbridgejsp"; //sends value but changes url
//		//return new ModelAndView("redirect:/weighBridge");
//	}
	@PostMapping(value = "/save")
	public String save(WeighBridgeObj wbo, Model model) {
		if (wbo == null) {
			System.out.println("null here");
		}
		Long lastId = wbdao.getLastId();
		if(wbo.getAddr()==null) {
			wbo.setAddr("");
		}
		if(wbo.getAmt()==null) {
			wbo.setAmt(BigDecimal.ZERO);
		}
		if(wbo.getVnum()==null) {
			wbo.setVnum("");
		}
		if(wbo.getTtype()==null) {
			wbo.setTtype("");
		}
		if(wbo.getVempty()==null) {
			wbo.setVempty("");
		}
		if(wbo.getGweight()==null) {
			wbo.setGweight(BigDecimal.ZERO);
		}
		if(wbo.getTweight()==null) {
			wbo.setTweight(BigDecimal.ZERO);
		}
		if(wbo.getPweight()==null) {
			wbo.setPweight(BigDecimal.ZERO);
		}
		if(wbo.getPweightpq()==null) {
			wbo.setPweightpq(BigDecimal.ZERO);
		}
		if(wbo.getLweight()==null) {
			wbo.setLweight(BigDecimal.ZERO);
		}
		if(wbo.getNweight()==null) {
			wbo.setNweight(BigDecimal.ZERO);
		}
		if(wbo.getPname()==null) {
			wbo.setPname("");
		}
		if(wbo.getCity()==null) {
			wbo.setCity("");
		}
		if(wbo.getMno()==null) {
			wbo.setMno(0);
		}
		if(wbo.getMat()==null) {
			wbo.setMat("");
		}
		if(wbo.getVtype()==null) {
			wbo.setVtype("");
		}
		if(wbo.getChgs()==null) {
			wbo.setChgs(BigDecimal.ZERO);
		}
		if(wbo.getUlb()==null) {
			wbo.setUlb("");
		}
		if(wbo.getUlbchgs()==null) {
			wbo.setUlbchgs(BigDecimal.ZERO);
		}
		if(wbo.getQty()==null) {
			wbo.setQty(BigDecimal.ZERO);
		}
		if(wbo.getRate()==null) {
			wbo.setRate(BigDecimal.ZERO);
		}
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		if(wbo.getPending()) {
			wbo.setPending(true);
			wbo.setEntryTime(ldt); 
			wbdao.insertWBObj(wbo);
		}
		else {
			Optional<WeighBridgeObj> forEntryTime = wbdao.findById(wbo.getId());
			wbo.setEntryTime(forEntryTime.get().getEntryTime());
			wbo.setExitTime(ldt); 
			wbo.setPending(false);
			wbo.setNweight(wbo.getGweight().subtract(wbo.getTweight()).subtract(wbo.getPweight()).subtract(wbo.getLweight()));
			wbdao.insertWBObj(wbo);
		}
		List<String> partyNames = wbdao.getPartyNames();
		model.addAttribute("lastId", lastId + 1);
		model.addAttribute("partyNames", partyNames.stream().toArray(String[] ::new));
		return "redirect:weighBridge";
	}
	
	@GetMapping({ "/second/{id}"})
	@ResponseBody
	public Response weighBridgeSecond(@PathVariable Long id) throws Exception {
		Optional<WeighBridgeObj> wbo = wbdao.findById(id);
		Map<String, List<String>> wboMap= new HashMap<String, List<String>>();
		List<String> lastid = new ArrayList<String>() {{add(id.toString());}};
		wboMap.put("id", lastid);
		List<String> vnum = new ArrayList<String>() {{add(wbo.get().getVnum());}};
		wboMap.put("vnum", vnum);
		List<String> ttype = new ArrayList<String>() {{add(wbo.get().getTtype());}};
		wboMap.put("ttype", ttype);
		List<String> pname = new ArrayList<String>() {{add(wbo.get().getPname());}};
		wboMap.put("pname", pname);
		List<String> addr = new ArrayList<String>() {{add(wbo.get().getAddr());}};
		wboMap.put("addr", addr);
		List<String> city = new ArrayList<String>() {{add(wbo.get().getCity());}};
		wboMap.put("city", city);
		List<String> mno = new ArrayList<String>() {{add(wbo.get().getMno().toString());}};
		wboMap.put("mno", mno);
		List<String> mat = new ArrayList<String>() {{add(wbo.get().getMat());}};
		wboMap.put("mat", mat);
		List<String> vtype = new ArrayList<String>() {{add(wbo.get().getVtype());}};
		wboMap.put("vtype", vtype);
		List<String> ispending = new ArrayList<String>() {{add("true");}};
		wboMap.put("ispending", ispending);
		Response response = new Response(200, wboMap);
	    return response;
		
	}



	@GetMapping(value = "/dateWiseReport", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> dateWiseReport(@RequestParam ("startDate") String startDate,@RequestParam ("endDate") String endDate) {
		LocalDate startDateLD = LocalDate.parse(startDate);
		LocalDate endDateLD = LocalDate.parse(endDate);
		List<WeighBridgeObj> wboList = wbdao.findAllByEntryTimeBetween(startDateLD, endDateLD);
		
		ByteArrayInputStream bis = DateWisePDF.getDateWise(wboList,startDateLD,endDateLD);

		HttpHeaders headers = new HttpHeaders();
		Date date = new Date();
		headers.add("Content-Disposition", "inline; filename=DateWiseReport_"+startDateLD+"_"+endDateLD+"_" + date.getTime() + ".pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	@GetMapping(value = "/cashcreditWiseReport", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> cashcreditWiseReport(@RequestParam ("startDate") String startDate,@RequestParam ("endDate") String endDate, @RequestParam ("cashcreditdd") String cashcredit) {
		LocalDate startDateLD = LocalDate.parse(startDate);
		LocalDate endDateLD = LocalDate.parse(endDate);
		List<WeighBridgeObj> wboList = wbdao.findAllByTtypeAndEntryTimeBetween(cashcredit,startDateLD, endDateLD);
		
		ByteArrayInputStream bis = CashCreditWisePDF.getCashcreditWise(wboList,cashcredit,startDateLD,endDateLD);

		HttpHeaders headers = new HttpHeaders();
		Date date = new Date();
		headers.add("Content-Disposition", "inline; filename=CashCreditReport_"+cashcredit+"_" + date.getTime() + ".pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	@GetMapping(value = "/itemWiseReport", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> itemWiseReport(@RequestParam ("startDate") String startDate,@RequestParam ("endDate") String endDate,@RequestParam ("itemdd") String item) {
		LocalDate startDateLD = LocalDate.parse(startDate);
		LocalDate endDateLD = LocalDate.parse(endDate);
		List<WeighBridgeObj> wboList = wbdao.findAllByMat(item,startDateLD, endDateLD);
		
		ByteArrayInputStream bis = ItemWisePDF.getItemWise(wboList,item,startDateLD,endDateLD);

		HttpHeaders headers = new HttpHeaders();
		Date date = new Date();
		headers.add("Content-Disposition", "inline; filename=ItemWiseReport_"+item+"_" + date.getTime() + ".pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	@GetMapping(value = "/pendingReport", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> pendingReport() {
//		Boolean pendingTrue = Boolean.TRUE;
		List<WeighBridgeObj> wboList = wbdao.findPending();
		
		ByteArrayInputStream bis = PendingPDF.getPending(wboList);

		HttpHeaders headers = new HttpHeaders();
		Date date = new Date();
		headers.add("Content-Disposition", "inline; filename=PendingReport_" + date.getTime() + ".pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	@GetMapping(value = "/loadingWiseReport", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> loadingWiseReport(@RequestParam ("startDate") String startDate,@RequestParam ("endDate") String endDate,@RequestParam ("loadingdd") String loading) {
		LocalDate startDateLD = LocalDate.parse(startDate);
		LocalDate endDateLD = LocalDate.parse(endDate);
		List<WeighBridgeObj> wboList = wbdao.findAllByUlb(loading, startDateLD, endDateLD);
		
		ByteArrayInputStream bis = LoadingWisePDF.getLoadingeWise(wboList,loading,startDateLD,endDateLD);

		HttpHeaders headers = new HttpHeaders();
		Date date = new Date();
		headers.add("Content-Disposition", "inline; filename=LoadingReport_" + date.getTime() + ".pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	@GetMapping(value = "/partyWiseReport", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> partyWiseReport(@RequestParam ("startDate") String startDate,@RequestParam ("endDate") String endDate,@RequestParam ("partydd") String party ) {
		LocalDate startDateLD = LocalDate.parse(startDate);
		LocalDate endDateLD = LocalDate.parse(endDate);
		List<WeighBridgeObj> wboList = wbdao.findAllByPname(party, startDateLD, endDateLD);
		
		ByteArrayInputStream bis = PartyWisePDF.getPartyWise(wboList,party,startDateLD,endDateLD);

		HttpHeaders headers = new HttpHeaders();
		Date date = new Date();
		headers.add("Content-Disposition", "inline; filename=PartyWiseReport_"+party+"_" + date.getTime() + ".pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}
	
	@GetMapping(value = "/vehicleWiseReport", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> vehicleWiseReport(@RequestParam ("startDate") String startDate,@RequestParam ("endDate") String endDate,@RequestParam ("vehicledd") String vehicle) {
		LocalDate startDateLD = LocalDate.parse(startDate);
		LocalDate endDateLD = LocalDate.parse(endDate);
		List<WeighBridgeObj> wboList = wbdao.findAllByVtype(vehicle, startDateLD, endDateLD);
		
		ByteArrayInputStream bis = VehicleWisePDF.getVehicleWise(wboList,vehicle,startDateLD,endDateLD);

		HttpHeaders headers = new HttpHeaders();
		Date date = new Date();
		headers.add("Content-Disposition", "inline; filename=VehicleWiseReport_"+vehicle+"_" + date.getTime() + ".pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

	@GetMapping(value = "/getAllIds")
	public List<Long> getAllIds() {
		List<Long> idList = wbdao.findAllIds();
		return idList;
	}

	@GetMapping(value = "/weighBridgeSlip/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> printSlip(@PathVariable Long id) {
		Optional<WeighBridgeObj> wbo = wbdao.findById(id);
		ByteArrayInputStream bis = WeighSlipPDF.getWeighSlip(wbo);

		HttpHeaders headers = new HttpHeaders();
		Date date = new Date();
		headers.add("Content-Disposition", "inline; filename=weigh_slip_" + date.getTime() + ".pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}


	@GetMapping(value = "/getWeight")
	public String getWeight(Model model) throws Exception {
		PortOneData pod = PortOneData.getInstance();
		int weight = pod.getWeight();
		model.addAttribute("weight", weight);
		System.out.println("/getWeight :" + weight);
		return "weighbridgejsp";
	}

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		weightService.sendMessages();
//		Thread.sleep(1000); // simulated delay
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}
	  public void fireGreeting() {
	        System.out.println("Fire");
	        this.template.convertAndSend("/topic/greetings", "mko");
	    }

}