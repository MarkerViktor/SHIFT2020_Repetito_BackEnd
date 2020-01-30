package ru.cft.shift.quickstart_bus_traffic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shift.quickstart_bus_traffic.entity.PassengerEntity;
import ru.cft.shift.quickstart_bus_traffic.repository.IPassengerRepository;

@Service
public class PassengerService implements IPassengerService {

  @Autowired
  private IPassengerRepository passengerRepository;

  @Override
  public void add(PassengerEntity bus) {
    passengerRepository.add(bus);
  }

  @Override
  public PassengerEntity get(Long id) {
    return passengerRepository.get(id);
  }
}
