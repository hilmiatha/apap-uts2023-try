package id.ac.ui.cs.eaap.lab.controller;

import id.ac.ui.cs.eaap.dto.AddRoomRequestDTO;
import id.ac.ui.cs.eaap.lab.model.IssueModel;
import id.ac.ui.cs.eaap.lab.model.RoomModel;
import id.ac.ui.cs.eaap.lab.service.IssueService;
import id.ac.ui.cs.eaap.lab.service.ListService;
import id.ac.ui.cs.eaap.lab.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/ruang")
public class RoomController {

    @Autowired
    ListService listService;

    @Autowired
    RoomService roomService;

    @Autowired
    IssueService issueService;


    @GetMapping("/view-all")
    public String viewAllPage(Model model) {
        log.info("view all issues");
        List<RoomModel> roomModels = new ArrayList<>();
        roomModels = roomService.findAll();
        model.addAttribute("roomList", roomModels);
        return "room/view-all";
    }


    @GetMapping("/add")
    public String addFormPage(Model model) {
        var roomDTO = new AddRoomRequestDTO();

        model.addAttribute("roomModel", roomDTO);
        model.addAttribute("listService", listService);

        return "room/form-add";
    }

    @PostMapping(value = "/add", params = {"save"})
    public String addSubmitPage(@ModelAttribute AddRoomRequestDTO roomModel, BindingResult result,
                                RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            redirectAttrs.addFlashAttribute("error", "The error occurred.");
            return "redirect:/ruang/add";
        }

        RoomModel newRoom = new RoomModel();
        newRoom.setRoomName(roomModel.getRoomName());
        newRoom.setRoomNumber(roomModel.getRoomNumber());
        newRoom.setBuildingName(roomModel.getBuildingName());
        newRoom.setFaculty(roomModel.getFaculty());

        roomService.add(newRoom);

        redirectAttrs.addFlashAttribute("success",
                String.format("Ruang berhasil disimpan dengan id %d", newRoom.getRoomId()));
        return "redirect:/ruang/view-all";
    }


    @GetMapping("/{id}/view")
    public String detail(@PathVariable Long id, Model model, RedirectAttributes redirectAttrs) {
        // TODO
        RoomModel roomModel = roomService.getRoomById(id);
        model.addAttribute("roomModel", roomModel);

        List<IssueModel> issueList = issueService.findAllByRoomId(id);
        model.addAttribute("issueList", issueList);

        IssueModel issueModel = new IssueModel();
        issueModel.setReportedOn(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        issueModel.setRoomModel(roomModel);
        model.addAttribute("issueModel", issueModel);

        model.addAttribute("listService", listService);

        return "room/detail";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam(name = "name") String name, Model model) {
        List<RoomModel> roomModels = new ArrayList<>();
        roomModels = roomService.searchRoom(name);
        model.addAttribute("roomList", roomModels);
        return "room/view-all";
    }

}
