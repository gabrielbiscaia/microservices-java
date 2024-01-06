//package com.microservice.shoesinfo.resources;
//
//import com.microservice.shoesinfo.models.Shoes;
//import com.microservice.shoesinfo.models.UserShoesList;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Arrays;
//import java.util.List;
//
//@RestController
//@RequestMapping("/shoes")
//public class ShoesResource {
//
//    @RequestMapping("users/{userId}")
//    public UserShoesList getUserShoes(@PathVariable("userId") String userId){
//        List<Shoes> shoesList;
//
//        // try to find a user's cart
//        if ("gabriel".equalsIgnoreCase(userId)) {
//            shoesList = Arrays.asList(
//            );
//        } else if ("pedro".equalsIgnoreCase(userId)) {
//            shoesList = Arrays.asList(
//
//            );
//        } else if ("lucas".equalsIgnoreCase(userId)) {
//            shoesList = Arrays.asList(
//            );
//        } else {
//            // if none of users are known
//            shoesList = Arrays.asList(
//            );
//        }
//
//        // instances a userShoeList
//        UserShoesList userShoesList = new UserShoesList();
//
//        //assign a shoeList to a UserShoesList
//        userShoesList.setUserShoesList(shoesList);
//
//        //return a userShoesList
//        return userShoesList;
//    }
//}