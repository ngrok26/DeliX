///*
// * **
// *  * @project : DeliX
// *  * @created : 27/04/2024, 14:59
// *  * @modified : 27/04/2024, 13:48
// *  * @description : This file is part of the DeliX project.
// *  * @license : MIT License
// * **
// */
//
///*
// * **
// *  * @project : DeliX
// *  * @created : 25/04/2024, 16:11
// *  * @modified : 25/04/2024, 16:11
// *  * @description : This file is part of the DeliX project.
// *  * @license : MIT License
// * **
// */
//
//package com.fsdm.pfe.delix.controller.test;
//
//import com.fsdm.pfe.delix.entity.DeliveryMan;
//import com.fsdm.pfe.delix.entity.Parcel;
//import com.fsdm.pfe.delix.entity.User;
//import com.fsdm.pfe.delix.model.enums.ParcelStatus;
//import com.fsdm.pfe.delix.model.enums.ParcelType;
//import com.fsdm.pfe.delix.model.enums.UserStatus;
//import com.fsdm.pfe.delix.service.Impl.*;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.Collection;
//
///*
// * actualy this is a test class
// * we used it for testing pruposes
// *
// * todo : delete this class after testing
// * */
//@Controller
//public class Test {
//
//    private final UserServiceImpl userService;
//    private PrivilegesGroupServiceImpl privilegesGroupService;
//    private final ParcelServiceImpl paarcelService;
//
//    private final DeliveryManServiceImpl deliveryManService;
//    private final EmailServiceImpl emailService;
//
//
//    public Test( UserServiceImpl userService, PrivilegesGroupServiceImpl privilegesGroupService, ParcelServiceImpl paarcelService, DeliveryManServiceImpl deliveryManService, EmailServiceImpl emailService) {
//        this.userService = userService;
//        this.privilegesGroupService = privilegesGroupService;
//        this.paarcelService = paarcelService;
//        this.deliveryManService = deliveryManService;
//        this.emailService = emailService;
//    }
//
//
//    @GetMapping("/test/sendEmail")
//    public ResponseEntity<String> sendEmail() {
//        emailService.sendSimpleMessage("codingabdo@gmail.com", "test", "this is a test email");
//        return new ResponseEntity<>("email sent", HttpStatus.OK);
//    }
//
//    @GetMapping("/test/get/user")
//    public ResponseEntity<User> getUser() {
//        User user = userService.loadUserById(1L);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @GetMapping("/test/timeline")
//    public String timeline() {
//        return "timeline";
//    }
//
//
////    @GetMapping("/register")
////    public String register() {
////        return "register";
////    }
//
//
//    @GetMapping("/loginSuccess")
//    public ResponseEntity<String> loginSuccess() {
//        return ResponseEntity.ok("You are logged in");
//    }
//
//    @GetMapping("/errorr")
//    public ResponseEntity<String> error() {
//        return new ResponseEntity<>("have a error", HttpStatus.OK);
//    }
//
//
//    @GetMapping("/test/addParcel")
//    public ResponseEntity<String> addParcel() {
//        // Create new Parcel object
//        Parcel parcel = new Parcel();
//
//
//        parcel.setHeight(10.0f);
//        parcel.setWidth(20.0f);
//        parcel.setWeight(30.0f);
//        parcel.setStatus(ParcelStatus.IN_TRANSIT); // Assuming ParcelStatus is an enum with a value of NEW
//        parcel.setType(ParcelType.DOCUMENT); // Assuming ParcelType is an enum with a value of TYPE1
//
//        try {
//            paarcelService.saveParcel(parcel);
//        } catch (Exception e) {
//            return new ResponseEntity<>("parcel not added added" + e.toString(), HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>("parcel was added", HttpStatus.OK);
//    }
//
//    @GetMapping("/public/getUsers")
//    public ResponseEntity<Collection<User>> getUsers() {
//        return new ResponseEntity<>(userService.loadAllUsers(), HttpStatus.OK);
//    }
//
//    @GetMapping("/test/addDelivery")
//    public ResponseEntity<?> addDelivery() {
//        DeliveryMan deliveryMan = new DeliveryMan();
//        deliveryMan.setFirstName("Abdelhakim");
//        deliveryMan.setLastName("Bouzidi");
//        deliveryMan.setEmail("abde@d.com");
//        deliveryMan.setPassword("12345678");
//        deliveryMan.setPhoneNumber("0656565656");
//        deliveryMan.setCin("AB123456");
//        deliveryMan.setStatus(UserStatus.ACTIVE);
//
//        try {
//            return ResponseEntity.ok( deliveryManService.addNewDeliveryMan(deliveryMan));
//        } catch (Exception e) {
//            return ResponseEntity.ok("delivery not added" + e.toString());
//
//        }
//
//    }
//}
