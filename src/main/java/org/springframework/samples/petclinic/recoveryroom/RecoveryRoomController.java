package org.springframework.samples.petclinic.recoveryroom;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {
    
    private static final String VIEWS_RECOVERY_ROOM_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";

    private final RecoveryRoomService recoveryRoomService;
    @Autowired
    public RecoveryRoomController(RecoveryRoomService recoveryRoomService){
        this.recoveryRoomService = recoveryRoomService;
    }

    @GetMapping(value = "/recoveryroom/create")
    public String initCreationForm(ModelMap model){
        RecoveryRoom recoveryRoom = new RecoveryRoom();
        List<RecoveryRoomType> recoveryRoomTypes = new ArrayList<RecoveryRoomType>();
        recoveryRoomTypes.addAll(recoveryRoomService.getAllRecoveryRoomTypes());
        model.put("recoveryRoom", recoveryRoom);
        model.put("recoveryRoomTypes", recoveryRoomTypes);
        return VIEWS_RECOVERY_ROOM_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping(value = "/recoveryroom/create")
    public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result, ModelMap model){
        if (result.hasErrors()){
            model.addAttribute("recoveryRoom", recoveryRoom);
            model.addAttribute("recoveryRoomType", recoveryRoomService.getAllRecoveryRoomTypes());
  
            return VIEWS_RECOVERY_ROOM_CREATE_OR_UPDATE_FORM;
        }else {
            recoveryRoomService.save(recoveryRoom);
            return "welcome";
        }
    }
  

}
