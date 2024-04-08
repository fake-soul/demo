package com.example.demo.service;

import com.example.demo.model.Slot;
import com.example.demo.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotService {

  @Autowired
  private SlotRepository slotRepository;

  public Slot createSlot(Slot slot) {
    return slotRepository.save(slot);
  }

  public List<Slot> findAvailableSlotsByConsultant(Long consultantId) {
    return slotRepository.findByConsultantIdAndIsBookedFalse(consultantId);
  }
}