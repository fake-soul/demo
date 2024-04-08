package com.example.demo.controller;

import com.example.demo.model.Slot;
import com.example.demo.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slots")
public class SlotController {
  @Autowired
  private SlotService slotService;

  @PostMapping("/create")
  public ResponseEntity<Slot> createSlot(@RequestBody Slot slot) {
    Slot createdSlot = slotService.createSlot(slot);
    return ResponseEntity.ok(createdSlot);
  }

  @GetMapping("/available/{consultantId}")
  public ResponseEntity<List<Slot>> getAvailableSlots(@PathVariable Long consultantId) {
    List<Slot> slots = slotService.findAvailableSlotsByConsultant(consultantId);
    return ResponseEntity.ok(slots);
  }
}

