package com.iddink.afspraak.read.kafka;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iddink.afspraak.read.entity.Afspraak;
import com.iddink.afspraak.read.entity.Attendees;
import com.iddink.afspraak.read.event.AfspraakTitelGewijzigdEvent;
import com.iddink.afspraak.read.event.EenOpEenAfspraak;
import com.iddink.afspraak.read.event.EenOpEenAfspraakGeplandEvent;
import com.iddink.afspraak.read.repository.AfspraakRepository;

@Service
public class KafkaConsumer {

	private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@Autowired
	private AfspraakRepository afspraakRepository;

	@KafkaListener(topics = "topic_afspraak", groupId = "group-id")
	public void consume(ConsumerRecord<String, String> cr) throws JsonParseException, JsonMappingException, IOException{
		logger.info(String.format("$$ key -->%s $$ -> Consumed Message -> %s",cr.key(),cr.value()));
		ObjectMapper mapper = new ObjectMapper();
		
		if (cr.key().equals("EenOpEenAfspraakGeplandEvent")) {
			EenOpEenAfspraakGeplandEvent eenOpEenAfspraakGeplandEvent = mapper.readValue(cr.value(), EenOpEenAfspraakGeplandEvent.class);
			logger.info("EenOpEenAfspraakGeplandEvent---------> "+eenOpEenAfspraakGeplandEvent.toString());
			
			Afspraak afspraak=new Afspraak();
			afspraak.setAfspraakId(eenOpEenAfspraakGeplandEvent.getAfspraakID());
			
			EenOpEenAfspraak appointmentData=eenOpEenAfspraakGeplandEvent.getAppointmentData();
			
			afspraak.setDescription(appointmentData.getDescription());
			afspraak.setEndDate(appointmentData.getEndDate());
			afspraak.setStartDate(appointmentData.getStartDate());
			afspraak.setTitle(appointmentData.getTitle());
			afspraak.setType(appointmentData.getType());
			afspraak.setOnderwijsProduct(appointmentData.getOnderwijsProduct());
			afspraak.setLocation(appointmentData.getLocation());
			
			List<String> attendees = appointmentData.getAttendees();
			
			List<Attendees> attendeesList=new ArrayList<Attendees>();
			
			for (String attendee : attendees) {
				attendeesList.add(new Attendees(attendee));
			}
			
			afspraak.setAttendees(attendeesList);
			afspraakRepository.save(afspraak);
		}
		else if(cr.key().equals("AfspraakTitelGewijzigdEvent")) {
			AfspraakTitelGewijzigdEvent afspraakTitelGewijzigdEvent = mapper.readValue(cr.value(), AfspraakTitelGewijzigdEvent.class);
			logger.info("AfspraakTitelGewijzigdEvent----------> "+afspraakTitelGewijzigdEvent.toString());
			
			UUID afspraakID = afspraakTitelGewijzigdEvent.getAfspraakID();
			
			Optional<Afspraak> afspraak = afspraakRepository.findById(afspraakID.toString());
			
			if(afspraak.isPresent()) {
				logger.info("----------------Present in DB-------------");
				afspraak.get().setTitle(afspraakTitelGewijzigdEvent.getUpdatedTitle());
				afspraakRepository.save(afspraak.get());
			}
		}
	}
}
