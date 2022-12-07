package com.yoti.roomba.navigator.endpoint;

import com.yoti.roomba.navigator.model.NavigationRequest;
import com.yoti.roomba.navigator.model.NavigationResponse;
import com.yoti.roomba.navigator.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NavigationController {

    @Autowired
    private NavigationService navigationService;

    @PostMapping("/navigate")
    @ResponseBody
    NavigationResponse navigate(@RequestBody NavigationRequest request) {

        return navigationService.navigate(request);
    }
}