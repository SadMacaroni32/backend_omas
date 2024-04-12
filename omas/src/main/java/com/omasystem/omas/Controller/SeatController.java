package com.omasystem.omas.Controller;


import org.springframework.web.bind.annotation.RestController;

import com.omasystem.omas.Model.SeatModel;
import com.omasystem.omas.Service.SeatService;


import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/seats") /*changed from /seat to /api/seats */
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/all") /*changed from getAll to all */
    public ResponseEntity<List<SeatModel>> getAllSeats() {
        return seatService.getAllSeats();
    }

    /* getAllAvaialable seat api */
    @GetMapping("/available")
    public List<SeatModel> getAvailableSeat(){
        return seatService.getAvailableSeat();
    }
    
    /* getAllOccupied seat api*/
    @GetMapping("/occupied")
    public List<SeatModel> getOccupiedSeat(){
        return seatService.getOccupiedSeat();
    }

    /* getAllUnderRestoration seat api */
    @GetMapping("/repairing")
    public List<SeatModel> getRepairingSeat(){
        return seatService.getRepairingSeat();
    }

     /*get seats by project */
     @GetMapping("/project")
     public ResponseEntity<Map<String, Object>> getTotalSeatsByProject(@RequestParam Long projectId) {
         return seatService.getTotalSeatsByProject(projectId);
     }
}
