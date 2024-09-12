package com.bharath.flightservices.integration;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.bharath.flightservices.dto.CreateReservationRequest;
import com.bharath.flightservices.dto.UpdateReservationRequest;
import com.bharath.flightservices.entities.Flight;
import com.bharath.flightservices.entities.Passenger;
import com.bharath.flightservices.entities.Reservation;
import com.bharath.flightservices.repos.FlightRepository;
import com.bharath.flightservices.repos.PassengerRepository;
import com.bharath.flightservices.repos.ReservationRepository;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin
public class ReservationRestController {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@GetMapping("/allFlights")
	public List<Flight> findAllFlights() {
		return flightRepository.findAll();

	}

	@GetMapping("/flights")
	public List<Flight> findFlights(@RequestParam String from, @RequestParam String to,
			@RequestParam @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate) {
		return flightRepository.findFlights(from,to,departureDate);

	}

	@GetMapping("/flights/{id}")
	public Flight findFlight(@PathVariable int id) {
		return flightRepository.findById(id).get();

	}

	@PostMapping("/reservations")
	@Transactional
	public Reservation saveReservation(@RequestBody CreateReservationRequest request) {

		Flight flight = flightRepository.findById(request.getFlightId()).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setMiddleName(request.getPassengerMiddleName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());

		Passenger savePassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savePassenger);
		reservation.setCheckedIn(false);

		return reservationRepository.save(reservation);

	}

	@GetMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable int id) {
		return reservationRepository.findById(id).get();
	}

	@PutMapping("/reservations")
	public Reservation updateReservation(@RequestBody UpdateReservationRequest request) {

		Reservation reservation = reservationRepository.findById(request.getId()).get();

		reservation.setCheckedIn(request.isCheckedIn());
		reservation.setNumberOfBags(request.getNumberOfBags());

		return reservationRepository.save(reservation);

	}

}
