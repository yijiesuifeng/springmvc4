package com.wind.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class SseController {
    /**
     * 基于SSE的服务器端推送技术，缺点是需要新式浏览器的支持
     * text/event-stream 是服务器端SSE的支持
     */
	@RequestMapping(value="/push",produces="text/event-stream")
	public @ResponseBody String push(){
		 Random r = new Random();
        try {
                Thread.sleep(5000);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }   
        return "data:Testing 1,2,3" + r.nextInt() +"\n\n";
	}

}
