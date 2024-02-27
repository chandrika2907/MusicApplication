package com.example.demo.controller;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.demo.Entities.User;
import com.example.demo.service.UserService;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

import jakarta.servlet.http.HttpSession;



@Controller
public class PaymentController {
	@Autowired
	UserService usv;
	@PostMapping("/createOrder")
	@ResponseBody
	
	public String createOrder() {
		 com.razorpay.Order  order = null ;
		try {
			
		RazorpayClient razorpay = new RazorpayClient("rzp_test_bLKsYm1DN163nY", "m2LHjnnHXXoVKBBA4opWaVbs");

		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount",50000);
		orderRequest.put("currency","INR");
		orderRequest.put("receipt", "receipt#1");
		JSONObject notes = new JSONObject();
		notes.put("notes_key_1","Tea, Earl Grey, Hot");
		orderRequest.put("notes",notes);

	     order =  razorpay.orders.create(orderRequest);
		}
		catch(Exception e)
		{
			System.out.println("exception while generating order");
		}
		return order.toString();
	}
	@PostMapping("/verify")
	@ResponseBody
	public boolean verifyPayment(@RequestParam  String orderId, @RequestParam String paymentId, @RequestParam String signature) {
	    try {
	        // Initialize Razorpay client with your API key and secret
	        RazorpayClient razorpayClient = new RazorpayClient("rzp_test_bLKsYm1DN163nY", "m2LHjnnHXXoVKBBA4opWaVbs");
	        // Create a signature verification data string
	        String verificationData = orderId + "|" + paymentId;

	        // Use Razorpay's utility function to verify the signature
	        boolean isValidSignature = Utils.verifySignature(verificationData, signature, "m2LHjnnHXXoVKBBA4opWaVbs");

	        return isValidSignature;
	    } catch (RazorpayException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	@GetMapping("payment-success")
	public String  paymentSuccess(HttpSession session) {
		String email=(String)session.getAttribute("emailid");
		User user=usv.getUser(email);
		user.setPremium(true);
		usv.updateUser(user);
		return "login";
		
	}
	@GetMapping("payment-failure")
	public String paymentFailure() {
		return "login";
	}

	//payment success ->update to premium user
	//payment-failure->redirect to login
	



}
