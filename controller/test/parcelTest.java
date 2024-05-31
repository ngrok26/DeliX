/*
 * **
 *  * @project : DeliX
 *  * @created : 30/04/2024, 19:15
 *  * @modified : 30/04/2024, 19:15
 *  * @description : This file is part of the DeliX project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.delix.controller.test;

import com.fsdm.pfe.delix.entity.Address;
import com.fsdm.pfe.delix.entity.Customer;
import com.fsdm.pfe.delix.entity.DeliveryAddress;
import com.fsdm.pfe.delix.entity.Parcel;
import com.fsdm.pfe.delix.entity.location.Area;
import com.fsdm.pfe.delix.model.enums.ParcelStatus;
import com.fsdm.pfe.delix.service.Impl.AddressServiceImpl;
import com.fsdm.pfe.delix.service.Impl.CustomerServiceImpl;
import com.fsdm.pfe.delix.service.Impl.DeliveryAddressServiceImpl;
import com.fsdm.pfe.delix.service.Impl.ParcelServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class parcelTest {

   AddressServiceImpl addressService;
   DeliveryAddressServiceImpl deliveryAddressService;
   CustomerServiceImpl customerService;
   ParcelServiceImpl parcelService;

   public parcelTest(AddressServiceImpl addressService, DeliveryAddressServiceImpl deliveryAddressService, CustomerServiceImpl customerService, ParcelServiceImpl parcelService) {
      this.addressService = addressService;
      this.deliveryAddressService = deliveryAddressService;
      this.customerService = customerService;
      this.parcelService = parcelService;
   }


}
