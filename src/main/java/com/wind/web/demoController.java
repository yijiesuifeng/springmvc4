package com.wind.web;

import com.wind.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lilandong
 * @date 2017/10/25
 */
//@RestController = @Controller + @ResponseBody
@Controller
@RequestMapping("/rest")
public class demoController {
    //-------------------------------------start 页面跳转
    /**
     * http://localhost:8202/springmvc4/rest/index
     * 跳转到index.jsp
     * 另一种方式见MyMvcConfig中的addViewControllers
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    //-------------------------------------end 页面跳转

    //---------------------------------------start 获取请求报文以及路由跳转
    /**
     * http://localhost:8202/springmvc4/rest/pathvar/lld
     */
    @RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")
    public String demoPathVar(@PathVariable String str, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access,str: " + str;
    }
    /**
     * http://localhost:8202/springmvc4/rest/requestParam?id=1
     */
    @RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
    public String passRequestParam(Long id, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access,id: " + id;
    }
    /**
     * http://localhost:8202/springmvc4/rest/obj?id=1&name=lld
     */
    @RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")
    public String passObj(DemoObj obj, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access, obj id: " + obj.getId()+" obj name:" + obj.getName();
    }
    /**
     * 映射不同的路径到相同的方法
     */
    @RequestMapping(value = { "/name1", "/name2" }, produces = "text/plain;charset=UTF-8")
    public String remove(HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access";
    }

    //-------------------------------------------end 获取请求报文以及路由跳转
    /**
     * 演示全局配置建言是否配置成功，可转到advice中看详细内容
     * http://localhost:8202/springmvc4/rest/advice?id=1&name=lld&sex=true
     * 结果：非常抱歉，参数有误/来自@ModelAttribute:额外信息,参数：DemoObj{id=1, name='lld', sex=null}
     */
    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj){//1
        throw new IllegalArgumentException("非常抱歉，参数有误/"+"来自@ModelAttribute:"+ msg+",参数："+obj.toString());
    }

}
